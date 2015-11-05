package org.inaetics.ails.impl.server.location.provider;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.server.location.provider.LocationProvider;

public class UserLocationProviderService implements LocationProvider {
    
    // TODO: inject extended data data store

    @Override
    public Optional<Location> locate(UUID uuid) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

}
