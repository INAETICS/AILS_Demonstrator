package org.inaetics.ails.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

/**
 * This class manages the Felix component lifecycle of any Android Activity.
 * It makes sure that the init, start, stop and destroy methods are called at the correct moments.
 * FelixManager is used to manage the Felix framework.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 09-12-2015
 */
public abstract class OSGiActivity extends AppCompatActivity {

    public FelixManager felixManager;

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

        FelixManager.configure(getApplicationContext());
        felixManager = FelixManager.getInstance();

        // call init on the activity
        init(felixManager.getBundleContext(), felixManager.getDependencyManager());
    }

    /**
     * Warning! When overriding this method, make sure to call its super method in the last line
     * of the overriding method. See {@link OSGiActivity#destroy(BundleContext, DependencyManager)}
     */
    @Override
    protected void onDestroy() {
        // destroy the bundle
        destroy(felixManager.getBundleContext(), felixManager.getDependencyManager());

        // Stop Felix
        try {
            felixManager.stopFelix();
        } catch (BundleException e) {
            throw new RuntimeException("Felix could not be stopped", e);
        }

        // destroy the activity
        super.onDestroy();
    }

    /**
     * Check if a service is available.
     *
     * @param clazz The class of the service that is checked for availability.
     * @return true if the service is available, otherwise false.
     */
    protected boolean isServiceAvailable(Class clazz) {
        return felixManager.getBundleContext().getServiceReference(clazz) != null;
    }

}
