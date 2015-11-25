package org.inaetics.ails.impl.client.model.device_data_store;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.osgi.framework.BundleContext;

public class DeviceDataStoreActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(DeviceDataStore.class.getName(), null)
                .setImplementation(DeviceDatStoreImpl.class));
    }

}
