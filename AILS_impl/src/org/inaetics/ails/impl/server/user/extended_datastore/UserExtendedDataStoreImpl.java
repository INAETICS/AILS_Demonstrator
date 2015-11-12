package org.inaetics.ails.impl.server.user.extended_datastore;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.AnonUser;
import org.inaetics.ails.api.common.model.UserLocation;
import org.inaetics.ails.api.server.database.UserDAO;
import org.inaetics.ails.api.server.database.UserLocationDAO;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;

import com.google.common.base.Preconditions;

/**
 * Implementation of the DataStores for User and Location combined. Provides a way to store and read
 * current Location information for a specific User as well as the standard store and read of User
 * information.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 04-11-2015
 */
public class UserExtendedDataStoreImpl implements UserDataStore, UserLocationDataStore {

    // Injected by Dependency Manager
    private volatile UserDAO userDAO;
    private volatile UserLocationDAO userLocationDAO;

    @Override
    public Optional<User> getUser(UUID uuid) {
        return userDAO.find(Preconditions.checkNotNull(uuid, "uuid is not set"));
    }

    @Override
    public void storeUser(User user) {
        userDAO.store(Preconditions.checkNotNull(user, "user is not set"));
    }

    @Override
    public Optional<Location> getLocation(UUID uuid) {
        Preconditions.checkNotNull(uuid, "uuid is not set");
        return userLocationDAO.find(uuid).map(UserLocation::getLocation);
    }

    @Override
    public void storeUserLocation(UserLocation userLocation) {
        userLocationDAO.store(userLocation);
    }

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAll();
	}
}
