package firetickets2;
// Generated Sep 8, 2015 7:01:42 PM by Hibernate Tools 4.3.1



/**
 * PmaRecent generated by hbm2java
 */
public class PmaRecent  implements java.io.Serializable {


     private String username;
     private String tables;

    public PmaRecent() {
    }

    public PmaRecent(String username, String tables) {
       this.username = username;
       this.tables = tables;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTables() {
        return this.tables;
    }
    
    public void setTables(String tables) {
        this.tables = tables;
    }




}


