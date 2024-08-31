package com.redbus.app.Seats;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbus.app.CodeResources.BookingQueue;

@Service
public class SeatBookingServiceImpl implements SeatBookingService {
	@Autowired
	BookingQueueRepository bookingQueueRepository;
	
	@Autowired
	SeatsRepository seatsRepository;
	@Autowired
	SeatsCountRepository seatsCountRepository;
	
	/*______ Seats Booked By Other User______________*/
	
	public List<String> alreadyBookedSeats(List<String> seatNos, long busId, Date dateOfJourney){
		return seatsRepository.getBookedSeats(seatNos, busId, dateOfJourney);
	}
	
	public String bookSeats(List<Seat> seats) {
		// So far No Payment Integration.. Lets Integerate in future.
		
		try {
		payment();
		seatsRepository.saveAllAndFlush(seats);
		
		//After booking, please update total seats booked DB. Coool.
		seatsCountRepository.updateSeatsBooked(seats.get(0).busId, seats.get(0).dateOfJourney, seats.size());
		}catch(Exception e) {
			return "Sorry Seats Not Booked.\n"+e.getMessage();
		}
		
		return "Seats Booked Succesfully. Yaswanth Bus Travels Wish you a Happy Journey";
			
	}
	
	
	
	/* ______ Seats Locked By other user ______________*/
	
	public List<String> lockSeatsForBusIdandDate(List<String> seatsList, long busId, Date dateOfJourney) {
		BookingQueue bookingObj;
		List<BookingQueue> list = new ArrayList();
		List<String> seatsAlreadyLockedList = new ArrayList();
		for(String seatNo: seatsList) {
			bookingObj = new BookingQueue(busId,seatNo, dateOfJourney);
			list.add(bookingObj);
		}
		try{
			bookingQueueRepository.saveAllAndFlush(list);
		}catch(Exception e){
			seatsAlreadyLockedList= getLockedSeatsInUserSelectedSeats(seatsList, busId, dateOfJourney);
			//System.out.println("Class :::::::::::::::::::: "+e.getClass());
		}
		
		return seatsAlreadyLockedList;
	}
	
	public List<String> getLockedSeatsInUserSelectedSeats(List<String> seatsList, long busId, Date journeyDate){
		List<String> lockedSeatsInUserSelectedSeats= new ArrayList<>();
		return bookingQueueRepository.FilterLockedSeatsInUserSelectedSeats(seatsList, busId, journeyDate);
		
	}
	
	public void unLockSeats(List<String> seatsList, long busId, Date journeyDate) {
		bookingQueueRepository.unlockSeatsList(seatsList, busId, journeyDate);
	}
	
	
	
	public void payment() {
		
	}
}
