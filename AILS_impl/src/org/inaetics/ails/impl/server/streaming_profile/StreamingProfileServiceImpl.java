package org.inaetics.ails.impl.server.streaming_profile;

import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.server.streaming_profile.StreamingProfileService;
import org.inaetics.ails.impl.server.buffer.BufferServiceImpl;

import com.google.common.base.Preconditions;

/**
 * The StreamingProfileServiceImpl class provides an implementation of the
 * {@link StreamingProvileService StreamingProfileService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 04-11-2015
 */
public class StreamingProfileServiceImpl implements StreamingProfileService {

    // Injected by Dependency Manager
    public volatile BufferServiceImpl buffer;

    /**
     * This constructs a Streaming Profile Service with a buffer.
     * 
     * @param buffer @NotNull The steaming profile buffer.
     */
    public StreamingProfileServiceImpl(BufferServiceImpl buffer) {
        this.buffer = Preconditions.checkNotNull(buffer, "Buffer is not set");
    }

    @Override
    public void add(UserWiFiProfile userWiFiProfile) {
        buffer.add(userWiFiProfile);
    }

}
