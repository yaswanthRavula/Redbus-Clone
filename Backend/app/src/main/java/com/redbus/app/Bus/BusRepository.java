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
	
}
