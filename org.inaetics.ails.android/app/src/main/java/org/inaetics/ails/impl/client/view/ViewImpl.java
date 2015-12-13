package org.inaetics.ails.impl.client.view;

import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.controllers.learning.LearningController;
import org.inaetics.ails.api.client.controllers.streaming_wifi_profiles.StreamingWiFiProfilesController;
import org.inaetics.ails.api.client.controllers.users.UsersController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.client.view.View;
import org.inaetics.ails.api.common.model.Location;

/**
 * The ViewImpl class provides a way to ask the user for its current location and manages the
 * different views shown to the user.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.1
 * @since 05-11-2015
 */
public class ViewImpl implements View {

    // Injected by the dependency manager
    private volatile DeviceDataStore deviceDataStore;
    private volatile DeviceController deviceController;
    private volatile UsersController usersController;
    private volatile StreamingWiFiProfilesController streamingWiFiProfilesController;
    private volatile LearningController learningController;
        
    // TODO: Need to implement views for client.

    @Override
    public Location askUserForCurrentLocation() {
        // TODO: Need to ask user for its current location.
        return new Location("Entrance", "Main Building", "Thales NL", "Thales");
    }

}
