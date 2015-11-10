package org.inaetics.ails.impl.server.streaming_profile.miner;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;

/**
 * The Streaming Profile Miner will process {@link UserWiFiProfile UserWiFiProfiles} from the
 * {@link BufferService}.
 * 
 * New UserWiFiProfiles arriving from the buffer will be stored. Stored UserWiFiProfiles will be
 * combined with {@link RawLocationProfile RawLocationProfiles} to gather new information about the
 * {@link Location} of a {@link User}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 10-11-2015
 */
public class StreamingProfileMiner {

    // Injected by Dependency Manager
    private volatile BufferService<UserWiFiProfile> buffer;

    public StreamingProfileMiner() {
        new StreamingProfileMinerThread().start();
    }

    private final class StreamingProfileMinerThread extends Thread {

        @Override
        public void run() {
            while (buffer == null) {
                System.out.println("StreamingProfileMiner not yet received BufferService<UserWiFiProfile>");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("StreamingProfileMiner has received BufferService<UserWiFiProfile>");
        }

    }

}
