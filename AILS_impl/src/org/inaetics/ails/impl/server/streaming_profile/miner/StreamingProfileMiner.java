package org.inaetics.ails.impl.server.streaming_profile.miner;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.LocationProfile;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.UserLocation;
import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.UserWiFiProfileDAO;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;

/**
 * The Streaming Profile Miner will process {@link UserWiFiProfile UserWiFiProfiles} from the
 * {@link BufferService}.
 *
 * New UserWiFiProfiles arriving from the buffer will be stored. Stored UserWiFiProfiles will be
 * combined with {@link LocationProfile LocationProfiles} to gather new information about the
 * {@link Location} of a {@link User}.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.4
 * @since 10-11-2015
 */
public class StreamingProfileMiner {

    // Injected by Dependency Manager
    private volatile BufferService<UserWiFiProfile> incomingUserWiFiProfileBuffer;
    private volatile UserWiFiProfileDAO oldUserWiFiProfileDAO;
    private volatile LocationProfileDAO locationProfileDAO;
    private volatile UserLocationDataStore userLocationDataStore;

    private final Timer timer;

    public StreamingProfileMiner() {
        timer = new Timer();
    }

    /**
     * Called by Felix DM when starting this component.
     */
    public void start() {
        timer.schedule(new StreamingProfileMinerTask(), 0);
    }

    private final class StreamingProfileMinerTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("StreamingProfileMiner started mining");

            Optional<UserWiFiProfile> userWiFiProfile;
            while ((userWiFiProfile = incomingUserWiFiProfileBuffer.remove()).isPresent()) {

                System.out.println("StreamingProfileMiner found a UserWiFiProfile in the buffer");

                // Store the newly found UserWiFiProfile for possible later use
                oldUserWiFiProfileDAO.store(userWiFiProfile.get());

                // Compare newly found UserWiFiProfile with existing LocationProfiles to find a
                // Location for the User
                // TODO: locationProfileDAO.getAll() can probably be done more efficiently
                for (LocationProfile locationProfile : locationProfileDAO.getAll()) {

                    WiFiProfile newWiFiProfile = userWiFiProfile.get().getWifiProfile();
                    if (newWiFiProfile.match(locationProfile.getWifiProfile())) {

                        System.out.println("A Location is found for this User");

                        // Match found! Update UserLocation data store
                        User user = userWiFiProfile.get().getUser();
                        Location location = locationProfile.getLocation();
                        UserLocation userLocation = new UserLocation(user, location);
                        userLocationDataStore.storeUserLocation(userLocation);
                        break;
                    }
                }

                // TODO: What if no match was found? Ask user for location, right?
            }

            System.out.println("StreamingProfileMiner finished mining");
            timer.schedule(new StreamingProfileMinerTask(), 1 * 1000);
        }

    }

}
