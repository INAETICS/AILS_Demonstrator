package org.inaetics.ails.impl.server.user.extended_datastore;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.common.model.UserLocation;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;

/**
 * Implementation of the DataStores for User and Location combined. Provides a way to store and read
 * current Location information for a specific User as well as the standard store and read of User
 * information.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 04-11-2015
 */
public class UserExtendedDataStoreImpl implements UserDataStore, UserLocationDataStore {

    // TODO add DAO dependency

    @Override
    public Optional<User> getUser(UUID uuid) {
        throw new UnsupportedOperationException(
                "UserExtendedDataStoreImpl.getUser(UUID uuid) not yet implemented.");
    }

    @Override
    public void storeUser(User user) {
        throw new UnsupportedOperationException(
                "UserExtendedDataStoreImpl.storeUser(User user) not yet implemented.");
    }

    @Override
    public Optional<Location> getLocation(UUID uuid) {
        throw new UnsupportedOperationException(
                "UserExtendedDataStoreImpl.getLocation(UUID uuid) not yet implemented.");
    }

    @Override
    public void storeUserLocation(UserLocation userLocation) {
        throw new UnsupportedOperationException(
                "UserExtendedDataStoreImpl.storeUserLocation(UserLocation userLocation) not yet implemented.");
    }
}
