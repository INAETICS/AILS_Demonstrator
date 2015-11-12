package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.UserLocation;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.UserLocationDAO;

import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link UserLocation} {@link DAO}.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 10-11-2015
 */
public class UserLocationDAOMockImpl implements UserLocationDAO {

    private final Map<UUID, UserLocation> storage;

    public UserLocationDAOMockImpl() {
        storage = new HashMap<>();
    }

    @Override
    public UUID store(UserLocation userLocation) {
        Preconditions.checkNotNull(userLocation, "user location is not set");
        UUID uuid = userLocation.getUser().getUuid();
        storage.put(uuid, userLocation);
        return uuid;
    }

    @Override
    public void delete(UUID uuid) {
        storage.remove(Preconditions.checkNotNull(uuid, "uuid is not set"));
    }

    @Override
    public void update(UserLocation userLocation) {
        Preconditions.checkNotNull(userLocation, "user location is not set");
        storage.put(userLocation.getKey(), userLocation);
    }

    @Override
    public Optional<UserLocation> find(UUID uuid) {
        Preconditions.checkNotNull(uuid, "uuid is not set");
        return Optional.ofNullable(storage.get(uuid));
    }

    @Override
    public List<UserLocation> getAll() {
        return new ArrayList<>(storage.values());
    }

}
