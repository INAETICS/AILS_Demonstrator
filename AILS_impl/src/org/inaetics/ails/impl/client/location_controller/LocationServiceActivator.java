package org.inaetics.ails.impl.client.location_controller;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;

import org.inaetics.ails.api.client.location_controller.LocationService;
import org.inaetics.ails.api.server.database.UserLocationDAO;
import org.inaetics.ails.api.server.user.service.UserService;

/**
 * The LocationServiceActivator starts the {@link LocationService LocationService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class LocationServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(LocationService.class.getName(), null)
                .setImplementation(LocationServiceImpl.class)
                .add(createServiceDependency()
                		.setService(UserService.class)
                        .setRequired(true)));
    }

}
