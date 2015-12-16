package org.inaetics.ails.android;

import android.app.Activity;
import android.widget.TextView;

import com.google.common.base.Optional;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.android.wifi_factory.WiFiProfileFactoryActivatorAndroid;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.common.model.WiFiProfile;
import org.osgi.framework.BundleContext;

/**
 * The main activity (i.e. Activity that is created at startup).
 *
 * This activity can use Apache Felix's dependency manager for dependency injections,
 * due to its superclass OSGiActivity.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 09-12-2015
 */
public class MainActivity extends OSGiActivity {

    private volatile DeviceDataStore deviceDataStore;
    private volatile WiFiProfileFactory wiFiProfileFactory;

    private TextView text;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        manager.add(manager.createComponent()
                        .setInterface(Activity.class.getName(), null)
                        .setImplementation(this)
                        .add(manager.createServiceDependency()
                                .setService(DeviceDataStore.class)
                                .setRequired(false))
                        .add(manager.createServiceDependency()
                                .setService(WiFiProfileFactory.class)
                                .setRequired(false))
        );
    }

    @Override
    void start() {
        text = new TextView(this);
        setContentView(text);

        if (deviceDataStore == null) {
            text.setText("device data store is unavailable");
        } else {
            if (deviceDataStore.hasUser()) {
                text.setText("Welcome back");
            } else {
                text.setText("Welcome new user");
            }
        }

        if (wiFiProfileFactory != null) {
            Optional<WiFiProfile> profile = wiFiProfileFactory.getProfile();
            if (profile.isPresent())  {
                text.setText("Total measurements" + profile.get().getAccessPointMeasurements().size());
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
