package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * Representation of raw location profile data. Consists of a WiFi profile and a location
 * description.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
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
        this.wifiProfile = Preconditions.checkNotNull(wifiProfile);
        this.location = Preconditions.checkNotNull(location);
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
