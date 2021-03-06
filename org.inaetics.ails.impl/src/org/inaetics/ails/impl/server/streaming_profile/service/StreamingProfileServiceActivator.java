package org.inaetics.ails.impl.server.streaming_profile.service;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;
import org.inaetics.ails.api.server.user.service.UserService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.remoteserviceadmin.RemoteConstants;

/**
 * The StreamingProfileServiceActivator starts a {@link StreamingProfileService} implementation.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 04-11-2015
 */
public class StreamingProfileServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
    	Properties props = new Properties();
		props.put(Constants.SERVICE_PID, StreamingProfileService.class.getName());
		props.put(RemoteConstants.SERVICE_EXPORTED_INTERFACES, StreamingProfileService.class.getName());
    	
    	
    	manager.add(createComponent().setInterface(StreamingProfileService.class.getName(), props)
                .setImplementation(StreamingProfileServiceImpl.class)
                .add(createServiceDependency()
                        .setService(BufferService.class, "(type=UUIDWiFiProfile)")
                        .setRequired(true)));
    }

}
