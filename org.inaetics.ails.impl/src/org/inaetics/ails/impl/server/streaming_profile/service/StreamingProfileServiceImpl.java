package org.inaetics.ails.impl.server.streaming_profile.service;

import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

import com.google.common.base.Preconditions;

/**
 * The StreamingProfileServiceImpl class provides an implementation of the
 * {@link StreamingProfileService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.4
 * @since 04-11-2015
 */
public class StreamingProfileServiceImpl implements StreamingProfileService {

    // Injected by Dependency Manager
    private volatile BufferService<UUIDWiFiProfile> buffer;
    
    @Override
    public void add(UUIDWiFiProfile uuidWiFiProfile) {
        // Simply store the received uuidWiFiProfile in the Buffer.
        buffer.add(Preconditions.checkNotNull(uuidWiFiProfile, "uuid wifi profile not set"));
    }

}
