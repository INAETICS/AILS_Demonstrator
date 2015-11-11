package org.inaetics.ails.impl.client.factory.raw_location_profile;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.factory.RawLocationProfileFactory;

/**
 * The DeviceFactoryActivator starts the {@link DeviceFactory DeviceFactory}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class RawLocationProfileFactoryActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(RawLocationProfileFactory.class.getName(), null)
                .setImplementation(RawLocationProfileFactoryImpl.class));
    }

}
