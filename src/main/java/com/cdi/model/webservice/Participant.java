
package com.cdi.model.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour participant complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="participant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idActivity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idParticipant" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idUser" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "participant", propOrder = {
    "idActivity",
    "idParticipant",
    "idUser"
})
public class Participant {

    protected int idActivity;
    protected Integer idParticipant;
    protected int idUser;

    /**
     * Obtient la valeur de la propriété idActivity.
     * 
     */
    public int getIdActivity() {
        return idActivity;
    }

    /**
     * Définit la valeur de la propriété idActivity.
     * 
     */
    public void setIdActivity(int value) {
        this.idActivity = value;
    }

    /**
     * Obtient la valeur de la propriété idParticipant.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdParticipant() {
        return idParticipant;
    }

    /**
     * Définit la valeur de la propriété idParticipant.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdParticipant(Integer value) {
        this.idParticipant = value;
    }

    /**
     * Obtient la valeur de la propriété idUser.
     * 
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Définit la valeur de la propriété idUser.
     * 
     */
    public void setIdUser(int value) {
        this.idUser = value;
    }

}
