package org.inaetics.ails.impl.server.location_provider.service;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.osgi.framework.BundleContext;

public class LocationProviderServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext ctx, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(LocationProvider.class.getName(), null)
                .setImplementation(UserLocationProviderService.class));
        // TODO: Depend on User Extended data
    }

}
