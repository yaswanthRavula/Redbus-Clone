package com.redbus.app.Seats;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatsRepository extends JpaRepository<Seat, Long> {
	@Query(nativeQuery = true, value="select seatNo from seats where seat_no in (?1) and  bus_id  = ?2 and dateOfJourney = ?3" )
	List<String> getBookedSeats(List<String> seatNos, long  busId, Date dateOfJourney);
	
	@Query(nativeQuery = true, value="select seat_no from seats where bus_id =?1")
	Set<String> getBookedSeatNosByBusid(long busId);
	
	@Query(nativeQuery = true, value="select seat_no from seats where bus_id=?1 and date_of_journey = ?2 is_female_booked = true")
	Set<String> getFemaleBookedSeatsNosByBusId(long busId, Date dateOfJourney);
}
