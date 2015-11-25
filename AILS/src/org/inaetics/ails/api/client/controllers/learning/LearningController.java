package org.inaetics.ails.api.client.controllers.learning;

import org.inaetics.ails.api.common.model.Location;

/**
 * The Learning Controller Service provides methods to start/stop the learning mode given a
 * location.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public interface LearningController {

    /**
     * Starts learning mode on the device. When in learning mode, the device will be queried for its
     * WiFi profile on a regular bases.
     * 
     * @param location The location where the learning mode is started.
     */
    public void startLearningMode(Location location);

    /**
     * Stops learning mode on the device.
     */
    public void stopLearningMode();
}
