package com.rohit.location.service;

import java.util.List;

import com.rohit.location.entities.Location;

public interface LocationService {

	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationById(long id);

	List<Location> getAllLocations();
}
