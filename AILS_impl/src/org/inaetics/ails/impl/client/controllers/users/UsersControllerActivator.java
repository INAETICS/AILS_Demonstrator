package org.inaetics.ails.impl.client.controllers.users;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.users.UsersController;
import org.osgi.framework.BundleContext;

public class UsersControllerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(UsersController.class.getName(), null));
        
    }

}
