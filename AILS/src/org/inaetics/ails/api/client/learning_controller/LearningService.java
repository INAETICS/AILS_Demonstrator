package org.inaetics.ails.api.client.learning_controller;

/**
 * Learning Service
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 20-10-2015
 */
public interface LearningService {

    /**
     * Starts learning mode on the device. When in learning mode, the device will be queried for its
     * WiFi profile on a regular bases, as defined in the device model.
     */
    public void startLearningMode();

    /**
     * Stops learning mode on the device.
     */
    public void stopLearningMode();
}
