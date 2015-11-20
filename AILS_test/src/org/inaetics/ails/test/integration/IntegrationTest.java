package org.inaetics.ails.test.integration;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.inaetics.ails.api.server.database.UserDAO;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Integration tests for AILS' services.
 * 
 * Tests: services available (i.e. active); use cases show services working as one system.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 20-11-2015
 */
public class IntegrationTest {

    private final BundleContext context =
            FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    /**
     * Get a particular service from the available bundles. 
     * 
     * @param clazz The class of the service to be retrieved.
     * @return Optional with the service if found, empty Optional if not.
     */
    @SuppressWarnings("unchecked")
    private <T> Optional<T> getService(Class<T> clazz) {
        ServiceTracker st = new ServiceTracker(context, clazz.getName(), null);
        st.open();
        Object service = st.getService();
        if (service != null) {
            return Optional.of((T) service);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Tests if a UserDAO service is available.
     */
    @Test
    public void testUserDAOActive() {
        assertTrue("UserDAO was null", getService(UserDAO.class).isPresent());
    }

}
