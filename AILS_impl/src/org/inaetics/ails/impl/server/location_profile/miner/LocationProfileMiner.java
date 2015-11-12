package org.inaetics.ails.impl.server.location_profile.miner;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.LocationProfile;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.RawLocationProfileDAO;

/**
 * The Location Profile Miner processes newly found {@link RawLocationProfile RawLocationProfiles}
 * into {@link LocationProfile LocationProfiles}. New RawLocationProfiles will first be stored for
 * later use, then using all of the old and new information the known LocationProfiles are updated.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 12-11-2015
 */
public class LocationProfileMiner {

    // Injected by Dependency Manager
    private volatile BufferService<RawLocationProfile> incomingRawLocationProfileBuffer;
    private volatile RawLocationProfileDAO rawLocationProfileDAO;
    private volatile LocationProfileDAO locationProfileDAO;

    private final Timer timer;

    public LocationProfileMiner() {
        timer = new Timer();
    }

    /**
     * Called by Felix DM when starting this component.
     */
    public void start() {
        timer.schedule(new LocationProfileMinerTask(), 0);
    }

    private final class LocationProfileMinerTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("LocationProfileMiner started mining");

            Optional<RawLocationProfile> rawLocationProfile;
            while ((rawLocationProfile = incomingRawLocationProfileBuffer.remove()).isPresent()) {
                System.out.println("LocationProfileMiner is processing a RawLocationProfile");

                // Store newly found RawLocationProfile
                RawLocationProfile foundRawLocationProfile = rawLocationProfile.get();
                rawLocationProfileDAO.store(foundRawLocationProfile);

                // Process the RawLocationProfile to a LocationProfile
                WiFiProfile wifiProfile = foundRawLocationProfile.getWifiProfile();
                Location location = foundRawLocationProfile.getLocation();
                LocationProfile locationProfile = new LocationProfile(-1, wifiProfile, location);

                // Store the processed LocationProfile
                locationProfileDAO.store(locationProfile);
            }

            System.out.println("LocationProfileMiner finished mining");
            timer.schedule(new LocationProfileMinerTask(), 1 * 1000);
        }

    }

}
