package entity;
// Generated Oct 11, 2015 7:56:58 PM by Hibernate Tools 4.3.1


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Customers generated by hbm2java
 */
@Entity
@Table(name="customers"
    ,catalog="fire_tickets"
)
public class Customers  implements java.io.Serializable {


     private Integer custId;
     private Integer cardNum;
     private String fname;
     private String lname;
     private String address;
     private String city;
     private String state;
     private String phone;
     private Integer totalSales;
     private Integer totalPrizes;
     private Set<TillTape> tillTapes = new HashSet<TillTape>(0);

    public Customers() {
    }

    public Customers(Integer cardNum, String fname, String lname, String address, String city, String state, String phone, Integer totalSales, Integer totalPrizes, Set<TillTape> tillTapes) {
       this.cardNum = cardNum;
       this.fname = fname;
       this.lname = lname;
       this.address = address;
       this.city = city;
       this.state = state;
       this.phone = phone;
       this.totalSales = totalSales;
       this.totalPrizes = totalPrizes;
       this.tillTapes = tillTapes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cust_id", unique=true, nullable=false)
    public Integer getCustId() {
        return this.custId;
    }
    
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    
    @Column(name="card_num")
    public Integer getCardNum() {
        return this.cardNum;
    }
    
    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    
    @Column(name="fname", length=30)
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    
    @Column(name="lname", length=30)
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }

    
    @Column(name="address", length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="city", length=12)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="state", length=12)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="phone", length=12)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="total_sales")
    public Integer getTotalSales() {
        return this.totalSales;
    }
    
    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    
    @Column(name="total_prizes")
    public Integer getTotalPrizes() {
        return this.totalPrizes;
    }
    
    public void setTotalPrizes(Integer totalPrizes) {
        this.totalPrizes = totalPrizes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customers")
    public Set<TillTape> getTillTapes() {
        return this.tillTapes;
    }
    
    public void setTillTapes(Set<TillTape> tillTapes) {
        this.tillTapes = tillTapes;
    }




}


