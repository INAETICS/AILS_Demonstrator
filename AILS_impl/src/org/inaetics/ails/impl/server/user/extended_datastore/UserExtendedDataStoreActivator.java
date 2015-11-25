package org.inaetics.ails.impl.server.user.extended_datastore;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.database.UserDAO;
import org.inaetics.ails.api.server.database.UUIDLocationDAO;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;
import org.osgi.framework.BundleContext;

/**
 * Activator for UserExtendedDataStore.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 04-11-2015
 */
public class UserExtendedDataStoreActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent()
                .setInterface(new String[] {UserDataStore.class.getName(),
                        UserLocationDataStore.class.getName()}, null)
                .setImplementation(UserExtendedDataStoreImpl.class)
                .add(createServiceDependency().setService(UserDAO.class).setRequired(true))
                .add(createServiceDependency().setService(UUIDLocationDAO.class)
                        .setRequired(true)));
    }

}
