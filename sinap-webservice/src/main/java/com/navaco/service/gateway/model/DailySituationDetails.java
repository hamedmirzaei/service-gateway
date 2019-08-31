
package com.navaco.service.gateway.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for DailySituationDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DailySituationDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="MoneyStatus" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}MoneyStatus" minOccurs="0"/&gt;
 *         &lt;element name="MoneyUnit" type="{http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model}MoneyUnits" minOccurs="0"/&gt;
 *         &lt;element name="Packet" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Piece" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DailySituationDetails", propOrder = {
    "amount",
    "moneyStatus",
    "moneyUnit",
    "packet",
    "piece"
})*/
public class DailySituationDetails {

    //@XmlElementRef(name = "Amount", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> amount;
    //@XmlElement(name = "MoneyStatus")
    //@XmlSchemaType(name = "string")
    protected MoneyStatus moneyStatus;
    //@XmlElement(name = "MoneyUnit")
    //@XmlSchemaType(name = "string")
    protected MoneyUnits moneyUnit;
    //@XmlElementRef(name = "Packet", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> packet;
    //@XmlElementRef(name = "Piece", namespace = "http://schemas.datacontract.org/2004/07/DailySituationServiceLibrary.Model", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> piece;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setAmount(JAXBElement<Long> value) {
        this.amount = value;
    }

    /**
     * Gets the value of the moneyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyStatus }
     *     
     */
    public MoneyStatus getMoneyStatus() {
        return moneyStatus;
    }

    /**
     * Sets the value of the moneyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyStatus }
     *     
     */
    public void setMoneyStatus(MoneyStatus value) {
        this.moneyStatus = value;
    }

    /**
     * Gets the value of the moneyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyUnits }
     *     
     */
    public MoneyUnits getMoneyUnit() {
        return moneyUnit;
    }

    /**
     * Sets the value of the moneyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyUnits }
     *     
     */
    public void setMoneyUnit(MoneyUnits value) {
        this.moneyUnit = value;
    }

    /**
     * Gets the value of the packet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getPacket() {
        return packet;
    }

    /**
     * Sets the value of the packet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setPacket(JAXBElement<Integer> value) {
        this.packet = value;
    }

    /**
     * Gets the value of the piece property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getPiece() {
        return piece;
    }

    /**
     * Sets the value of the piece property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setPiece(JAXBElement<Integer> value) {
        this.piece = value;
    }

}
