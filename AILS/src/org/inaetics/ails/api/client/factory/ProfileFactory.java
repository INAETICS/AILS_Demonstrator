package org.inaetics.ails.api.client.factory;

import java.util.Optional;

import org.inaetics.ails.api.common.model.WiFiProfile;

/**
 * Profile Factory
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 22-10-2015
 */
public interface ProfileFactory {

    /**
     * Get the current WiFi profile of the device.
     * 
     * @return An optional containing the current WiFi profile of the device if the operation
     *         succeeded, otherwise returns an empty optional.
     */
    public Optional<WiFiProfile> getProfile();
}
