package org.inaetics.ails.impl.server.streaming_profile.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

import com.google.common.base.Preconditions;

/**
 * The StreamingProfileServiceImpl class provides an implementation of the
 * {@link StreamingProfileService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 04-11-2015
 */
public class StreamingProfileServiceImpl implements StreamingProfileService {

    // Injected by Dependency Manager
    private volatile BufferService<UserWiFiProfile> buffer;
    
    // TODO Remove this, it is just a test to add some profiles to the buffer to be used by the miner
    public void start() {
        new Timer().schedule(new TimerTask() {
            
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    WiFiProfile wifiProfile = new WiFiProfile(Instant.now(), new ArrayList<>());
                    User user = new User(UUID.randomUUID(), "Some name", "Some mac".getBytes());
                    UserWiFiProfile userWiFiProfile = new UserWiFiProfile(0, wifiProfile, user);
                    buffer.add(userWiFiProfile);
                }
            }
            
        }, 15 * 1000);
    }
    
    @Override
    public void add(UserWiFiProfile userWiFiProfile) {
        // Simply store the received UserWiFiProfile in the Buffer.
        buffer.add(Preconditions.checkNotNull(userWiFiProfile));
    }

}
