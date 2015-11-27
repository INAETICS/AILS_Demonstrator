package org.inaetics.ails.impl.server.streaming_profile.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

import com.google.common.base.Preconditions;

/**
 * The StreamingProfileServiceImpl class provides an implementation of the
 * {@link StreamingProfileService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.3
 * @since 04-11-2015
 */
public class StreamingProfileServiceImpl implements StreamingProfileService {

    // Injected by Dependency Manager
    private volatile BufferService<UUIDWiFiProfile> buffer;
    
    // TODO Remove this, it is just a test to add some profiles to the buffer to be used by the miner
    public void start() {
        new Timer().schedule(new TimerTask() {
            
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    WiFiProfile wifiProfile = new WiFiProfile(Instant.now(), new ArrayList<>());
                    UUIDWiFiProfile uuidWiFiProfile = new UUIDWiFiProfile(-1, wifiProfile, UUID.randomUUID());
                    buffer.add(uuidWiFiProfile);
                }
            }
            
        }, 5 * 1000);
    }
    
    @Override
    public void add(UUIDWiFiProfile uuidWiFiProfile) {
        // Simply store the received uuidWiFiProfile in the Buffer.
        buffer.add(Preconditions.checkNotNull(uuidWiFiProfile));
    }

}