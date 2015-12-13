package org.inaetics.ails.android;

import android.app.Activity;
import android.widget.TextView;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.osgi.framework.BundleContext;

/**
 * Created by nicokorthout on 09/12/15.
 */
public class MainActivity extends OSGiActivity {

    private volatile DeviceDataStore deviceDataStore;
    private TextView text;

    @Override
    protected void init(BundleContext context, DependencyManager manager) {
        manager.add(manager.createComponent()
                        .setInterface(Activity.class.getName(), null)
                        .setImplementation(this)
                        .add(manager.createServiceDependency()
                                .setService(DeviceDataStore.class)
                                .setRequired(true))
        );
    }

    @Override
    protected void destroy(BundleContext context, DependencyManager manager) {

    }

    @Override
    void start() {
        text = new TextView(this);
        setContentView(text);

        if (deviceDataStore.hasUser()) {
            text.setText("Welcome back");
        } else {
            text.setText("Welcome new user");
        }
    }

    @Override
    void stop() {
        text.setText("Stopping....");
    }

}
