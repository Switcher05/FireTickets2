package entity;
// Generated Sep 8, 2015 7:01:42 PM by Hibernate Tools 4.3.1



/**
 * BigWinnersId generated by hbm2java
 */
public class BigWinnersId  implements java.io.Serializable {


     private int bwId;
     private int tillTapeTId;
     private int tillTapeUsersUserId;
     private int tillTapeCustomersCustId;
     private int tillTapeLocationsLocId;

    public BigWinnersId() {
    }

    public BigWinnersId(int bwId, int tillTapeTId, int tillTapeUsersUserId, int tillTapeCustomersCustId, int tillTapeLocationsLocId) {
       this.bwId = bwId;
       this.tillTapeTId = tillTapeTId;
       this.tillTapeUsersUserId = tillTapeUsersUserId;
       this.tillTapeCustomersCustId = tillTapeCustomersCustId;
       this.tillTapeLocationsLocId = tillTapeLocationsLocId;
    }
   
    public int getBwId() {
        return this.bwId;
    }
    
    public void setBwId(int bwId) {
        this.bwId = bwId;
    }
    public int getTillTapeTId() {
        return this.tillTapeTId;
    }
    
    public void setTillTapeTId(int tillTapeTId) {
        this.tillTapeTId = tillTapeTId;
    }
    public int getTillTapeUsersUserId() {
        return this.tillTapeUsersUserId;
    }
    
    public void setTillTapeUsersUserId(int tillTapeUsersUserId) {
        this.tillTapeUsersUserId = tillTapeUsersUserId;
    }
    public int getTillTapeCustomersCustId() {
        return this.tillTapeCustomersCustId;
    }
    
    public void setTillTapeCustomersCustId(int tillTapeCustomersCustId) {
        this.tillTapeCustomersCustId = tillTapeCustomersCustId;
    }
    public int getTillTapeLocationsLocId() {
        return this.tillTapeLocationsLocId;
    }
    
    public void setTillTapeLocationsLocId(int tillTapeLocationsLocId) {
        this.tillTapeLocationsLocId = tillTapeLocationsLocId;
    }




}


