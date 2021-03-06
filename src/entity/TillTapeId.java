package entity;
// Generated Oct 11, 2015 7:56:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TillTapeId generated by hbm2java
 */
@Embeddable
public class TillTapeId  implements java.io.Serializable {


     private int TId;
     private int usersUserId;
     private int customersCustId;
     private int locationsLocId;

    public TillTapeId() {
    }

    public TillTapeId(int TId, int usersUserId, int customersCustId, int locationsLocId) {
       this.TId = TId;
       this.usersUserId = usersUserId;
       this.customersCustId = customersCustId;
       this.locationsLocId = locationsLocId;
    }



    @Column(name="t_id", unique=true, nullable=false)
    public int getTId() {
        return this.TId;
    }
    
    public void setTId(int TId) {
        this.TId = TId;
    }


    @Column(name="users_user_id", nullable=false)
    public int getUsersUserId() {
        return this.usersUserId;
    }
    
    public void setUsersUserId(int usersUserId) {
        this.usersUserId = usersUserId;
    }


    @Column(name="customers_cust_id", nullable=false)
    public int getCustomersCustId() {
        return this.customersCustId;
    }
    
    public void setCustomersCustId(int customersCustId) {
        this.customersCustId = customersCustId;
    }


    @Column(name="locations_loc_id", nullable=false)
    public int getLocationsLocId() {
        return this.locationsLocId;
    }
    
    public void setLocationsLocId(int locationsLocId) {
        this.locationsLocId = locationsLocId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TillTapeId) ) return false;
		 TillTapeId castOther = ( TillTapeId ) other; 
         
		 return (this.getTId()==castOther.getTId())
 && (this.getUsersUserId()==castOther.getUsersUserId())
 && (this.getCustomersCustId()==castOther.getCustomersCustId())
 && (this.getLocationsLocId()==castOther.getLocationsLocId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTId();
         result = 37 * result + this.getUsersUserId();
         result = 37 * result + this.getCustomersCustId();
         result = 37 * result + this.getLocationsLocId();
         return result;
   }   


}


