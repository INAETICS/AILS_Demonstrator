package org.inaetics.ails.android.wifi_factory;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.google.common.base.Optional;

import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.common.model.AccessPoint;
import org.inaetics.ails.api.common.model.AccessPointMeasurement;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.inaetics.ails.impl.client.model.wifi_profile_factory.WiFiProfileFactoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The ProfileFactoryImpl class provides an implementation of the {@link WiFiProfileFactory
 * WiFiProfileFactory}
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.0.0
 * @since 05-11-2015
 */
public class WiFiProfileFactoryAndroidImpl extends WiFiProfileFactoryImpl {

    private final Context context;

    public WiFiProfileFactoryAndroidImpl(Context context) {
        this.context = context;
    }

    // TODO: Remove optional and throw exception when WiFi is disabled.

    @Override
    public Optional<WiFiProfile> getProfile() {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        if (wifiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLED) {
            return Optional.absent();
        }

        List<AccessPointMeasurement> accessPointMeasurements = new ArrayList<>();
        for (ScanResult scanResult : wifiManager.getScanResults()) {
            accessPointMeasurements.add(
                    new AccessPointMeasurement(
                            new AccessPoint(scanResult.BSSID.getBytes()), scanResult.level
                    )
            );
        }
        return Optional.of(new WiFiProfile(new Date(), accessPointMeasurements));
    }
}