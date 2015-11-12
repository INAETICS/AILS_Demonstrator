package org.inaetics.ails.impl.client.device_controller;

import org.inaetics.ails.api.client.dao.device.DeviceDAO;
import org.inaetics.ails.api.client.device_controller.DeviceService;
import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.Device;

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
    private volatile DeviceDAO deviceDAO;
    
    @Override
    public void setAccuracy(Accuracy accuracy) {
        Device currentDevice = deviceDAO.readDevice();
        Device newDevice = new Device(currentDevice.getUser(), accuracy);
        
        deviceDAO.updateDevice(newDevice);
    }

    @Override
    public void setName(String name) {
        byte[] mac = {(byte) 0xBE, (byte) 0xCE, (byte) 0x60, (byte) 0x8D, (byte) 0xE9, (byte) 0x84};
        
        deviceDAO.createDevice(name, mac);
    }

}
