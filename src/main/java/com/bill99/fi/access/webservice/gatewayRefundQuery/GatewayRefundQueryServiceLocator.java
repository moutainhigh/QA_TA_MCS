/**
 * GatewayRefundQueryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bill99.fi.access.webservice.gatewayRefundQuery;

public class GatewayRefundQueryServiceLocator extends org.apache.axis.client.Service implements com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQueryService {

    public GatewayRefundQueryServiceLocator() {
    }


    public GatewayRefundQueryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GatewayRefundQueryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for gatewayRefundQuery
    private java.lang.String gatewayRefundQuery_address = "http://www.99bill.com/gatewayapi/services/gatewayRefundQuery";

    public java.lang.String getgatewayRefundQueryAddress() {
        return gatewayRefundQuery_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String gatewayRefundQueryWSDDServiceName = "gatewayRefundQuery";

    public java.lang.String getgatewayRefundQueryWSDDServiceName() {
        return gatewayRefundQueryWSDDServiceName;
    }

    public void setgatewayRefundQueryWSDDServiceName(java.lang.String name) {
        gatewayRefundQueryWSDDServiceName = name;
    }

    public com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQuery getgatewayRefundQuery() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(gatewayRefundQuery_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getgatewayRefundQuery(endpoint);
    }

    public com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQuery getgatewayRefundQuery(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQuerySoapBindingStub _stub = new com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQuerySoapBindingStub(portAddress, this);
            _stub.setPortName(getgatewayRefundQueryWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setgatewayRefundQueryEndpointAddress(java.lang.String address) {
        gatewayRefundQuery_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQuery.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQuerySoapBindingStub _stub = new com.bill99.fi.access.webservice.gatewayRefundQuery.GatewayRefundQuerySoapBindingStub(new java.net.URL(gatewayRefundQuery_address), this);
                _stub.setPortName(getgatewayRefundQueryWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("gatewayRefundQuery".equals(inputPortName)) {
            return getgatewayRefundQuery();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.99bill.com/gatewayapi/services/gatewayRefundQuery", "GatewayRefundQueryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.99bill.com/gatewayapi/services/gatewayRefundQuery", "gatewayRefundQuery"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("gatewayRefundQuery".equals(portName)) {
            setgatewayRefundQueryEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
