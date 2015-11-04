package org.inaetics.ails.impl.server.user.service;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.service.UserService;
import org.osgi.framework.BundleContext;

public class UserServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext bc, DependencyManager dm) throws Exception {
        dm.add(createComponent()
                .setInterface(UserService.class.getName(), null)
                .setImplementation(UserServiceImpl.class)
                .add(createServiceDependency()
                        .setService(LocationProvider.class)
                        .setRequired(true)));
    }

    @Override
    public void destroy(BundleContext bc, DependencyManager dm) throws Exception {
        // TODO Auto-generated method stub

    }

}
