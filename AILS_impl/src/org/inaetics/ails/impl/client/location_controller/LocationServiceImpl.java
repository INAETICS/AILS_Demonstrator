package org.inaetics.ails.impl.client.location_controller;

import java.util.List;
import java.util.Optional;

import org.inaetics.ails.api.client.location_controller.LocationService;
import org.inaetics.ails.api.common.model.Location;
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

    @Override
    public List<AnonUser> getUsers() {
        throw new UnsupportedOperationException(
                "LocationServiceImpl.getUsers() not yet implemented.");
    }

    @Override
    public void displayUserlist(List<AnonUser> users) {
        throw new UnsupportedOperationException(
                "LocationServiceImpl.displayUserlist(List<User> user) not yet implemented.");
    }

    @Override
    public Optional<Location> queryUserLocation(AnonUser user) {
        throw new UnsupportedOperationException(
                "LocationServiceImpl.queryUserLocation(User user) not yet implemented.");
    }

    @Override
    public void displayLocation(Location location) {
        throw new UnsupportedOperationException(
                "LocationServiceImpl.displayLocation(Location location) not yet implemented.");
    }

}
