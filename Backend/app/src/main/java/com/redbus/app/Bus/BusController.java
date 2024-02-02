package com.redbus.app.Bus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BusController")
public class BusController {

	@GetMapping("Bus")
	public String getBus() {
		return "Firs Bus";
	}
}
