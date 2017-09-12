package com.cdi.bouchon.models;

import java.util.ArrayList;
import java.util.List;

public class MockContext {

	private static MockContext INSTANCE;
	
	private List<User> users;
	
	private List<Activity> activities;
	
	private MockContext() {
		users = new ArrayList<User>();
		activities = new ArrayList<Activity>();
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

	public Object createActivity(Activity activity) {
		activities.add(activity);
		return activity;
	}
	
	
	
}
