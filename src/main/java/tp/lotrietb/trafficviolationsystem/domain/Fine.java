/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.lotriet.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Brandon1
 */
@Entity
public class Fine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long driver_id;
    private String licence_no;
    private Long officer_no;
    private Long court_no;
    private Date date_of_fine;
    
    @Embedded
    private violation violation_code;

    public violation getViolation_code() {
        return violation_code;
    }

    public void setViolation_code(violation violation_code) {
        this.violation_code = violation_code;
    }
    private double violation_amount;
    private Date date_paid;
    private Date court_date;
    private String verdict;
    private String violation_Address;
    
    

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
        if (!(object instanceof Fine)) {
            return false;
        }
        Fine other = (Fine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp.lotriet.domain.Fine[ id=" + id + " ]";
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public String getLicence_no() {
        return licence_no;
    }

    public void setLicence_no(String licence_no) {
        this.licence_no = licence_no;
    }

    public Long getOfficer_no() {
        return officer_no;
    }

    public void setOfficer_no(Long officer_no) {
        this.officer_no = officer_no;
    }

    public Long getCourt_no() {
        return court_no;
    }

    public void setCourt_no(Long court_no) {
        this.court_no = court_no;
    }

    public Date getDate_of_fine() {
        return date_of_fine;
    }

    public void setDate_of_fine(Date date_of_fine) {
        this.date_of_fine = date_of_fine;
    }

    public double getViolation_amount() {
        return violation_amount;
    }

    public void setViolation_amount(double violation_amount) {
        this.violation_amount = violation_amount;
    }

    public Date getDate_paid() {
        return date_paid;
    }

    public void setDate_paid(Date date_paid) {
        this.date_paid = date_paid;
    }

    public Date getCourt_date() {
        return court_date;
    }

    public void setCourt_date(Date court_date) {
        this.court_date = court_date;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public String getViolation_Address() {
        return violation_Address;
    }

    public void setViolation_Address(String violation_Address) {
        this.violation_Address = violation_Address;
    }
    
}
