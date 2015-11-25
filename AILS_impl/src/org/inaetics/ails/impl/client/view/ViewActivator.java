package org.inaetics.ails.impl.client.view;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
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
                .setImplementation(ViewImpl.class));
    }

}
