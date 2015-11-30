package org.inaetics.ails.test.server.user.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Accuracy;
import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.common.model.User;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.datastore.UserDataStore;
import org.inaetics.ails.api.server.user.service.UserService;
import org.inaetics.ails.impl.server.user.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Some simple unit tests for {@link UserServiceImpl}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 30-11-2015
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private LocationProvider locationProvider;
    @Mock
    private UserDataStore userDataStore;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test(expected = NullPointerException.class)
    public void testAddUserNullValues() {
        userService.add(null, null);
    }

    @Test
    public void testAddUserSuccessful() {
        // Setup
        UUID uuid = UUID.randomUUID();
        when(userDataStore.storeUser(any(User.class))).thenReturn(uuid);

        // Execute
        UUID retrievedUUID = userService.add("John Doe", Accuracy.AREA);

        // Verify
        verify(userDataStore, times(1)).storeUser(any(User.class));
        assertEquals(uuid, retrievedUUID);
    }

    @Test
    public void testGetAllEmpty() {
        assertTrue(userService.getAll().isEmpty());
    }

    @Test
    public void testGetAllWithSomeUsers() {
        // Setup
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID(), "John Doe", Accuracy.AREA));
        users.add(new User(UUID.randomUUID(), "Jane Doe", Accuracy.BUILDING));
        users.add(new User(UUID.randomUUID(), "Johnny Does", Accuracy.OFF));
        when(userDataStore.getAllUsers()).thenReturn(users);

        // execute
        List<User> retrievedUsers = userService.getAll();

        // Verify
        assertEquals(users, retrievedUsers);
    }

    @Test(expected = NullPointerException.class)
    public void testFindNull() {
        userService.find(null);
    }

    @Test
    public void testFindUnknownUUID() {
        // Mocks need to return Optional.empty, not null (their default)
        when(userDataStore.getUser(any(UUID.class))).thenReturn(Optional.empty());
        assertEquals(Optional.empty(), userService.find(UUID.randomUUID()));
    }

    @Test
    public void testFind() {
        UUID uuid = UUID.randomUUID();
        Optional<User> user = Optional.of(new User(uuid, "John Doe", Accuracy.AREA));
        when(userDataStore.getUser(uuid)).thenReturn(user);
        assertEquals(user, userService.find(uuid));
    }

    @Test(expected = NullPointerException.class)
    public void testLocateNull() {
        userService.locate(null);
    }

    @Test
    public void testLocateUnknownUUID() {
        // Mocks need to return Optional.empty, not null (their default)
        when(locationProvider.locate(any(UUID.class))).thenReturn(Optional.empty());
        assertEquals(Optional.empty(), userService.locate(UUID.randomUUID()));
    }

    @Test
    public void testLocate() {
        UUID uuid = UUID.randomUUID();
        Optional<Location> location = Optional.of(new Location("foo", "bar", "foofoo", "foobar"));
        when(locationProvider.locate(uuid)).thenReturn(location);
        assertEquals(location, userService.locate(uuid));
    }

}
