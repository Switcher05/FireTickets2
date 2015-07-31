/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Switcher
 */
public class Customer {
    Connection c;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void create(String fname, String lname, String address, String city, String state, String phone, double totalSale, double totalPrizes, int cardNum) throws SQLException, Exception{
        PreparedStatement createCust = null;
        String createCustString = "INSERT INTO customers(card_num, fname,lname,address, city, state, phone, total_sale, total_prizes, card_num) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
        c = DbConnect.getConnection();
        c.setAutoCommit(false);
        createCust = c.prepareStatement(createCustString);
        createCust.setString(1, fname);
        createCust.setString(2, lname);
        createCust.setString(3, address);
        createCust.setString(4, city);
        createCust.setString(5, state);
        createCust.setString(6, phone);
        createCust.setDouble(7, totalSale);
        createCust.setDouble(8, totalPrizes);
        createCust.setInt(9, cardNum);
        c.commit();
        }catch (SQLException sqlex) {
            Utilities.printSQLException(sqlex);
            if (c != null){
                try{
                    System.out.println("Transaction is being rolled back");
                    c.rollback();
                }catch (SQLException ex) {
                    Utilities.printSQLException(ex);
                }
            }
        } finally {
            if(createCust != null){
                createCust.close();
                c.setAutoCommit(true);
            }
                
        }
    }
    
    public void delete(){
        
    }
    public void update(){
        
    }
    public void transaction(int id, double saleAmount, double prizeAmount) throws SQLException, Exception{
        PreparedStatement selectT = null;
        PreparedStatement trans = null;
        String transSelect = "SELECT total_sales, total_prizes FROM customers WHERE id =?";
        String transString = "UPDATE customers SET total_sales = ?, total_prizes =? WHERE id = ?";
        try{
            c = DbConnect.getConnection();
            selectT = c.prepareStatement(transSelect);
            trans = c.prepareStatement(transString);
            c.setAutoCommit(false);
            rs = trans.executeQuery();
            rs.next();
            double selectSale = rs.getInt("total_sales");
            double selectprize = rs.getInt("total_prizes");
            selectSale = selectSale + saleAmount;
            selectprize = selectprize + prizeAmount;
            trans.setDouble(1, selectSale);
            trans.setDouble(2, selectprize);
            trans.setInt(3, id);
            trans.executeUpdate();
            c.commit();
       }catch (SQLException sqlex) {
            Utilities.printSQLException(sqlex);
            if (c != null){
                try{
                    System.out.println("Transaction is being rolled back");
                    c.rollback();
                }catch (SQLException ex) {
                    Utilities.printSQLException(ex);
                }
            }
        } finally {
            if(trans != null){
                trans.close();
                c.setAutoCommit(true);
            }
                
        }
    }
}
