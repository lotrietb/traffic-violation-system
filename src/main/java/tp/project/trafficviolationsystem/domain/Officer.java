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
public class Officer extends Person  {
    private String rank;
    private int points;
    @OneToMany(orphanRemoval=true, cascade= CascadeType.ALL)
    @JoinColumn(name="officer_id")
    private List<Fine> fines;
    
    private Officer(Builder builder) {
        id = builder.id;
        name = builder.name;
        surname = builder.surname;
        age = builder.age;
        idNum = builder.idNum;
        addr = builder.addr;
        contact = builder.contact;
        rank = builder.rank;
        points = builder.points;
        fines = builder.fines;
    }
    
    public Officer() {
        
    }
    
    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private int age;
        private String idNum;
        private Address addr;
        private Contact contact;
        private String rank;
        private int points;
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
        
        public Builder rank(String value) {
            rank = value;
            return this;
        }
        
        public Builder points(int value) {
            points = value;
            return this;
        }
        
        public Builder fines(List<Fine> values) {
            fines = values;
            return this;
        }
        
        public Builder officer(Officer o) {
            id = o.getId();
            name = o.getName();
            surname = o.getSurname();
            age = o.getAge();
            idNum = o.getIdNum();
            addr = o.getAddr();
            contact = o.getContact();
            rank = o.getRank();
            points = o.getPoints();
            fines = o.getFines();
            return this;
        }
        
        public Officer build() {
            return new Officer(this);
        }
    }

    public String getRank() {
        return rank;
    }

    public int getPoints() {
        return points;
    }

    public List<Fine> getFines() {
        return fines;
    }
}
