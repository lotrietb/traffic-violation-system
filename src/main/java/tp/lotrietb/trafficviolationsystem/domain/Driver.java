/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotrietb.trafficviolationsystem.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Brandon1
 */
@Entity
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String licence_type;
    private String driver_name;
    private String address;
    private String exp_date;
    private Date driver_dob;

    public Driver() {
    }

    public Driver(Long id, String licence_type, String driver_name, String address, String exp_date, Date driver_dob) {
        this.id = id;
        this.licence_type = licence_type;
        this.driver_name = driver_name;
        this.address = address;
        this.exp_date = exp_date;
        this.driver_dob = driver_dob;
    }

    public String getLicence_type() {
        return licence_type;
    }

    public void setLicence_type(String licence_type) {
        this.licence_type = licence_type;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public Date getDriver_dob() {
        return driver_dob;
    }

    public void setDriver_dob(Date driver_dob) {
        this.driver_dob = driver_dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp.lotriet.domain.Driver[ id=" + id + " ]";
    }
    
}
