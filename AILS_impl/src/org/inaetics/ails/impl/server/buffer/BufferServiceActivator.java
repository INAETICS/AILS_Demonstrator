package org.inaetics.ails.impl.server.buffer;

import org.inaetics.ails.api.server.buffer.BufferService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BufferServiceActivator implements BundleActivator {
    
    private ServiceRegistration serviceRegistration;
    
    @Override
    public void start(BundleContext context) throws Exception {
        serviceRegistration = context.registerService(BufferService.class.getName(), new BufferServiceImpl(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
    }

}
