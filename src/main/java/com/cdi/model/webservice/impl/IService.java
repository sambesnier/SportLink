
package com.cdi.model.webservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import com.cdi.model.webservice.Activity;
import com.cdi.model.webservice.ActivityArray;
import com.cdi.model.webservice.ObjectFactory;
import com.cdi.model.webservice.Participant;
import com.cdi.model.webservice.ParticipantArray;
import com.cdi.model.webservice.User;
import com.cdi.model.webservice.UserArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IService", targetNamespace = "http://webService.model.cdi.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.User
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/registerRequest", output = "http://webService.model.cdi.com/IService/registerResponse")
    public User register(
        @WebParam(name = "arg0", partName = "arg0")
        User arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.User
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/authenticateRequest", output = "http://webService.model.cdi.com/IService/authenticateResponse")
    public User authenticate(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.UserArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/getParticipantRequest", output = "http://webService.model.cdi.com/IService/getParticipantResponse")
    public UserArray getParticipant(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.Activity
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/getActivityRequest", output = "http://webService.model.cdi.com/IService/getActivityResponse")
    public Activity getActivity(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.Activity
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/addActivityRequest", output = "http://webService.model.cdi.com/IService/addActivityResponse")
    public Activity addActivity(
        @WebParam(name = "arg0", partName = "arg0")
        Activity arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/detailsRequest", output = "http://webService.model.cdi.com/IService/detailsResponse")
    public void details(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.ActivityArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/activitiesByLastRequest", output = "http://webService.model.cdi.com/IService/activitiesByLastResponse")
    public ActivityArray activitiesByLast(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/addParticipantRequest", output = "http://webService.model.cdi.com/IService/addParticipantResponse")
    public void addParticipant(
        @WebParam(name = "arg0", partName = "arg0")
        Participant arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.ActivityArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/activitiesByLieuRequest", output = "http://webService.model.cdi.com/IService/activitiesByLieuResponse")
    public ActivityArray activitiesByLieu(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.ActivityArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/activitiesByTypeAndLieuRequest", output = "http://webService.model.cdi.com/IService/activitiesByTypeAndLieuResponse")
    public ActivityArray activitiesByTypeAndLieu(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.ActivityArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/activitiesByDayAndLieuRequest", output = "http://webService.model.cdi.com/IService/activitiesByDayAndLieuResponse")
    public ActivityArray activitiesByDayAndLieu(
        @WebParam(name = "arg0", partName = "arg0")
        XMLGregorianCalendar arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/getParticipantSizeRequest", output = "http://webService.model.cdi.com/IService/getParticipantSizeResponse")
    public int getParticipantSize(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @return
     *     returns com.cdi.model.webservice.ActivityArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/findAllActivityRequest", output = "http://webService.model.cdi.com/IService/findAllActivityResponse")
    public ActivityArray findAllActivity();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.Activity
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/readActivityRequest", output = "http://webService.model.cdi.com/IService/readActivityResponse")
    public Activity readActivity(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/updateActivityRequest", output = "http://webService.model.cdi.com/IService/updateActivityResponse")
    public void updateActivity(
        @WebParam(name = "arg0", partName = "arg0")
        Activity arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/deleteActivityRequest", output = "http://webService.model.cdi.com/IService/deleteActivityResponse")
    public void deleteActivity(
        @WebParam(name = "arg0", partName = "arg0")
        Activity arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/createActivityRequest", output = "http://webService.model.cdi.com/IService/createActivityResponse")
    public void createActivity(
        @WebParam(name = "arg0", partName = "arg0")
        Activity arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.User
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/readUserRequest", output = "http://webService.model.cdi.com/IService/readUserResponse")
    public User readUser(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/createUserRequest", output = "http://webService.model.cdi.com/IService/createUserResponse")
    public void createUser(
        @WebParam(name = "arg0", partName = "arg0")
        User arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/updateUserRequest", output = "http://webService.model.cdi.com/IService/updateUserResponse")
    public void updateUser(
        @WebParam(name = "arg0", partName = "arg0")
        User arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/deleteUserRequest", output = "http://webService.model.cdi.com/IService/deleteUserResponse")
    public void deleteUser(
        @WebParam(name = "arg0", partName = "arg0")
        User arg0);

    /**
     * 
     * @return
     *     returns com.cdi.model.webservice.UserArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/findAllUserRequest", output = "http://webService.model.cdi.com/IService/findAllUserResponse")
    public UserArray findAllUser();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.cdi.model.webservice.Participant
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/readParticipantRequest", output = "http://webService.model.cdi.com/IService/readParticipantResponse")
    public Participant readParticipant(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/createParticipantRequest", output = "http://webService.model.cdi.com/IService/createParticipantResponse")
    public void createParticipant(
        @WebParam(name = "arg0", partName = "arg0")
        Participant arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/updateParticipantRequest", output = "http://webService.model.cdi.com/IService/updateParticipantResponse")
    public void updateParticipant(
        @WebParam(name = "arg0", partName = "arg0")
        Participant arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webService.model.cdi.com/IService/deleteParticipantRequest", output = "http://webService.model.cdi.com/IService/deleteParticipantResponse")
    public void deleteParticipant(
        @WebParam(name = "arg0", partName = "arg0")
        Participant arg0);

    /**
     * 
     * @return
     *     returns com.cdi.model.webservice.ParticipantArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webService.model.cdi.com/IService/findAllParticipantRequest", output = "http://webService.model.cdi.com/IService/findAllParticipantResponse")
    public ParticipantArray findAllParticipant();

}
