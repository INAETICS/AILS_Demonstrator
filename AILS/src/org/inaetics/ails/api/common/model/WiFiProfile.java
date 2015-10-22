package org.inaetics.ails.api.common.model;

/**
 * Representation of a WiFi 
 * @author Jessy Naus
 *
 */
public class WiFiProfile {
    private final String SSID;
    private final byte[] mac;
    private final int rssi;
    private final int networkId;
    private final int IPaddress;
    
    /**
     * 
     * @param SSID
     * @param mac
     * @param rssi
     * @param networkId
     * @param IPaddress
     */
    public WiFiProfile(String SSID, byte[] mac, int rssi, int networkId, int IPaddress) {
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
        this.IPaddress = IPaddress;
    }

    public String getSSID() {
        return SSID;
    }

    public byte[] getMac() {
        return mac;
    }

    public int getRssi() {
        return rssi;
    }

    public int getNetworkId() {
        return networkId;
    }

    public int getIPaddress() {
        return IPaddress;
    }   
}
