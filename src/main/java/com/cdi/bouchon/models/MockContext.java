package com.cdi.bouchon.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.cdi.model.webservice.Activity;
import com.cdi.model.webservice.User;

public class MockContext {

	private static MockContext INSTANCE;
	
	private List<User> users;
	
	private List<Activity> activities;
	
	private MockContext() {
		users = new ArrayList<User>();
		activities = new ArrayList<Activity>();
		User user = new User();
		user.setPassword("1234");
		user.setMail("sam@gmail.com");
		user.setGender("Homme");
		user.setCity("Lille");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		XMLGregorianCalendar xmlGregCal;
		try {
			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			user.setBirthday(xmlGregCal);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setCp(59000);
		register(user);
	}
	
	public static MockContext getContext() {
		if (INSTANCE == null) {
			INSTANCE = new MockContext();
		}
		return INSTANCE;
	}
	
	public User authenticate(String mail, String pass) {
		User user = null;
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getMail().equals(mail) && users.get(i).getPassword().equals(pass)) {
				user = users.get(i);
			}
		}
		
		return user;
	}
	
	public User register(User user) {
		users.add(user);
		return user;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the activities
	 */
	public List<Activity> getActivities() {
		return activities;
	}

	/**
	 * @param activities the activities to set
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity createActivity(Activity activity) {
		activities.add(activity);
		return activity;
	}

	public Activity readActivity(int id) {
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i).getId() == id) {
				return activities.get(i);
			}
		}
		return null;
	}
	
	
	
}
