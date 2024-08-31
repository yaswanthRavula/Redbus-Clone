package com.redbus.app.Bus;


	
import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Primary;
import jakarta.persistence.Id;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
@Entity
@Table(name = "Busses")
public class BusShort {
	
	@Id
	long busId;
	String travelsName;
	@Column(name = "isac")
	boolean isAc;
	String startTime, reachTime;
	int fare;
	String source, destination;
	boolean isSleeper;
	Date journeyDate;
	
	
	
	
	public BusShort(long busId, String travelsName, boolean isAc, String startTime, String reachTime,
			int fare, String source, String destination, boolean isSleeper, Date journeyDate) {
		super();
		this.busId = busId;
		this.travelsName = travelsName;
		this.isAc = isAc;
		this.startTime = startTime;
		this.reachTime = reachTime;
		this.fare = fare;
		this.source = source;
		this.destination = destination;
		this.isSleeper = isSleeper;
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
	public boolean isAc() {
		return isAc;
	}
	public void setAc(boolean isAc) {
		this.isAc = isAc;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getreachTime() {
		return reachTime;
	}
	public void setreachTime(String reachTime) {
		this.reachTime = reachTime;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
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
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public boolean isSleeper() {
		return isSleeper;
	}
	public void setSleeper(boolean isSleeper) {
		this.isSleeper = isSleeper;
	}
	public String getReachTime() {
		return reachTime;
	}
	public void setReachTime(String reachTime) {
		this.reachTime = reachTime;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	
	
}
