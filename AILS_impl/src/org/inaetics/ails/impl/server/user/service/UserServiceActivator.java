package org.inaetics.ails.impl.server.user.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class UserServiceActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Running for my life!");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("He's dead, Jim!");
    }

}
