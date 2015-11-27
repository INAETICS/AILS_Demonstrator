package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * Representation of an access point. Can be used for location measurements.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 22-10-2015
 */
public class AccessPoint {

    private final byte[] mac;

    /**
     * Constructor for AccessPoint.
     * 
     * @param mac @NotNull The uniquely identifying MAC-address of this access point.
     */
    public AccessPoint(byte[] mac) {
        super();
        this.mac = Preconditions.checkNotNull(mac, "mac is not set");
    }

    /**
     * Retrieve the uniquely identifying MAC-address of this access point.
     * 
     * @return the mac
     */
    public byte[] getMac() {
        return mac;
    }

}
