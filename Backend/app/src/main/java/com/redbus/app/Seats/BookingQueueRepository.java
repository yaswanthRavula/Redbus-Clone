package com.redbus.app.Seats;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.redbus.app.CodeResources.BookingQueue;

public interface BookingQueueRepository extends JpaRepository<BookingQueue, Long> {

	@Query(nativeQuery = true, value = "SELECT seat_no from redbus.booking_queue where seat_no in (?1) and bus_id = ?2 and journey_date = ?3")
	public List<String> FilterLockedSeatsInUserSelectedSeats(List<String> seatsList, long busId, Date journeyDate);
	
	@Query(nativeQuery = true, value = "DELETE from redbus.booking_queue where seat_no in (?1) and bus_id = ?2 and journey_date = ?3")
	public void unlockSeatsList(List<String> seatsList, long busId, Date journeyDate);
}
