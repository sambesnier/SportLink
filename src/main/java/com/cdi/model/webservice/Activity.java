
package com.cdi.model.webservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour activity complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="activity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idActivity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="min" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="place" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activity", propOrder = {
    "end",
    "idActivity",
    "max",
    "min",
    "name",
    "place",
    "start",
    "status"
})
public class Activity {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateGreg;
    @XmlSchemaType(name = "dateTime")
    protected Date date;
    protected String name;
    protected String place;
    protected String type;
    protected int participants;
    protected int id;
    protected String description;
    protected List<Commentaire> commentaires;
    
    
    
    
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the dateGreg
	 */
	public XMLGregorianCalendar getDateGreg() {
		return dateGreg;
	}
	/**
	 * @param dateGreg the dateGreg to set
	 */
	public void setDateGreg(XMLGregorianCalendar dateGreg) {
		this.dateGreg = dateGreg;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a z");
        GregorianCalendar gCalendar = dateGreg.toGregorianCalendar();
 
        //Converted to date object
        Date dater = gCalendar.getTime();
        
		return dater;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the participants
	 */
	public int getParticipants() {
		return participants;
	}
	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the commentaires
	 */
	public List<Commentaire> getCommentaires() {
		if (commentaires == null) {
			commentaires = new ArrayList<Commentaire>();
		}
		return commentaires;
	}
	/**
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	

     

}
