package org.inaetics.ails.impl.client.model.wifi_profile_factory;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;

/**
 * The DeviceFactoryActivator starts the {@link DeviceFactory DeviceFactory}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class WiFiProfileFactoryActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(WiFiProfileFactory.class.getName(), null)
                .setImplementation(WiFiProfileFactoryImpl.class));
    }

    @Override
    public void destroy(BundleContext bundleContext, DependencyManager dependencyManager) throws Exception {

    }

}
