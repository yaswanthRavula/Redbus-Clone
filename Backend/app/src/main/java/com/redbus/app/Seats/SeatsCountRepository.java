package com.redbus.app.Seats;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatsCountRepository extends JpaRepository<SeatsCount, Long> {

	@Query(nativeQuery = true, value = "select count from seats_booked where bus_id = ?1 and journey_date = ?2")
	public int getSeatsBookedCount(long busId, Date dateOfJourney);
	
	@Query(nativeQuery = true, value = "insert into seats_booked values(?1, ?2, ?3) on duplicate key update count = (count + ?3)")
	public void updateSeatsBooked(long busId, Date dateOfJourney, int ticketCountTOBeAdded);
	
	
	
	
}
