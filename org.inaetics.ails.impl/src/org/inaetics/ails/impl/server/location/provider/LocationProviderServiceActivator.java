package org.inaetics.ails.impl.server.location.provider;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

/**
 * The LocationProviderServiceActivator starts a {@link UserLocationProviderService} as the
 * {@link LocationProvider}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 10-11-2015
 */
public class LocationProviderServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {		
        manager.add(createComponent().setInterface(LocationProvider.class.getName(), null)
                .setImplementation(UserLocationProviderService.class).add(createServiceDependency()
                        .setService(UserLocationDataStore.class)
                        .setRequired(true)));
    }

}
