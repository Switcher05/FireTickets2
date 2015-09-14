package entity;
// Generated Sep 8, 2015 7:01:42 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TillTape generated by hbm2java
 */
public class TillTape  implements java.io.Serializable {


     private TillTapeId id;
     private Customers customers;
     private Locations locations;
     private Users users;
     private String serial;
     private String name;
     private Date time;
     private Integer saleAmount;
     private Integer prizeAmount;
     private Boolean saleClosed;
     private int invoice;
     private Integer void_;
     private Set bigWinnerses = new HashSet(0);

    public TillTape() {
    }

	
    public TillTape(TillTapeId id, Customers customers, Locations locations, Users users, int invoice) {
        this.id = id;
        this.customers = customers;
        this.locations = locations;
        this.users = users;
        this.invoice = invoice;
    }
    public TillTape(TillTapeId id, Customers customers, Locations locations, Users users, String serial, String name, Date time, Integer saleAmount, Integer prizeAmount, Boolean saleClosed, int invoice, Integer void_, Set bigWinnerses) {
       this.id = id;
       this.customers = customers;
       this.locations = locations;
       this.users = users;
       this.serial = serial;
       this.name = name;
       this.time = time;
       this.saleAmount = saleAmount;
       this.prizeAmount = prizeAmount;
       this.saleClosed = saleClosed;
       this.invoice = invoice;
       this.void_ = void_;
       this.bigWinnerses = bigWinnerses;
    }
   
    public TillTapeId getId() {
        return this.id;
    }
    
    public void setId(TillTapeId id) {
        this.id = id;
    }
    public Customers getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    public Locations getLocations() {
        return this.locations;
    }
    
    public void setLocations(Locations locations) {
        this.locations = locations;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
    public Integer getSaleAmount() {
        return this.saleAmount;
    }
    
    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }
    public Integer getPrizeAmount() {
        return this.prizeAmount;
    }
    
    public void setPrizeAmount(Integer prizeAmount) {
        this.prizeAmount = prizeAmount;
    }
    public Boolean getSaleClosed() {
        return this.saleClosed;
    }
    
    public void setSaleClosed(Boolean saleClosed) {
        this.saleClosed = saleClosed;
    }
    public int getInvoice() {
        return this.invoice;
    }
    
    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }
    public Integer getVoid_() {
        return this.void_;
    }
    
    public void setVoid_(Integer void_) {
        this.void_ = void_;
    }
    public Set getBigWinnerses() {
        return this.bigWinnerses;
    }
    
    public void setBigWinnerses(Set bigWinnerses) {
        this.bigWinnerses = bigWinnerses;
    }




}


