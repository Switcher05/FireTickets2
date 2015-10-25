package entity;
// Generated Oct 11, 2015 7:56:58 PM by Hibernate Tools 4.3.1


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Locations generated by hbm2java
 */
@Entity
@Table(name="locations"
    ,catalog="fire_tickets"
)
public class Locations  implements java.io.Serializable {


     private Integer locId;
     private String name;
     private String address;
     private String state;
     private String city;
     private Set<TillTape> tillTapes = new HashSet<TillTape>(0);

    public Locations() {
    }

    public Locations(String name, String address, String state, String city, Set<TillTape> tillTapes) {
       this.name = name;
       this.address = address;
       this.state = state;
       this.city = city;
       this.tillTapes = tillTapes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="loc_id", unique=true, nullable=false)
    public Integer getLocId() {
        return this.locId;
    }
    
    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    
    @Column(name="name", length=30)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="address", length=30)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="state", length=30)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="city", length=30)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="locations")
    public Set<TillTape> getTillTapes() {
        return this.tillTapes;
    }
    
    public void setTillTapes(Set<TillTape> tillTapes) {
        this.tillTapes = tillTapes;
    }




}


