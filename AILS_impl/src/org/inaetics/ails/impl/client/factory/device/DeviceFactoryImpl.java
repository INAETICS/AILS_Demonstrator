package org.inaetics.ails.impl.client.factory.device;

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

    @Override
    public Device createDevice() {
        throw new UnsupportedOperationException(
                "DeviceFactoryImpl.createDevice() not yet implemented.");
    }

    @Override
    public Device readDevice() {
        throw new UnsupportedOperationException(
                "DeviceFactoryImpl.readDevice() not yet implemented.");
    }

    @Override
    public Device updateDevice(Device device) {
        throw new UnsupportedOperationException(
                "DeviceFactoryImpl.updateDevice(Device device) not yet implemented.");
    }

}
