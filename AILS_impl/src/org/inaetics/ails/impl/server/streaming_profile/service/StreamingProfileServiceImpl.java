package org.inaetics.ails.impl.server.streaming_profile.service;

import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

import com.google.common.base.Preconditions;

/**
 * The StreamingProfileServiceImpl class provides an implementation of the
 * {@link StreamingProfileService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 04-11-2015
 */
public class StreamingProfileServiceImpl implements StreamingProfileService {

    // Injected by Dependency Manager
    private volatile BufferService<UserWiFiProfile> buffer;
    
    @Override
    public void add(UserWiFiProfile userWiFiProfile) {
        // Simply store the received UserWiFiProfile in the Buffer.
        buffer.add(Preconditions.checkNotNull(userWiFiProfile));
    }

}
