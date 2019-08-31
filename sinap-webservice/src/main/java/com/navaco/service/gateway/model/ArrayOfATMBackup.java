
package com.navaco.service.gateway.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfATMBackup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfATMBackup"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ATMBackup" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}ATMBackup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfATMBackup", propOrder = {
    "atmBackup"
})*/
public class ArrayOfATMBackup {

    //@XmlElement(name = "ATMBackup", nillable = true)
    protected List<ATMBackup> atmBackup;

    /**
     * Gets the value of the atmBackup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atmBackup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getATMBackup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ATMBackup }
     * 
     * 
     */
    public List<ATMBackup> getATMBackup() {
        if (atmBackup == null) {
            atmBackup = new ArrayList<ATMBackup>();
        }
        return this.atmBackup;
    }

}
