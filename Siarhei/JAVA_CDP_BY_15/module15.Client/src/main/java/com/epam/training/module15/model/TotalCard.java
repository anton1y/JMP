
package com.epam.training.module15.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for totalCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="totalCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="redCard" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="yellowCard" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "totalCard", propOrder = {
    "redCard",
    "yellowCard"
})
public class TotalCard {

    protected int redCard;
    protected int yellowCard;

    /**
     * Gets the value of the redCard property.
     * 
     */
    public int getRedCard() {
        return redCard;
    }

    /**
     * Sets the value of the redCard property.
     * 
     */
    public void setRedCard(int value) {
        this.redCard = value;
    }

    /**
     * Gets the value of the yellowCard property.
     * 
     */
    public int getYellowCard() {
        return yellowCard;
    }

    /**
     * Sets the value of the yellowCard property.
     * 
     */
    public void setYellowCard(int value) {
        this.yellowCard = value;
    }

}
