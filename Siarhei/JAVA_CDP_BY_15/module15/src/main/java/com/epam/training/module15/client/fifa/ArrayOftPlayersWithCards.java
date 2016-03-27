
package com.epam.training.module15.client.fifa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOftPlayersWithCards complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOftPlayersWithCards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tPlayersWithCards" type="{http://footballpool.dataaccess.eu}tPlayersWithCards" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOftPlayersWithCards", propOrder = {
    "tPlayersWithCards"
})
public class ArrayOftPlayersWithCards {

    @XmlElement(nillable = true)
    protected List<TPlayersWithCards> tPlayersWithCards;

    /**
     * Gets the value of the tPlayersWithCards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tPlayersWithCards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTPlayersWithCards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPlayersWithCards }
     * 
     * 
     */
    public List<TPlayersWithCards> getTPlayersWithCards() {
        if (tPlayersWithCards == null) {
            tPlayersWithCards = new ArrayList<TPlayersWithCards>();
        }
        return this.tPlayersWithCards;
    }

}
