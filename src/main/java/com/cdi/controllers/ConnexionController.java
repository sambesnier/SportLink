package com.cdi.controllers;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cdi.beans.MyContext;
import com.cdi.model.webservice.User;
import com.cdi.model.webservice.impl.ServiceService;
import com.cdi.service.ServiceManager;

@ManagedBean(name = "connexion", eager = true)
@SessionScoped
public class ConnexionController {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String mail;
	String password;
	public ConnexionController() {
	}
	
	public void submit() {		
		Object sessionUser = ServiceManager.getManager().authenticate(mail, password);
		
		if (sessionUser != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
        	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        	
        	session.setAttribute("user", sessionUser);
        	
        	try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("in/newActivity.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
