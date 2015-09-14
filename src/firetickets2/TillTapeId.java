package firetickets2;
// Generated Sep 8, 2015 7:01:42 PM by Hibernate Tools 4.3.1



/**
 * TillTapeId generated by hbm2java
 */
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
   
    public int getTId() {
        return this.TId;
    }
    
    public void setTId(int TId) {
        this.TId = TId;
    }
    public int getUsersUserId() {
        return this.usersUserId;
    }
    
    public void setUsersUserId(int usersUserId) {
        this.usersUserId = usersUserId;
    }
    public int getCustomersCustId() {
        return this.customersCustId;
    }
    
    public void setCustomersCustId(int customersCustId) {
        this.customersCustId = customersCustId;
    }
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


