package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * Representation of an access point measurement. This describes the measurement of access points by
 * a single device.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
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
        this.accessPoint = Preconditions.checkNotNull(accessPoint);
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
