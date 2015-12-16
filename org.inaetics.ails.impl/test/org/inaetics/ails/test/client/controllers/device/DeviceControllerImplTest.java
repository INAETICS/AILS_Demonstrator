package org.inaetics.ails.test.client.controllers.device;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.inaetics.ails.api.client.controllers.device.DeviceController;
import org.inaetics.ails.api.client.model.device_data_store.DeviceDataStore;
import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.user.service.UserService;
import org.inaetics.ails.impl.client.controllers.device.DeviceControllerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Some simple unit tests for {@link DeviceControllerImpl}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 30-11-2015
 */
@RunWith(MockitoJUnitRunner.class)
public class DeviceControllerImplTest {

    @Mock
    private UserService userService;
    @Mock
    private DeviceDataStore deviceDataStore;

    @InjectMocks
    private DeviceController deviceController = new DeviceControllerImpl();

    @Test(expected = NullPointerException.class)
    public void testRegisterUserNull() {
        deviceController.registerUser(null);
    }

    @Test
    public void testRegisterUser() {
        // Setup
        when(userService.add("John Doe", Accuracy.AREA)).thenReturn(UUID.randomUUID());

        // Execute
        deviceController.registerUser("John Doe");

        // Verify
        verify(userService, times(1)).add("John Doe", Accuracy.AREA);
        verify(deviceDataStore, times(1)).storeUser(any(User.class));
    }

    @Test(expected = IllegalStateException.class)
    public void testRegisterUserTwice() {
        when(deviceDataStore.hasUser()).thenReturn(true);
        deviceController.registerUser("John Doe");
    }

    @Test(expected = NullPointerException.class)
    public void testSetAccuracyNull() {
        deviceController.setAccuracy(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testSetAccuracyNoUserRegistered() {
        deviceController.setAccuracy(Accuracy.AREA);
    }

    @Test
    public void testSetAccuracy() {
        when(deviceDataStore.hasUser()).thenReturn(true);
        deviceController.setAccuracy(Accuracy.AREA);
    }

}
