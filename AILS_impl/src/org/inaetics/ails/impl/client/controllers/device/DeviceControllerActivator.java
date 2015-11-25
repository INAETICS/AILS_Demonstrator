package org.inaetics.ails.impl.client.controllers.device;

import org.osgi.framework.BundleContext;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.device.DeviceController;

/**
 * The DeviceControllerActivator starts the {@link DeviceController DeviceController}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 04-11-2015
 */
public class DeviceControllerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager dm) throws Exception {
        dm.add(createComponent().setInterface(DeviceController.class.getName(), null)
                .setImplementation(DeviceControllerImpl.class));

        // TODO: Add dependency injections
    }

}
