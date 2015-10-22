package org.inaetics.ails.api.common.model;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Representation of an access point. Can be used for location measurements.
 * 
 * @author nicokorthout
 * @version 0.1.0
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
        this.mac = checkNotNull(mac);
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
