package com.redbus.app.Bus;

import java.time.LocalTime;

public class Bus {
	long busId;
	String travelsName;
	int totalNoOfSeats;
	boolean isAC;
	boolean isSleeper;
	String source, destionation;
	LocalTime startTime, reachTime;
	boolean isBusAvailable;
	int seatsLeft;
	int fare;
	
	
	
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
	public String getDestionation() {
		return destionation;
	}
	public void setDestionation(String destionation) {
		this.destionation = destionation;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getReachTime() {
		return reachTime;
	}
	public void setReachTime(LocalTime reachTime) {
		this.reachTime = reachTime;
	}
	public boolean isBusAvailable() {
		return isBusAvailable;
	}
	public void setBusAvailable(boolean isBusAvailable) {
		this.isBusAvailable = isBusAvailable;
	}
	public int getSeatsLeft() {
		return seatsLeft;
	}
	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
	

}
