/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class FineType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String descr;
    @OneToOne
    private Fine fine;
    
    private FineType(Builder builder) {
        id = builder.id;
        name = builder.name;
        descr = builder.descr;
        fine = builder.fine;
    }
    
    public FineType() {
        
    }
    
    public static class Builder {
        private Long id;
        private String name;
        private String descr;
        private Fine fine;
        
        public Builder id(Long value) {
            id = value;
            return this;
        }
        
        public Builder name(String value) {
            name = value;
            return this;
        }
        
        public Builder descr(String value) {
            descr = value;
            return this;
        }
        
        public Builder fine(Fine value) {
            fine = value;
            return this;
        }
        
        public Builder fineType(FineType ft) {
            id = ft.getId();
            name = ft.getName();
            descr = ft.getDescr();
            fine = ft.getFine();
            return this;
        }
        
        public FineType build() {
            return new FineType(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public Fine getFine() {
        return fine;
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
        if (!(object instanceof FineType)) {
            return false;
        }
        FineType other = (FineType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp.lotrietb.trafficviolationsystem.domain.FineType[ id=" + id + " ]";
    }   
}
