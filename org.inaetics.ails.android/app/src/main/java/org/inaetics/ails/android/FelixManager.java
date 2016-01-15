package org.inaetics.ails.android;

import com.google.common.base.Preconditions;

import android.content.Context;

import org.apache.felix.dm.DependencyManager;
import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.inaetics.ails.android.wifi_factory.WiFiProfileFactoryActivatorAndroid;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This singleton class manages the Felix framework and the bundles running within.
 * It can be used to request the BundleContext or the DependencyManager
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 13-01-2016
 */
public class FelixManager {

    private static FelixManager instance;
    private static Context applicationContext;

    /**
     * Configure the FelixManager.
     * Required to be invoked before {@link FelixManager#getInstance()} can be called.
     *
     * @param context @NotNull The Android application environment's context.
     */
    public static void configure(Context context) {
        if (applicationContext == null) {
            applicationContext = Preconditions.checkNotNull(context, "context was not set");
        }
    }

    /**
     * Retrieve the singleton instance of the FelixManager.
     * Requires {@link FelixManager#configure(Context)} to be invoked.
     *
     * @throws IllegalStateException When FelixManager was not yet configured.
     * @return The singleton instance of the FelixManager
     */
    public static FelixManager getInstance() {
        if (instance == null) {
            if (applicationContext == null) {
                throw new IllegalStateException("FelixManager was not yet configured");
            }
            instance = new FelixManager();
        }
        return instance;
    }

    private final Felix felix;
    private final BundleContext bundleContext;
    private final DependencyManager dependencyManager;

    private FelixManager() {
        Map<String, Object> config = new HashMap<>();

        // Cache File for bundle storage
        File cache = new File("/data/data/org.inaetics.ails.android/felixcache");
        System.out.println("Creating cache: " + cache.mkdirs());
        config.put(Constants.FRAMEWORK_STORAGE, cache.toString());

        // Framework bundle
        config.put(FelixConstants.SERVICE_URLHANDLERS_PROP, "false");
        config.put("org.osgi.framework.bundle.parent", "framework");

        // Amdatu shit
        config.put("org.amdatu.remote.discovery.etcd.connecturl", "http://172.17.8.20:2379");
        config.put("org.amdatu.remote.discovery.etcd.rootpath", "/inaetics/discovery");
//        config.put("org.amdatu.remote.admin.http.host", "eigen ip");
//        config.put("org.apache.felix.http.host", "eigen ip");

        // Bundle Activators
        config.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, Arrays.asList(
                // Amdatu remote services bundles
                new org.amdatu.remote.admin.http.Activator(),
                new org.amdatu.remote.discovery.etcd.Activator(),
                new org.amdatu.remote.topology.promiscuous.Activator(),

                // AILS bundles
                new WiFiProfileFactoryActivatorAndroid(applicationContext)
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
    }

    /**
     * Retrieve the BundleContext of the Felix framework.
     *
     * @return The BundleContext.
     */
    public BundleContext getBundleContext() {
        return bundleContext;
    }

    /**
     * Retrieve the DependencyManager of the Felix framework.
     *
     * @return The DependencyManager.
     */
    public DependencyManager getDependencyManager() {
        return dependencyManager;
    }

    /**
     * Completely stop the Felix framework.
     *
     * @throws BundleException @see {@link Felix#stop()}.
     */
    public void stopFelix() throws BundleException {
        felix.stop();
        FelixManager.instance = null;
    }

}
