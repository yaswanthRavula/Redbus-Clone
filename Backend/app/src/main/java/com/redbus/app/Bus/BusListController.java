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
@RequestMapping("bus-list")
public class BusListController {

	@Autowired
	BusRepository busRepository;
	
	
	@GetMapping("/busses-list")
	List<Bus> getBussesList(@RequestParam(name = "source") String source, @RequestParam(name= "destination") String destination, @RequestParam(name = "isAc", required = false) String isAc, @RequestParam(name = "isSleeper", required = false) String isSleeper){
		if(isAc==null && isSleeper==null)
			return busRepository.getBusesBetweenSrcandDest(source.toLowerCase(), destination.toLowerCase());
		else if(isAc==null)
			return busRepository.filterBussesByOnlySleeper(source.toLowerCase(), destination.toLowerCase(), isSleeper.toLowerCase().equals("true"));
		else if(isSleeper == null)
			return busRepository.filterBussesByOnlyAc(source.toLowerCase(), destination.toLowerCase(), isAc.toLowerCase().equals(true));
		else
			return busRepository.filterBussesByAcandSleeper(source.toLowerCase(), destination.toLowerCase(), isAc.toLowerCase().equals("true"), isSleeper.toLowerCase().equals("true"));
			
	}

	@PostMapping("addNewBus")
	Bus addNewBus(@RequestBody Bus bus){
		bus.setSource(bus.getSource().toLowerCase());
		bus.setDestination(bus.getDestination().toLowerCase());
		return busRepository.save(bus);
		//return findById();
	}	
}
