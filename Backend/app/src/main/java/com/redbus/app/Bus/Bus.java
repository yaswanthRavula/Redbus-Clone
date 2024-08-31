package com.redbus.app.Bus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Busses")
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long busId;
	
	String travelsName;
	int totalNoOfSeats;
	boolean isAC;
	boolean isSleeper;
	String source, destination;
	String startTime, reachTime;
	boolean isBusAvailable;
	int fare;
	Date journeyDate;
	
	
	
	public Bus(long busId, String travelsName, int totalNoOfSeats, boolean isAC, boolean isSleeper, String source,
			String destination, String startTime, String reachTime, boolean isBusAvailable, int seatsLeft, int fare,
			Date journeyDate) {
		super();
		this.busId = busId;
		this.travelsName = travelsName;
		this.totalNoOfSeats = totalNoOfSeats;
		this.isAC = isAC;
		this.isSleeper = isSleeper;
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.reachTime = reachTime;
		this.isBusAvailable = isBusAvailable;
		this.fare = fare;
		this.journeyDate = journeyDate;
	}
	
	public long getBusId() {
		return busId;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public String getTravelsName() {
		return travelsName;
	}
	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}
	public int getTotalNoOfSeats() {
		return totalNoOfSeats;
	}
	public void setTotalNoOfSeats(int totalNoOfSeats) {
		this.totalNoOfSeats = totalNoOfSeats;
	}
	public boolean isAC() {
		return isAC;
	}
	public void setAC(boolean isAC) {
		this.isAC = isAC;
	} 
	public boolean isSleeper() {
		return isSleeper;
	}
	public void setSleeper(boolean isSleeper) {
		this.isSleeper = isSleeper;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destionation) {
		this.destination = destionation;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getReachTime() {
		return reachTime;
	}
	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}
	public boolean isBusAvailable() {
		return isBusAvailable;
	}
	public void setBusAvailable(boolean isBusAvailable) {
		this.isBusAvailable = isBusAvailable;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	

}
