package org.inaetics.ails.impl.server.database;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.server.database.DAO;
import org.osgi.framework.BundleContext;

/**
 * Activates the {@link DAO DAOs}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 10-11-2015
 */
public class DAOActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        Properties props = new Properties();
        props.put("type", "User");

        manager.add(createComponent().setInterface(DAO.class.getName(), props)
                .setImplementation(UserDAOMockImpl.class));
        
        Properties props2 = new Properties();
        props2.put("type", "UserLocation");

        manager.add(createComponent().setInterface(DAO.class.getName(), props2)
                .setImplementation(UserLocationDAOMockImpl.class));
    }

}
