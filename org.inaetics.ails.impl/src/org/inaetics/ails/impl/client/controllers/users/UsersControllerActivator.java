package org.inaetics.ails.impl.client.controllers.users;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.inaetics.ails.api.client.controllers.users.UsersController;
import org.inaetics.ails.api.server.user.service.UserService;
import org.osgi.framework.BundleContext;

/**
 * The UsersControllerActivator starts the {@link UsersController UsersController}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 25-11-2015
 */
public class UsersControllerActivator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext context, DependencyManager manager) throws Exception {
        manager.add(createComponent().setInterface(UsersController.class.getName(), null)
                .setImplementation(UsersControllerImpl.class)
                .add(createServiceDependency().setService(UserService.class).setRequired(false)));
    }

    @Override
    public void destroy(BundleContext bundleContext, DependencyManager dependencyManager) throws Exception {

    }

}
