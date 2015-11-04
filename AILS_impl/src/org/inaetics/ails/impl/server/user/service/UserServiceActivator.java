package org.inaetics.ails.impl.server.user.service;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.service.UserService;
import org.osgi.framework.BundleContext;

/**
 * Activator for UserService. Injects dependencies into UserService.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 04-11-2015
 */
public class UserServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext bc, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(UserService.class.getName(), null)
                .setImplementation(UserServiceImpl.class)
                .add(createServiceDependency().setService(LocationProvider.class).setRequired(true))
                .add(createServiceDependency().setService(UserDataStore.class).setRequired(true)));
    }

}
