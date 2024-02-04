package com.redbus.app.Bus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Bus-list")
public class BusListController {

	@Autowired
	BusRepository busRepository;
	
	
	@GetMapping("/bussesList")
	List<Bus> getBussesList(){
		return busRepository.findAll();
	}
	
	@PostMapping("addNewBus")
	List<Bus> addNewBus(@RequestBody Bus bus){
		busRepository.save(bus);
		return getBussesList();
	}	
}
