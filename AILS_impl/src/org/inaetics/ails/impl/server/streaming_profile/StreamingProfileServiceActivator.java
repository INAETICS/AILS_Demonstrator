package org.inaetics.ails.impl.server.streaming_profile;

import org.osgi.framework.BundleContext;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.StreamingProfileService;

/**
 * The StreamingProfileServiceActivator starts the {@link StreamingProfileService
 * StreamingProfileService} and its dependency BufferService.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 04-11-2015
 */
public class StreamingProfileServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(StreamingProfileService.class.getName(), null)
                .setImplementation(StreamingProfileServiceImpl.class)
                .add(createServiceDependency().setService(BufferService.class).setRequired(true)));
    }
}
