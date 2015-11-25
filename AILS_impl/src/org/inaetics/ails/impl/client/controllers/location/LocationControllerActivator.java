package org.inaetics.ails.impl.client.controllers.location;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.location.LocationController;
import org.inaetics.ails.api.client.view.View;

/**
 * The LocationControllerActivator starts the {@link LocationController LocationController}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class LocationControllerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(LocationController.class.getName(), null)
                .setImplementation(LocationControllerImpl.class)
                .add(createServiceDependency()
                		.setService(View.class)
                        .setRequired(true)));
    }

}
