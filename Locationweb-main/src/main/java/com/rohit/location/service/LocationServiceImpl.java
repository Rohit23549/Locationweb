package com.rohit.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.location.entities.Location;
import com.rohit.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationRepository repository;

	@Override
	public Location saveLocation(Location location) {
		// TODO Auto-generated method stub
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
	      repository.delete(location);
	}

	@Override
	public Location getLocationById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
