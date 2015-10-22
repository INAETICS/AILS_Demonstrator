package org.inaetics.ails.api.client.factory;

import org.inaetics.ails.api.model.Device;

/**
 * Device Factory
 * 
 * @author Jessy Naus
 * @version 0.1.0
 * @since 22-10-2015
 */
public interface DeviceFactory {

    /**
     * Create a new device.
     * 
     * @return
     */
    public Device createDevice();

    /**
     * Read a device.
     * 
     * @return The current device's state.
     */
    public Device readDevice();

    /**
     * Update a device.
     * 
     * @param device @NotNull the device to update.
     *  
     * @return The current device's state.
     */
    public Device updateDevice(Device device);
}
