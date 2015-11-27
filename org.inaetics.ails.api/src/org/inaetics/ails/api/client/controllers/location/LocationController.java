package org.inaetics.ails.api.client.controllers.location;

import org.inaetics.ails.api.common.model.Location;

/**
 * The Location Controller Service provides a method to request the location of an User.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface LocationController {

    /**
     * Request the Location of the User by notifying the UI.
     * 
     * @return The user's current location.
     */
    Location requestLocation();
}
