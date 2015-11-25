package org.inaetics.ails.impl.client.controllers.streaming_wifi_profiles;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.client.controllers.streaming_wifi_profiles.StreamingWiFiProfilesController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
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
public class StreamingWiFiProfilesControllerImpl implements StreamingWiFiProfilesController {

    // Injected by Dependency Manager
    private volatile WiFiProfileFactory wifiProfileFactory;
    private volatile DeviceDataStore deviceDataStore;
    private volatile StreamingProfileService streamingProfileService;

    private final Timer timer;

    public StreamingWiFiProfilesControllerImpl() {
        timer = new Timer();
    }
    
    @Override
    public void startStreaming() {
        System.out.println("Streaming Profile Service started");

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Optional<WiFiProfile> wifiProfile = wifiProfileFactory.getProfile();

                if (wifiProfile.isPresent()) {
                    UUIDWiFiProfile uuidWiFiProfile = new UUIDWiFiProfile(-1, wifiProfile.get(), deviceDataStore.getUUID());
                    streamingProfileService.add(uuidWiFiProfile);
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
