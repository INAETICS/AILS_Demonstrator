package org.inaetics.ails.impl.client.device_controller;

import org.inaetics.ails.api.client.dao.device.DeviceDAO;
import org.inaetics.ails.api.client.device_controller.DeviceService;
import org.inaetics.ails.api.common.model.Accuracy;

/**
 * The DeviceServiceImpl class provides an implementation of the
 * {@link DeviceService DeviceService}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class DeviceServiceImpl implements DeviceService {
	
	// Injected by Dependency Manager
    private volatile DeviceDAO device;
    
    @Override
    public void setAccuracy(Accuracy accuracy) {
        throw new UnsupportedOperationException(
                "DeviceServiceImpl.setName(String name) not yet implemented.");
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException(
                "DeviceServiceImpl.setName(String name) not yet implemented.");
    }

}
