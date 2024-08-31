package com.redbus.app.cities;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CiitiesController {
	
	@Autowired
	CitiesService citiesService;
	
	@GetMapping("getCities")
	public String getCitites(){
		return citiesService.getCities();
	}
}
