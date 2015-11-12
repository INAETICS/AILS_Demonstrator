package org.inaetics.ails.api.client.dao.device;

import org.inaetics.ails.api.common.model.Device;

/**
 * Device DAO that provides the device with a way to save locally its settings.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 22-10-2015
 */
public interface DeviceDAO {

    /**
     * Create a new device given a name and a MAC address.
     * 
     * @param name @notNull the user's name
     * @param mac @notNull the user's MAC address.
     * 
     * @return A new device.
     */
    public Device createDevice(String name, byte[] mac);

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
