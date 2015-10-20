package org.inaetics.ails.api.client.Device;

import org.inaetics.ails.api.client.Accuracy;

public interface DeviceService {
	/**
	 * Sets the accuracy with which a location is send back.
	 * 
	 * @param accuracy The accuracy with which a location is send back.
	 */
	public void setAccuracy(Accuracy accuracy);
	
	/**
	 * Sets the user's display name.
	 * 
	 * @param name The user's display name.
	 */
	public void setName(String name);
}
