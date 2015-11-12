package org.inaetics.ails.impl.server.user.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.AnonUser;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.service.UserService;

/**
 * Implementation of UserService.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 04-11-2015
 */
public class UserServiceImpl implements UserService {

    // Injected by Dependency Manager
    private volatile LocationProvider locationProvider;
    private volatile UserDataStore userDataStore;

    @Override
    public AnonUser add(String name, byte[] mac) {
    	UUID uuid = UUID.randomUUID();
    	User user = new User(uuid, name, mac);
    	
        userDataStore.storeUser(user);
        
        return user.asAnonUser();
    }

    @Override
    public List<AnonUser> getAll() {
    	return userDataStore.getAllUsers().stream().map(x -> x.asAnonUser()).collect(Collectors.toList());
    }

    @Override
    public Optional<AnonUser> find(UUID uuid) {
        return userDataStore.getUser(uuid).map(x -> x.asAnonUser());
    }

    @Override
    public Optional<Location> locate(UUID uuid) {
        return locationProvider.locate(uuid);
    }

}
