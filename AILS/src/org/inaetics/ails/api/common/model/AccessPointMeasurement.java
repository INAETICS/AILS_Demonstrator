package org.inaetics.ails.api.common.model;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Representation of an access point measurement. This describes the measurement of access points by
 * a single device.
 * 
 * @author nicokorthout
 * @version 0.1.0
 * @since 22-10-2015
 */
public class AccessPointMeasurement {

    private final AccessPoint accessPoint;

    /**
     * Constructor for AccessPointMeasurement.
     * 
     * @param accessPoint @NotNull The access point on which the measurement was performed.
     */
    public AccessPointMeasurement(AccessPoint accessPoint) {
        super();
        this.accessPoint = checkNotNull(accessPoint);
    }

    /**
     * Retrieve the access point on which the measurement was performed.
     * 
     * @return the accessPoint
     */
    public AccessPoint getAccessPoint() {
        return accessPoint;
    }

}
