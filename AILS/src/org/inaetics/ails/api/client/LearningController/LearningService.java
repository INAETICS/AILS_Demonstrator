package org.inaetics.ails.api.client.LearningController;

import java.util.List;

import org.inaetics.ails.api.model.Profile;

public interface LearningService {
	/**
	 * Gets the current WiFi profile of the device.
	 * 
	 * @return The current WiFi profile of the device.
	 */
	public Profile getProfile();
	
	/**
	 * Starts learning mode on the device. When in learning mode, the device
	 * will be queried for its WiFi profile on a regular bases, as defined
	 * in the device model.
	 */
	public void startLearningMode();
	
	/**
	 * Stops learning mode on the device. 
	 */
	public void stopLearningMode();
	
	/**
	 * Sends all profiles gathered during learning mode to the server. 
	 * 
	 * @param profiles List of profiles gathered during learning mode.
	 * 
	 * @return True on success, false on error.
	 */
	public Boolean pushProfile(List<Profile> profiles);
}
