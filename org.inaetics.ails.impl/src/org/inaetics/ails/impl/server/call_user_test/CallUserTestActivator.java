package org.inaetics.ails.impl.server.call_user_test;
import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;
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
public class CallUserTestActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
    	
        manager.add(createComponent().setInterface(CallUserTest.class.getName(), null)
                .setImplementation(CallUserTest.class)
                .add(createServiceDependency().setService(UserService.class).setRequired(true))
                .add(createServiceDependency().setService(StreamingProfileService.class).setRequired(true))
                .add(createServiceDependency().setService(LocationProfileService.class).setRequired(true)));
    }

}
