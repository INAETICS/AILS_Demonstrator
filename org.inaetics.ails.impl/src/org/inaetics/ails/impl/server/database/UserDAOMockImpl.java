package org.inaetics.ails.impl.server.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.UserDAO;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * Mock implementation for a {@link AnonUser} {@link DAO}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 10-11-2015
 */
public class UserDAOMockImpl implements UserDAO {

    private final Map<UUID, User> storage;
    
    public UserDAOMockImpl() {
        storage = new HashMap<>();
    }
    
    @Override
    public UUID store(User user) {
        Preconditions.checkNotNull(user, "user is not set");
        UUID uuid = user.getUuid();
        storage.put(uuid, user);
        return uuid;
    }

    @Override
    public void delete(UUID uuid) {
        storage.remove(Preconditions.checkNotNull(uuid, "uuid is not set"));
    }

    @Override
    public void update(User user) {
        Preconditions.checkNotNull(user, "user is not set");
        storage.put(user.getKey(), user);
    }

    @Override
    public Optional<User> find(UUID uuid) {
        Preconditions.checkNotNull(uuid, "uuid is not set");
        return Optional.fromNullable(storage.get(uuid));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(storage.values());
    }

}
