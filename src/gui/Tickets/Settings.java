/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;

/**
 *
 * @author Switcher
 */
public class Settings {
    private static final String JDBCURL = "jdbc:mysql://192.168.1.2/fire_tickets";
    private static final String USER = "switcher";
    private static final String PASS = "duJU92Ca";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static String getJDBCURL() {
        return JDBCURL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static String getDRIVER() {
        return DRIVER;
    }
    
}
