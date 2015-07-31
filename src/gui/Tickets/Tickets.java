/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tickets;

import Tickets.Logging.LoggerExample;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Switcher
 */
public class Tickets {
    
    private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
    
    Connection c;
    PreparedStatement pstmt;
    ResultSet rs;
    int id1;
    int amount;
    int gross;
    public int invoice_num;
    public int invoice_num2;
    
    public void getSelectedGame(int bin){
        try{
            c = DbConnect.getConnection();
            pstmt = c.prepareStatement("SELECT serial FROM tickets WHERE bin =?");
            pstmt.setInt(1,bin);
            rs = pstmt.executeQuery();
            rs.next();
            
        }catch (Exception e) {e.printStackTrace();}
    }
    public int Sale(int unsold_amt, int actual_gross, int unsold_tickets, int subtotal, String serial, int ticketCost, String gameName)throws SQLException, Exception{
        PreparedStatement updateTill = null;
        String updateTillString = "INSERT INTO `fire_tickets`.`till_tape` (`serial`, `name`, `time`, `sale_amount`, `prize_amount`, `users_user_id`, `customers_cust_id`, `locations_loc_id`, invoice) VALUES (?, ?, ?, ?, '0', '3', '3', '1','0')";

        subtotal = subtotal * ticketCost; //calculate cost based on ticket price
        try{
            c = DbConnect.getConnection();
            updateTill = c.prepareStatement(updateTillString,PreparedStatement.RETURN_GENERATED_KEYS);
            c.setAutoCommit(false);
            updateTill.setString(1,serial);
            updateTill.setString(2,gameName);
            updateTill.setTimestamp(3, getCurrentTimeStamp());
            updateTill.setInt(4, subtotal);
            updateTill.executeUpdate();
            ResultSet key = updateTill.getGeneratedKeys();
            System.out.println("key " + key);
            c.commit();
            }catch (SQLException e ) {
            Utilities.printSQLException(e);
            if (c != null) {
                try {
                System.err.print("Transaction is being rolled back");
                c.rollback();
                } catch(SQLException excep) {
                Utilities.printSQLException(excep);
                    }
                }
            } finally {
            if (updateTill != null) {
                updateTill.close();
            }
            c.setAutoCommit(true);
            LOGGER.log(Level.INFO, "Inserted sale: {0} / {1} sold: {2}", new Object[]{gameName, serial, subtotal});
            }
        return amount;
    }
    public int Prize(int bin, int subtotal, String serial, String gameName)throws SQLException, Exception{
            PreparedStatement tillTapePrize = null;
            String prizeTillTapePrize = "INSERT INTO `fire_tickets`.`till_tape` (`serial`, `name`, `time`, `sale_amount`, `prize_amount`, `users_user_id`, `customers_cust_id`, `locations_loc_id`, invoice) VALUES (?, ?, ?, '0', ?, '1', '1', '1', '0')";
            
        try{
            c = DbConnect.getConnection();
            tillTapePrize = c.prepareStatement(prizeTillTapePrize,PreparedStatement.RETURN_GENERATED_KEYS);
            c.setAutoCommit(false);
            tillTapePrize.setString(1,serial);
            tillTapePrize.setString(2,gameName);
            tillTapePrize.setTimestamp(3, getCurrentTimeStamp());
            tillTapePrize.setInt(4, subtotal);
            tillTapePrize.executeUpdate();
            c.commit();
        }catch (SQLException e ) {
        Utilities.printSQLException(e);
        if (c != null) {
            try {
                System.err.print("Transaction is being rolled back");
                c.rollback();
            } catch(SQLException excep) {
                Utilities.printSQLException(excep);
            }
        }
        } finally {
        if (tillTapePrize != null) {
            tillTapePrize.close();
        }
        }
        c.setAutoCommit(true);
    
    LOGGER.log(Level.INFO, "Inserted prize: {0} / {1} sold: {2}", new Object[]{gameName, serial, subtotal});
    return amount;
    }
    
    public void closeSale() throws SQLException, Exception{
        int grossTotal = 0;
        int grossPrize = 0;
        int grossNet = 0;
        PreparedStatement updateTicket = null;
        PreparedStatement selectTicket = null;
        PreparedStatement updateTill = null;
        PreparedStatement selectSaleSessions = null;
        PreparedStatement updateCash = null;
        String selectTicketString = "Select * from till_tape inner join tickets where till_tape.serial = tickets.serial and till_tape.sale_closed = 0";
        String updateTicketString = "UPDATE tickets set unsold_amt = ?, actual_gross = ?, unsold_tickets =?, actual_prizes = ? where serial = ?";
        String updateTill_tape = "Update till_tape SET sale_closed = 1, invoice = ? where invoice = 0";
        String selectSaleString = "SELECT * from sale_sessions WHERE id = 5";
        String updateCashString = "Update sale_sessions set gross_sales = ?, gross_prizes = ?, gross_net = ?, currentbank =? WHERE id =5";
    try{
        c = DbConnect.getConnection();
        updateTicket = c.prepareStatement(updateTicketString);
        selectTicket = c.prepareStatement(selectTicketString);
        updateTill = c.prepareStatement(updateTill_tape);
        selectSaleSessions = c.prepareStatement(selectSaleString);
        updateCash = c.prepareStatement(updateCashString);
        //c.setAutoCommit(false);
        rs = selectTicket.executeQuery();
        rs.next();
        while(rs.next()){
            int sale_amount = rs.getInt("sale_amount");
            int prize_amount = rs.getInt("prize_amount");
            String serial = rs.getString("serial");
            int unsold_amt = rs.getInt("unsold_amt");
            int actual_gross = rs.getInt("actual_gross");
            int unsold_tickets = rs.getInt("unsold_tickets");
            int actual_prizes = rs.getInt("actual_prizes");
            System.out.println("Unsold: "+ unsold_amt);
            unsold_amt = unsold_amt - sale_amount; //needs fixed to adjust based on ticket price
            actual_gross = actual_gross + sale_amount;
            grossTotal = grossTotal + sale_amount;
            unsold_tickets = unsold_tickets - sale_amount;
            actual_prizes = actual_prizes + prize_amount;
            grossPrize = grossPrize + prize_amount;
            updateTicket.setInt(1, unsold_amt);
            updateTicket.setInt(2, actual_gross);
            updateTicket.setInt(3, unsold_tickets);
            updateTicket.setInt(4, actual_prizes);
            updateTicket.setString(5, serial);
            updateTicket.executeUpdate();
        }
        updateTill.setInt(1, getInvoice());
        updateTill.executeUpdate();
        LOGGER.log(Level.INFO, "Sale completed, invoice number: {0}", invoice_num2);
        getInvoice();
        rs = selectSaleSessions.executeQuery();
        rs.next();
        updateCash.setInt(1, grossTotal);
        updateCash.setInt(2, grossPrize);
        grossNet = grossTotal - grossPrize;
        updateCash.setInt(3, grossNet);
        updateCash.setInt(4, grossNet);
        updateCash.executeUpdate();
        //c.commit();
    }catch (SQLException e ) {
        Utilities.printSQLException(e);
        if (c != null) {
            try {
                System.err.print("Transaction is being rolled back");
                c.rollback();
            } catch(SQLException excep) {
                Utilities.printSQLException(excep);
            }
        }
    } finally {
        if (selectTicket != null) {
            selectTicket.close();
        }
        if (updateTicket != null) {
            updateTicket.close();
        }
        if (updateTill != null) {
            updateTill.close();
        }
        c.setAutoCommit(true);
    }
    }
    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
    public void getSale()throws SQLException, Exception{
        
        PreparedStatement getSaleReceipt = null;
        String saleReceipt = "Select sale_amount,serial from till_tape where invoice=105 and sale_closed = 0";
        try{
            c = DbConnect.getConnection();
            getSaleReceipt = c.prepareStatement(saleReceipt);
            c.setAutoCommit(false);
            rs = getSaleReceipt.executeQuery();
            while(rs.next()){
            String serial = rs.getString("serial");
            int amount = rs.getInt("sale_amount");
//            ReceiptArray receipt = new ReceiptArray();
            //receipt.captureSales(amount, serial, "Crazy hoes");
            }
            rs.next();
            c.commit();
            }catch (SQLException e ) {
        Utilities.printSQLException(e);
        if (c != null) {
            try {
                System.err.print("Transaction is being rolled back");
                c.rollback();
            } catch(SQLException excep) {
                Utilities.printSQLException(excep);
            }
        }
    } finally {
        if (getSaleReceipt != null) {
            getSaleReceipt.close();
        }
        c.setAutoCommit(true);
    }
    }
    public int getInvoice()throws SQLException, Exception {
    PreparedStatement selectInvoice = null;
    String selectInvoiceNum = "Select MAX(till_tape.invoice) AS Invoice FROM till_tape";
    try{
        c = DbConnect.getConnection();
        selectInvoice = c.prepareStatement(selectInvoiceNum);
        c.setAutoCommit(false);
        rs = selectInvoice.executeQuery();
        rs.next();
        invoice_num = rs.getInt("invoice");
//        LOGGER.log(Level.INFO, "Invoice num: {0}", invoice_num);
        invoice_num2 = invoice_num + 1;
//        LOGGER.log(Level.INFO, "Invoice num: {0}", invoice_num2);
    }catch (SQLException e ) {
        Utilities.printSQLException(e);
        if (c != null) {
            try {
                System.err.print("Transaction is being rolled back");
                c.rollback();
            } catch(SQLException excep) {
                Utilities.printSQLException(excep);
            }
        }
    } finally {
        if (selectInvoice != null) {
            selectInvoice.close();
        }
        c.setAutoCommit(true);
    }
    return invoice_num2;
}
    public void create(){
        
    }
    public void delete(){
        
    }
    public void view(){
        
    }
    public void update(){
        
    }
    
}
