package org.inaetics.ails.impl.client.device_controller;

import org.osgi.framework.BundleContext;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.dao.device.DeviceDAO;
import org.inaetics.ails.api.client.device_controller.DeviceService;

/**
 * The DeviceServiceActivator starts the {@link DeviceService DeviceService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 04-11-2015
 */
public class DeviceServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(DeviceService.class.getName(), null)
                .setImplementation(DeviceServiceImpl.class).add(createServiceDependency()
                        .setService(DeviceDAO.class).setRequired(true)));
    }

}
