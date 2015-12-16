package org.inaetics.ails.api.client.controllers.learning;

import org.inaetics.ails.api.client.exceptions.ServerUnavailableException;
import org.inaetics.ails.api.common.model.Location;

/**
 * The Learning Controller Service provides methods to start/stop the learning mode given a
 * location.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.0.0
 * @since 24-11-2015
 */
public interface LearningController {

    /**
     * Starts learning mode on the device. When in learning mode, the device will be queried for its
     * WiFi profile on a regular bases.
     * 
     * @param location @NotNull The location where the learning mode is started.
     * @param period The period the learning mode should wait in between sending WiFiProfiles. Must
     *        be positive.
     * @throws ServerUnavailableException When the server is unavailable.
     * @since 2.0.0
     */
    void startLearningMode(Location location, int period) throws ServerUnavailableException;

    /**
     * Stops learning mode on the device.
     */
    void stopLearningMode();
}
