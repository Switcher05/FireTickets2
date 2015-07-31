/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tickets;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Switcher
 */
/*TODO
Export settings on set to file, load from file after starup
*/
public class DbConnect {
    static private Connection connection;
    public static Connection getConnection() throws Exception{
        if(connection ==null){
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.2/fire_tickets", "switcher", "duJU92Ca");
        }
        return connection;
    }
    public static Connection setConnection(String url, String user, String pass) throws Exception{
        if(connection==null){
            Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
    
}
