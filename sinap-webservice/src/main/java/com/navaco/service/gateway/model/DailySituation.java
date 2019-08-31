
package com.navaco.service.gateway.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for DailySituation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DailySituation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ATMBackupList" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}ArrayOfATMBackup" minOccurs="0"/&gt;
 *         &lt;element name="BankNoteTahtast" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="BranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CashPayment" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="CashReception" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="CoinTahdast" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="DailySituationDetailsList" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}ArrayOfDailySituationDetails" minOccurs="0"/&gt;
 *         &lt;element name="EndSituation" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="FirstSituation" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="FunctionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MoneyDispatcher_PayList" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}ArrayOfMoneyDispatcher_Pay" minOccurs="0"/&gt;
 *         &lt;element name="MoneyDispatcher_ReceivesList" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}ArrayOfMoneyDispatcher_Receive" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DailySituation", propOrder = {
    "atmBackupList",
    "bankNoteTahtast",
    "branchCode",
    "cashPayment",
    "cashReception",
    "coinTahdast",
    "dailySituationDetailsList",
    "endSituation",
    "firstSituation",
    "functionDate",
    "moneyDispatcherPayList",
    "moneyDispatcherReceivesList"
})*/
public class DailySituation {

    //@XmlElementRef(name = "ATMBackupList", required = false)
    protected JAXBElement<ArrayOfATMBackup> atmBackupList;
    //@XmlElement(name = "BankNoteTahtast")
    protected Long bankNoteTahtast;
    //@XmlElementRef(name = "BranchCode", required = false)
    protected JAXBElement<String> branchCode;
    //@XmlElement(name = "CashPayment")
    protected Long cashPayment;
    //@XmlElement(name = "CashReception")
    protected Long cashReception;
    //@XmlElement(name = "CoinTahdast")
    protected Long coinTahdast;
    //@XmlElementRef(name = "DailySituationDetailsList", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDailySituationDetails> dailySituationDetailsList;
    //@XmlElement(name = "EndSituation")
    protected Long endSituation;
    //@XmlElement(name = "FirstSituation")
    protected Long firstSituation;
    //@XmlElementRef(name = "FunctionDate", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<String> functionDate;
    //@XmlElementRef(name = "MoneyDispatcher_PayList", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMoneyDispatcherPay> moneyDispatcherPayList;
    //@XmlElementRef(name = "MoneyDispatcher_ReceivesList", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMoneyDispatcherReceive> moneyDispatcherReceivesList;

    /**
     * Gets the value of the atmBackupList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfATMBackup }{@code >}
     *     
     */
    public JAXBElement<ArrayOfATMBackup> getATMBackupList() {
        return atmBackupList;
    }

    /**
     * Sets the value of the atmBackupList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfATMBackup }{@code >}
     *     
     */
    public void setATMBackupList(JAXBElement<ArrayOfATMBackup> value) {
        this.atmBackupList = value;
    }

    /**
     * Gets the value of the bankNoteTahtast property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBankNoteTahtast() {
        return bankNoteTahtast;
    }

    /**
     * Sets the value of the bankNoteTahtast property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBankNoteTahtast(Long value) {
        this.bankNoteTahtast = value;
    }

    /**
     * Gets the value of the branchCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the value of the branchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranchCode(JAXBElement<String> value) {
        this.branchCode = value;
    }

    /**
     * Gets the value of the cashPayment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCashPayment() {
        return cashPayment;
    }

    /**
     * Sets the value of the cashPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCashPayment(Long value) {
        this.cashPayment = value;
    }

    /**
     * Gets the value of the cashReception property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCashReception() {
        return cashReception;
    }

    /**
     * Sets the value of the cashReception property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCashReception(Long value) {
        this.cashReception = value;
    }

    /**
     * Gets the value of the coinTahdast property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCoinTahdast() {
        return coinTahdast;
    }

    /**
     * Sets the value of the coinTahdast property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCoinTahdast(Long value) {
        this.coinTahdast = value;
    }

    /**
     * Gets the value of the dailySituationDetailsList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDailySituationDetails }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDailySituationDetails> getDailySituationDetailsList() {
        return dailySituationDetailsList;
    }

    /**
     * Sets the value of the dailySituationDetailsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDailySituationDetails }{@code >}
     *     
     */
    public void setDailySituationDetailsList(JAXBElement<ArrayOfDailySituationDetails> value) {
        this.dailySituationDetailsList = value;
    }

    /**
     * Gets the value of the endSituation property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEndSituation() {
        return endSituation;
    }

    /**
     * Sets the value of the endSituation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEndSituation(Long value) {
        this.endSituation = value;
    }

    /**
     * Gets the value of the firstSituation property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFirstSituation() {
        return firstSituation;
    }

    /**
     * Sets the value of the firstSituation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFirstSituation(Long value) {
        this.firstSituation = value;
    }

    /**
     * Gets the value of the functionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFunctionDate() {
        return functionDate;
    }

    /**
     * Sets the value of the functionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFunctionDate(JAXBElement<String> value) {
        this.functionDate = value;
    }

    /**
     * Gets the value of the moneyDispatcherPayList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMoneyDispatcherPay }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMoneyDispatcherPay> getMoneyDispatcherPayList() {
        return moneyDispatcherPayList;
    }

    /**
     * Sets the value of the moneyDispatcherPayList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMoneyDispatcherPay }{@code >}
     *     
     */
    public void setMoneyDispatcherPayList(JAXBElement<ArrayOfMoneyDispatcherPay> value) {
        this.moneyDispatcherPayList = value;
    }

    /**
     * Gets the value of the moneyDispatcherReceivesList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMoneyDispatcherReceive }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMoneyDispatcherReceive> getMoneyDispatcherReceivesList() {
        return moneyDispatcherReceivesList;
    }

    /**
     * Sets the value of the moneyDispatcherReceivesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMoneyDispatcherReceive }{@code >}
     *     
     */
    public void setMoneyDispatcherReceivesList(JAXBElement<ArrayOfMoneyDispatcherReceive> value) {
        this.moneyDispatcherReceivesList = value;
    }

}
