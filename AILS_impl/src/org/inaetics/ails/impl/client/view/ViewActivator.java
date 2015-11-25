package org.inaetics.ails.impl.client.view;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.view.View;
import org.osgi.framework.BundleContext;

public class ViewActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(View.class.getName(), null)
                .setImplementation(ViewImpl.class));
    }

}
