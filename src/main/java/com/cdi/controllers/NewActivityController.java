package com.cdi.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.cdi.beans.MyContext;
import com.cdi.model.webservice.Activity;
import com.cdi.model.webservice.User;
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
	int min;
	String description;

	public NewActivityController() {

	}

	public void submit() {
		Activity activity = new Activity();
		activity.setName(title); // String
		activity.setPlace(place); // String
		activity.setMin(min);
		activity.setType(type);
		activity.setCommentaire(description);
		
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	
    	User user = (User)session.getAttribute("user");
    	
    	activity.setUserId(user.getIdUser());

		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);

			XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			activity.setDate(xmlGregCal);

		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int id = ServiceManager.getManager().createActivity(activity).getIdActivity();

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
		setMin(2);
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
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
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
