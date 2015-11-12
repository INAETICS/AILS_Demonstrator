package org.inaetics.ails.impl.client.learning_controller;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.client.factory.WiFiProfileFactory;
import org.inaetics.ails.api.client.learning_controller.LearningService;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.location_profile.LocationProfileService;

/**
 * The LearningServiceImpl provides an implementation of the {@link LearningService LearningService}
 * . When started, the learning mode queries the device for {@link WiFiProfile WiFiProfiles} and
 * decorates them with a {@link Location Location} provided by the constructor. The resulting
 * {@link RawLocationProfile RawLocationProfile} is send to the {@link LocationProfileService
 * LocationProfileService} of the server.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 05-11-2015
 */
public class LearningServiceImpl implements LearningService {

    // Injected by Dependency Manager
    private volatile WiFiProfileFactory wifiProfileFactory;
    private volatile LocationProfileService locationProfileService;

    private final Timer timer;
    private final TimerTask task;

    public LearningServiceImpl(Location location) {

        timer = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                Optional<WiFiProfile> wifiProfile = wifiProfileFactory.getProfile();

                if (wifiProfile.isPresent()) {
                    RawLocationProfile rawLocationProfile =
                            new RawLocationProfile(wifiProfile.get(), location);
                    locationProfileService.add(rawLocationProfile);
                }
            }
        };
    }

    @Override
    public void startLearningMode() {
        timer.schedule(task, 0, 50000);
    }

    @Override
    public void stopLearningMode() {
        task.cancel();
        timer.cancel();
    }
}
