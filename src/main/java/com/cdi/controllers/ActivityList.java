package com.cdi.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cdi.model.webservice.Activity;
import com.cdi.service.ServiceManager;

@ManagedBean(name = "activities", eager = true)
@SessionScoped
public class ActivityList {

	List<Activity> items;

	public ActivityList() {
		items = ServiceManager.getManager().getActivities();
	}

	public void test() {

	}

	public List<Activity> getItems() {
		return items;
	}

}
