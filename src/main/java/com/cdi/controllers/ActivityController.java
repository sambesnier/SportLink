package com.cdi.controllers;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cdi.model.webservice.Activity;
import com.cdi.model.webservice.Commentaire;
import com.cdi.model.webservice.User;
import com.cdi.service.ServiceManager;

@ManagedBean(name = "activity", eager = true)
@ViewScoped
public class ActivityController {

	String id;
	
	Activity act;
	
	String comtext;

	public ActivityController() {
		
	}
	
	public void submitComment() {
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	
    	User currentUser = (User)session.getAttribute("user");
    	System.out.println(comtext);
		Commentaire com = new Commentaire();
		com.setName(currentUser.getMail());
		com.setText(comtext);
		com.setDate(new Date());
		
		ServiceManager.getManager().getActivityById(Integer.parseInt(id)).getCommentaires().add(com);
		
		setComtext(null);
		
	    try {
	    	FacesContext.getCurrentInstance().getExternalContext().redirect("activity.xhtml?id=" + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the act
	 */
	public Activity getAct() {
//		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
//				.getRequest();
//
//		id = request.getParameter("id");
		
		return ServiceManager.getManager().getActivityById(Integer.parseInt(id));
	}

	/**
	 * @param act the act to set
	 */
	public void setAct(Activity act) {
		this.act = act;
	}

	/**
	 * @return the comtext
	 */
	public String getComtext() {
		return comtext;
	}

	/**
	 * @param comtext the comtext to set
	 */
	public void setComtext(String comtext) {
		this.comtext = comtext;
	}

	
	
	

}