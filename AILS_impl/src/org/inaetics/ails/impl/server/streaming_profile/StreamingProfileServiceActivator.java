package org.inaetics.ails.impl.server.streaming_profile;

import org.osgi.framework.BundleContext;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.streaming_profile.StreamingProfileService;

public class StreamingProfileServiceActivator extends DependencyActivatorBase {
    
    @Override
    public void init(BundleContext context, DependencyManager dm) throws Exception {
        dm.add(createComponent()
                .setInterface(StreamingProfileService.class.getName(), null)
                .setImplementation(StreamingProfileServiceImpl.class)
                .add(createServiceDependency()
                        .setService(BufferService.class)
                        .setRequired(true)
                )
        );
    }
    
    @Override
    public void destroy(BundleContext context, DependencyManager dm) throws Exception {
        // TODO Auto-generated method stub
        
    }
}
