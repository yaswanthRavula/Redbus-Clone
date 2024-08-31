package com.redbus.app.Seats;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.redbus.app.Bus.BusRepository;
import com.redbus.app.CodeResources.Passenger;

import ch.qos.logback.core.joran.sanity.Pair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${server.port}")
	String portString;
	
	@Autowired
	SeatsRepository seatsRepository;
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	SeatBookingService seatBookingService;
	
	
	
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
	public String bookSeat(@RequestBody List<String> seatNos, long busId, Date dateOfJourney, int noofPassengers, List<Passenger> passengers, long transactionalId){
		
		
		
		/*________________ Seats Booked By other user Criteria ____________*/
		List<String> seatsLAreadyBookedList = seatBookingService.alreadyBookedSeats(seatNos, busId, dateOfJourney);
		boolean anySeatBookedByOtherUser = seatsLAreadyBookedList.size() > 0 ? true : false;
		if(anySeatBookedByOtherUser) {
			//One or more seats are already booked.
			//Lets inform the user fastlyy...
			String msgString = "Sorry! We could not book tickets.\n";
			msgString +="Seats: "+ seatsLAreadyBookedList+ " already Booked by others. \n-Team Yaswanth Travels";
			return msgString;
		}
		/*__________________Seats Activated By other User Criteria______________-*/ 
		List<String> seatsAlreadyLockedList =  seatBookingService.lockSeatsForBusIdandDate(seatNos, busId, dateOfJourney);
		boolean anySeatLockedByOtherUser = seatsAlreadyLockedList.size() > 0 ? true : false;
		
		if(anySeatLockedByOtherUser) {
			//Few seats are already locked by other user
			//lets inform the user fastlyy..
			String msgString = "Sorry ! We could not book you seats at this time.";
			msgString+= " Seats: "+seatsAlreadyLockedList+" are selected by some othe persons.\n" +" - Team Yaswanth Travels";
			
			return msgString;
		}
		
		//Create a List of seats in "Seat" Format from User payload
		List<Seat> seatList = new ArrayList<>();
		for(int i = 0; i < noofPassengers; i++) {
			Seat seat = new Seat(seatNos.get(i), passengers.get(i).isFemale, busId, passengers.get(i).name, dateOfJourney, transactionalId);
			seatList.add(seat);
		}
		
		String msgString = seatBookingService.bookSeats(seatList);
		seatBookingService.unLockSeats(seatNos, busId, dateOfJourney);
		
		return msgString;
	}
	
	
	
	@GetMapping("booked-seats")
	public HashMap<String,Set<Integer>> getBookedSeatsByBusId(@RequestParam(name = "busId") long busId){
		return null;
	}	
	
	
	
	@GetMapping("API-LB-instance")
	public String getInstance() {
		String msgString ="";
		InetAddress inetAddress;
		try {
			inetAddress = InetAddress.getLoopbackAddress();
			msgString = inetAddress.getHostAddress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msgString = e.getMessage();
		}
		
		return portString+"\n"+ msgString;
	}
	

}
