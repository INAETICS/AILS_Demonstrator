package org.inaetics.ails.impl.client.factory.raw_location_profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.inaetics.ails.api.client.factory.RawLocationProfileFactory;
import org.inaetics.ails.api.common.model.AccessPoint;
import org.inaetics.ails.api.common.model.AccessPointMeasurement;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.WiFiProfile;

/**
 * The ProfileFactoryImpl class provides an implementation of the {@link ProfileFactory
 * ProfileFactory}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 05-11-2015
 */
public class RawLocationProfileFactoryImpl implements RawLocationProfileFactory {
    
    private Random rand = new Random();
    
    @Override
    public Optional<RawLocationProfile> getProfile() {
        List<AccessPointMeasurement> accessPointMeasurement =
                new ArrayList<AccessPointMeasurement>();
        for (int i = 0; i < 10; i++) {
            accessPointMeasurement
                    .add(new AccessPointMeasurement(new AccessPoint(randomMac()), randomRSSI()));
        }
        
        WiFiProfile wifiProfile = new WiFiProfile(Instant.now(), accessPointMeasurement);
        
        if (shouldReturnOptional()) {
            return Optional.empty();
        } else {
            return Optional.of(new RawLocationProfile(wifiProfile, randomLocation()));
        }        
    }

    /**
     * Generate a random location.
     * 
     * @return A location
     */
    private Location randomLocation() {
        Location[] locations = {
                new Location("A", "Main Building", "Thales NL", "Thales"),
                new Location("B", "Main Building", "Thales NL", "Thales"),
                new Location("C", "Main Building", "Thales NL", "Thales"),
                new Location("D", "Main Building", "Thales NL", "Thales"),
                new Location("A", "Secondary Building", "Thales NL", "Thales"),
                new Location("B", "Secondary Building", "Thales NL", "Thales"),
                new Location("C", "Secondary Building", "Thales NL", "Thales"),
                new Location("D", "Secondary Building", "Thales NL", "Thales"),
        };
        
        return locations[rand.nextInt(locations.length)];
    }
    
    /**
     * Generate a random RSSI value between 80 (inclusive) and 120 (exclusive).
     * 
     * @return Random RSSI value.
     */
    private int randomRSSI() {
        return rand.nextInt(120) + 80;
    }

    /**
     * Generate a random MAC address.
     * 
     * @return a MAC address.
     */
    private byte[] randomMac() {
        byte[] mac = new byte[6];

        rand.nextBytes(mac);

        return mac;
    }

    /**
     * Generate a random boolean.
     * 
     * @return a boolean.
     */
    private boolean shouldReturnOptional() {
        return rand.nextBoolean();
    }
}
