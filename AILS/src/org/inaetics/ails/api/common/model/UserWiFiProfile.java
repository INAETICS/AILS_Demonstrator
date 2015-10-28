package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * A UserWiFiProfile can used to store a {@link WiFiProfile} that specifically belongs to a
 * {@link User}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
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
        this.wifiProfile = Preconditions.checkNotNull(wifiProfile);
        this.user = Preconditions.checkNotNull(user);
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
