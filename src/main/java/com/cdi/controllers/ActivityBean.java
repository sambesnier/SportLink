package com.cdi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.cdi.bouchon.models.Activity;

@ManagedBean(name = "activity", eager = true)
@SessionScoped
public class ActivityBean {

	List<Activity> items;

	  public ActivityBean() {
//		  List<String> users = new ArrayList<String>();
//		  users.add("Mehdi");
//		  users.add("Clement");
//		  users.add("Cédric");
//
//		  Activity act1 = new Activity("Activité 1", "3 rue de la plage", "15/09/2017 20:00", users, "Foot");	
//		  Activity act2 = new Activity("Activité 2", "4 rue de la plage", "16/09/2017 20:00", users, "Basket");	
//		  Activity act3 = new Activity("Activité 3", "5 rue de la plage", "17/09/2017 20:00", users, "Rugby");	
//		  items = new ArrayList<Activity>();
//		  items.add(act1);
//		  items.add(act2);
//		  items.add(act3);
	  }
	  
	  public void test() {
		  
	  }

	  public List<Activity> getItems() {
		  return items;
	  }
	
	  
}
