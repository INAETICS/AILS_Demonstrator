package org.inaetics.ails.api.common.model;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Representation of raw location profile data. Consists of a WiFi profile and a location
 * description.
 * 
 * @author nicokorthout
 * @version 0.1.0
 * @since 22-10-2015
 */
public class RawLocationProfile {

    private final WiFiProfile wifiProfile;
    private final Location location;

    /**
     * Constructor for RawLocationProfile.
     * 
     * @param wifiProfile @NotNull WiFiProfile describing the distance to access points.
     * @param location @NotNull Location data.
     */
    public RawLocationProfile(WiFiProfile wifiProfile, Location location) {
        super();
        this.wifiProfile = checkNotNull(wifiProfile);
        this.location = checkNotNull(location);
    }

    /**
     * Retrieve WiFi Profile.
     * 
     * @return the wifiProfile
     */
    public WiFiProfile getWifiProfile() {
        return wifiProfile;
    }

    /**
     * Retrieve the Location.
     * 
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

}
