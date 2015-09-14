/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Switcher
 */
@Entity
@Table(name = "sessions")
public class Session implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    private int id;
    private String dateTime;
    private static double gross;
    private static double prizes;
    private static double net;
    private static int numInvoices;
    
    //Constructor
    
    public Session(){
        
        
    }
    //TODO:Creates a new sales session
    public void startSession(){
        
    }
    //TODO:Closes current sales session
    public void closeSession(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public static double getGross() {
        return gross;
    }

    public static void setGross(double gross) {
        Session.gross = gross;
    }

    public static double getPrizes() {
        return prizes;
    }

    public static void setPrizes(double prizes) {
        Session.prizes = prizes;
    }

    public static double getNet() {
        return net;
    }

    public static void setNet(double net) {
        Session.net = net;
    }

    public static int getNumInvoices() {
        return numInvoices;
    }

    public static void setNumInvoices(int numInvoices) {
        Session.numInvoices = numInvoices;
    }
    
}
