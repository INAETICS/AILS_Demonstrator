package org.inaetics.ails.impl.client.controllers.device;

import java.util.UUID;

import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.user.service.UserService;

/**
 * The DeviceControllerImpl class provides a way to register a new user on the server and on its
 * local storage and to set his/her accuracy.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 05-11-2015
 */
public class DeviceControllerImpl implements DeviceController {

    /**
     * The default accuracy value used when a new user is created.
     */
    private static final Accuracy ACCURACY_DEFAULT = Accuracy.AREA;

    // Injected by Dependency Manager
    private volatile UserService userService;
    private volatile DeviceDataStore deviceDataStore;

    @Override
    public void registerUser(String name) {
        UUID uuid = userService.add(name, ACCURACY_DEFAULT);
        deviceDataStore.storeUser(new User(uuid, name, ACCURACY_DEFAULT));
    }

    @Override
    public void setAccuracy(Accuracy accuracy) {
        deviceDataStore.storeAccuracy(accuracy);
    }
}
