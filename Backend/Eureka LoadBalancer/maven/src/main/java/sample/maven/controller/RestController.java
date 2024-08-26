package sample.maven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("path")
public class RestController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("test")
	public String getMethodName() {
		String reString = "http://myService/seats/API-LB-instance";
		return restTemplate.getForEntity(reString, String.class).getBody();
	}
	

}
