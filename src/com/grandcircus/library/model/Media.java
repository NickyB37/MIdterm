package com.grandcircus.library.model;

import java.time.LocalDate;

public class Media {

	protected String title;
	protected LocalDate localDate;
	protected String status;
	protected String runTime;
	
	public Media(String title, String runTime, String status, LocalDate localDate) {
		super();
		this.status = status;
		this.title = title;
		this.runTime = runTime;
		this.localDate = localDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
}
