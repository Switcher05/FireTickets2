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
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Switcher
 */
public class Transaction {
    
    Connection c;
    PreparedStatement pstmt;
    ResultSet rs;
    public static int invoiceNum = 0;
    public int sessionid = 0;
    public int sales = 0, prizes = 0;
    StarReceiptTest print = new StarReceiptTest();
    
    public void Transaction(int bin, String serial, int saleAmount, int prizeAmount, String gameName, int invoice) throws SQLException, Exception {
        PreparedStatement addTrans = null;
        String addTransString = "INSERT INTO fire_tickets.till_tape (serial, name, time, sale_amount, prize_amount, users_user_id, customers_cust_id, locations_loc_id, invoice) VALUES (?, ?, ?, ?, ?, '3', '3', '1', ?)";
        
        try{
            c = DbConnect.getConnection();
            addTrans = c.prepareStatement(addTransString, PreparedStatement.RETURN_GENERATED_KEYS);
            print.formatLine(saleAmount, prizeAmount, serial, gameName);
            c.setAutoCommit(false);
            addTrans.setString(1, serial);
            addTrans.setString(2, gameName);
            addTrans.setTimestamp(3, getCurrentTimeStamp());
            addTrans.setInt(4, saleAmount);
            addTrans.setInt(5, prizeAmount);
            addTrans.setInt(6, invoice);
            System.out.println("Executing sale to till tape");
            addTrans.executeUpdate();
            c.commit();
            System.out.println("Inserted: " + invoice);
            
        } catch (SQLException e) {
            Utilities.printSQLException(e);
            if (c != null){
                try {
                    System.err.print("Transaction is being rolled back");
                    c.rollback();
                } catch (SQLException excep){
                    Utilities.printSQLException(excep);
                }
            }
        } finally {
            if (addTrans != null) {addTrans.close();}
            c.setAutoCommit(true);
            saleAmount = 0;
        }
    }
    
    public static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
    public int setInvoice()throws SQLException, Exception {
    PreparedStatement selectInvoice = null;
    String selectInvoiceNum = "Select MAX(till_tape.invoice) AS Invoice FROM till_tape";
    try{
        c = DbConnect.getConnection();
        selectInvoice = c.prepareStatement(selectInvoiceNum);
        c.setAutoCommit(false);
        rs = selectInvoice.executeQuery();
        rs.next();
        invoiceNum = rs.getInt("invoice");
        invoiceNum = invoiceNum + 1;
        System.out.println("Invoice number: " + invoiceNum);
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
    }return invoiceNum;
    }
    public int getInvoice(){
        return invoiceNum;
    }
    
    public void TransClose() throws SQLException, Exception{
        LinkedList<Integer> salesOut = new LinkedList<Integer>();
        PreparedStatement selectTill = null;
        PreparedStatement updateTicket = null;
        PreparedStatement updateTill = null;
        PreparedStatement selectLast = null;
        PreparedStatement selectCash = null;
        PreparedStatement updateCash = null;
        String selectTillString = "SELECT * FROM till_tape INNER JOIN tickets where till_tape.serial = tickets.serial and till_tape.sale_closed = 0";
        String updateTicketString = "UPDATE tickets SET unsold_amt = ?, actual_gross = ?, actual_prizes = ?, actual_net = ?, unsold_tickets = ? WHERE serial = ?";
        String updateTillString = "UPDATE till_tape SET sale_closed = 1 WHERE invoice = ?";
        String selectMax = "Select MAX(sale_sessions.id) AS Id FROM sale_sessions";
        String selectCashString = "SELECT * from sale_sessions WHERE id = ?";
        String updateCashString = "UPDATE sale_sessions SET gross_sales = ?, gross_prizes = ?, gross_net = ?, currentbank = ? WHERE id = ?";
        try{
            c = DbConnect.getConnection();
            selectTill = c.prepareStatement(selectTillString);
            updateTicket = c.prepareStatement(updateTicketString);
            updateTill = c.prepareStatement(updateTillString);
            selectLast = c.prepareStatement(selectMax);
            selectCash = c.prepareStatement(selectCashString);
            updateCash = c.prepareStatement(updateCashString);
            c.setAutoCommit(false);
            rs = selectTill.executeQuery();
            while(rs.next()){
                int sale_amount = rs.getInt("sale_amount");
                int prize_amount = rs.getInt("prize_amount");
                String serial = rs.getString("serial");
                int unsold_amt = rs.getInt("unsold_amt");
                int actual_gross = rs.getInt("actual_gross");
                int actual_prizes = rs.getInt("actual_prizes");
                int actual_net = rs.getInt("actual_net");
                int unsold_tickets = rs.getInt("unsold_tickets");
                int invoiceNum = rs.getInt("invoice");
//                System.out.println("BEFORE:Sale amount: " + sale_amount + " Prize amount: " + prize_amount + " Serial: " + serial + " Unsold amount: " + unsold_amt + " Actual gross: " + actual_gross + " Actual prizes: " + actual_prizes + "Actual net: " + actual_net);
                salesOut.add(sale_amount);
                prizes = prizes + prize_amount;
                unsold_amt = unsold_amt - sale_amount;
                actual_gross = actual_gross + sale_amount;
                actual_prizes = actual_prizes + prize_amount;
                actual_net = actual_gross - actual_prizes;
                unsold_tickets = unsold_tickets - sale_amount;
                System.out.println("Calculated net: " + actual_net);
//                System.out.println("AFTER:Sale amount: " + sale_amount + " Prize amount: " + prize_amount + " Serial: " + serial + " Unsold amount: " + unsold_amt + " Actual gross: " + actual_gross + " Actual prizes: " + actual_prizes + "Actual net: " + actual_net);
                updateTill.setInt(1, invoiceNum);
                updateTill.executeUpdate();
                updateTicket.setInt(1, unsold_amt);
                updateTicket.setInt(2, actual_gross);
                updateTicket.setInt(3, actual_prizes);
                updateTicket.setInt(4, actual_net);
                updateTicket.setInt(5, unsold_tickets);
                updateTicket.setString(6, serial);
                updateTicket.executeUpdate();
//                System.out.println("Updated ticket: " + serial);
                System.out.println("Sales total : " + sales + " Prizes total: " + prizes);
                
            }
            rs = selectLast.executeQuery();
            rs.next();
            int id = rs.getInt("Id");
            sessionid = id;
            System.out.println("Sale session number: " + sessionid);
            selectCash.setInt(1, sessionid);
            rs = selectCash.executeQuery();
            rs.next();
            int startbank = rs.getInt("start_bank");
            int grosstotal = rs.getInt("gross_sales");
            int prizetotal = rs.getInt("gross_prizes");
            int nettotal = rs.getInt("gross_net");
            int currentbank = rs.getInt("currentbank");
//            System.out.println("Gross sales: " + grosstotal + " Gross prizes: " + prizetotal + " Net: " + nettotal + " Current Bank: " + currentbank);
            for (int i = 0; i < salesOut.size(); i++) {
                grosstotal = grosstotal + salesOut.get(i);
            }
            grosstotal = grosstotal + sales;
            prizetotal = prizetotal + prizes;
            nettotal = grosstotal - prizetotal;
            currentbank = startbank + nettotal;
            updateCash.setInt(1, grosstotal);
            updateCash.setInt(2, prizetotal);
            updateCash.setInt(3, nettotal);
            updateCash.setInt(4, currentbank);
            updateCash.setInt(5, sessionid);
            updateCash.executeUpdate();
//            System.out.println("Updated sale sessions");
            c.commit();
            rs.close();
            System.out.println("===========SALE CLOSED===========");
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
        if (selectTill != null) {
            selectTill.close();
        }
        if (selectCash != null) {
            selectCash.close();
        }
        if (updateCash != null) {
            updateCash.close();
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
    }
