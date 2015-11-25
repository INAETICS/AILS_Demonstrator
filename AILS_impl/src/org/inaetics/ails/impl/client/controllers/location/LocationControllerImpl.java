package org.inaetics.ails.impl.client.controllers.location;

import org.inaetics.ails.api.client.controllers.location.LocationController;
import org.inaetics.ails.api.client.view.View;
import org.inaetics.ails.api.common.model.Location;

/**
 * The LocationControllerImpl class provides a way to retrieve the user's current location if the
 * server couldn't find a match. It will ask the view to notify the user for its location.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class LocationControllerImpl implements LocationController {
    // Injected by the DM
    private volatile View view;

    @Override
    public Location requestLocation() {
        return view.askUserForCurrentLocation();
    }

}
