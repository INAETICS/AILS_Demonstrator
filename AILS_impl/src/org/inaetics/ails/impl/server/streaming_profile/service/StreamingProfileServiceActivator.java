package org.inaetics.ails.impl.server.streaming_profile.service;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;
import org.osgi.framework.BundleContext;

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
        manager.add(createComponent().setInterface(StreamingProfileService.class.getName(), null)
                .setImplementation(StreamingProfileServiceImpl.class)
                .add(createServiceDependency()
                        .setService(BufferService.class, "(type=AnonUserWiFiProfile)")
                        .setRequired(true)));
    }

}
