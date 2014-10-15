/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class License implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int code;
    private Date expiryDate;
    @OneToOne
    private Driver driver;
            
    private License(Builder builder) {
        id = builder.id;
        code = builder.code;
        expiryDate = builder.expiryDate;
        driver = builder.driver;
    }
    
    public License() {
    }
    
    public static class Builder {
        private Long id;
        private int code;
        private Date expiryDate;
        private Driver driver;
        
        public Builder id(Long value) {
            id = value;
            return this;
        }
        
        public Builder code(int value) {
            code = value;
            return this;
        }
        
        public Builder expiryDate(Date value) {
            expiryDate = value;
            return this;
        }
        
        public Builder driver(Driver value) {
            driver = value;
            return this;
        }
        
        public Builder license(License l) {
            id = l.getId();
            code = l.getCode();
            expiryDate = l.getExpiryDate();
            driver = l.getDriver();
            return this;
        }
        
        public License build() {
            return new License(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Driver getDriver() {
        return driver;
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
        if (!(object instanceof License)) {
            return false;
        }
        License other = (License) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp.lotrietb.trafficviolationsystem.domain.License[ id=" + id + " ]";
    }   
}
