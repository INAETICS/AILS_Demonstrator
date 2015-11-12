package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * Representation of a location profile, the processed version of a {@link RawLocationProfile}. For
 * now its similar to the RawLocationProfile, but it could contain extra information that is vital
 * for matching it to WiFiProfiles that have not yet had a Location appointed to it.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 12-11-2015
 */
public class LocationProfile implements Key<Integer> {

    // Used to reference the object in persistence
    private final int storageIndex;

    private final WiFiProfile wifiProfile;
    private final Location location;

    /**
     * Constructor for LocationProfile.
     * 
     * @param storageIndex Index for this object in persistence. Can be either -1 (not yet set) or a
     *        higher value (index of stored object).
     * @param wifiProfile @NotNull WiFiProfile describing the distance to access points.
     * @param location @NotNull Location data.
     * @since 1.0.0
     */
    public LocationProfile(int storageIndex, WiFiProfile wifiProfile, Location location) {
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
    public Integer getKey() {
        return storageIndex;
    }

}
