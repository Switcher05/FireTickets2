package entity;
// Generated Oct 11, 2015 7:56:58 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * BigWinners generated by hbm2java
 */
@Entity
@Table(name="big_winners"
    ,catalog="fire_tickets"
    , uniqueConstraints = @UniqueConstraint(columnNames="bw_id") 
)
public class BigWinners  implements java.io.Serializable {


     private BigWinnersId id;
     private TillTape tillTape;
     private Boolean w2g;

    public BigWinners() {
    }

	
    public BigWinners(BigWinnersId id, TillTape tillTape) {
        this.id = id;
        this.tillTape = tillTape;
    }
    public BigWinners(BigWinnersId id, TillTape tillTape, Boolean w2g) {
       this.id = id;
       this.tillTape = tillTape;
       this.w2g = w2g;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="bwId", column=@Column(name="bw_id", unique=true, nullable=false) ), 
        @AttributeOverride(name="tillTapeTId", column=@Column(name="till_tape_t_id", nullable=false) ), 
        @AttributeOverride(name="tillTapeUsersUserId", column=@Column(name="till_tape_users_user_id", nullable=false) ), 
        @AttributeOverride(name="tillTapeCustomersCustId", column=@Column(name="till_tape_customers_cust_id", nullable=false) ), 
        @AttributeOverride(name="tillTapeLocationsLocId", column=@Column(name="till_tape_locations_loc_id", nullable=false) ) } )
    public BigWinnersId getId() {
        return this.id;
    }
    
    public void setId(BigWinnersId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns( { 
        @JoinColumn(name="till_tape_t_id", referencedColumnName="t_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="till_tape_users_user_id", referencedColumnName="users_user_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="till_tape_customers_cust_id", referencedColumnName="customers_cust_id", nullable=false, insertable=false, updatable=false), 
        @JoinColumn(name="till_tape_locations_loc_id", referencedColumnName="locations_loc_id", nullable=false, insertable=false, updatable=false) } )
    public TillTape getTillTape() {
        return this.tillTape;
    }
    
    public void setTillTape(TillTape tillTape) {
        this.tillTape = tillTape;
    }

    
    @Column(name="w2g")
    public Boolean getW2g() {
        return this.w2g;
    }
    
    public void setW2g(Boolean w2g) {
        this.w2g = w2g;
    }




}


