package com.cdi.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.cdi.beans.MyContext;
import com.cdi.model.webservice.Activity;
import com.cdi.model.webservice.impl.ServiceService;
import com.cdi.service.ServiceManager;

@ManagedBean(name = "newActivity", eager = true)
@SessionScoped
public class NewActivityController {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;

	Date date;
	String title;
	String place;
	String type;
	int participants;
	String description;

	public NewActivityController() {

	}

	public void submit() {
		Activity activity = new Activity();
		activity.setName(title); // String
		activity.setPlace(place); // String
		activity.setParticipants(participants);
		activity.setType(type);
		activity.setDescription(description);

		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);

			XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			activity.setDateGreg(xmlGregCal);

		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id = ServiceManager.getManager().createActivity(activity).getId();

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("activity.xhtml?id=" + id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		clear();

	}

	private void clear() {
		setDate(null);
		setDescription(null);
		setParticipants(2);
		setPlace(null);
		setTitle(null);
		setType(null);
	}

	/**
	 * @return the myContext
	 */
	public MyContext getMyContext() {
		return myContext;
	}

	/**
	 * @param myContext the myContext to set
	 */
	public void setMyContext(MyContext myContext) {
		this.myContext = myContext;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the participants
	 */
	public int getParticipants() {
		return participants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(int participants) {
		this.participants = participants;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
