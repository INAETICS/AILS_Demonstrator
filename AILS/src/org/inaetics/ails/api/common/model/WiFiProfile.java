package org.inaetics.ails.api.common.model;

import java.time.Instant;
import java.util.List;

/**
 * Representation of a WiFi Profile.
 * 
 * @author Jessy Naus
 * @version 0.2.0
 * @since 22-10-2015
 */
public class WiFiProfile {
    
    private final Instant creationDate;
    private final List<AccessPointMeasurement> accessPointMeasurements;
    
    /**
     * Constructor for WiFiProfile.
     * 
     * @param creationDate Instant of the creation date of this WiFiProfile.
     * @param accessPointMeasurements List of AccessPointMeasurements belonging to this WiFiProfile.
     */
    public WiFiProfile(Instant creationDate, List<AccessPointMeasurement> accessPointMeasurements) {
        super();
        this.creationDate = creationDate;
        this.accessPointMeasurements = accessPointMeasurements;
    }

    /**
     * Return the Instant of the creation date of this WiFiProfile.
     * 
     * @return the creationDate
     */
    public Instant getCreationDate() {
        return creationDate;
    }

    /**
     * Retrieve the List of AccessPointMeasurements.
     * 
     * @return the accessPointMeasurements
     */
    public List<AccessPointMeasurement> getAccessPointMeasurements() {
        return accessPointMeasurements;
    }
    
}
