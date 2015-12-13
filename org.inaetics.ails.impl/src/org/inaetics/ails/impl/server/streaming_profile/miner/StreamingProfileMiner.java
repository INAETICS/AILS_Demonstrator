package org.inaetics.ails.impl.server.streaming_profile.miner;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.LocationProfile;
import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.common.model.UUIDLocation;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.UUIDWiFiProfileDAO;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;

import com.google.common.base.Optional;

/**
 * The Streaming Profile Miner will process {@link UUIDWiFiProfile UUIDWiFiProfiles} from
 * the {@link BufferService}.
 *
 * New UserWiFiProfiles arriving from the buffer will be stored. Stored UUIDWiFiProfiles will be
 * combined with {@link LocationProfile LocationProfiles} to gather new information about the
 * {@link Location} of a {@link User}.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.6
 * @since 10-11-2015
 */
public class StreamingProfileMiner {

    // Injected by Dependency Manager
    private volatile BufferService<UUIDWiFiProfile> incomingUUIDWiFiProfileBuffer;
    private volatile UUIDWiFiProfileDAO oldUUIDWiFiProfileDAO;
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

            Optional<UUIDWiFiProfile> uuidWiFiProfile;
            while ((uuidWiFiProfile = incomingUUIDWiFiProfileBuffer.remove()).isPresent()) {

                System.out.println("StreamingProfileMiner found a UUIDWiFiProfile in the buffer");

                // Store the newly found UserWiFiProfile for possible later use
                oldUUIDWiFiProfileDAO.store(uuidWiFiProfile.get());

                UUID uuid = uuidWiFiProfile.get().getUuid();
                WiFiProfile newWiFiProfile = uuidWiFiProfile.get().getWifiProfile();

                // Compare the newly found UUIDWiFiProfile with existing LocationProfiles to find a
                // Location for the User
                // TODO: locationProfileDAO.getAll() can probably be done more efficiently
                for (LocationProfile locationProfile : locationProfileDAO.getAll()) {
                    if (newWiFiProfile.match(locationProfile.getWifiProfile())) {
                        System.out.println("A Location is found for this User");
                        Location location = locationProfile.getLocation();
                        UUIDLocation uuidLocation = new UUIDLocation(uuid, location);
                        userLocationDataStore.storeUserLocation(uuidLocation);
                    }
                }
                
//                // Pretty Java 8 code of the above
//                locationProfileDAO.getAll().stream()
//                        .filter(locationProfile -> newWiFiProfile
//                                .match(locationProfile.getWifiProfile()))
//                        .forEach(locationProfile -> {
//                            System.out.println("A Location is found for this User");
//                            Location location = locationProfile.getLocation();
//                            UUIDLocation uuidLocation = new UUIDLocation(uuid, location);
//                            userLocationDataStore.storeUserLocation(uuidLocation);
//                        });

                // TODO: What if no match was found? Ask user for location, right?
            }

            System.out.println("StreamingProfileMiner finished mining");
            timer.schedule(new StreamingProfileMinerTask(), 1 * 1000);
        }

    }

}
