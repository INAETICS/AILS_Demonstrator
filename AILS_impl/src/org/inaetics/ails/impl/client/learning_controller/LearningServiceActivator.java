package org.inaetics.ails.impl.client.learning_controller;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.factory.RawLocationProfileFactory;
import org.inaetics.ails.api.client.learning_controller.LearningService;

/**
 * The LearningServiceActivator starts the {@link LearningService LearningService}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class LearningServiceActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(LearningService.class.getName(), null)
                .setImplementation(LearningServiceImpl.class)
                .add(createServiceDependency().setService(RawLocationProfileFactory.class).setRequired(true)));
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        ServiceReference serviceReference = context.getServiceReference(LearningServiceImpl.class.getName());
        LearningServiceImpl learningService = (LearningServiceImpl) context.getService(serviceReference);
        
        learningService.startLearningMode();
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
        
        ServiceReference serviceReference = context.getServiceReference(LearningServiceImpl.class.getName());
        LearningServiceImpl learningService = (LearningServiceImpl) context.getService(serviceReference);
        
        learningService.stopLearningMode();
    }
}
