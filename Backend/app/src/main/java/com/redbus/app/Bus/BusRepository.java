package com.redbus.app.Bus;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface BusRepository extends JpaRepository<Bus, Long> {
	
	@Query(value = "select is_bus_available from busses where bus_id = ?1", nativeQuery = true)
	boolean isBusAvailable(long busId);
	
	@Query(value="update busses set is_bus_available = true where bus_id = :busId", nativeQuery = true)
	@Modifying
	@Transactional
	void makeBusAvailable(@Param("busId") long busId);
	
	@Query(value="update busses set is_bus_available = false where bus_id = :busId", nativeQuery = true)
	@Modifying
	@Transactional
	void makeBusUnAvailable(@Param("busId") long busId);
	
	@Query(nativeQuery = true, value = "update busses set seats_left=?2 where bus_id = ?1 ")
	@Modifying
	@Transactional
	void updateSeatsLeftBybusId(long busId, int seatsLeft);
	
	@Query(nativeQuery = true, value = "select seats_left from busses where bus_id = ?1")
	int getSeatsLeftByBusId(long busId);
	
	@Query(nativeQuery = true, value= "select * from busses where lower(source) = ?1 and lower(destination) = ?2 and is_bus_available = true")
	List<Bus> getBusesBetweenSrcandDest(String source, String destination); 
	
	@Query(nativeQuery= true, value= "select * from busses where lower(source) = ?1 and lower(destination) = ?2 and is_bus_available = true and isac= ?3")
	List<Bus> filterBussesByOnlyAc(String source, String destination, boolean isAc);
	
	@Query(nativeQuery= true, value= "select * from busses where lower(source) = ?1 and lower(destination) = ?2 and is_bus_available = true and is_sleeper=?3")
	List<Bus> filterBussesByOnlySleeper(String source, String destination, boolean isSleeper);
	
	@Query(nativeQuery= true, value= "select * from busses where lower(source) = ?1 and lower(destination) = ?2 and is_bus_available = true and isac=?3 and is_sleeper=?4")
	List<Bus> filterBussesByAcandSleeper(String source, String destination, boolean isAC, boolean isSleeper);
	
}
