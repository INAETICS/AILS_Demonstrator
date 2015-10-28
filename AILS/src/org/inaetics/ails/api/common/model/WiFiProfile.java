package org.inaetics.ails.api.common.model;

import java.time.Instant;
import java.util.List;

import com.google.common.base.Preconditions;

/**
 * Representation of a WiFi Profile.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.2
 * @since 22-10-2015
 */
public class WiFiProfile {

    private final Instant creationDate;
    private final List<AccessPointMeasurement> accessPointMeasurements;

    /**
     * Constructor for WiFiProfile.
     * 
     * @param creationDate @NotNull Instant of the creation date of this WiFiProfile.
     * @param accessPointMeasurements @NotNull List of AccessPointMeasurements belonging to this
     *        WiFiProfile.
     */
    public WiFiProfile(Instant creationDate, List<AccessPointMeasurement> accessPointMeasurements) {
        super();
        this.creationDate = Preconditions.checkNotNull(creationDate, "creationDate is not set");
        this.accessPointMeasurements = Preconditions.checkNotNull(accessPointMeasurements,
                "accessPointMeasurements is not set");
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
