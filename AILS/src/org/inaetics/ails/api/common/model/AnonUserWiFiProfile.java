package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * A UserWiFiProfile can used to store a {@link WiFiProfile} that specifically belongs to a
 * {@link AnonUser}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 28-10-2015
 */
public class AnonUserWiFiProfile implements Key<Integer> {

    // Used to reference the object in persistence
    private final int storageIndex;
    
    private final WiFiProfile wifiProfile;
    private final AnonUser user;

    /**
     * Constructor for UserWiFiProfile.
     * 
     * @param storageIndex Index for this object in persistence. Can be either -1 (not yet set) or a
     *        higher value (index of stored object).
     * @param wifiProfile @NotNull WiFiProfile describing the distance to access points.
     * @param user @NotNull User data.
     * @since 1.0.0
     */
    public AnonUserWiFiProfile(int storageIndex, WiFiProfile wifiProfile, AnonUser user) {
        super();
        Preconditions.checkArgument(storageIndex > -2, "storage index must be -1 or higher");
        this.storageIndex = storageIndex;
        this.wifiProfile = Preconditions.checkNotNull(wifiProfile, "wifi profile is not set");
        this.user = Preconditions.checkNotNull(user, "user is not set");
    }

    /**
     * Retrieve WiFi Profile.
     * 
     * @return the wifiProfile.
     * @since 0.1.0
     */
    public WiFiProfile getWifiProfile() {
        return wifiProfile;
    }

    /**
     * Retrieve the User.
     * 
     * @return the user.
     * @since 0.1.0
     */
    public AnonUser getUser() {
        return user;
    }

    /**
     * @since 1.0.0
     */
    @Override
    public Integer getKey() {
        return storageIndex;
    }

}
