package org.inaetics.ails.api.client.learning_controller;

import org.inaetics.ails.api.common.model.Location;

/**
 * Learning Service
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 20-10-2015
 */
public interface LearningService {

    /**
     * Starts learning mode on the device. When in learning mode, the device will be queried for its
     * WiFi profile on a regular bases, as defined in the device model.
     * 
     * @param location The location where the learning mode is started.
     */
    public void startLearningMode(Location location);

    /**
     * Stops learning mode on the device.
     */
    public void stopLearningMode();
}
