package org.inaetics.ails.api.common.model;

import java.time.Instant;
import java.util.List;
import java.util.Random;

import com.google.common.base.Preconditions;

/**
 * Representation of a WiFi Profile.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.3.0
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
     * Compare this WiFiProfile to another to see if they match.
     * 
     * @param wifiProfile @NotNull The other WiFiProfile to match to.
     * @return true if the WiFiProfiles match, false if not.
     * @since 0.3.0
     */
    public boolean match(WiFiProfile wifiProfile) {
        // TODO: Properly implement the match method, instead of random matching
        return new Random().nextBoolean();
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
