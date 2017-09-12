package com.cdi.bouchon.models;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

public class Activity {
	String title;
	String place;
	XMLGregorianCalendar date;
	List<String> users;
	String type;
	int maxPersons;
	
	public Activity(String title, String place, XMLGregorianCalendar date, List<String> users, String type) {
		super();
		this.title = title;
		this.place = place;
		this.date = date;
		this.users = users;
		this.type = type;
	}
	
	public Activity() {
		
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the date
	 */
	public XMLGregorianCalendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(XMLGregorianCalendar date) {
		this.date = date;
	}

	/**
	 * @return the users
	 */
	public List<String> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<String> users) {
		this.users = users;
	}
	
	/**
	 * 
	 * @param user
	 */
	public void addUser(String user) {
		this.users.add(user);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the maxPersons
	 */
	public int getMaxPersons() {
		return maxPersons;
	}

	/**
	 * @param maxPersons the maxPersons to set
	 */
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	
	
}
