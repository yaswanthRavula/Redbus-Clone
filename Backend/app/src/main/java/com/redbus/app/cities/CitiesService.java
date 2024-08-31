package com.redbus.app.cities;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CitiesService {

	RestTemplate restTemplate = new RestTemplate();
	public String getAuthorizationToken() {
		String urlString = "https://www.universal-tutorial.com/api/getaccesstoken";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept","application/json");
		headers.add("api-token","aRcDULxk2k4pmAtb7fV6m67Xfpyui0LaHnfMEVX1id972SodWvee1_SrXb17Eis6WRM");
		headers.add("user-email", "yaswanthravula0@gmail.com");
		HttpEntity<String> entity = new HttpEntity(headers);
		 
		try{
			return restTemplate.exchange(urlString, HttpMethod.GET, entity, String.class ).getBody();
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	public String getCities(){
		String urlString = "https://www.universal-tutorial.com/api/cities/Telangana";
		HttpHeaders headers = new HttpHeaders();
		String bearerKeyString = this.getAuthorizationToken();
		headers.add("Accept","application/json");
		JSONObject jsonObject = new JSONObject(bearerKeyString);
		bearerKeyString = jsonObject.getString("auth_token");
		headers.add("Authorization", "Bearer "+bearerKeyString);
		HttpEntity entity = new HttpEntity (headers);
		System.out.println(headers.toString());
				
		List<String> res= new ArrayList(); 
		try{
			return restTemplate.exchange(urlString, HttpMethod.GET,entity,String.class ).getBody();
		}catch(Exception e) {
			return e.getMessage();
			
		}
	}
}
