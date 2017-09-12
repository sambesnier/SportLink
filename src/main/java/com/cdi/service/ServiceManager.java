package com.cdi.service;

import java.util.ArrayList;
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
	
	public Object register(String mail, String password, String sexe, XMLGregorianCalendar birthDate, String ville, int codePostal) {
		if (prod) {
			User user = new User();
			user.setPassword(password);
			user.setMail(mail);
			user.setGender(sexe);
			user.setCity(ville);
			user.setBirthday(birthDate);
			user.setCp(codePostal);
			ServiceService service = new ServiceService();
			return service.getServicePort().register(user);
		} else {
			com.cdi.bouchon.models.User user = new com.cdi.bouchon.models.User();
			user.setPassword(password);
			user.setMail(mail);
			user.setSexe(sexe);
			user.setVille(ville);
			user.setDateNaissance(birthDate);
			user.setCodePostal(codePostal);
			return MockContext.getContext().register(user);
		}
	}
	
	public Object createActivity(String title, String type, String place, XMLGregorianCalendar date, int maxPersons) {
		if (prod) {
			Activity activity = new Activity();
			
			ServiceService service = new ServiceService();
			//return service.getServicePort().createActivity(activity);
			return null;
		} else {
			com.cdi.bouchon.models.Activity activity = new com.cdi.bouchon.models.Activity();
			activity.setTitle(title);
			activity.setType(type);
			activity.setPlace(place);
			activity.setDate(date);
			activity.setMaxPersons(maxPersons);
			return MockContext.getContext().createActivity(activity);
		}
	}

	public List<com.cdi.bouchon.models.Activity> getActivities() {
		if (prod) {
			ServiceService service = new ServiceService();
			return null;
		} else {
			return MockContext.getContext().getActivities();
		}
	}
}
