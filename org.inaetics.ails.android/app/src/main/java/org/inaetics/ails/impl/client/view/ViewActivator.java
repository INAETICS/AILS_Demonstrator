package org.inaetics.ails.impl.client.view;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.controllers.learning.LearningController;
import org.inaetics.ails.api.client.controllers.streaming_wifi_profiles.StreamingWiFiProfilesController;
import org.inaetics.ails.api.client.controllers.users.UsersController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.client.view.View;
import org.osgi.framework.BundleContext;

/**
 * The ViewActivator starts the {@link View View}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class ViewActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(View.class.getName(), null)
                        .setImplementation(ViewImpl.class)
                        .add(createServiceDependency().setService(DeviceDataStore.class).setRequired(true))
                        .add(createServiceDependency().setService(DeviceController.class)
                                .setRequired(true))
                .add(createServiceDependency().setService(UsersController.class).setRequired(true))
                .add(createServiceDependency().setService(StreamingWiFiProfilesController.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(LearningController.class)
                        .setRequired(true)));
    }

    @Override
    public void destroy(BundleContext bundleContext, DependencyManager dependencyManager) throws Exception {

    }

}
