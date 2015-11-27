package org.inaetics.ails.api.client.controllers.device;

import org.inaetics.ails.api.common.model.Accuracy;

/**
 * The Device Controller Service provides a way to register a new user and to set a user's accuracy.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface DeviceController {
    /**
     * Sets the accuracy with which a location is send back.
     * 
     * @param accuracy @NotNull The accuracy with which a location is send back.
     */
    public void setAccuracy(Accuracy accuracy);

    /**
     * Sets the user's display name.
     * 
     * @param name @NotNull The user's display name.
     */
    public void registerUser(String name);
}
