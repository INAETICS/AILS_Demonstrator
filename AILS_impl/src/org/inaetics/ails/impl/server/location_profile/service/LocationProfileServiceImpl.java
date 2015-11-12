package org.inaetics.ails.impl.server.location_profile.service;

import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;

import com.google.common.base.Preconditions;

/**
 * The LocationProfileServiceImpl class provides an implementation of the
 * {@link LocationProfileService LocationProfileService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 04-11-2015
 */
public class LocationProfileServiceImpl implements LocationProfileService {
    
    private volatile BufferService<RawLocationProfile> buffer;

    @Override
    public void add(RawLocationProfile locationProfile) {
        buffer.add(Preconditions.checkNotNull(locationProfile, "location profile is not set"));
    }

}
