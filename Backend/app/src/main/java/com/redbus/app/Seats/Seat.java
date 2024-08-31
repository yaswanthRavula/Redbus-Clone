package com.redbus.app.Seats;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long seatId;
	String seatNo;
	boolean isFemaleBooked;
	long busId;
	String passengerName;
	Date dateOfJourney;
	long transactionId;
	
	
	
	public long getSeatId() {
		return seatId;
	}
	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public boolean isFemaleBooked() {
		return isFemaleBooked;
	}
	public void setFemaleBooked(boolean isFemaleBooked) {
		this.isFemaleBooked = isFemaleBooked;
	}
	public long getBusId() {
		return busId;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Date getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public Seat(String seatNo, boolean isFemaleBooked, long busId, String passengerName, Date dateOfJourney,
			long transactionId) {
		super();
		this.seatNo = seatNo;
		this.isFemaleBooked = isFemaleBooked;
		this.busId = busId;
		this.passengerName = passengerName;
		this.dateOfJourney = dateOfJourney;
		this.transactionId = transactionId;
	}
	
	
	
	
}
