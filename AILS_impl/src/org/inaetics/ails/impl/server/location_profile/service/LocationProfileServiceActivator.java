package org.inaetics.ails.impl.server.location_profile.service;

import org.osgi.framework.BundleContext;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;

/**
 * The LocationProfileServiceActivator starts the {@link LocationProfileService
 * LocationProfileService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 05-11-2015
 */
public class LocationProfileServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(LocationProfileService.class.getName(), null)
                .setImplementation(LocationProfileServiceImpl.class)
                .add(createServiceDependency()
                        .setService(BufferService.class, "(type=RawLocationProfile)")
                        .setRequired(true)));
    }

}
