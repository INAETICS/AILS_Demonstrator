package org.inaetics.ails.api.common.model;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Representation of raw location profile data. Consists of a WiFi profile and a location
 * description.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 28-10-2015
 */
public class UserWiFiProfile {

    private final WiFiProfile wifiProfile;
    private final User user;

    /**
     * Constructor for UserWiFiProfile.
     * 
     * @param wifiProfile @NotNull WiFiProfile describing the distance to access points.
     * @param user @NotNull User data.
     */
    public UserWiFiProfile(WiFiProfile wifiProfile, User user) {
        super();
        this.wifiProfile = checkNotNull(wifiProfile);
        this.user = checkNotNull(user);
    }

    /**
     * Retrieve WiFi Profile.
     * 
     * @return the wifiProfile.
     */
    public WiFiProfile getWifiProfile() {
        return wifiProfile;
    }

    /**
     * Retrieve the User.
     * 
     * @return the user.
     */
    public User getUser() {
        return user;
    }
}
