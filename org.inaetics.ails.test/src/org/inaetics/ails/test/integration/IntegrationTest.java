package org.inaetics.ails.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.controllers.learning.LearningController;
import org.inaetics.ails.api.client.controllers.location.LocationController;
import org.inaetics.ails.api.client.controllers.streaming_wifi_profiles.StreamingWiFiProfilesController;
import org.inaetics.ails.api.client.controllers.users.UsersController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.client.view.View;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.RawLocationProfileDAO;
import org.inaetics.ails.api.server.database.UUIDLocationDAO;
import org.inaetics.ails.api.server.database.UUIDWiFiProfileDAO;
import org.inaetics.ails.api.server.database.UserDAO;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.location.service.LocationService;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;
import org.inaetics.ails.api.server.user.service.UserService;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Integration tests for AILS' services.
 *
 * Tests: services available (i.e. active); use cases show services working as one system.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.0.0
 * @since 20-11-2015
 */
public class IntegrationTest {

    private final BundleContext context =
            FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    /**
     * Get a particular service from the available bundles.
     *
     * @param clazz The class of the service to be retrieved.
     * @return Optional with the service if found, empty Optional if not.
     * @since 1.0.0
     */
    @SuppressWarnings("unchecked")
    private <T> Optional<T> service(Class<T> clazz) {
        ServiceTracker st = new ServiceTracker(context, clazz.getName(), null);
        st.open();
        Object service = st.getService();
        if (service != null) {
            return Optional.of((T) service);
        }
        return Optional.empty();
    }

    /**
     * Get several particular services from the available bundles. Useful when you expect several
     * different instances of the same service to be available.
     *
     * @param clazz The class of the services to be retrieved.
     * @return A List of the found services or an empty List if nothing was found.
     * @since 1.0.0
     */
    @SuppressWarnings("unchecked")
    private <T> List<T> services(Class<T> clazz) {
        ServiceTracker st = new ServiceTracker(context, clazz.getName(), null);
        st.open();
        Object[] servicesArray = st.getServices();
        if (servicesArray != null) {
            return (List<T>) Arrays.asList(servicesArray);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Test the systems services for availability and its general functionality.
     * 
     * @throws InterruptedException Thrown if a Thread sleep is interrupted.
     * @since 2.0.0
     */
    @SuppressWarnings("rawtypes")
    @Test(timeout=60000)
    public void test() throws InterruptedException {

        /*
         * Test server services availability
         */

        // Check the standard User services
        assertTrue(service(UserDAO.class).isPresent());
        assertTrue(service(UserDataStore.class).isPresent());
        assertTrue(service(UserService.class).isPresent());

        // Check Location Profile services
        assertTrue(service(RawLocationProfileDAO.class).isPresent());
        assertTrue(service(LocationProfileDAO.class).isPresent());
        assertTrue(service(LocationProfileService.class).isPresent());

        // Check the Location Provider
        assertTrue(service(LocationProvider.class).isPresent());

        // if UserLocationDataStore is available, some other services should also be there
        if (service(UserLocationDataStore.class).isPresent()) {

            // This is the streaming wifi profiles option
            assertTrue(service(UUIDWiFiProfileDAO.class).isPresent());
            assertTrue(service(UUIDLocationDAO.class).isPresent());
            assertTrue(service(StreamingProfileService.class).isPresent());

            // Check the buffers
            List<BufferService> buffers = services(BufferService.class);
            assertEquals(2, buffers.size());
            assertTrue((buffers.get(0).forType().equals(UUIDWiFiProfile.class)
                    && buffers.get(1).forType().equals(RawLocationProfile.class))
                    || (buffers.get(0).forType().equals(RawLocationProfile.class)
                            && buffers.get(1).forType().equals(UUIDWiFiProfile.class)));

        } else {
            // This is the query location option
            assertTrue(service(LocationService.class).isPresent());

            // Check the buffers
            List<BufferService> buffers = services(BufferService.class);
            assertEquals(2, buffers.size());
            assertTrue((buffers.get(0).forType().equals(UUID.class)
                    && buffers.get(1).forType().equals(RawLocationProfile.class))
                    || (buffers.get(0).forType().equals(RawLocationProfile.class)
                            && buffers.get(1).forType().equals(UUID.class)));
        }

        /*
         * Test Client Services availability
         */

        // Test model
        assertTrue(service(DeviceDataStore.class).isPresent());
        assertTrue(service(WiFiProfileFactory.class).isPresent());

        // Test controller
        assertTrue(service(DeviceController.class).isPresent());
        assertTrue(service(LearningController.class).isPresent());
        assertTrue(service(LocationController.class).isPresent());
        assertTrue(service(StreamingWiFiProfilesController.class).isPresent());
        assertTrue(service(UsersController.class).isPresent());

        // Test view
        assertTrue(service(View.class).isPresent());

        /*
         * Test register new user
         */

        // Check no user exists client-side
        assertFalse(service(DeviceDataStore.class).get().hasUser());
        assertFalse(service(DeviceDataStore.class).get().getUUID().isPresent());
        assertTrue(service(UsersController.class).get().getAll().isEmpty());

        // Check no user exists server-side
        assertTrue(service(UserDAO.class).get().getAll().isEmpty());
        assertTrue(service(UserDataStore.class).get().getAllUsers().isEmpty());
        assertTrue(service(UserService.class).get().getAll().isEmpty());

        // Register a new user
        service(DeviceController.class).get().registerUser("John Doe");

        // Check user exists client-side
        assertTrue(service(DeviceDataStore.class).get().hasUser());
        assertTrue(service(DeviceDataStore.class).get().getUUID().isPresent());
        assertFalse(service(UsersController.class).get().getAll().isEmpty());
        
        // Check user exists server-side
        assertFalse(service(UserDAO.class).get().getAll().isEmpty());
        assertFalse(service(UserDataStore.class).get().getAllUsers().isEmpty());
        assertFalse(service(UserService.class).get().getAll().isEmpty());
        
        UUID uuid = service(DeviceDataStore.class).get().getUUID().get();
        
        /*
         * Test learning new locations
         */
        
        // Make sure no Location Profiles are known
        assertTrue(service(LocationProfileDAO.class).get().getAll().isEmpty());
        
        // Learn a location
        Location location = new Location("area", "building", "site", "organization");
        service(LearningController.class).get().startLearningMode(location, 100);
        
        while(service(LocationProfileDAO.class).get().getAll().size() < 6) {
            // Sleep a bit so the miner can catch-up
            Thread.sleep(100);
        }
        
        // Stop learning-mode
        service(LearningController.class).get().stopLearningMode();
        
        /*
         * Test streaming
         */
        service(StreamingWiFiProfilesController.class).get().startStreaming(1000);
       
        while(!service(UserLocationDataStore.class).get().getLocation(uuid).isPresent()) {
            // Sleep a bit so the miner can catch-up until a location is found (kinda random)
            Thread.sleep(100);
        }
        
        service(StreamingWiFiProfilesController.class).get().stopStreaming();
        
        /*
         * Check User Location
         */
        
        // Check find location of user
        assertTrue(service(UsersController.class).get().getLocationForUser(uuid).isPresent());
    }

}
