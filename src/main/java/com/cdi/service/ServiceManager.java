package com.cdi.service;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.cdi.bouchon.models.MockContext;
import com.cdi.model.webservice.Activity;
import com.cdi.model.webservice.User;
import com.cdi.model.webservice.impl.ServiceService;

public class ServiceManager {

	private static ServiceManager INSTANCE;
	
	private boolean prod;
	
	private ServiceManager() {
		prod = false;
	}
	
	public static ServiceManager getManager() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceManager();
		}
		return INSTANCE;
	}

	public Object authenticate(String mail, String password) {
		
		if (prod) {
			ServiceService service = new ServiceService();
			return service.getServicePort().authenticate(mail, password);
		} else {
			return MockContext.getContext().authenticate(mail, password);
		}
		
	}
	
	public User register(String mail, String password, String sexe, XMLGregorianCalendar birthDate, String ville, int codePostal) {
		User user = new User();
		user.setPassword(password);
		user.setMail(mail);
		user.setGender(sexe);
		user.setCity(ville);
		user.setBirthday(birthDate);
		user.setCp(codePostal);
		
		if (prod) {
			ServiceService service = new ServiceService();
			return service.getServicePort().register(user);
		} else {
			return MockContext.getContext().register(user);
		}
	}
	
	public Activity createActivity(Activity activity) {
		
		if (prod) {			
			ServiceService service = new ServiceService();
			//return service.getServicePort().createActivity(activity);
			return null;
		} else {
			activity.setId(MockContext.getContext().getActivities().size() + 1);
			return MockContext.getContext().createActivity(activity);
		}
	}

	public List<Activity> getActivities() {
		if (prod) {
			ServiceService service = new ServiceService();
			return service.getServicePort().findAllActivity().getItem();
		} else {
			return MockContext.getContext().getActivities();
		}
	}
	
	public Activity getActivityById(int id) {
		if (prod) {
			ServiceService service = new ServiceService();
			return service.getServicePort().readActivity(id);
		} else {
			return MockContext.getContext().readActivity(id);
		}
	}
}
