package entity;
// Generated Oct 11, 2015 7:56:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TicketsId generated by hbm2java
 */
@Embeddable
public class TicketsId  implements java.io.Serializable {


     private String serial;
     private String gameTemplatesPartNum;

    public TicketsId() {
    }

    public TicketsId(String serial, String gameTemplatesPartNum) {
       this.serial = serial;
       this.gameTemplatesPartNum = gameTemplatesPartNum;
    }
   


    @Column(name="Serial", unique=true, nullable=false, length=12)
    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }


    @Column(name="game_templates_part_num", nullable=false, length=12)
    public String getGameTemplatesPartNum() {
        return this.gameTemplatesPartNum;
    }
    
    public void setGameTemplatesPartNum(String gameTemplatesPartNum) {
        this.gameTemplatesPartNum = gameTemplatesPartNum;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TicketsId) ) return false;
		 TicketsId castOther = ( TicketsId ) other; 
         
		 return ( (this.getSerial()==castOther.getSerial()) || ( this.getSerial()!=null && castOther.getSerial()!=null && this.getSerial().equals(castOther.getSerial()) ) )
 && ( (this.getGameTemplatesPartNum()==castOther.getGameTemplatesPartNum()) || ( this.getGameTemplatesPartNum()!=null && castOther.getGameTemplatesPartNum()!=null && this.getGameTemplatesPartNum().equals(castOther.getGameTemplatesPartNum()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSerial() == null ? 0 : this.getSerial().hashCode() );
         result = 37 * result + ( getGameTemplatesPartNum() == null ? 0 : this.getGameTemplatesPartNum().hashCode() );
         return result;
   }   


}


