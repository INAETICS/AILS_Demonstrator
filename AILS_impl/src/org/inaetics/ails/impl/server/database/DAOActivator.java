package org.inaetics.ails.impl.server.database;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.database.DAO;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.RawLocationProfileDAO;
import org.inaetics.ails.api.server.database.UserDAO;
import org.inaetics.ails.api.server.database.UUIDLocationDAO;
import org.inaetics.ails.api.server.database.UUIDWiFiProfileDAO;
import org.osgi.framework.BundleContext;

/**
 * Activates the {@link DAO DAOs}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.4
 * @since 10-11-2015
 */
public class DAOActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {

        manager.add(createComponent().setInterface(UserDAO.class.getName(), null)
                .setImplementation(UserDAOMockImpl.class));

        manager.add(createComponent().setInterface(UUIDLocationDAO.class.getName(), null)
                .setImplementation(UUIDLocationDAOMockImpl.class));

        manager.add(createComponent().setInterface(UUIDWiFiProfileDAO.class.getName(), null)
                .setImplementation(UUIDWiFiProfileDAOMockImpl.class));

        manager.add(createComponent().setInterface(LocationProfileDAO.class.getName(), null)
                .setImplementation(LocationProfileDAOMockImpl.class));

        manager.add(createComponent().setInterface(RawLocationProfileDAO.class.getName(), null)
                .setImplementation(RawLocationProfileDAOMockImpl.class));
    }

}
