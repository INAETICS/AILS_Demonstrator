package org.inaetics.ails.impl.client.controllers.learning;

import org.osgi.framework.BundleContext;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.learning.LearningController;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;

/**
 * The LearningControllerActivator starts the {@link LearningController LearningController}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 05-11-2015
 */
public class LearningControllerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(LearningController.class.getName(), null)
                .setImplementation(LearningControllerImpl.class).add(createServiceDependency()
                        .setService(WiFiProfileFactory.class).setRequired(true)));
    }
}
