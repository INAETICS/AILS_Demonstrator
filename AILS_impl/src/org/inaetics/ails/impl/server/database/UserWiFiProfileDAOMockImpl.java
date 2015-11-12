package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.inaetics.ails.api.common.model.AnonUserWiFiProfile;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.AnonUserWiFiProfileDAO;

import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link UserWiFiProfile} {@link DAO}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 11-11-2015
 */
public class UserWiFiProfileDAOMockImpl implements AnonUserWiFiProfileDAO {

    private final Map<Integer, AnonUserWiFiProfile> storage;

    public UserWiFiProfileDAOMockImpl() {
        storage = new HashMap<>();
    }

    @Override
    public Integer store(AnonUserWiFiProfile anonUserWiFiProfile) {
        int key = storage.size();
        Preconditions.checkNotNull(anonUserWiFiProfile, "user wifi profile is not set");
        storage.put(key, anonUserWiFiProfile);
        return key;
    }

    @Override
    public void delete(Integer key) {
        storage.remove(Preconditions.checkNotNull(key, "key is not set"));
    }

    @Override
    public void update(AnonUserWiFiProfile anonUserWiFiProfile) {
        Preconditions.checkNotNull(anonUserWiFiProfile, "user wifi profile is not set");
        Preconditions.checkArgument(anonUserWiFiProfile.getKey() > -1, "key is not set");
        storage.put(anonUserWiFiProfile.getKey(), anonUserWiFiProfile);
    }

    @Override
    public Optional<AnonUserWiFiProfile> find(Integer key) {
        Preconditions.checkArgument(key > -1, "key is not set");
        return Optional.ofNullable(storage.get(key));
    }

    @Override
    public List<AnonUserWiFiProfile> getAll() {
        return new ArrayList<>(storage.values());
    }

}
