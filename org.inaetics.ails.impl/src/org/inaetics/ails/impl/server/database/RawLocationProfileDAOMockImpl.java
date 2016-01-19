package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.RawLocationProfileDAO;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link RawLocationProfile} {@link DAO}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 11-11-2015
 */
public class RawLocationProfileDAOMockImpl implements RawLocationProfileDAO {
    
    private final Map<Integer, RawLocationProfile> storage;
    
    public RawLocationProfileDAOMockImpl() {
        storage = new HashMap<>();
    }

    @Override
    public Integer store(RawLocationProfile rawLocationProfile) {
        int key = storage.size();
        Preconditions.checkNotNull(rawLocationProfile, "raw location profile is not set");
        storage.put(key, rawLocationProfile);
        return key;
    }

    @Override
    public void delete(Integer key) {
        storage.remove(Preconditions.checkNotNull(key, "key is not set"));
    }

    @Override
    public void update(RawLocationProfile rawLocationProfile) {
        Preconditions.checkNotNull(rawLocationProfile, "raw location profile is not set");
        Preconditions.checkArgument(rawLocationProfile.retrieveKey() > -1, "key is not set");
        storage.put(rawLocationProfile.retrieveKey(), rawLocationProfile);
    }

    @Override
    public Optional<RawLocationProfile> find(Integer key) {
        Preconditions.checkArgument(key > -1, "key is not set");
        return Optional.fromNullable(storage.get(key));
    }

    @Override
    public List<RawLocationProfile> getAll() {
        return new ArrayList<>(storage.values());
    }

}
