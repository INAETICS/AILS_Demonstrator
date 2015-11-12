package org.inaetics.ails.impl.client.location_controller;

import java.util.List;
import java.util.Optional;

import org.inaetics.ails.api.client.location_controller.LocationService;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.server.user.service.UserService;
import org.inaetics.ails.api.common.model.AnonUser;

/**
 * The LocationServiceImpl class provides an implementation of the {@link LocationService
 * LocationService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class LocationServiceImpl implements LocationService {
	// Injected by the DM
	private volatile UserService userService;

    @Override
    public List<AnonUser> getUsers() {
    	return userService.getAll();
    }

    @Override
    public Optional<Location> queryUserLocation(AnonUser user) {
        return userService.locate(user.getUuid());
    }

}
