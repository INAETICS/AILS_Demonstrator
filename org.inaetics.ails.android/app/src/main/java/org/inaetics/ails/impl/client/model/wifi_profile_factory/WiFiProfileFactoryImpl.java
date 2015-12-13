package org.inaetics.ails.impl.client.model.wifi_profile_factory;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Optional;
import java.util.Random;

import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.common.model.AccessPoint;
import org.inaetics.ails.api.common.model.AccessPointMeasurement;
import org.inaetics.ails.api.common.model.WiFiProfile;

/**
 * The ProfileFactoryImpl class provides an implementation of the {@link ProfileFactory
 * ProfileFactory}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.1
 * @since 05-11-2015
 */
public class WiFiProfileFactoryImpl implements WiFiProfileFactory {
    
    private Random rand = new Random();
    
    @Override
    public Optional<WiFiProfile> getProfile() {
        List<AccessPointMeasurement> accessPointMeasurement =
                new ArrayList<AccessPointMeasurement>();
        for (int i = 0; i < 10; i++) {
            accessPointMeasurement
                    .add(new AccessPointMeasurement(new AccessPoint(randomMac()), randomRSSI()));
        }
                
        if (shouldReturnOptional()) {
            return Optional.absent();
        } else {
            return Optional.of(new WiFiProfile(new Date(), accessPointMeasurement));
//            return Optional.of(new RawLocationProfile(-1, wifiProfile, randomLocation()));
        }        
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
