package org.inaetics.ails.impl.client.controllers.streaming_wifi_profiles;

import com.google.common.base.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.inaetics.ails.api.client.controllers.streaming_wifi_profiles.StreamingWiFiProfilesController;
import org.inaetics.ails.api.client.exceptions.ServerUnavailableException;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

import com.google.common.base.Preconditions;

/**
 * The StreamingServiceImpl provides an implementation for the {@link StreamingService
 * StreamingService}. It will generate and send on a regular bases {@link UserWiFiProfile
 * UserWiFiProfiles} to the {@link StreamingProfileService StreamingProfileService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.0.0
 * @since 11-11-2015
 */
public class StreamingWiFiProfilesControllerImpl implements StreamingWiFiProfilesController {

    // Injected by Dependency Manager
    private volatile WiFiProfileFactory wifiProfileFactory;
    private volatile DeviceDataStore deviceDataStore;
    private volatile StreamingProfileService streamingProfileService;

    private final Timer timer;

    // The get WiFiProfiles task
    private TimerTask task;

    public StreamingWiFiProfilesControllerImpl() {
        timer = new Timer();
    }

    @Override
    public void startStreaming(int period) throws ServerUnavailableException {
        Preconditions.checkArgument(period > 0, "period must be positive");
        
        if (streamingProfileService == null) {
            throw new ServerUnavailableException("StreamingProfileService unavailable");
        }
        
        System.out.println("Streaming WiFi Profiles started");

        task = new TimerTask() {
            @Override
            public void run() {
                Optional<WiFiProfile> wifiProfile = wifiProfileFactory.getProfile();

                if (wifiProfile.isPresent()) {
                    UUID uuid = deviceDataStore.getUUID().get();
                    UUIDWiFiProfile uuidWiFiProfile =
                            new UUIDWiFiProfile(-1, wifiProfile.get(), uuid);
                    if (streamingProfileService != null) {
                        streamingProfileService.add(uuidWiFiProfile);
                    } else {
                        // Nothing we can really do here.
                        // TODO: make sure this is true.
                    }
                }
            }
        };

        timer.schedule(task, 0, period);
    }

    @Override
    public void stopStreaming() {
        System.out.println("Streaming WiFi Profiles stopped");
        task.cancel();
    }
}
