package org.inaetics.ails.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.apache.felix.dm.DependencyManager;
import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.inaetics.ails.impl.client.model.device_data_store.DeviceDataStoreActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class OSGiActivity extends AppCompatActivity {

    private Felix felix;
    private BundleContext bundleContext;
    private DependencyManager dependencyManager;

    protected abstract void init(BundleContext context, DependencyManager manager);
    protected abstract void destroy(BundleContext context, DependencyManager manager);

    abstract void start();
    abstract void stop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Map<String, Object> config = new HashMap<>();

        // Cache File
        File cache = new File("/data/data/org.inaetics.ails_demonstrator/felixcache");
        System.out.println("Creating cache: " + cache.mkdirs());
        config.put(Constants.FRAMEWORK_STORAGE, cache.toString());

        // Framework bundle
        config.put(FelixConstants.SERVICE_URLHANDLERS_PROP, "false");
        config.put("org.osgi.framework.bundle.parent", "framework");

        // Bundle Activators
        config.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, Arrays.asList(
                new DeviceDataStoreActivator()
//
//                new org.apache.felix.eventadmin.impl.Activator(),
//                new org.apache.felix.cm.impl.ConfigurationManager()
        ));

        felix = new Felix(config);

        try {
            felix.start();
        } catch (BundleException e) {
            throw new RuntimeException("Felix could not be started", e);
        }

        bundleContext = felix.getBundleContext();
        dependencyManager = new DependencyManager(bundleContext);

        init(bundleContext, dependencyManager);
    }

    @Override
    protected void onDestroy() {
        destroy(bundleContext, dependencyManager);

        try {
            felix.stop();
        } catch (BundleException e) {
            throw new RuntimeException("Felic could not be stopped", e);
        }

        super.onDestroy();
    }

}
