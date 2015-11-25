package org.inaetics.ails.impl.client.model.device_data_store;

import java.util.UUID;

import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.User;

public class DeviceDatStoreImpl implements DeviceDataStore {

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
