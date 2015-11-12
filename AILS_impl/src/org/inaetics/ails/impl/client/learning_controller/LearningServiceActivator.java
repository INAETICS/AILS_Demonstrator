package org.inaetics.ails.impl.client.learning_controller;

import org.osgi.framework.BundleContext;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.factory.WiFiProfileFactory;
import org.inaetics.ails.api.client.learning_controller.LearningService;

/**
 * The LearningServiceActivator starts the {@link LearningService LearningService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 05-11-2015
 */
public class LearningServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(LearningService.class.getName(), null)
                .setImplementation(LearningServiceImpl.class).add(createServiceDependency()
                        .setService(WiFiProfileFactory.class).setRequired(true)));
    }
}
