package org.inaetics.ails.api.client.view;

import org.inaetics.ails.api.common.model.Location;

/**
 * The View provides a way to ask the {@link User} for his/her current location.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface View {

    /**
     * Ask the user for his/her current location.
     * 
     * @return The user's current location.
     */
    Location askUserForCurrentLocation();
}
