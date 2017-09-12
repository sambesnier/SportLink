package com.cdi.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="myContext")
@SessionScoped
public class MyContext {
	FacesContext facesContext;
	HttpSession session;
	
	public MyContext() {
		facesContext = FacesContext.getCurrentInstance(); 
    	session = (HttpSession) facesContext.getExternalContext().getSession(true);
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
}
