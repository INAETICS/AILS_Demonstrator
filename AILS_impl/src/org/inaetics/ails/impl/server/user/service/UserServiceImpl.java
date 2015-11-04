package org.inaetics.ails.impl.server.user.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.service.UserService;

public class UserServiceImpl implements UserService {
    
    // Injected by Dependency Manager
    private volatile LocationProvider locationProvider;
    
    public UserServiceImpl() {
        // TODO Auto-generated constructor stub
        System.out.println("constructing UserServiceImpl");
    }
    
    @Override
    public void add(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<User> find(UUID uuid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Location> locate(UUID uuid) {
        return locationProvider.locate(uuid);
    }

}
