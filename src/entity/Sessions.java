package entity;
// Generated Aug 1, 2015 5:45:51 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Sessions generated by hbm2java
 */
public class Sessions  implements java.io.Serializable {


     private Integer sessionId;
     private Date date;
     private Short attendance;
     private Integer incomeDoor;
     private Integer lbcPayment;
     private Integer bingoPayout;
     private Integer doorPrizes;
     private Integer profitT1;
     private Integer totalGross;
     private Integer totalPrizes;
     private Integer costTickets;
     private Integer underOver;
     private Integer profitT2;
     private Integer concessEnd;
     private Integer concessSales;
     private Integer concessExp;
     private Integer concessProfit;
     private Integer checks;
     private Integer credits;
     private Integer cashProfit;
     private Integer deposit;
     private Integer safeAmount;

    public Sessions() {
    }

    public Sessions(Date date, Short attendance, Integer incomeDoor, Integer lbcPayment, Integer bingoPayout, Integer doorPrizes, Integer profitT1, Integer totalGross, Integer totalPrizes, Integer costTickets, Integer underOver, Integer profitT2, Integer concessEnd, Integer concessSales, Integer concessExp, Integer concessProfit, Integer checks, Integer credits, Integer cashProfit, Integer deposit, Integer safeAmount) {
       this.date = date;
       this.attendance = attendance;
       this.incomeDoor = incomeDoor;
       this.lbcPayment = lbcPayment;
       this.bingoPayout = bingoPayout;
       this.doorPrizes = doorPrizes;
       this.profitT1 = profitT1;
       this.totalGross = totalGross;
       this.totalPrizes = totalPrizes;
       this.costTickets = costTickets;
       this.underOver = underOver;
       this.profitT2 = profitT2;
       this.concessEnd = concessEnd;
       this.concessSales = concessSales;
       this.concessExp = concessExp;
       this.concessProfit = concessProfit;
       this.checks = checks;
       this.credits = credits;
       this.cashProfit = cashProfit;
       this.deposit = deposit;
       this.safeAmount = safeAmount;
    }
   
    public Integer getSessionId() {
        return this.sessionId;
    }
    
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Short getAttendance() {
        return this.attendance;
    }
    
    public void setAttendance(Short attendance) {
        this.attendance = attendance;
    }
    public Integer getIncomeDoor() {
        return this.incomeDoor;
    }
    
    public void setIncomeDoor(Integer incomeDoor) {
        this.incomeDoor = incomeDoor;
    }
    public Integer getLbcPayment() {
        return this.lbcPayment;
    }
    
    public void setLbcPayment(Integer lbcPayment) {
        this.lbcPayment = lbcPayment;
    }
    public Integer getBingoPayout() {
        return this.bingoPayout;
    }
    
    public void setBingoPayout(Integer bingoPayout) {
        this.bingoPayout = bingoPayout;
    }
    public Integer getDoorPrizes() {
        return this.doorPrizes;
    }
    
    public void setDoorPrizes(Integer doorPrizes) {
        this.doorPrizes = doorPrizes;
    }
    public Integer getProfitT1() {
        return this.profitT1;
    }
    
    public void setProfitT1(Integer profitT1) {
        this.profitT1 = profitT1;
    }
    public Integer getTotalGross() {
        return this.totalGross;
    }
    
    public void setTotalGross(Integer totalGross) {
        this.totalGross = totalGross;
    }
    public Integer getTotalPrizes() {
        return this.totalPrizes;
    }
    
    public void setTotalPrizes(Integer totalPrizes) {
        this.totalPrizes = totalPrizes;
    }
    public Integer getCostTickets() {
        return this.costTickets;
    }
    
    public void setCostTickets(Integer costTickets) {
        this.costTickets = costTickets;
    }
    public Integer getUnderOver() {
        return this.underOver;
    }
    
    public void setUnderOver(Integer underOver) {
        this.underOver = underOver;
    }
    public Integer getProfitT2() {
        return this.profitT2;
    }
    
    public void setProfitT2(Integer profitT2) {
        this.profitT2 = profitT2;
    }
    public Integer getConcessEnd() {
        return this.concessEnd;
    }
    
    public void setConcessEnd(Integer concessEnd) {
        this.concessEnd = concessEnd;
    }
    public Integer getConcessSales() {
        return this.concessSales;
    }
    
    public void setConcessSales(Integer concessSales) {
        this.concessSales = concessSales;
    }
    public Integer getConcessExp() {
        return this.concessExp;
    }
    
    public void setConcessExp(Integer concessExp) {
        this.concessExp = concessExp;
    }
    public Integer getConcessProfit() {
        return this.concessProfit;
    }
    
    public void setConcessProfit(Integer concessProfit) {
        this.concessProfit = concessProfit;
    }
    public Integer getChecks() {
        return this.checks;
    }
    
    public void setChecks(Integer checks) {
        this.checks = checks;
    }
    public Integer getCredits() {
        return this.credits;
    }
    
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
    public Integer getCashProfit() {
        return this.cashProfit;
    }
    
    public void setCashProfit(Integer cashProfit) {
        this.cashProfit = cashProfit;
    }
    public Integer getDeposit() {
        return this.deposit;
    }
    
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }
    public Integer getSafeAmount() {
        return this.safeAmount;
    }
    
    public void setSafeAmount(Integer safeAmount) {
        this.safeAmount = safeAmount;
    }




}


