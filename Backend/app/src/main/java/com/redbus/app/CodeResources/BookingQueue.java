package com.redbus.app.CodeResources;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class BookingQueue {

	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	long transactionalId;
	
	@Column(name = "busId")
	long busId;
	
	@Column(name = "seatNo")
	String seatNo;
	
	@Column(name = "journeyDate")
	Date journeyDate;

	
	
	public BookingQueue(long busId, String seatNo, Date journeyDate) {
		super();
		this.busId = busId;
		this.seatNo = seatNo;
		this.journeyDate = journeyDate;
	}

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	

	
	
	
}