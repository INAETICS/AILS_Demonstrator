package org.inaetics.ails.impl.client.controllers.device;

import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.user.service.UserService;

/**
 * The DeviceControllerImpl class provides an implementation of the
 * {@link DeviceController DeviceController}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 05-11-2015
 */
public class DeviceControllerImpl implements DeviceController {
	
	// Injected by Dependency Manager
    private volatile UserService userService;
    private volatile DeviceDataStore deviceDataStore;
    
    @Override
    public void registerUser(String name) {
        // TODO: Implementation
//        User user = userService.add(name);
//        deviceDataStore
    }

    @Override
    public void setAccuracy(Accuracy accuracy) {
        // TODO: Implementation   
    }
}
