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

/**
 * This activity manages the startup of Felix, the dependency manager and the bundle context.
 * It makes sure that the init, start, stop and destroy methods are called at the correct moments.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 09-12-2015
 */
public abstract class OSGiActivity extends AppCompatActivity {

    private Felix felix;
    private BundleContext bundleContext;
    private DependencyManager dependencyManager;

    /**
     * This method is similar to the Felix lifecycle method init.
     * <br><br>
     * This method can be used to configure the BundleContext or the DependencyManager at startup
     * of the Activity. If your activity, for instance, is a component depending on some services,
     * this has to declared here to the dependency manager.
     * <br><br>
     * This method is called when Felix has started, as a result of onCreate() call on this class.
     * Therefore, if a subclass of OSGiActivity wants to Override the onCreate method,
     * <code>super.onCreate(savedInstanceState)</code> should always be called in the first line of
     * the overriding method.
     *
     * @param context The bundle's execution context.
     * @param manager The dependency manager.
     */
    protected abstract void init(BundleContext context, DependencyManager manager);

    /**
     * This method is called by Felix when the dependencies have been resolved. It is a standard
     * method in Felix's lifecycle.
     */
    abstract void start();

    /**
     * This method is called by Felix when the dependencies are no longer resolved or when the
     * bundle is stopped. It is a standard method in Felix's lifecycle.
     */
    abstract void stop();

    /**
     * This method is similar to the Felix lifecycle method destroy.
     * <br><br>
     * This method is called when the activity is stopped, as a result of onDestroy() call on
     * this class. Therefore, if a subclass of OSGiActivity wants to Override the onDestroy method,
     * <code>super.onDestroy(savedInstanceState)</code> should always be called in the last line of
     * the overriding method. Because otherwise your bundle's context will have been destroyed and
     * Felix will have shutdown.
     *
     * @param context The bundle's execution context.
     * @param manager The dependency manager.
     */
    protected abstract void destroy(BundleContext context, DependencyManager manager);

    /**
     * Warning! When overriding this method, make sure to call its super method in the first line
     * of the overriding method. See {@link OSGiActivity#init(BundleContext, DependencyManager)}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Map<String, Object> config = new HashMap<>();

        // Cache File for bundle storage
        File cache = new File("/data/data/org.inaetics.ails.android/felixcache");
        System.out.println("Creating cache: " + cache.mkdirs());
        config.put(Constants.FRAMEWORK_STORAGE, cache.toString());

        // Framework bundle
        config.put(FelixConstants.SERVICE_URLHANDLERS_PROP, "false");
        config.put("org.osgi.framework.bundle.parent", "framework");

        // Bundle Activators
        config.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, Arrays.asList(
                new DeviceDataStoreActivator()
        ));

        // Startup Felix
        felix = new Felix(config);
        try {
            felix.start();
        } catch (BundleException e) {
            throw new RuntimeException("Felix could not be started", e);
        }

        bundleContext = felix.getBundleContext();
        dependencyManager = new DependencyManager(bundleContext);

        // init the bundle
        init(bundleContext, dependencyManager);
    }

    /**
     * Warning! When overriding this method, make sure to call its super method in the last line
     * of the overriding method. See {@link OSGiActivity#destroy(BundleContext, DependencyManager)}
     */
    @Override
    protected void onDestroy() {
        // destroy the bundle
        destroy(bundleContext, dependencyManager);

        // Stop Felix
        try {
            felix.stop();
        } catch (BundleException e) {
            throw new RuntimeException("Felic could not be stopped", e);
        }

        // destroy the activity
        super.onDestroy();
    }

}
