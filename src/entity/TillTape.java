package entity;
// Generated Oct 11, 2015 7:56:58 PM by Hibernate Tools 4.3.1


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TillTape generated by hbm2java
 */
@Entity
@Table(name="till_tape"
    ,catalog="fire_tickets"
    , uniqueConstraints = @UniqueConstraint(columnNames="t_id") 
)
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
    private Boolean void_;
    private Set<BigWinners> bigWinnerses = new HashSet<BigWinners>(0);

    public TillTape() {
    }

	
    public TillTape(TillTapeId id, Customers customers, Locations locations, Users users, int invoice) {
        this.id = id;
        this.customers = customers;
        this.locations = locations;
        this.users = users;
        this.invoice = invoice;
    }

    public TillTape(TillTapeId id, Customers customers, Locations locations, Users users, String serial, String name, Date time, Integer saleAmount, Integer prizeAmount, Boolean saleClosed, int invoice, Boolean void_, Set<BigWinners> bigWinnerses) {
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
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="TId", column=@Column(name="t_id", unique=true, nullable=false) ), 
        @AttributeOverride(name="usersUserId", column=@Column(name="users_user_id", nullable=false) ), 
        @AttributeOverride(name="customersCustId", column=@Column(name="customers_cust_id", nullable=false) ), 
        @AttributeOverride(name="locationsLocId", column=@Column(name="locations_loc_id", nullable=false) ) } )
    public TillTapeId getId() {
        return this.id;
    }
    
    public void setId(TillTapeId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customers_cust_id", nullable=false, insertable=false, updatable=false)
    public Customers getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="locations_loc_id", nullable=false, insertable=false, updatable=false)
    public Locations getLocations() {
        return this.locations;
    }
    
    public void setLocations(Locations locations) {
        this.locations = locations;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="users_user_id", nullable=false, insertable=false, updatable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    
    @Column(name="serial", length=12)
    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }

    
    @Column(name="name", length=20)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time", length=19)
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }

    
    @Column(name="sale_amount")
    public Integer getSaleAmount() {
        return this.saleAmount;
    }
    
    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    
    @Column(name="prize_amount")
    public Integer getPrizeAmount() {
        return this.prizeAmount;
    }
    
    public void setPrizeAmount(Integer prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    
    @Column(name="sale_closed")
    public Boolean getSaleClosed() {
        return this.saleClosed;
    }
    
    public void setSaleClosed(Boolean saleClosed) {
        this.saleClosed = saleClosed;
    }

    
    @Column(name="invoice", nullable=false)
    public int getInvoice() {
        return this.invoice;
    }
    
    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    
    @Column(name="void")
    public Boolean getVoid_() {
        return this.void_;
    }

    public void setVoid_(Boolean void_) {
        this.void_ = void_;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tillTape")
    public Set<BigWinners> getBigWinnerses() {
        return this.bigWinnerses;
    }

    public void setBigWinnerses(Set<BigWinners> bigWinnerses) {
        this.bigWinnerses = bigWinnerses;
    }




}


