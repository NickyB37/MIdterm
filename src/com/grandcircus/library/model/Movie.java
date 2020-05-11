package com.grandcircus.library.model;

import java.time.LocalDate;

public class Movie extends Media {
	protected String director;
	
	public Movie(String title, String director, String runTime, String status, LocalDate localDate) {
		super(title, runTime, status, localDate);
		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	
	@Override
	public String toString() {
		return String.format("Title: " + title + " Director: " + director + " Runtime: " + runTime + " Status: " + status + " Date: " + localDate.toString());
	}
}
