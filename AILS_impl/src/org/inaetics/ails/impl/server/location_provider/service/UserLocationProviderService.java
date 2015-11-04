package org.inaetics.ails.impl.server.location_provider.service;

import java.util.Optional;
import java.util.UUID;

import org.inaetics.ails.api.common.model.Location;
import org.inaetics.ails.api.server.location.provider.LocationProvider;

public class UserLocationProviderService implements LocationProvider {

	@Override
	public Optional<Location> locate(UUID uuid) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
