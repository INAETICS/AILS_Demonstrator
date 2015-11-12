package org.inaetics.ails.impl.server.streaming_profile.miner;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.osgi.framework.BundleContext;

/**
 * The StreamingProfileMinerActivator starts a {@link StreamingProfileMiner}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 10-11-2015
 */
public class StreamingProfileMinerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setImplementation(StreamingProfileMiner.class)
                .add(createServiceDependency()
                        .setService(BufferService.class, "(type=UserWiFiProfile)")
                        .setRequired(true)));
    }

}