/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class Address implements Serializable{
    private String street;
    private String suburb;
    private String postalCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void SetPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    
}
