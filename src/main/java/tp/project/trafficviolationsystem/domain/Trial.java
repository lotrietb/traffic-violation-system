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
public class Trial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date courtDate;
    private String verdict;
    @OneToOne
    private Fine fine;
    
    private Trial(Builder builder) {
        id = builder.id;
        courtDate = builder.courtDate;
        verdict = builder.verdict;
        fine = builder.fine;
    }
    
    public Trial() {
        
    }
    
    public static class Builder {
        private Long id;
        private Date courtDate;
        private String verdict;
        private Fine fine;
        
        public Builder id(Long value) {
            id = value;
            return this;
        }
        
        public Builder courtDate(Date value) {
            courtDate = value;
            return this;
        }
        
        public Builder verdict(String value) {
            verdict = value;
            return this;
        }
        
        public Builder fine(Fine value) {
            fine = value;
            return this;
        }
        
        public Builder trial(Trial t) {
            id = t.getId();
            courtDate = t.getCourtDate();
            verdict = t.getVerdict();
            fine = t.getFine();
            return this;
        } 
        
        public Trial build() {
            return new Trial(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Date getCourtDate() {
        return courtDate;
    }

    public String getVerdict() {
        return verdict;
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
        if (!(object instanceof Trial)) {
            return false;
        }
        Trial other = (Trial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp.lotrietb.trafficviolationsystem.domain.Trial[ id=" + id + " ]";
    }   
}
