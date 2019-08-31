
package com.navaco.service.gateway.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SinapException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SinapException"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParamName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParamValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RaisedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SinapException", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Exception", propOrder = {
    "errorCode",
    "errorMessage",
    "id",
    "paramName",
    "paramValue",
    "raisedTime"
})*/
public class SinapException {

    //@XmlElement(name = "ErrorCode")
    protected Integer errorCode;
    //@XmlElementRef(name = "ErrorMessage", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Exception", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorMessage;
    //@XmlElementRef(name = "Id", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Exception", type = JAXBElement.class, required = false)
    protected JAXBElement<String> id;
    //@XmlElementRef(name = "ParamName", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Exception", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paramName;
    //@XmlElementRef(name = "ParamValue", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Exception", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paramValue;
    //@XmlElement(name = "RaisedTime")
    //@XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar raisedTime;

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCode(Integer value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorMessage(JAXBElement<String> value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setId(JAXBElement<String> value) {
        this.id = value;
    }

    /**
     * Gets the value of the paramName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParamName() {
        return paramName;
    }

    /**
     * Sets the value of the paramName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParamName(JAXBElement<String> value) {
        this.paramName = value;
    }

    /**
     * Gets the value of the paramValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getParamValue() {
        return paramValue;
    }

    /**
     * Sets the value of the paramValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParamValue(JAXBElement<String> value) {
        this.paramValue = value;
    }

    /**
     * Gets the value of the raisedTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRaisedTime() {
        return raisedTime;
    }

    /**
     * Sets the value of the raisedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRaisedTime(XMLGregorianCalendar value) {
        this.raisedTime = value;
    }

}
