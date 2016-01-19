package org.inaetics.ails.android;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.LinearLayout;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.osgi.framework.BundleContext;

/**
 * The main activity (i.e. Activity that is created at startup).
 *
 * This activity can use Apache Felix's dependency manager for dependency injections,
 * due to its superclass OSGiActivity.
 *
 * This activity starts-up the RegisterActivity if no user is available on this device yet.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 09-12-2015
 */
public class MainActivity extends OSGiActivity {

    private volatile DeviceDataStore deviceDataStore;

    private boolean isPaused;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        Log.d("MainActivity", "Configure Felix component");
        manager.add(manager.createComponent()
                .setInterface(Activity.class.getName(), null)
                .setImplementation(this)
                .add(manager.createServiceDependency()
                        .setService(DeviceDataStore.class)
                        .setRequired(true)));
    }

    @Override
    void start() {
        Log.d("MainActivity", "Dependencies resolved");
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

            final LinearLayout content = new LinearLayout(this);
            content.setOrientation(LinearLayout.VERTICAL);
            setContentView(content);

            Snackbar.make(content, "Yay user found!", Snackbar.LENGTH_LONG).show();
        }
    }
}
