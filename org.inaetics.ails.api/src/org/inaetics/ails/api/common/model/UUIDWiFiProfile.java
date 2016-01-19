package org.inaetics.ails.api.common.model;

import java.util.UUID;

import com.google.common.base.Preconditions;

/**
 * A UUIDWiFiProfile is used to store a {@link WiFiProfile} that specifically belongs to a
 * {@link User}'s UUID.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 24-11-2015
 */
public class UUIDWiFiProfile implements Key<Integer> {

    // Used to reference the object in persistence
    private int storageIndex;

    private WiFiProfile wifiProfile;
    private UUID uuid;
    
    public UUIDWiFiProfile() {
        // empty constructor for Jackson
    }

    /**
     * Constructor for UserWiFiProfile.
     * 
     * @param storageIndex Index for this object in persistence. Can be either -1 (not yet set) or a
     *        higher value (index of stored object).
     * @param wifiProfile @NotNull WiFiProfile describing the distance to access points.
     * @param user @NotNull User data.
     * @since 1.0.0
     */
    public UUIDWiFiProfile(int storageIndex, WiFiProfile wifiProfile, UUID uuid) {
        super();
        Preconditions.checkArgument(storageIndex > -2, "storage index must be -1 or higher");
        this.storageIndex = storageIndex;
        this.wifiProfile = Preconditions.checkNotNull(wifiProfile, "wifi profile is not set");
        this.uuid = Preconditions.checkNotNull(uuid, "user is not set");
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
     * Retrieve the UUID.
     * 
     * @return the user.
     * @since 0.1.0
     */
    public UUID getUuid() {
        return uuid;
    }
    
    // Setters needed for Jackson

    public void setStorageIndex(int storageIndex) {
        this.storageIndex = storageIndex;
    }

    public void setWifiProfile(WiFiProfile wifiProfile) {
        this.wifiProfile = wifiProfile;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * @since 1.0.0
     */
    @Override
    public Integer retrieveKey() {
        return storageIndex;
    }
    
    public String toString() {
        return "UUIDWiFiProfile{index: " + this.storageIndex + ", wifi_profile: " + this.wifiProfile.toString() + ", uuid: " + this.uuid + "}";
    }

}
