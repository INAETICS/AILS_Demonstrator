package org.inaetics.ails.impl.client.streaming_controller;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.client.factory.WiFiProfileFactory;
import org.inaetics.ails.api.client.streaming_controller.StreamingService;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

/**
 * The StreamingServiceImpl provides an implementation for the {@link StreamingService
 * StreamingService}. It will generate and send on a regular bases {@link UserWiFiProfile
 * UserWiFiProfiles} to the {@link StreamingProfileService StreamingProfileService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 11-11-2015
 */
public class StreamingServiceImpl implements StreamingService {

    // Injected by Dependency Manager
    private volatile WiFiProfileFactory wifiProfileFactory;
    private volatile StreamingProfileService streamingProfileService;

    private final Timer timer;
    private final TimerTask task;

    public StreamingServiceImpl(User user) {
        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                Optional<WiFiProfile> wifiProfile = wifiProfileFactory.getProfile();

                if (wifiProfile.isPresent()) {
                    UserWiFiProfile userWiFiProfile = new UserWiFiProfile(-1, wifiProfile.get(), user);
                    streamingProfileService.add(userWiFiProfile);
                }
            }
        };
    }

    // Called by the Dependency Manager
    public void start() {
        System.out.println("Streaming Profile Service started");
        startStreaming();
    }

    // Called by the Dependency Manager
    public void stop() {
        System.out.println("Streaming Profile Service stopped");
        stopStreaming();
    }

    @Override
    public void startStreaming() {
        timer.schedule(task, 0, 60000);
    }

    @Override
    public void stopStreaming() {
        task.cancel();
        timer.cancel();
    }
}
