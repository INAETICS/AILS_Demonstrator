package org.inaetics.ails.android;

import com.google.common.base.Optional;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
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
 * This activity starts-up the RegisterActivity if no user is available on this device yet
 * and shows a list of current AccessPointMeasurements if a user was available.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.1
 * @since 09-12-2015
 */
public class MainActivity extends OSGiActivity {

    // Injected by dependency manager
    private volatile DeviceDataStore deviceDataStore;
    private volatile WiFiProfileFactory wiFiProfileFactory;

    private boolean isPaused;

    private ScrollView scrollView;
    private LinearLayout wifiProfilesListView;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        Log.d("MainActivity", "Configure Felix component");
        manager.add(manager.createComponent()
                .setInterface(Activity.class.getName(), null)
                .setImplementation(this)
                .add(manager.createServiceDependency()
                        .setService(DeviceDataStore.class)
                        .setRequired(true))
                .add(manager.createServiceDependency()
                        .setService(WiFiProfileFactory.class)
                        .setRequired(true)));
    }

    @Override
    void start() {
        Log.d("MainActivity", "Dependencies resolved");

        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.main_scroll);
        wifiProfilesListView = (LinearLayout) findViewById(R.id.wifiprofiles_list);

        checkUserRegistered();
    }

    @Override
    void stop() {

    }

    @Override
    protected void destroy(BundleContext context, DependencyManager manager) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "Pausing activity");
        isPaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isPaused) {
            Log.d("MainActivity", "Resuming activity");
            checkUserRegistered();
            isPaused = false;
        }
    }

    private void checkUserRegistered() {
        if (!deviceDataStore.hasUser()) {
            Log.d("MainActivity", "No user found on device! Show register screen");
            startActivity(new Intent(this, RegisterActivity.class));
        } else {
            Log.d("MainActivity", "User found on device!");

            wifiProfilesListView.removeAllViews();

            Optional<WiFiProfile> wiFiProfileOptional = wiFiProfileFactory.getProfile();
            if (wiFiProfileOptional.isPresent()) {
                for (AccessPointMeasurement measurement :
                        wiFiProfileOptional.get().getAccessPointMeasurements()) {

                    TextView accessPointTextView = new TextView(this);
                    accessPointTextView.setText(
                            new StringBuilder(new String(measurement.getAccessPoint().getMac()))
                                    .append(": ")
                                    .append(measurement.getMeasurementValue())
                                    .append(" db")
                                    .toString());
                    wifiProfilesListView.addView(accessPointTextView);
                }
            }
        }
    }

}
