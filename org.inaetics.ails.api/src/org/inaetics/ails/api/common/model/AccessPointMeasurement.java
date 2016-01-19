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

    private AccessPoint accessPoint;
    private int measurementValue;
    
    public AccessPointMeasurement() {
        // Empty constructor for Jackson
    }

    /**
     * Constructor for AccessPointMeasurement.
     * 
     * @param accessPoint @NotNull The access point on which the measurement was performed.
     */
    public AccessPointMeasurement(AccessPoint accessPoint, int measurementValue) {
        super();
        this.accessPoint = Preconditions.checkNotNull(accessPoint, "accesspoint is not set");
        this.measurementValue = Preconditions.checkNotNull(measurementValue, "measurementValue is not set");
    }

    /**
     * Retrieve the access point on which the measurement was performed.
     * 
     * @return the accessPoint
     */
    public AccessPoint getAccessPoint() {
        return accessPoint;
    }

    /**
     * Retrieve the measurement value on which the measurement was performed.
     * 
     * @return the measurement value
     */
    public int getMeasurementValue() {
        return measurementValue;
    }
    

    // Below setters only exist for Jackson

    public void setAccessPoint(AccessPoint accessPoint) {
        this.accessPoint = accessPoint;
    }

    public void setMeasurementValue(int measurementValue) {
        this.measurementValue = measurementValue;
    }  
    
    public String toString() {
        return "AccessPointMeasurement{access_point: " + this.accessPoint + ", measurement_value: " + this.measurementValue +  "}";
    }
}
