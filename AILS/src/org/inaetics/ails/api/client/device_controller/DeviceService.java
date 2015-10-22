package org.inaetics.ails.api.client.device_controller;

import org.inaetics.ails.api.model.Accuracy;

/**
 * Device services
 * 
 * @author Jessy Naus
 * @version 0.1.0
 * @since 20-10-2015
 */
public interface DeviceService {
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
    public void setName(String name);
}
