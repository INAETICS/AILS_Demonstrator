package org.inaetics.ails.api.client.factory;

import java.util.Optional;

import org.inaetics.ails.api.common.model.RawLocationProfile;

/**
 * Profile Factory
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 22-10-2015
 */
public interface RawLocationProfileFactory {

    /**
     * Get the current WiFi profile of the device.
     * 
     * @return An optional containing the current WiFi profile of the device if the operation
     *         succeeded, otherwise returns an empty optional.
     */
    public Optional<RawLocationProfile> getProfile();
}
