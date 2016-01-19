package org.inaetics.ails.impl.server.user.service;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.service.UserService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

/**
 * Activator for UserService. Injects dependencies into UserService.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 04-11-2015
 */
public class UserServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
    	Properties props = new Properties();
		props.put(Constants.SERVICE_PID, UserService.class.getName());
		props.put(RemoteConstants.SERVICE_EXPORTED_INTERFACES, UserService.class.getName());
    	
        manager.add(createComponent().setInterface(UserService.class.getName(), props)
                .setImplementation(UserServiceImpl.class)
                .add(createServiceDependency().setService(LocationProvider.class).setRequired(true))
                .add(createServiceDependency().setService(UserDataStore.class).setRequired(true)));
    }

}
