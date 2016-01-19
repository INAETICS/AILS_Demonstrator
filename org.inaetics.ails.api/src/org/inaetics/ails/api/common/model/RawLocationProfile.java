package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * Representation of raw location profile data. Consists of a WiFi profile and a location
 * description.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 22-10-2015
 */
public class RawLocationProfile implements Key<Integer> {
    
    // Used to reference the object in persistence
    private int storageIndex;

    private WiFiProfile wifiProfile;
    private Location location;
    
    public RawLocationProfile() {
        // Empty constructor for Jackson        
    }

    /**
     * Constructor for RawLocationProfile.
     * 
     * @param storageIndex Index for this object in persistence. Can be either -1 (not yet set) or a
     *        higher value (index of stored object).
     * @param wifiProfile @NotNull WiFiProfile describing the distance to access points.
     * @param location @NotNull Location data.
     * @since 1.0.0
     */
    public RawLocationProfile(int storageIndex, WiFiProfile wifiProfile, Location location) {
        super();
        Preconditions.checkArgument(storageIndex > -2, "storage index must be -1 or higher");
        this.storageIndex = storageIndex;
        this.wifiProfile = Preconditions.checkNotNull(wifiProfile, "wifiProfile is not set");
        this.location = Preconditions.checkNotNull(location, "location is not set");
    }

    /**
     * Retrieve WiFi Profile.
     * 
     * @return the wifiProfile
     * @since 0.1.0
     */
    public WiFiProfile getWifiProfile() {
        return wifiProfile;
    }

    /**
     * Retrieve the Location.
     * 
     * @return the location
     * @since 0.1.0
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @since 1.0.0
     */
    @Override
    public Integer retrieveKey() {
        return storageIndex;
    }
    

    // Below setters only exist for Jackson

    public void setStorageIndex(int storageIndex) {
        this.storageIndex = storageIndex;
    }

    public void setWifiProfile(WiFiProfile wifiProfile) {
        this.wifiProfile = wifiProfile;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
    public String toString() {
        return "UUIDWiFiProfile{index: " + this.storageIndex + ", wifi_profile: " + this.wifiProfile.toString() + ", location: " + this.location.toString() + "}";
    }
    
    

}
