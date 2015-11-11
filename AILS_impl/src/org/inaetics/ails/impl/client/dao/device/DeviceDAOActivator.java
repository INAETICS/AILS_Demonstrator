package org.inaetics.ails.impl.client.dao.device;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.dao.device.DeviceDAO;
import org.inaetics.ails.api.client.factory.DeviceFactory;

/**
 * The DeviceFactoryActivator starts the {@link DeviceFactory DeviceFactory}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class DeviceDAOActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(DeviceDAO.class.getName(), null)
                .setImplementation(DeviceDAOImpl.class));
    }

}
