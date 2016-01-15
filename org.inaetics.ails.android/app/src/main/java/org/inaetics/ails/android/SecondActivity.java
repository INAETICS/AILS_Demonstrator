package org.inaetics.ails.android;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.osgi.framework.BundleContext;

/**
 * A second activity.
 *
 * This activity can use Apache Felix's dependency manager for dependency injections,
 * due to its superclass OSGiActivity.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 15-01-2016
 */
public class SecondActivity extends OSGiActivity {

    private volatile WiFiProfileFactory wiFiProfileFactory;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        manager.add(manager.createComponent()
                .setInterface(Activity.class.getName(), null)
                .setImplementation(this)
                .add(manager.createServiceDependency()
                        .setService(WiFiProfileFactory.class)
                        .setRequired(true)));
    }

    @Override
    void start() {
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        setContentView(content);

        TextView textView = new TextView(this);
        StringBuilder textBuilder = new StringBuilder("Second activity\n");
        textView.setText(textBuilder.toString());
        content.addView(textView);

        // Check WiFiProfileFactory dependency
        if (isServiceAvailable(WiFiProfileFactory.class)) {
            textBuilder.append("Wifi profile factory available\n");
        } else {
            textBuilder.append("Wifi profile factory not available\n");
        }
        textView.setText(textBuilder.toString());

//        if (isServiceAvailable(WiFiProfileFactory.class)) {
//            Optional<WiFiProfile> profile = wiFiProfileFactory.getProfile();
//            if (profile.isPresent())  {
//                StringBuilder measurements = new StringBuilder();
//                for (AccessPointMeasurement measurement :
//                        profile.get().getAccessPointMeasurements()) {
//                    String accessPointMac = new String(measurement.getAccessPoint().getMac());
//                    measurements.append(accessPointMac)
//                            .append(": ")
//                            .append(measurement.getMeasurementValue())
//                            .append("\n");
//                }
//                text.setText("Access Point Measurements:\n" + measurements);
//
//            } else {
//                text.setText("No WiFi Profile available.");
//            }
//        } else {
//            text.setText("WiFiProfileFactory is null");
//        }
    }

    @Override
    void stop() {

    }

    @Override
    protected void destroy(BundleContext context, DependencyManager manager) {

    }

}
