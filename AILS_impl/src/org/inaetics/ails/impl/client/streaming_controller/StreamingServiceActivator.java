package org.inaetics.ails.impl.client.streaming_controller;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;

import org.inaetics.ails.api.client.factory.WiFiProfileFactory;
import org.inaetics.ails.api.client.streaming_controller.StreamingService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

/**
 * The StreamingProfileServiceActivator starts the {@link StreamingProfileService
 * StreamingProfileService} bundle and starts the streaming service automatically.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 11-11-2015
 */
public class StreamingServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(StreamingService.class.getName(), null)
                .setImplementation(StreamingServiceImpl.class)
                .add(createServiceDependency().setService(WiFiProfileFactory.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(StreamingProfileService.class)
                        .setRequired(true)));
    }
}
