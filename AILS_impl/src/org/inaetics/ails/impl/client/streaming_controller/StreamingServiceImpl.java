package org.inaetics.ails.impl.client.streaming_controller;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.client.factory.WiFiProfileFactory;
import org.inaetics.ails.api.client.streaming_controller.StreamingService;
import org.inaetics.ails.api.common.model.AnonUser;
import org.inaetics.ails.api.common.model.AnonUserWiFiProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

/**
 * The StreamingServiceImpl provides an implementation for the {@link StreamingService
 * StreamingService}. It will generate and send on a regular bases {@link UserWiFiProfile
 * UserWiFiProfiles} to the {@link StreamingProfileService StreamingProfileService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 11-11-2015
 */
public class StreamingServiceImpl implements StreamingService {

    // Injected by Dependency Manager
    private volatile WiFiProfileFactory wifiProfileFactory;
    private volatile StreamingProfileService streamingProfileService;

    private final Timer timer;

    public StreamingServiceImpl() {
        timer = new Timer();
    }
    
    @Override
    public void startStreaming(AnonUser anonUser) {
        System.out.println("Streaming Profile Service started");

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Optional<WiFiProfile> wifiProfile = wifiProfileFactory.getProfile();

                if (wifiProfile.isPresent()) {
                    AnonUserWiFiProfile anonUserWiFiProfile = new AnonUserWiFiProfile(-1, wifiProfile.get(), anonUser);
                    streamingProfileService.add(anonUserWiFiProfile);
                }
            }
        };
        
        timer.schedule(task, 0, 60000);
    }

    @Override
    public void stopStreaming() {
        System.out.println("Streaming Profile Service stopped");

        timer.cancel();
    }
}
