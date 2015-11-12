package org.inaetics.ails.impl.client.dao.device;

import java.util.UUID;

import org.inaetics.ails.api.client.dao.device.DeviceDAO;
import org.inaetics.ails.api.common.model.Device;
import org.inaetics.ails.api.common.model.User;

/**
 * The DeviceFactoryImpl class provides an implementation of the {@link DeviceFactory DeviceFactory}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class DeviceDAOImpl implements DeviceDAO {

    private Device device;

    @Override
    public Device createDevice() {
        // TODO: Should receive UUID from the server.
        String name = "AILS";
        UUID uuid = UUID.randomUUID();
        byte[] mac = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};

        User user = new User(uuid, name, mac);

        return device = new Device(user, null);
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
