package com.redbus.loadbalancer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("path")
public class Controller {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/test")
	public String testEndPoint() {
		String reString = "https://myService/seats/API-LB-instance";
		return restTemplate.getForEntity(reString, String.class).getBody();
	}
	
	
}
