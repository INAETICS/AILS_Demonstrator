package org.inaetics.ails.impl.server.user.service;

import java.util.List;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.service.UserService;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Implementation of UserService.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.1
 * @since 04-11-2015
 */
public class UserServiceImpl implements UserService {

    // Injected by Dependency Manager
    private volatile LocationProvider locationProvider;
    private volatile UserDataStore userDataStore;

    @Override
    public UUID add(String name, Accuracy accuracy) {
        Preconditions.checkNotNull(name, "name is not set");
        Preconditions.checkNotNull(accuracy, "accuracy is not set");
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, name, accuracy);

        return userDataStore.storeUser(user);
    }

    @Override
    public List<User> getAll() {
        return userDataStore.getAllUsers();
    }

    @Override
    public Optional<User> find(UUID uuid) {
        return userDataStore.getUser(Preconditions.checkNotNull(uuid, "uuid is not set"));
    }

    @Override
    public Optional<Location> locate(UUID uuid) {
        return locationProvider.locate(Preconditions.checkNotNull(uuid, "uuid is not set"));
    }

}
