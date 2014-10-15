/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Fine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fineDate;
    private double amount;
    @OneToOne
    private Driver driver;
    @OneToOne
    private Officer officer;
    @Embedded
    private Address address;
    @OneToOne
    private FineType fineType;
    @OneToMany(orphanRemoval=true, cascade= CascadeType.ALL)
    @JoinColumn(name="fine_id")
    private List<Trial> trials;
    
    private Fine(Builder builder) {
        id = builder.id;
        fineDate = builder.fineDate;
        amount = builder.amount;
        driver = builder.driver;
        officer = builder.officer;
        address = builder.address;
        fineType = builder.fineType;
        trials = builder.trials;
    }
    
    public Fine() {
        
    }
    
    public static class Builder {
        private Long id;
        private Date fineDate;
        private double amount;
        private Driver driver;
        private Officer officer;
        private Address address;
        private FineType fineType;
        private List<Trial> trials;
        
        public Builder id(Long value) {
            id = value;
            return this;
        }
        
        public Builder fineDate(Date value) {
            fineDate = value;
            return this;
        }
        
        public Builder amount(double value) {
            amount = value;
            return this;
        }
        
        public Builder driver(Driver value) {
            driver = value;
            return this;
        }
        
        public Builder officer(Officer value) {
            officer = value;
            return this;
        }
        
        public Builder address(Address value) {
            address = value;
            return this;
        }
        
        public Builder fineType(FineType value) {
            fineType = value;
            return this;
        }
        
        public Builder trials(List<Trial> values) {
            trials = values;
            return this;
        }
        
        public Builder fine(Fine f) {
            id = f.getId();
            fineDate = f.getFineDate();
            amount = f.getAmount();
            driver = f.getDriver();
            officer = f.getOfficer();
            address = f.getAddress();
            fineType = f.getFineType();
            trials = f.getTrials();
            return this;
        }
        
        public Fine build() {
            return new Fine(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public double getAmount() {
        return amount;
    }

    public Driver getDriver() {
        return driver;
    }

    public Officer getOfficer() {
        return officer;
    }

    public Address getAddress() {
        return address;
    }

    public FineType getFineType() {
        return fineType;
    }

    public List<Trial> getTrials() {
        return trials;
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
        return "tp.lotrietb.trafficviolationsystem.domain.Fine[ id=" + id + " ]";
    }
    
}
