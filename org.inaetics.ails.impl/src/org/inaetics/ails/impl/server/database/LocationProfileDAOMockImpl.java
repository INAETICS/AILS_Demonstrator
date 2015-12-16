package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.inaetics.ails.api.common.model.LocationProfile;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.LocationProfileDAO;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link LocationProfile} {@link DAO}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 12-11-2015
 */
public class LocationProfileDAOMockImpl implements LocationProfileDAO {
    
    private final Map<Integer, LocationProfile> storage;
    
    public LocationProfileDAOMockImpl() {
        storage = new HashMap<>();
    }

    @Override
    public Integer store(LocationProfile locationProfile) {
        int key = storage.size();
        Preconditions.checkNotNull(locationProfile, "location profile is not set");
        storage.put(key, locationProfile);
        return key;
    }

    @Override
    public void delete(Integer key) {
        storage.remove(Preconditions.checkNotNull(key, "key is not set"));
    }

    @Override
    public void update(LocationProfile locationProfile) {
        Preconditions.checkNotNull(locationProfile, "location profile is not set");
        Preconditions.checkArgument(locationProfile.getKey() > -1, "key is not set");
        storage.put(locationProfile.getKey(), locationProfile);
    }

    @Override
    public Optional<LocationProfile> find(Integer key) {
        Preconditions.checkArgument(key > -1, "key is not set");
        return Optional.fromNullable(storage.get(key));
    }

    @Override
    public List<LocationProfile> getAll() {
        return new ArrayList<>(storage.values());
    }

}
