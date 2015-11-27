package org.inaetics.ails.impl.server.location_profile.miner;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.RawLocationProfileDAO;
import org.osgi.framework.BundleContext;

/**
 * The StreamingProfileMinerActivator starts a {@link LocationProfileMiner}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 12-11-2015
 */
public class LocationProfileMinerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setImplementation(LocationProfileMiner.class)
                .add(createServiceDependency()
                        .setService(BufferService.class, "(type=RawLocationProfile)")
                        .setRequired(true))
                .add(createServiceDependency().setService(RawLocationProfileDAO.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(LocationProfileDAO.class)
                        .setRequired(true)));
    }

}
