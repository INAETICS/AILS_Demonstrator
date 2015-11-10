package org.inaetics.ails.impl.client.factory.device;

import java.util.UUID;

import org.inaetics.ails.api.client.factory.DeviceFactory;
import org.inaetics.ails.api.common.model.Device;

/**
 * The DeviceFactoryImpl class provides an implementation of the {@link DeviceFactory DeviceFactory}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class DeviceFactoryImpl implements DeviceFactory {

    private Device device;

    @Override
    public Device createDevice() {
        String name = "AILS";
        UUID uuid = UUID.randomUUID();
        byte[] mac = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};

        return device = new Device(name, mac, uuid, null);
    }

    @Override
    public Device readDevice() {
        return device;
    }

    @Override
    public Device updateDevice(Device device) {
        return this.device = device;
    }

}
