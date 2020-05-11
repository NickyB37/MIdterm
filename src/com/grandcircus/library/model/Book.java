package com.grandcircus.library.model;

import java.time.LocalDate;

/**
 * Models a library book.
 */
public class Book extends Media{

protected String author;
	
	public Book(String title, String author,String runTime, String status, LocalDate localDate) {
		super(title, runTime,status,localDate);
		this.author = author;

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	@Override
	public String toString() {
		return String.format("Title: " + title + " Author: " + author + "Run Time:" + runTime + " Status: " + status + " Date: " + localDate.toString());
	}
	
	
}
