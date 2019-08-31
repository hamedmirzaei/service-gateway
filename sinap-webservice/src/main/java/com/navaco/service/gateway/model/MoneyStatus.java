
package com.navaco.service.gateway.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MoneyStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MoneyStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NotDetermind"/&gt;
 *     &lt;enumeration value="Usable"/&gt;
 *     &lt;enumeration value="Overused"/&gt;
 *     &lt;enumeration value="Useless"/&gt;
 *     &lt;enumeration value="Incomplete"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
/*@XmlType(name = "MoneyStatus")
@XmlEnum*/
public enum MoneyStatus {

    //@XmlEnumValue("NotDetermind")
    NOT_DETERMIND("NotDetermind"),
    //@XmlEnumValue("Usable")
    USABLE("Usable"),
    //@XmlEnumValue("Overused")
    OVERUSED("Overused"),
    //@XmlEnumValue("Useless")
    USELESS("Useless"),
    //@XmlEnumValue("Incomplete")
    INCOMPLETE("Incomplete");
    private final String value;

    MoneyStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MoneyStatus fromValue(String v) {
        for (MoneyStatus c: MoneyStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
