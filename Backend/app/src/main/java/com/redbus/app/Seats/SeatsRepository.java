package com.redbus.app.Seats;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatsRepository extends JpaRepository<Seat, Long> {
	@Query(nativeQuery = true, value="select * from seats where bus_id  = ?1")
	List<Seat> getBookedSeatsByBusId(long busId);
	
	@Query(nativeQuery = true, value="select seat_no from seats where bus_id =?1")
	Set<Integer> getBookedSeatNosByBusid(long busId);
	
	@Query(nativeQuery = true, value="select seat_no from seats where bus_id=?1 and is_female_booked = true")
	Set<Integer> getFemaleBookedSeatsNosByBusId(long busId);
}
