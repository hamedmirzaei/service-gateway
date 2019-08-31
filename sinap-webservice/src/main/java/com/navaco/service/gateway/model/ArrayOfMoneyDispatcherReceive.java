
package com.navaco.service.gateway.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfMoneyDispatcher_Receive complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMoneyDispatcher_Receive"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MoneyDispatcher_Receive" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}MoneyDispatcher_Receive" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMoneyDispatcher_Receive", propOrder = {
    "moneyDispatcherReceive"
})*/
public class ArrayOfMoneyDispatcherReceive {

    //@XmlElement(name = "MoneyDispatcher_Receive", nillable = true)
    protected List<MoneyDispatcherReceive> moneyDispatcherReceive;

    /**
     * Gets the value of the moneyDispatcherReceive property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the moneyDispatcherReceive property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMoneyDispatcherReceive().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MoneyDispatcherReceive }
     * 
     * 
     */
    public List<MoneyDispatcherReceive> getMoneyDispatcherReceive() {
        if (moneyDispatcherReceive == null) {
            moneyDispatcherReceive = new ArrayList<MoneyDispatcherReceive>();
        }
        return this.moneyDispatcherReceive;
    }

}
