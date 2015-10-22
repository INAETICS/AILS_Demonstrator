package org.inaetics.ails.api.server.location_load_balancer;

import java.util.Optional;
import java.util.UUID;
import org.inaetics.ails.api.model.Location;

public interface LocationLoadBalancerService {
	/** 
	 * Adds or removes servers from the system, if a negative number is 
	 * supplied, servers shall be removed when they finish their jobs
	 * 
	 * @param n Amount of services to instantiate
	 */
	void scale(int n);
	
	/**
	 * Retrieves the load information of the balanced location servers
	 * 
	 * @return A load figure in range [0.0, 1.0] where 1.0 indicates full load
	 * 		   and 0.0 zero load. 
	 */
	double getLoad();
	
	/**
	 * Retrieves a location from a user given its UUID
	 * Facade for LocationService
	 * 
	 * The implementation of this function should be thread safe but not blocking, it must support
	 * multiple callers without corrupting its state
	 * 
	 * @see org.inaetics.ails.api.server.location_service.LocationService#getLocation(java.util.UUID)
	 */
	Optional<Location> getLocation(UUID uuid);
}
