package org.inaetics.ails.impl.server.user.extended_datastore;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;
import org.osgi.framework.BundleContext;

/**
 * Activator for UserExtendedDataStore.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 04-11-2015
 */
public class UserExtendedDataStoreActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent()
                .setInterface(new String[] {UserDataStore.class.getName(),
                        UserLocationDataStore.class.getName()}, null)
                .setImplementation(UserExtendedDataStoreImpl.class)
                .add(createServiceDependency().setService(DAO.class, "(type=User)")
                        .setRequired(true))
                .add(createServiceDependency().setService(DAO.class, "(type=UserLocation)")
                        .setRequired(true)));
    }

}
