package org.inaetics.ails.api.client.model.device_data_store;

import java.util.UUID;

import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.User;

/**
 * The Device Data Store provides methods to check whether a User already exists, and if so get and
 * set his/her accuracy and get his/her UUID.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface DeviceDataStore {

    /**
     * Get the current {@link Accuracy} setting of the Device.
     * 
     * @return The current {@link Accuracy} setting.
     */
    Accuracy getAccuracy();

    /**
     * Get the device's UUID.
     * 
     * @return The device's UUID.
     */
    UUID getUUID();

    /**
     * Set the device's User.
     * 
     * @param user The device's user.
     */
    void setUser(User user);

    /**
     * Set the device's {@link Accuracy}.
     * 
     * @param accuracy The device's {@link Accuracy}.
     */
    void setAccuracy(Accuracy accuracy);

    /**
     * Check if the device has a registered user.
     * 
     * @return true if the device has a registered user.
     */
    boolean hasUser();
}
