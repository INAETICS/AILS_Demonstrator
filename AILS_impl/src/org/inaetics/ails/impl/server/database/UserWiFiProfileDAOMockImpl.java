package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.inaetics.ails.api.common.model.UserWiFiProfile;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.UserWiFiProfileDAO;

import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link UserWiFiProfile} {@link DAO}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 11-11-2015
 */
public class UserWiFiProfileDAOMockImpl implements UserWiFiProfileDAO {

    private final Map<Integer, UserWiFiProfile> storage;

    public UserWiFiProfileDAOMockImpl() {
        storage = new HashMap<>();
    }

    @Override
    public Integer store(UserWiFiProfile userWiFiProfile) {
        int key = storage.size();
        Preconditions.checkNotNull(userWiFiProfile, "user wifi profile is not set");
        storage.put(key, userWiFiProfile);
        return key;
    }

    @Override
    public void delete(Integer key) {
        storage.remove(Preconditions.checkNotNull(key, "key is not set"));
    }

    @Override
    public void update(UserWiFiProfile userWiFiProfile) {
        Preconditions.checkNotNull(userWiFiProfile, "user wifi profile is not set");
        Preconditions.checkArgument(userWiFiProfile.getKey() > -1, "key is not set");
        storage.put(userWiFiProfile.getKey(), userWiFiProfile);
    }

    @Override
    public Optional<UserWiFiProfile> find(Integer key) {
        Preconditions.checkArgument(key > -1, "key is not set");
        return Optional.ofNullable(storage.get(key));
    }

    @Override
    public List<UserWiFiProfile> getAll() {
        return new ArrayList<>(storage.values());
    }

}
