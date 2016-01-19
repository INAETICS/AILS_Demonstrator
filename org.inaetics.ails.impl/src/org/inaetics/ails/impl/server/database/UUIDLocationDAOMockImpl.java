package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.UUIDLocation;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.UUIDLocationDAO;

import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link UUIDLocation} {@link DAO}.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 10-11-2015
 */
public class UUIDLocationDAOMockImpl implements UUIDLocationDAO {

    private final Map<UUID, UUIDLocation> storage;

    public UUIDLocationDAOMockImpl() {
        storage = new HashMap<>();
    }

    @Override
    public UUID store(UUIDLocation uuidLocation) {
        Preconditions.checkNotNull(uuidLocation, "uuid location is not set");
        UUID uuid = uuidLocation.getUUID();
        storage.put(uuid, uuidLocation);
        return uuid;
    }

    @Override
    public void delete(UUID uuid) {
        storage.remove(Preconditions.checkNotNull(uuid, "uuid is not set"));
    }

    @Override
    public void update(UUIDLocation uuidLocation) {
        Preconditions.checkNotNull(uuidLocation, "uuid location is not set");
        storage.put(uuidLocation.retrieveKey(), uuidLocation);
    }

    @Override
    public Optional<UUIDLocation> find(UUID uuid) {
        Preconditions.checkNotNull(uuid, "uuid is not set");
        return Optional.ofNullable(storage.get(uuid));
    }

    @Override
    public List<UUIDLocation> getAll() {
        return new ArrayList<>(storage.values());
    }

}
