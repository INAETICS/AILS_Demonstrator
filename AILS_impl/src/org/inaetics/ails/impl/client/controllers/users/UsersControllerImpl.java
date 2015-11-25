package org.inaetics.ails.impl.client.controllers.users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.client.controllers.users.UsersController;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.user.service.UserService;

/**
 * The UsersControllerImpl class provides a way to retrieve the user list from the server and to
 * send a request to the server for the location of a specific user.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 25-11-2015
 */
public class UsersControllerImpl implements UsersController {

    // Injected by the DM
    private volatile UserService userService;
    
    @Override
    public List<User> getAll() {
        return userService.getAll();
    }

    @Override
    public Optional<Location> getLocationForUser(UUID uuid) {
        return userService.locate(uuid);
    }

}
