package org.inaetics.ails.impl.client.controllers.streaming_wifi_profiles;

import org.osgi.framework.BundleContext;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.streaming_wifi_profiles.StreamingWiFiProfilesController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.client.model.wifi_profile_factory.WiFiProfileFactory;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;

/**
 * The StreamingWiFiProfilesControllerActivator starts the {@link StreamingWiFiProfileController
 * StreamingWiFiProfileController} bundle.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 11-11-2015
 */
public class StreamingWiFiProfilesControllerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent()
                .setInterface(StreamingWiFiProfilesController.class.getName(), null)
                .setImplementation(StreamingWiFiProfilesControllerImpl.class)
                .add(createServiceDependency().setService(WiFiProfileFactory.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(StreamingProfileService.class)
                        .setRequired(true))
                .add(createServiceDependency().setService(DeviceDataStore.class)
                        .setRequired(true)));
    }
}
