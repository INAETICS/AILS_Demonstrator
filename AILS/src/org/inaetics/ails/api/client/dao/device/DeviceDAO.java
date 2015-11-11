package org.inaetics.ails.api.client.dao.device;

import org.inaetics.ails.api.common.model.Device;

/**
 * Device Factory
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 22-10-2015
 */
public interface DeviceDAO {

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
