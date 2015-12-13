package org.inaetics.ails.test.integration;

import static org.amdatu.testing.configurator.TestConfigurator.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.controllers.learning.LearningController;
import org.inaetics.ails.api.client.controllers.streaming_wifi_profiles.StreamingWiFiProfilesController;
import org.inaetics.ails.api.client.controllers.users.UsersController;
import org.inaetics.ails.api.client.exceptions.ServerUnavailableException;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.UserDAO;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;
import org.inaetics.ails.api.server.user.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SystemTest {

    // Injected by DM
    private volatile DeviceController deviceController;
    private volatile DeviceDataStore deviceDataStore;

    private volatile UsersController usersController;
    private volatile UserDAO userDAO;
    private volatile UserDataStore userDataStore;
    private volatile UserService userService;

    private volatile LocationProfileDAO locationProfileDAO;
    private volatile LearningController learningController;

    private volatile StreamingWiFiProfilesController streamingWiFiProfilesController;
    private volatile UserLocationDataStore userLocationDataStore;

    @Before
    public void setup() {
        configure(this)
                .add(createServiceDependency().setService(DeviceController.class).setRequired(true))
                .add(createServiceDependency().setService(DeviceDataStore.class).setRequired(true))
                .add(createServiceDependency().setService(UsersController.class).setRequired(true))
                .add(createServiceDependency().setService(UserDAO.class).setRequired(true))
                .add(createServiceDependency().setService(UserDataStore.class).setRequired(true))
                .add(createServiceDependency().setService(UserService.class).setRequired(true))
                .add(createServiceDependency().setService(LocationProfileDAO.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(LearningController.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(StreamingWiFiProfilesController.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(UserLocationDataStore.class)
                        .setRequired(true))
                .apply();
    }

    @After
    public void after() {
        cleanUp(this);
    }

    /**
     * Test the systems services for availability and its general functionality.
     * 
     * @throws InterruptedException Thrown if a Thread sleep is interrupted.
     * @throws ServerUnavailableException 
     */
    @Test(timeout = 60000)
    public void testRegisterUser() throws InterruptedException, ServerUnavailableException {
        // Register a new user
        deviceController.registerUser("John Doe");

        // Check user exists client-side
        assertTrue(deviceDataStore.hasUser());
        assertTrue(deviceDataStore.getUUID().isPresent());
        assertFalse(usersController.getAll().isEmpty());

        // Check user exists server-side
        assertFalse(userDAO.getAll().isEmpty());
        assertFalse(userDataStore.getAllUsers().isEmpty());
        assertFalse(userService.getAll().isEmpty());

        /*
         * Test learning new locations
         */

        // Make sure no Location Profiles are known
        assertTrue(locationProfileDAO.getAll().isEmpty());

        // Learn a location
        Location location = new Location("area", "building", "site", "organization");
        learningController.startLearningMode(location, 100);

        while (locationProfileDAO.getAll().size() < 5) {
            // Sleep a bit so the miner can catch-up
            TimeUnit.MILLISECONDS.sleep(100);
        }

        // Stop learning-mode
        learningController.stopLearningMode();

        /*
         * Test streaming
         */

        streamingWiFiProfilesController.startStreaming(1000);
        UUID uuid = deviceDataStore.getUUID().get();

        while (!userLocationDataStore.getLocation(uuid).isPresent()) {
            // Sleep a bit so the miner can catch-up until a location is found (kinda random)
            TimeUnit.MILLISECONDS.sleep(100);
        }

        streamingWiFiProfilesController.stopStreaming();

        /*
         * Check User Location
         */

        // Check find location of user
        assertTrue(usersController.getLocationForUser(uuid).isPresent());
    }

}
