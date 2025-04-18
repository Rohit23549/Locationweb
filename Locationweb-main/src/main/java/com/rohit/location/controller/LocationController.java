package com.rohit.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rohit.location.entities.Location;
import com.rohit.location.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService service;
	@GetMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("location", new Location());
		 System.out.println("LocationController.showCreate");
		return "createLocation";
	}

	@PostMapping("/saveLoc")
	String saveLocation(@ModelAttribute Location location, ModelMap modelMap) {
		System.out.println("saveLocation.saveLocation");
		Location savedLocation = service.saveLocation(location);
		String msg = "Location saved with id : " + savedLocation.getId();
		modelMap.addAttribute("msg", msg);
		System.out.println("saveLocation.saveLocation");
		return "createLocation";
	}

	/*
	 * @GetMapping("/displayLocations") String displayLocations(ModelMap modelMap) {
	 * List<Location> locations=service.getAllLocations();
	 * modelMap.addAttribute("locations",locations); return "displayLocations"; }
	 */
	@GetMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		System.out.println("displayLocations.displayLocations");
		return "displayLocations"; // ye HTML template return karega
	}
	
	@GetMapping("/showUpdate")
	String showUpdate(@RequestParam long id, ModelMap modelMap) {
		System.out.println("createLocation. showUpdate()");
		Location location=service.getLocationById(id);
		modelMap.addAttribute("location",location);
		return"updateLocation";
	}

	@PostMapping("/updateLoc")
	String updateLocation(@ModelAttribute Location location, ModelMap modelMap) {
		service.updateLocation(location);
		System.out.println("saveLocation.saveLocation");
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@GetMapping("/deleteLocation")
	String deleteLocation(@RequestParam long id, ModelMap modelMap) {
		Location location=new Location();
		location.setId(id);
		System.out.println("deleteLocation()");
		service.deleteLocation(location);
		List<Location> locations=service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}

}
