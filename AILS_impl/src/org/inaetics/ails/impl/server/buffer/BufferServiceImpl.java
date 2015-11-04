package org.inaetics.ails.impl.server.buffer;

import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;

/**
 * The BufferServiceImpl class provides an implementation of the {@link BufferService BufferService}
 * for buffering {@link UserWiFiProfile UserWiFiProfiles}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 04-11-2015
 */
public class BufferServiceImpl implements BufferService<UserWiFiProfile> {

    @Override
    public void add(UserWiFiProfile e) {
        throw new UnsupportedOperationException("BufferServiceImpl.add(UserWiFiProfile e) not yet implemented."); 
    }

    @Override
    public UserWiFiProfile remove() {
        throw new UnsupportedOperationException("BufferServiceImpl.remove() not yet implemented."); 
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("BufferServiceImpl.size() not yet implemented."); 
    }

}
