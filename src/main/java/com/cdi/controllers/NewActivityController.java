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

@ManagedBean(name = "newActivity", eager = true)
@SessionScoped
public class NewActivityController {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;

	Date date;
	String title;
	String place;
	String type;
	int max;

	public NewActivityController() {

	}

	public void submit() {
		Activity activity = new Activity();
		activity.setName(title); // String
		activity.setPlace(place); // String
		activity.setStatus("Inscriptions en cours"); // String
		activity.setMin(0);
		activity.setMax(max);

		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);

			XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			activity.setStart(xmlGregCal);
			activity.setEnd(xmlGregCal);

		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServiceService service = new ServiceService();
		service.getServicePort().createActivity(activity);

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("activity.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}

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
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
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
	
	

}
