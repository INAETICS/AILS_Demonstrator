package org.inaetics.ails.api.common.model;

/**
 * Representation of a WiFi
 * 
 * @author Jessy Naus
 *
 */
public class WiFiProfile {
    private final String SSID;
    private final byte[] mac;
    private final int rssi;
    private final int networkId;

    /**
     * Constructor for WiFiProfile.
     * 
     * @param SSID @NotNull SSID of the access point.
     * @param mac @NotNull MAC address of the access point.
     * @param rssi Rssi value of the access point.
     * @param networkId Network ID of the access point.
     * @param IPaddress IP address of the access point.
     */
    public WiFiProfile(String SSID, byte[] mac, int rssi, int networkId) {
        super();

        if (SSID == null) {
            // TODO Change to use Google Guava's checkNotNull() method, requires library import
            throw new IllegalArgumentException("uuid may not be null");
        }
        if (mac == null) {
            // TODO Change to use Google Guava's checkNotNull() method, requires library import
            throw new IllegalArgumentException("uuid may not be null");
        }

        this.SSID = SSID;
        this.mac = mac;
        this.rssi = rssi;
        this.networkId = networkId;
    }

    /**
     * Retrieve the SSID of this WiFi Profile.
     * 
     * @return This WiFi Profile's SSID.
     */    
    public String getSSID() {
        return SSID;
    }

    /**
     * Retrieve the MAC-address of this WiFi Profile.
     * 
     * @return A byte[] representation of the MAC-address of this User's device.
     */
    public byte[] getMac() {
        return mac;
    }

    /**
     * Retrieve the Rssi value of this WiFi Profile.
     * 
     * @return This WiFi Profile's Rssi value.
     */ 
    public int getRssi() {
        return rssi;
    }

    /**
     * Retrieve the network ID of this WiFi Profile.
     * 
     * @return This WiFi Profile's network ID.
     */ 
    public int getNetworkId() {
        return networkId;
    }
}
