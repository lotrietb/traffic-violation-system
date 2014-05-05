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
public class Audit_fines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_changed;
    private Long user_id;
    private Long fine_no;
    private double amount_before;
    private double amount_after;

    public Date getDate_changed() {
        return date_changed;
    }

    public void setDate_changed(Date date_changed) {
        this.date_changed = date_changed;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getFine_no() {
        return fine_no;
    }

    public void setFine_no(Long fine_no) {
        this.fine_no = fine_no;
    }

    public double getAmount_before() {
        return amount_before;
    }

    public void setAmount_before(double amount_before) {
        this.amount_before = amount_before;
    }

    public double getAmount_after() {
        return amount_after;
    }

    public void setAmount_after(double amount_after) {
        this.amount_after = amount_after;
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
        if (!(object instanceof Audit_fines)) {
            return false;
        }
        Audit_fines other = (Audit_fines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp.lotriet.domain.Audit_fines[ id=" + id + " ]";
    }
    
}
