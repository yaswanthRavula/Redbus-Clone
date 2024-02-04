package com.redbus.app.Seats;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long seatId;
	int seatNo;
	long bookedCustomerId;
	boolean isFemaleBooked;
	long busId;
	long bookedTransactionId;
	String passengerName;
	
	public long getSeatId() {
		return seatId;
	}
	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public long getBookedCustomerId() {
		return bookedCustomerId;
	}
	public void setBookedCustomerId(long bookedCustomerId) {
		this.bookedCustomerId = bookedCustomerId;
	}
	public boolean getIsFemaleBooked() {
		return isFemaleBooked;
	}
	public void setIsFemaleBooked(boolean isFemaleBooked) {
		this.isFemaleBooked = isFemaleBooked;
	}
	public long getBusId() {
		return busId;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public long getBookedTransactionId() {
		return bookedTransactionId;
	}
	public void setBookedTransactionId(long bookedTransactionId) {
		this.bookedTransactionId = bookedTransactionId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	
	
	
	
}
