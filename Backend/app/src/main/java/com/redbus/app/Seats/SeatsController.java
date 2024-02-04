package com.redbus.app.Seats;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.redbus.app.Bus.BusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seats")
public class SeatsController {
	
	@Autowired
	SeatsRepository seatsRepository;
	@Autowired
	BusRepository busRepository;
	
	
	@DeleteMapping("unbook-tickets")
	HashMap<String, Set<Integer>> unBookSeat(@RequestBody List<Seat> seatsList){
		try {
			seatsRepository.deleteInBatch(seatsList);
			int seatsLeft = busRepository.getSeatsLeftByBusId(seatsList.get(0).getBusId())+seatsList.size();
	        busRepository.updateSeatsLeftBybusId(seatsList.get(0).getBusId(), seatsLeft);
	        return getBookedSeatsByBusId(seatsList.get(0).getBusId());
			
		}catch(Exception e) {
				System.out.println("Unable to book Seat.\nReason: "+e.getMessage());
			
		}
			return null;
	}
	
	
	@PostMapping("book-seats")
	HashMap<String, Set<Integer>> bookSeat(@RequestBody List<Seat> seatsList){
		try {
			seatsRepository.saveAll(seatsList);
	        int seatsLeft = busRepository.getSeatsLeftByBusId(seatsList.get(0).getBusId())-seatsList.size();
	        busRepository.updateSeatsLeftBybusId(seatsList.get(0).getBusId(), seatsLeft);
	        return getBookedSeatsByBusId(seatsList.get(0).getBusId());
		}catch(Exception e) {
			System.out.println("Unable to book Seat.\nReason: "+e.getMessage());
		}
		return null;
	}
	
	
	
	@GetMapping("booked-seats")
	public HashMap<String,Set<Integer>> getBookedSeatsByBusId(@RequestParam(name = "busId") long busId){
		try{
			Set<Integer> allBookedSeats = seatsRepository.getBookedSeatNosByBusid(busId); 
			HashMap<String, Set<Integer>> bookedSeatsMap= new HashMap<>();
			bookedSeatsMap.put("All Booked Seats", allBookedSeats);
			allBookedSeats = seatsRepository.getFemaleBookedSeatsNosByBusId(busId);
			bookedSeatsMap.put("Female Booked Seats", allBookedSeats);
			return bookedSeatsMap;
			
		}catch(Exception e) {
			System.out.println("Unable to retrieve Booked Tickets.\nReason : "+e.getMessage());
		}
		return null;
	}		
	

}
