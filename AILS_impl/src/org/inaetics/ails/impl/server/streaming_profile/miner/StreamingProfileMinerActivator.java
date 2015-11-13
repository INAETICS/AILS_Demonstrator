package org.inaetics.ails.impl.server.streaming_profile.miner;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.AnonUserWiFiProfileDAO;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;
import org.osgi.framework.BundleContext;

/**
 * The StreamingProfileMinerActivator starts a {@link StreamingProfileMiner}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.3
 * @since 10-11-2015
 */
public class StreamingProfileMinerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setImplementation(StreamingProfileMiner.class)
                .add(createServiceDependency()
                        .setService(BufferService.class, "(type=AnonUserWiFiProfile)")
                        .setRequired(true))
                .add(createServiceDependency().setService(LocationProfileDAO.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(AnonUserWiFiProfileDAO.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(UserLocationDataStore.class)
                        .setRequired(true)));
    }

}
