package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.UUIDWiFiProfileDAO;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link UUIDWiFiProfile} {@link DAO}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 11-11-2015
 */
public class UUIDWiFiProfileDAOMockImpl implements UUIDWiFiProfileDAO {

    private final Map<Integer, UUIDWiFiProfile> storage;

    public UUIDWiFiProfileDAOMockImpl() {
        storage = new HashMap<>();
    }

    @Override
    public Integer store(UUIDWiFiProfile uuidWiFiProfile) {
        int key = storage.size();
        Preconditions.checkNotNull(uuidWiFiProfile, "uud wifi profile is not set");
        storage.put(key, uuidWiFiProfile);
        return key;
    }

    @Override
    public void delete(Integer key) {
        storage.remove(Preconditions.checkNotNull(key, "key is not set"));
    }

    @Override
    public void update(UUIDWiFiProfile uuidWiFiProfile) {
        Preconditions.checkNotNull(uuidWiFiProfile, "uuid wifi profile is not set");
        Preconditions.checkArgument(uuidWiFiProfile.getKey() > -1, "key is not set");
        storage.put(uuidWiFiProfile.getKey(), uuidWiFiProfile);
    }

    @Override
    public Optional<UUIDWiFiProfile> find(Integer key) {
        Preconditions.checkArgument(key > -1, "key is not set");
        return Optional.fromNullable(storage.get(key));
    }

    @Override
    public List<UUIDWiFiProfile> getAll() {
        return new ArrayList<>(storage.values());
    }

}
