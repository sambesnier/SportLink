package com.cdi.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.cdi.beans.MyContext;
import com.cdi.model.webservice.User;
import com.cdi.model.webservice.impl.ServiceService;
import com.cdi.service.ServiceManager;


@ManagedBean(name = "inscription", eager = true)
@SessionScoped
public class InscriptionController {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String mail;
	String password;
	String password2;
	Date date;
	String sexe;
	String ville;
	int codePostal;

	public InscriptionController() {

	}

	public void submit() {
		
		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);

			XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);	
			
			Object sessionUser = ServiceManager.getManager().register(mail, password, sexe, xmlGregCal, ville, codePostal);
			
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
			
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2 the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
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
