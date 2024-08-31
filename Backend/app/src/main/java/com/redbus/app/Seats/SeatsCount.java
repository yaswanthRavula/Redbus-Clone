package com.redbus.app.Seats;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats_count")
public class SeatsCount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long busId;
	Date journeyDate;
	int count;
	public long getBusId() {
		return busId;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJoruneyDate(Date dateOfJourney) {
		this.journeyDate = dateOfJourney;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

	
}
