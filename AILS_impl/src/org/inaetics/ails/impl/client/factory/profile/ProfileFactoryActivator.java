package org.inaetics.ails.impl.client.factory.profile;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;

import org.inaetics.ails.api.client.factory.ProfileFactory;

/**
 * The DeviceFactoryActivator starts the {@link DeviceFactory DeviceFactory}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class ProfileFactoryActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(ProfileFactory.class.getName(), null)
                .setImplementation(ProfileFactoryImpl.class));
    }

}
