package com.cdi.controllers;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cdi.beans.MyContext;

@ManagedBean
@ViewScoped
public class LogoutController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	public LogoutController() {
		// TODO Auto-generated constructor stub
	}
	
	public void logout() {
		
		
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	session.removeAttribute("user");    	
    	
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch (IOException e) {
			
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

}
