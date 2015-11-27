package org.inaetics.ails.api.client.model.wifi_profile_factory;

import java.util.Optional;
import org.inaetics.ails.api.common.model.WiFiProfile;

/**
 * The WiFi Profile Factory provides a method that returns the current WiFi profile of the device.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface WiFiProfileFactory {

    /**
     * Get the current WiFi profile of the device.
     * 
     * @return An optional containing the current WiFi profile of the device if the operation
     *         succeeded, otherwise returns an empty optional.
     */
    public Optional<WiFiProfile> getProfile();
}
