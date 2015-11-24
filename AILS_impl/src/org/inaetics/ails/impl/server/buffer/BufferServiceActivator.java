package org.inaetics.ails.impl.server.buffer;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.common.model.AnonUserWiFiProfile;
import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.osgi.framework.BundleContext;

/**
 * The BufferServiceActivator starts several {@link BufferService} implementations.
 *
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.1
 * @since 04-11-2015
 */
public class BufferServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        Properties props = new Properties();
        props.put("type", "AnonUserWiFiProfile");

        manager.add(createComponent().setInterface(BufferService.class.getName(), props)
                .setImplementation(new BufferServiceFIFOImpl<>(AnonUserWiFiProfile.class)));

        Properties props2 = new Properties();
        props2.put("type", "RawLocationProfile");

        manager.add(createComponent().setInterface(BufferService.class.getName(), props2)
                .setImplementation(new BufferServiceFIFOImpl<>(RawLocationProfile.class)));
    }

}
