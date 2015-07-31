/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Switcher
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    
    @Column(nullable = false, unique = true)
    private String serial;
    private String datePlaced;
    private String dateRemoved;
    private int unsoldAmt;
    private double actualGross;
    private double actualPrizes;
    private double actualNet;
    private int bin;
    private boolean inplay;
    private boolean closed;
    private int unsoldTickets;
    
    private int lastSaleRem;
    private int[] prizesRemaining;  
    
    //Getters and setters

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(String datePlaced) {
        this.datePlaced = datePlaced;
    }

    public String getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(String dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    public int getUnsoldAmt() {
        return unsoldAmt;
    }

    public void setUnsoldAmt(int unsoldAmt) {
        this.unsoldAmt = unsoldAmt;
    }

    public double getActualGross() {
        return actualGross;
    }

    public void setActualGross(double actualGross) {
        this.actualGross = actualGross;
    }

    public double getActualPrizes() {
        return actualPrizes;
    }

    public void setActualPrizes(double actualPrizes) {
        this.actualPrizes = actualPrizes;
    }

    public double getActualNet() {
        return actualNet;
    }

    public void setActualNet(double actualNet) {
        this.actualNet = actualNet;
    }

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public boolean isInplay() {
        return inplay;
    }

    public void setInplay(boolean inplay) {
        this.inplay = inplay;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public int getUnsoldTickets() {
        return unsoldTickets;
    }

    public void setUnsoldTickets(int unsoldTickets) {
        this.unsoldTickets = unsoldTickets;
    }

    public int getLastSaleRem() {
        return lastSaleRem;
    }

    public void setLastSaleRem(int lastSaleRem) {
        this.lastSaleRem = lastSaleRem;
    }

    public int[] getPrizesRemaining() {
        return prizesRemaining;
    }

    public void setPrizesRemaining(int[] prizesRemaining) {
        this.prizesRemaining = prizesRemaining;
    }
    
}
