package org.inaetics.ails.api.client.controllers.device;

import org.inaetics.ails.api.client.exceptions.ServerUnavailableException;
import org.inaetics.ails.api.common.model.Accuracy;

/**
 * The Device Controller Service provides a way to register a new user and to set a user's accuracy.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 24-11-2015
 */
public interface DeviceController {
    /**
     * Sets the accuracy with which a location is send back.
     * 
     * @param accuracy @NotNull The accuracy with which a location is send back.
     */
    void setAccuracy(Accuracy accuracy);

    /**
     * Sets the user's display name.
     * 
     * @param name @NotNull The user's display name.
     * @throws ServerUnavailableException When the UserService (i.e. the server) is not available.
     */
    void registerUser(String name) throws ServerUnavailableException;
}
