package com.redbus.app.Seats;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


public interface SeatBookingService {
	

	public List<String> alreadyBookedSeats(List<String> seatNos, long busId, Date dateOfJourney);
	public String bookSeats(List<Seat> seats) ;
	
	public List<String> lockSeatsForBusIdandDate(List<String> seatsList, long busid, Date DateOfJourney);
	public void unLockSeats(List<String> seatsList, long busId, Date journeyDate);
}
