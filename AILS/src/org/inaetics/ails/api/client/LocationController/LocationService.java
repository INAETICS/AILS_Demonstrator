package org.inaetics.ails.api.client.LocationController;

import java.util.List;

import org.inaetics.ails.api.model.Location;
import org.inaetics.ails.api.model.Profile;
import org.inaetics.ails.api.model.User;

public interface LocationService {
	/**
	 * Get the current WiFi profile of the device.
	 * 
	 * @return The current WiFi profile of the device.
	 */
	public Profile getProfile();

	/**
	 * Get the user list from the server.
	 * 
	 * @return List of users.
	 */
	public List<User> getUsers();
	
	/**
	 * Display a list of users.
	 * 
	 * @param users List of users
	 */
	public void displayUserlist(List<User> users);
		
	/**
	 * Get the location of a given user.
	 * 
	 * @param user The given user.
	 * 
	 * @return The location of the given user.
	 */
	public Location queryUserLocation(User user);
	
	/**
	 * Display a location.
	 * 
	 * @param location Location to be displayed.
	 */
	public void displayLocation(Location location);
}
