package org.inaetics.ails.impl.server.location.provider;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.server.location.provider.LocationProvider;
import org.inaetics.ails.api.server.user.extended_datastore.UserLocationDataStore;

/**
 * The User Location Provider Service provides a way to retrieve a {@link User User's}
 * {@link Location}.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 10-11-2015
 */
public class UserLocationProviderService implements LocationProvider {

    // injected by the DM
    private volatile UserLocationDataStore userLocationDataStore;

    @Override
    public Optional<Location> locate(UUID uuid) {
        return userLocationDataStore.getLocation(uuid);
    }

}
