/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.project.trafficviolationsystem.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Driver extends Person {
    @OneToMany(orphanRemoval=true, cascade= CascadeType.ALL)
    @JoinColumn(name="driver_id")
    private List<License> licenses;
    @OneToMany(orphanRemoval=true, cascade= CascadeType.ALL)
    @JoinColumn(name="driver_id")
    private List<Fine> fines;
    
    private Driver(Builder builder) {
        id = builder.id;
        name = builder.name;
        surname = builder.surname;
        age = builder.age;
        idNum = builder.idNum;
        addr = builder.addr;
        contact = builder.contact;
        licenses = builder.licenses;
        fines = builder.fines;
    }
    
    public Driver() {
        
    }
    
    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private int age;
        private String idNum;
        private Address addr;
        private Contact contact;
        private List<License> licenses;
        private List<Fine> fines;

        public Builder id(Long value) {
            id = value;
            return this;
        }
        
        public Builder name(String value) {
            name = value;
            return this;
        }
        
        public Builder surname(String value) {
            surname = value;
            return this;
        }
        
        public Builder age(int value) {
            age = value;
            return this;
        }
        
        public Builder idNum(String value) {
            idNum = value;
            return this;
        }
        
        public Builder addr(Address value) {
            addr = value;
            return this;
        }
        
        public Builder contact(Contact value) {
            contact = value;
            return this;
        }
        
        public Builder licenses(List<License> values) {
            licenses = values;
            return this;
        }
        
        public Builder fines(List<Fine> values) {
            fines = values;
            return this;
        }
        
        public Builder driver(Driver d) {
            id = d.getId();
            name = d.getName();
            surname = d.getSurname();
            age = d.getAge();
            idNum = d.getIdNum();
            addr = d.getAddr();
            contact = d.getContact();
            licenses = d.getLicenses();
            fines = d.getFines();
            return this;
        }
        
        public Driver build() {
            return new Driver(this);
        }
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public List<Fine> getFines() {
        return fines;
    }    
}
