package com.redbus.app.Bus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Bus")
public class BusController {

	@Autowired
	BusRepository busRepository;
	
	
	@SuppressWarnings("deprecation")
	@GetMapping("getBusById")
	Bus getBusById(@RequestParam(name= "busId") long busId) {
		return busRepository.getById(busId);
	}
	
	
	@DeleteMapping("deleteBusById")
	String deleteBusById(@RequestParam(name = "busId") long busId) {
		try{
			busRepository.deleteById(busId);
			return "Bus Deleted Successfully !";
		}catch (Exception e) {
			// TODO: handle exception
			return "Bus not deleted because : "+e.getMessage();
		}
	}
	
	
	@PutMapping("activateBus")
	String activateBus(@RequestParam(name="busId") long busId) {
		try{
			if(busRepository.isBusAvailable(busId)) return "Bus is Already Active !";
			else {
				busRepository.makeBusAvailable(busId);
				return "Bus is activated Succesfully";
			}
		}catch(Exception e){
			return "Error while updating Bus Available \n Message: "+e.getMessage();
		}
	}
	
	@PutMapping("inActivateBus")
	String inActivateBus(@RequestParam(name="busId") long busId) {
		try{
			if(!busRepository.isBusAvailable(busId)) return "Bus is Already InActive !";
			else {
				busRepository.makeBusUnAvailable(busId);
				return "Bus is inactivated Succesfully";
			}
		}catch(Exception e){
			return "Error while updating Bus Available \n Message: "+e.getMessage();
		}
	}
	@PutMapping("update-bus")
	Bus updateBus(@RequestBody Bus bus) {
		try {
			System.out.println("\n\n"+bus.getBusId()+"\n\n");
			busRepository.save(bus);
			return busRepository.getById(bus.getBusId());
		}catch(Exception e) {
			System.out.println( "Unable to update Bus. \n Message: "+e.getMessage());
			return null;
		}
	}
	

	
}
