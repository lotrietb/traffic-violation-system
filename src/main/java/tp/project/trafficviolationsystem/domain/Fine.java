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
    
    Date fine_date;
    double amount;
    
    @OneToOne
    private Driver driver;
    
    @OneToOne
    private Officer officer;
    
    @Embedded
    private Address address;
    
    @OneToOne
    private FineType fine_type;
    
    @OneToMany(orphanRemoval=true, cascade= CascadeType.ALL)
    @JoinColumn(name="fine_id")
    private List<Trial> trials;

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
        return "tp.lotrietb.trafficviolationsystem.domain.Fine[ id=" + id + " ]";
    }
    
}
