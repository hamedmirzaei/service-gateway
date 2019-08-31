
package com.navaco.service.gateway.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MoneyUnits.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MoneyUnits"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NotDetermined"/&gt;
 *     &lt;enumeration value="B100r"/&gt;
 *     &lt;enumeration value="B200r"/&gt;
 *     &lt;enumeration value="B500r"/&gt;
 *     &lt;enumeration value="B1Kr"/&gt;
 *     &lt;enumeration value="B2Kr"/&gt;
 *     &lt;enumeration value="B5Kr"/&gt;
 *     &lt;enumeration value="B10Kr"/&gt;
 *     &lt;enumeration value="B20Kr"/&gt;
 *     &lt;enumeration value="B50Kr"/&gt;
 *     &lt;enumeration value="B100Kr"/&gt;
 *     &lt;enumeration value="B500Kr"/&gt;
 *     &lt;enumeration value="B1Mr"/&gt;
 *     &lt;enumeration value="CoinSum"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
/*@XmlType(name = "MoneyUnits")
@XmlEnum*/
public enum MoneyUnits {

    //@XmlEnumValue("NotDetermined")
    NOT_DETERMINED("NotDetermined"),
    //@XmlEnumValue("B100r")
    B_100_R("B100r"),
    //@XmlEnumValue("B200r")
    B_200_R("B200r"),
    //@XmlEnumValue("B500r")
    B_500_R("B500r"),
    //@XmlEnumValue("B1Kr")
    B_1_KR("B1Kr"),
    //@XmlEnumValue("B2Kr")
    B_2_KR("B2Kr"),
    //@XmlEnumValue("B5Kr")
    B_5_KR("B5Kr"),
    //@XmlEnumValue("B10Kr")
    B_10_KR("B10Kr"),
    //@XmlEnumValue("B20Kr")
    B_20_KR("B20Kr"),
    //@XmlEnumValue("B50Kr")
    B_50_KR("B50Kr"),
    //@XmlEnumValue("B100Kr")
    B_100_KR("B100Kr"),
    //@XmlEnumValue("B500Kr")
    B_500_KR("B500Kr"),
    //@XmlEnumValue("B1Mr")
    B_1_MR("B1Mr"),
    //@XmlEnumValue("CoinSum")
    COIN_SUM("CoinSum");
    private final String value;

    MoneyUnits(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MoneyUnits fromValue(String v) {
        for (MoneyUnits c: MoneyUnits.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
