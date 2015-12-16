package org.inaetics.ails.android;

import com.google.common.base.Optional;

import android.app.Activity;
import android.widget.TextView;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.common.model.AccessPointMeasurement;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.osgi.framework.BundleContext;

/**
 * The main activity (i.e. Activity that is created at startup).
 *
 * This activity can use Apache Felix's dependency manager for dependency injections,
 * due to its superclass OSGiActivity.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 09-12-2015
 */
public class MainActivity extends OSGiActivity {

    private volatile WiFiProfileFactory wiFiProfileFactory;

    private TextView text;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        manager.add(manager.createComponent()
                        .setInterface(Activity.class.getName(), null)
                        .setImplementation(this)
                        .add(manager.createServiceDependency()
                                .setService(WiFiProfileFactory.class)
                                .setRequired(false))
        );
    }

    @Override
    void start() {
        text = new TextView(this);
        setContentView(text);

        if (wiFiProfileFactory != null) {
            Optional<WiFiProfile> profile = wiFiProfileFactory.getProfile();
            if (profile.isPresent())  {
                StringBuilder measurements = new StringBuilder();
                for (AccessPointMeasurement measurement : profile.get().getAccessPointMeasurements()) {
                    String accessPointMac = new String(measurement.getAccessPoint().getMac());
                    measurements.append(accessPointMac)
                            .append(": ")
                            .append(measurement.getMeasurementValue())
                            .append("\n");
                }
                text.setText("Access Point Measurements:\n" + measurements);

            } else {
                text.setText("No WiFi Profile available.");
            }
        } else {
            text.setText("WiFiProfileFactory is null");
        }

    }

    @Override
    void stop() {
        text.setText("Stopping....");
    }

    @Override
    protected void destroy(BundleContext context, DependencyManager manager) {

    }

}
