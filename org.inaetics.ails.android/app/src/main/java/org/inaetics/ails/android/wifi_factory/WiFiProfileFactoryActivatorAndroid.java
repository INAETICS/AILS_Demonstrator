package org.inaetics.ails.android.wifi_factory;

import android.content.Context;

import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.impl.client.model.wifi_profile_factory.WiFiProfileFactoryActivator;

import org.inaetics.ails.impl.client.model.wifi_profile_factory.WiFiProfileFactoryImpl;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * The WiFiProfileFactoryActivatorAndroid starts the {@link WiFiProfileFactory WiFiProfileFactory}.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 05-11-2015
 */
public class WiFiProfileFactoryActivatorAndroid extends WiFiProfileFactoryActivator {

    private final Context context;

    public WiFiProfileFactoryActivatorAndroid(Context context) {
        this.context = context;
    }

    @Override
    public void init(BundleContext bundleContext, DependencyManager manager) throws Exception {

        Dictionary<String, Object> props = new Hashtable<String, Object>();
        props.put(RemoteConstants.SERVICE_EXPORTED_INTERFACES, WiFiProfileFactoryImpl.class.getName());

        manager.add(createComponent().setInterface(WiFiProfileFactory.class.getName(), null)
                .setImplementation(new WiFiProfileFactoryAndroidImpl(context)));
    }
}
