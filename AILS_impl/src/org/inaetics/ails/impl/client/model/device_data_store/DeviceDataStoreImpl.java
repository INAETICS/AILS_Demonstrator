package org.inaetics.ails.impl.client.model.device_data_store;

import java.util.UUID;

import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.User;

/**
 * The DeviceDatStoreImpl class provides a way to store a user in-memory.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 25-11-2015
 */
public class DeviceDataStoreImpl implements DeviceDataStore {

    User user;
    
    @Override
    public Accuracy getAccuracy() {
        return user.getAccuracy();
    }

    @Override
    public UUID getUUID() {
        return user.getUuid();
    }

    @Override
    public void storeUser(User user) {
        this.user = new User(user.getUuid(), user.getName(), user.getAccuracy());
    }

    @Override
    public void storeAccuracy(Accuracy accuracy) {
        this.user = new User(user.getUuid(), user.getName(), accuracy);
    }

    @Override
    public boolean hasUser() {
        return user != null;
    }

}