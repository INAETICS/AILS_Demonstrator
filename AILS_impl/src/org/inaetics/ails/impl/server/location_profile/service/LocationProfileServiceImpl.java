package org.inaetics.ails.impl.server.location_profile.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;

import com.google.common.base.Preconditions;

/**
 * The LocationProfileServiceImpl class provides an implementation of the
 * {@link LocationProfileService LocationProfileService}
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 04-11-2015
 */
public class LocationProfileServiceImpl implements LocationProfileService {

    private volatile BufferService<RawLocationProfile> buffer;

    // TODO Remove this, it is just a test to add some profiles to the buffer to be used by the miner
    public void start() {
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    WiFiProfile wifiProfile = new WiFiProfile(Instant.now(), new ArrayList<>());
                    Location location = new Location("area " + i, "thales", "thales", "thales");
                    add(new RawLocationProfile(-1, wifiProfile, location));
                }
            }

        }, 3 * 1000);
    }

    @Override
    public void add(RawLocationProfile locationProfile) {
        buffer.add(Preconditions.checkNotNull(locationProfile, "location profile is not set"));
    }

}
