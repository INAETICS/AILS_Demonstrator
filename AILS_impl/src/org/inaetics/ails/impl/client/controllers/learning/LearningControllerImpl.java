package org.inaetics.ails.impl.client.controllers.learning;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.inaetics.ails.api.client.controllers.learning.LearningController;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;

/**
 * The LearningControllerImpl provides an implementation of the {@link LearningController
 * LearningController} . When started, the learning mode queries the device for {@link WiFiProfile
 * WiFiProfiles} and decorates them with a {@link Location Location} provided by the constructor.
 * The resulting {@link RawLocationProfile RawLocationProfile} is send to the
 * {@link LocationProfileService LocationProfileService} of the server.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 05-11-2015
 */
public class LearningControllerImpl implements LearningController {

    // Injected by Dependency Manager
    private volatile WiFiProfileFactory wifiProfileFactory;
    private volatile LocationProfileService locationProfileService;

    private final Timer timer;

    public LearningControllerImpl() {
        timer = new Timer();
    }

    @Override
    public void startLearningMode(Location location) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Optional<WiFiProfile> wifiProfile = wifiProfileFactory.getProfile();

                if (wifiProfile.isPresent()) {
                    RawLocationProfile rawLocationProfile =
                            new RawLocationProfile(-1, wifiProfile.get(), location);
                    locationProfileService.add(rawLocationProfile);
                }
            }
        };

        timer.schedule(task, 0, 50000);
    }

    @Override
    public void stopLearningMode() {
        timer.cancel();
    }
}
