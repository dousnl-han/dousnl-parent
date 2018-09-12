/**
 * GreetingImplServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */
package org.dousnl.webservice.axisclient;


/**
 *  GreetingImplServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class GreetingImplServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public GreetingImplServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public GreetingImplServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for greeting method
     * override this method for handling normal response from greeting operation
     */
    public void receiveResultgreeting(
        org.dousnl.webservice.axisclient.GreetingImplServiceStub.GreetingResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from greeting operation
     */
    public void receiveErrorgreeting(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for findUserById method
     * override this method for handling normal response from findUserById operation
     */
    public void receiveResultfindUserById(
        org.dousnl.webservice.axisclient.GreetingImplServiceStub.FindUserByIdResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from findUserById operation
     */
    public void receiveErrorfindUserById(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getAllUser method
     * override this method for handling normal response from getAllUser operation
     */
    public void receiveResultgetAllUser(
        org.dousnl.webservice.axisclient.GreetingImplServiceStub.GetAllUserResponseE result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getAllUser operation
     */
    public void receiveErrorgetAllUser(java.lang.Exception e) {
    }
}
