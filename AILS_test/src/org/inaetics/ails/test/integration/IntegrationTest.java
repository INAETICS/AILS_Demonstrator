package org.inaetics.ails.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.RawLocationProfile;
import org.inaetics.ails.api.common.model.UUIDWiFiProfile;
import org.inaetics.ails.api.server.buffer.BufferService;
import org.inaetics.ails.api.server.database.LocationProfileDAO;
import org.inaetics.ails.api.server.database.RawLocationProfileDAO;
import org.inaetics.ails.api.server.database.UUIDLocationDAO;
import org.inaetics.ails.api.server.database.UUIDWiFiProfileDAO;
import org.inaetics.ails.api.server.database.UserDAO;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.location.service.LocationService;
import org.inaetics.ails.api.server.location_profile.service.LocationProfileService;
import org.inaetics.ails.api.server.streaming_profile.service.StreamingProfileService;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;
import org.inaetics.ails.api.server.user.service.UserService;
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
 * @version 1.0.0
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
     * @since 1.0.0
     */
    @SuppressWarnings("unchecked")
    private <T> Optional<T> service(Class<T> clazz) {
        ServiceTracker st = new ServiceTracker(context, clazz.getName(), null);
        st.open();
        Object service = st.getService();
        if (service != null) {
            return Optional.of((T) service);
        }
        return Optional.empty();
    }

    /**
     * Get several particular services from the available bundles. Useful when you expect several
     * different instances of the same service to be available.
     *
     * @param clazz The class of the services to be retrieved.
     * @return A List of the found services or an empty List if nothing was found.
     * @since 1.0.0
     */
    @SuppressWarnings("unchecked")
    private <T> List<T> services(Class<T> clazz) {
        ServiceTracker st = new ServiceTracker(context, clazz.getName(), null);
        st.open();
        Object[] servicesArray = st.getServices();
        if (servicesArray != null) {
            return (List<T>) Arrays.asList(servicesArray);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Test the availability of each of the server-side services. Due to this testing the
     * availability of interfaces, this does not test the availability of the miners.
     * 
     * @since 1.0.0
     */
    @SuppressWarnings("rawtypes")
    @Test
    public void testServersideServicesAvailable() {
        // Check the standard User services
        assertTrue(service(UserDAO.class).isPresent());
        assertTrue(service(UserDataStore.class).isPresent());
        assertTrue(service(UserService.class).isPresent());

        // Check Location Profile services
        assertTrue(service(RawLocationProfileDAO.class).isPresent());
        assertTrue(service(LocationProfileDAO.class).isPresent());
        assertTrue(service(LocationProfileService.class).isPresent());

        // Check the Location Provider
        assertTrue(service(LocationProvider.class).isPresent());

        // if UserLocationDataStore is available, some other services should also be there
        if (service(UserLocationDataStore.class).isPresent()) {

            // This is the streaming wifi profiles option
            assertTrue(service(UUIDWiFiProfileDAO.class).isPresent());
            assertTrue(service(UUIDLocationDAO.class).isPresent());
            assertTrue(service(StreamingProfileService.class).isPresent());

            // Check the buffers
            List<BufferService> buffers = services(BufferService.class);
            assertEquals(2, buffers.size());
            assertTrue((buffers.get(0).forType().equals(UUIDWiFiProfile.class)
                    && buffers.get(1).forType().equals(RawLocationProfile.class))
                    || (buffers.get(0).forType().equals(RawLocationProfile.class)
                            && buffers.get(1).forType().equals(UUIDWiFiProfile.class)));

        } else {
            // This is the query location option
            assertTrue(service(LocationService.class).isPresent());

            // Check the buffers
            List<BufferService> buffers = services(BufferService.class);
            assertEquals(2, buffers.size());
            assertTrue((buffers.get(0).forType().equals(UUID.class)
                    && buffers.get(1).forType().equals(RawLocationProfile.class))
                    || (buffers.get(0).forType().equals(RawLocationProfile.class)
                            && buffers.get(1).forType().equals(UUID.class)));
        }
    }

}
