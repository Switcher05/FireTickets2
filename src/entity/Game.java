/*
 * The MIT License
 *
 * Copyright 2015 Ryan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Ryan
 */
public class Game {
     private String partNum;
     private int distsIdDistId;
     private int mfgIdMfgId;
     private DistsId distsId;
     private MfgId mfgId;
     private String gameName;
     private Double gameCost;
     private Double ticketCost;
     private Integer numTickets;
     private Integer ideaGross;
     private Integer ideaPrizes;
     private Integer ideaNet;
     private Integer lastSale;
     private Integer lastSaleAllow;
     private Integer prizeAmt1;
     private Integer prizeAmt2;
     private Integer prizeAmt3;
     private Integer prizeAmt4;
     private Integer prizeAmt5;
     private Integer prizeAmt6;
     private Integer prizeAmt7;
     private Integer prizeAmt8;
     private Integer prizeAmt9;
     private Integer prizeAmt10;
     private Integer prizeAmt11;
     private Integer prizeAmt12;
     private Integer prizeAmt13;
     private Integer prizeAmt14;
     private Integer prizeAmt15;
     private Integer prizeAll1;
     private Integer prizeAll2;
     private Integer prizeAll3;
     private Integer prizeAll4;
     private Integer prizeAll5;
     private Integer prizeAll6;
     private Integer prizeAll7;
     private Integer prizeAll8;
     private Integer prizeAll9;
     private Integer prizeAll10;
     private Integer prizeAll11;
     private Integer prizeAll12;
     private Integer prizeAll13;
     private Integer prizeAll14;
     private Integer prizeAll15;

     private Date datePlaced;
     private Date dateRemoved;
     private Integer unsoldAmt;
     private Integer actualGross;
     private Integer actualPrizes;
     private Integer actualNet;
     private Integer bin;
     private Boolean inplay;
     private Integer closed;
     private Integer unsoldTickets;
     private Byte lastSaleRem;
     private Integer prizeRem1;
     private Integer prizeRem2;
     private Integer prizeRem3;
     private Integer prizeRem4;
     private Integer prizeRem5;
     private Integer prizeRem6;
     private Integer prizeRem7;
     private Integer prizeRem8;
     private Integer prizeRem9;
     private Integer prizeRem10;
     private Integer prizeRem11;
     private Integer prizeRem12;
     private Integer prizeRem13;
     private Integer prizeRem14;
     private Integer prizeRem15;
     private Date datePurch;
     private String invoiceNum;
     private String serial;
     private String gameTemplatesPartNum;

    public Game(String partNum, int distsIdDistId, int mfgIdMfgId, DistsId distsId, MfgId mfgId, String gameName, Double gameCost, Double ticketCost, Integer numTickets, Integer ideaGross, Integer ideaPrizes, Integer ideaNet, Integer lastSale, Integer lastSaleAllow, Integer prizeAmt1, Integer prizeAmt2, Integer prizeAmt3, Integer prizeAmt4, Integer prizeAmt5, Integer prizeAmt6, Integer prizeAmt7, Integer prizeAmt8, Integer prizeAmt9, Integer prizeAmt10, Integer prizeAmt11, Integer prizeAmt12, Integer prizeAmt13, Integer prizeAmt14, Integer prizeAmt15, Integer prizeAll1, Integer prizeAll2, Integer prizeAll3, Integer prizeAll4, Integer prizeAll5, Integer prizeAll6, Integer prizeAll7, Integer prizeAll8, Integer prizeAll9, Integer prizeAll10, Integer prizeAll11, Integer prizeAll12, Integer prizeAll13, Integer prizeAll14, Integer prizeAll15, Date datePlaced, Date dateRemoved, Integer unsoldAmt, Integer actualGross, Integer actualPrizes, Integer actualNet, Integer bin, Boolean inplay, Integer closed, Integer unsoldTickets, Byte lastSaleRem, Integer prizeRem1, Integer prizeRem2, Integer prizeRem3, Integer prizeRem4, Integer prizeRem5, Integer prizeRem6, Integer prizeRem7, Integer prizeRem8, Integer prizeRem9, Integer prizeRem10, Integer prizeRem11, Integer prizeRem12, Integer prizeRem13, Integer prizeRem14, Integer prizeRem15, Date datePurch, String invoiceNum, String serial, String gameTemplatesPartNum) {
        this.partNum = partNum;
        this.distsIdDistId = distsIdDistId;
        this.mfgIdMfgId = mfgIdMfgId;
        this.distsId = distsId;
        this.mfgId = mfgId;
        this.gameName = gameName;
        this.gameCost = gameCost;
        this.ticketCost = ticketCost;
        this.numTickets = numTickets;
        this.ideaGross = ideaGross;
        this.ideaPrizes = ideaPrizes;
        this.ideaNet = ideaNet;
        this.lastSale = lastSale;
        this.lastSaleAllow = lastSaleAllow;
        this.prizeAmt1 = prizeAmt1;
        this.prizeAmt2 = prizeAmt2;
        this.prizeAmt3 = prizeAmt3;
        this.prizeAmt4 = prizeAmt4;
        this.prizeAmt5 = prizeAmt5;
        this.prizeAmt6 = prizeAmt6;
        this.prizeAmt7 = prizeAmt7;
        this.prizeAmt8 = prizeAmt8;
        this.prizeAmt9 = prizeAmt9;
        this.prizeAmt10 = prizeAmt10;
        this.prizeAmt11 = prizeAmt11;
        this.prizeAmt12 = prizeAmt12;
        this.prizeAmt13 = prizeAmt13;
        this.prizeAmt14 = prizeAmt14;
        this.prizeAmt15 = prizeAmt15;
        this.prizeAll1 = prizeAll1;
        this.prizeAll2 = prizeAll2;
        this.prizeAll3 = prizeAll3;
        this.prizeAll4 = prizeAll4;
        this.prizeAll5 = prizeAll5;
        this.prizeAll6 = prizeAll6;
        this.prizeAll7 = prizeAll7;
        this.prizeAll8 = prizeAll8;
        this.prizeAll9 = prizeAll9;
        this.prizeAll10 = prizeAll10;
        this.prizeAll11 = prizeAll11;
        this.prizeAll12 = prizeAll12;
        this.prizeAll13 = prizeAll13;
        this.prizeAll14 = prizeAll14;
        this.prizeAll15 = prizeAll15;
        this.datePlaced = datePlaced;
        this.dateRemoved = dateRemoved;
        this.unsoldAmt = unsoldAmt;
        this.actualGross = actualGross;
        this.actualPrizes = actualPrizes;
        this.actualNet = actualNet;
        this.bin = bin;
        this.inplay = inplay;
        this.closed = closed;
        this.unsoldTickets = unsoldTickets;
        this.lastSaleRem = lastSaleRem;
        this.prizeRem1 = prizeRem1;
        this.prizeRem2 = prizeRem2;
        this.prizeRem3 = prizeRem3;
        this.prizeRem4 = prizeRem4;
        this.prizeRem5 = prizeRem5;
        this.prizeRem6 = prizeRem6;
        this.prizeRem7 = prizeRem7;
        this.prizeRem8 = prizeRem8;
        this.prizeRem9 = prizeRem9;
        this.prizeRem10 = prizeRem10;
        this.prizeRem11 = prizeRem11;
        this.prizeRem12 = prizeRem12;
        this.prizeRem13 = prizeRem13;
        this.prizeRem14 = prizeRem14;
        this.prizeRem15 = prizeRem15;
        this.datePurch = datePurch;
        this.invoiceNum = invoiceNum;
        this.serial = serial;
        this.gameTemplatesPartNum = gameTemplatesPartNum;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public int getDistsIdDistId() {
        return distsIdDistId;
    }

    public void setDistsIdDistId(int distsIdDistId) {
        this.distsIdDistId = distsIdDistId;
    }

    public int getMfgIdMfgId() {
        return mfgIdMfgId;
    }

    public void setMfgIdMfgId(int mfgIdMfgId) {
        this.mfgIdMfgId = mfgIdMfgId;
    }

    public DistsId getDistsId() {
        return distsId;
    }

    public void setDistsId(DistsId distsId) {
        this.distsId = distsId;
    }

    public MfgId getMfgId() {
        return mfgId;
    }

    public void setMfgId(MfgId mfgId) {
        this.mfgId = mfgId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Double getGameCost() {
        return gameCost;
    }

    public void setGameCost(Double gameCost) {
        this.gameCost = gameCost;
    }

    public Double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public Integer getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(Integer numTickets) {
        this.numTickets = numTickets;
    }

    public Integer getIdeaGross() {
        return ideaGross;
    }

    public void setIdeaGross(Integer ideaGross) {
        this.ideaGross = ideaGross;
    }

    public Integer getIdeaPrizes() {
        return ideaPrizes;
    }

    public void setIdeaPrizes(Integer ideaPrizes) {
        this.ideaPrizes = ideaPrizes;
    }

    public Integer getIdeaNet() {
        return ideaNet;
    }

    public void setIdeaNet(Integer ideaNet) {
        this.ideaNet = ideaNet;
    }

    public Integer getLastSale() {
        return lastSale;
    }

    public void setLastSale(Integer lastSale) {
        this.lastSale = lastSale;
    }

    public Integer getLastSaleAllow() {
        return lastSaleAllow;
    }

    public void setLastSaleAllow(Integer lastSaleAllow) {
        this.lastSaleAllow = lastSaleAllow;
    }

    public Integer getPrizeAmt1() {
        return prizeAmt1;
    }

    public void setPrizeAmt1(Integer prizeAmt1) {
        this.prizeAmt1 = prizeAmt1;
    }

    public Integer getPrizeAmt2() {
        return prizeAmt2;
    }

    public void setPrizeAmt2(Integer prizeAmt2) {
        this.prizeAmt2 = prizeAmt2;
    }

    public Integer getPrizeAmt3() {
        return prizeAmt3;
    }

    public void setPrizeAmt3(Integer prizeAmt3) {
        this.prizeAmt3 = prizeAmt3;
    }

    public Integer getPrizeAmt4() {
        return prizeAmt4;
    }

    public void setPrizeAmt4(Integer prizeAmt4) {
        this.prizeAmt4 = prizeAmt4;
    }

    public Integer getPrizeAmt5() {
        return prizeAmt5;
    }

    public void setPrizeAmt5(Integer prizeAmt5) {
        this.prizeAmt5 = prizeAmt5;
    }

    public Integer getPrizeAmt6() {
        return prizeAmt6;
    }

    public void setPrizeAmt6(Integer prizeAmt6) {
        this.prizeAmt6 = prizeAmt6;
    }

    public Integer getPrizeAmt7() {
        return prizeAmt7;
    }

    public void setPrizeAmt7(Integer prizeAmt7) {
        this.prizeAmt7 = prizeAmt7;
    }

    public Integer getPrizeAmt8() {
        return prizeAmt8;
    }

    public void setPrizeAmt8(Integer prizeAmt8) {
        this.prizeAmt8 = prizeAmt8;
    }

    public Integer getPrizeAmt9() {
        return prizeAmt9;
    }

    public void setPrizeAmt9(Integer prizeAmt9) {
        this.prizeAmt9 = prizeAmt9;
    }

    public Integer getPrizeAmt10() {
        return prizeAmt10;
    }

    public void setPrizeAmt10(Integer prizeAmt10) {
        this.prizeAmt10 = prizeAmt10;
    }

    public Integer getPrizeAmt11() {
        return prizeAmt11;
    }

    public void setPrizeAmt11(Integer prizeAmt11) {
        this.prizeAmt11 = prizeAmt11;
    }

    public Integer getPrizeAmt12() {
        return prizeAmt12;
    }

    public void setPrizeAmt12(Integer prizeAmt12) {
        this.prizeAmt12 = prizeAmt12;
    }

    public Integer getPrizeAmt13() {
        return prizeAmt13;
    }

    public void setPrizeAmt13(Integer prizeAmt13) {
        this.prizeAmt13 = prizeAmt13;
    }

    public Integer getPrizeAmt14() {
        return prizeAmt14;
    }

    public void setPrizeAmt14(Integer prizeAmt14) {
        this.prizeAmt14 = prizeAmt14;
    }

    public Integer getPrizeAmt15() {
        return prizeAmt15;
    }

    public void setPrizeAmt15(Integer prizeAmt15) {
        this.prizeAmt15 = prizeAmt15;
    }

    public Integer getPrizeAll1() {
        return prizeAll1;
    }

    public void setPrizeAll1(Integer prizeAll1) {
        this.prizeAll1 = prizeAll1;
    }

    public Integer getPrizeAll2() {
        return prizeAll2;
    }

    public void setPrizeAll2(Integer prizeAll2) {
        this.prizeAll2 = prizeAll2;
    }

    public Integer getPrizeAll3() {
        return prizeAll3;
    }

    public void setPrizeAll3(Integer prizeAll3) {
        this.prizeAll3 = prizeAll3;
    }

    public Integer getPrizeAll4() {
        return prizeAll4;
    }

    public void setPrizeAll4(Integer prizeAll4) {
        this.prizeAll4 = prizeAll4;
    }

    public Integer getPrizeAll5() {
        return prizeAll5;
    }

    public void setPrizeAll5(Integer prizeAll5) {
        this.prizeAll5 = prizeAll5;
    }

    public Integer getPrizeAll6() {
        return prizeAll6;
    }

    public void setPrizeAll6(Integer prizeAll6) {
        this.prizeAll6 = prizeAll6;
    }

    public Integer getPrizeAll7() {
        return prizeAll7;
    }

    public void setPrizeAll7(Integer prizeAll7) {
        this.prizeAll7 = prizeAll7;
    }

    public Integer getPrizeAll8() {
        return prizeAll8;
    }

    public void setPrizeAll8(Integer prizeAll8) {
        this.prizeAll8 = prizeAll8;
    }

    public Integer getPrizeAll9() {
        return prizeAll9;
    }

    public void setPrizeAll9(Integer prizeAll9) {
        this.prizeAll9 = prizeAll9;
    }

    public Integer getPrizeAll10() {
        return prizeAll10;
    }

    public void setPrizeAll10(Integer prizeAll10) {
        this.prizeAll10 = prizeAll10;
    }

    public Integer getPrizeAll11() {
        return prizeAll11;
    }

    public void setPrizeAll11(Integer prizeAll11) {
        this.prizeAll11 = prizeAll11;
    }

    public Integer getPrizeAll12() {
        return prizeAll12;
    }

    public void setPrizeAll12(Integer prizeAll12) {
        this.prizeAll12 = prizeAll12;
    }

    public Integer getPrizeAll13() {
        return prizeAll13;
    }

    public void setPrizeAll13(Integer prizeAll13) {
        this.prizeAll13 = prizeAll13;
    }

    public Integer getPrizeAll14() {
        return prizeAll14;
    }

    public void setPrizeAll14(Integer prizeAll14) {
        this.prizeAll14 = prizeAll14;
    }

    public Integer getPrizeAll15() {
        return prizeAll15;
    }

    public void setPrizeAll15(Integer prizeAll15) {
        this.prizeAll15 = prizeAll15;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public Date getDateRemoved() {
        return dateRemoved;
    }

    public void setDateRemoved(Date dateRemoved) {
        this.dateRemoved = dateRemoved;
    }

    public Integer getUnsoldAmt() {
        return unsoldAmt;
    }

    public void setUnsoldAmt(Integer unsoldAmt) {
        this.unsoldAmt = unsoldAmt;
    }

    public Integer getActualGross() {
        return actualGross;
    }

    public void setActualGross(Integer actualGross) {
        this.actualGross = actualGross;
    }

    public Integer getActualPrizes() {
        return actualPrizes;
    }

    public void setActualPrizes(Integer actualPrizes) {
        this.actualPrizes = actualPrizes;
    }

    public Integer getActualNet() {
        return actualNet;
    }

    public void setActualNet(Integer actualNet) {
        this.actualNet = actualNet;
    }

    public Integer getBin() {
        return bin;
    }

    public void setBin(Integer bin) {
        this.bin = bin;
    }

    public Boolean getInplay() {
        return inplay;
    }

    public void setInplay(Boolean inplay) {
        this.inplay = inplay;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public Integer getUnsoldTickets() {
        return unsoldTickets;
    }

    public void setUnsoldTickets(Integer unsoldTickets) {
        this.unsoldTickets = unsoldTickets;
    }

    public Byte getLastSaleRem() {
        return lastSaleRem;
    }

    public void setLastSaleRem(Byte lastSaleRem) {
        this.lastSaleRem = lastSaleRem;
    }

    public Integer getPrizeRem1() {
        return prizeRem1;
    }

    public void setPrizeRem1(Integer prizeRem1) {
        this.prizeRem1 = prizeRem1;
    }

    public Integer getPrizeRem2() {
        return prizeRem2;
    }

    public void setPrizeRem2(Integer prizeRem2) {
        this.prizeRem2 = prizeRem2;
    }

    public Integer getPrizeRem3() {
        return prizeRem3;
    }

    public void setPrizeRem3(Integer prizeRem3) {
        this.prizeRem3 = prizeRem3;
    }

    public Integer getPrizeRem4() {
        return prizeRem4;
    }

    public void setPrizeRem4(Integer prizeRem4) {
        this.prizeRem4 = prizeRem4;
    }

    public Integer getPrizeRem5() {
        return prizeRem5;
    }

    public void setPrizeRem5(Integer prizeRem5) {
        this.prizeRem5 = prizeRem5;
    }

    public Integer getPrizeRem6() {
        return prizeRem6;
    }

    public void setPrizeRem6(Integer prizeRem6) {
        this.prizeRem6 = prizeRem6;
    }

    public Integer getPrizeRem7() {
        return prizeRem7;
    }

    public void setPrizeRem7(Integer prizeRem7) {
        this.prizeRem7 = prizeRem7;
    }

    public Integer getPrizeRem8() {
        return prizeRem8;
    }

    public void setPrizeRem8(Integer prizeRem8) {
        this.prizeRem8 = prizeRem8;
    }

    public Integer getPrizeRem9() {
        return prizeRem9;
    }

    public void setPrizeRem9(Integer prizeRem9) {
        this.prizeRem9 = prizeRem9;
    }

    public Integer getPrizeRem10() {
        return prizeRem10;
    }

    public void setPrizeRem10(Integer prizeRem10) {
        this.prizeRem10 = prizeRem10;
    }

    public Integer getPrizeRem11() {
        return prizeRem11;
    }

    public void setPrizeRem11(Integer prizeRem11) {
        this.prizeRem11 = prizeRem11;
    }

    public Integer getPrizeRem12() {
        return prizeRem12;
    }

    public void setPrizeRem12(Integer prizeRem12) {
        this.prizeRem12 = prizeRem12;
    }

    public Integer getPrizeRem13() {
        return prizeRem13;
    }

    public void setPrizeRem13(Integer prizeRem13) {
        this.prizeRem13 = prizeRem13;
    }

    public Integer getPrizeRem14() {
        return prizeRem14;
    }

    public void setPrizeRem14(Integer prizeRem14) {
        this.prizeRem14 = prizeRem14;
    }

    public Integer getPrizeRem15() {
        return prizeRem15;
    }

    public void setPrizeRem15(Integer prizeRem15) {
        this.prizeRem15 = prizeRem15;
    }

    public Date getDatePurch() {
        return datePurch;
    }

    public void setDatePurch(Date datePurch) {
        this.datePurch = datePurch;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getGameTemplatesPartNum() {
        return gameTemplatesPartNum;
    }

    public void setGameTemplatesPartNum(String gameTemplatesPartNum) {
        this.gameTemplatesPartNum = gameTemplatesPartNum;
    }

}
