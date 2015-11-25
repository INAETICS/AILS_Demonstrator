package org.inaetics.ails.impl.client.controllers.location;

import org.inaetics.ails.api.client.controllers.location.LocationController;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.server.user.service.UserService;

/**
 * The LocationServiceImpl class provides an implementation of the {@link LocationService
 * LocationService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class LocationControllerImpl implements LocationController {
	// Injected by the DM
	private volatile UserService userService;

    @Override
    public Location requestLocation() {
        // TODO Auto-generated method stub
        return null;
    }
	
}
