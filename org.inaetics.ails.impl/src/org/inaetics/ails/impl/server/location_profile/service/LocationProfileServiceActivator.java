package org.inaetics.ails.impl.server.location_profile.service;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

import java.util.Properties;

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
    	Properties props = new Properties();
		props.put(Constants.SERVICE_PID, LocationProfileService.class.getName());
		props.put(RemoteConstants.SERVICE_EXPORTED_INTERFACES, LocationProfileService.class.getName());
		
        manager.add(createComponent().setInterface(LocationProfileService.class.getName(), props)
                .setImplementation(LocationProfileServiceImpl.class)
                .add(createServiceDependency()
                        .setService(BufferService.class, "(type=RawLocationProfile)")
                        .setRequired(true)));
    }

}
