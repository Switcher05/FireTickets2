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
package dao;

import entity.*;
import gui.SellingMain;
import main.resources.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Ryan
 */
public class Transaction {
    Session session;
    Tickets tks;
    public static GameTemplateDAO gtDAO;
    public static GameTemplates gt;
    public static Tickets tk;
    public static TicketDAO tkDAO;
    public static Customers cust;
    public static Transaction tx;
    public static Users usr;
    public static UserDAO usrDAO;
    public static SaleSessions ss;
    public static SaleSessDAO ssDAO;
    public static Locations loc;
    public static CustomerDAO custDAO;
    public TillTapeDAO ttDAO;

    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }

    public Tickets getTicketBin(int bin) {
        TicketDAO tDAO = new TicketDAO();
        Tickets tk = new Tickets();
        tk = tDAO.getTByBin(bin);
        return tk;
    }

    public void Sale(Tickets tk, int  amount, int value){
        //Update tickets table with, add till tape, update sale session,
        //add sales to customer
        TicketDAO tDAO = new TicketDAO();
        System.out.println(tk.toString());
        int gross = tk.getActualGross();
        gross = gross + amount;
        int unsold = tk.getUnsoldAmt();
        unsold = unsold - value;
        int unsoldTickets = tk.getUnsoldTickets();
        unsoldTickets = unsoldTickets - amount;
        tk.setActualGross(gross);
        tk.setUnsoldAmt(unsold);
        tk.setUnsoldTickets(unsoldTickets);
        tDAO.updateTickets(tk);

    }

    public void Prize(Tickets tk, int prize){
        //Need method to subtract prize
        TicketDAO tDAO = new TicketDAO();
        int prizes = tk.getActualPrizes();
        prizes = prizes + prize;
        tk.setActualPrizes(prizes);
        tDAO.updateTickets(tk);

    }

    public int getInvoice(){
        session = getSession();
        Criteria criteria = session
                .createCriteria(TillTape.class)
                .setProjection(Projections.max("invoice"));
        Integer maxInvoice = (Integer)criteria.uniqueResult();
        int invoice = maxInvoice + 1;
        return invoice;
    }

    public Session getSession() {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

        }catch (HibernateException he) {
            he.printStackTrace();
        }
        return session;
    }

    public void updateTicket(Tickets tk, int amount, int prizeIn, int value) {
        int gross = tk.getActualGross();
        int prize = tk.getActualPrizes();
        int net = tk.getActualNet();
        int unsold = tk.getUnsoldTickets();
        int unsoldValue = tk.getUnsoldAmt();
        gross = gross + amount;
        prize = prize + prizeIn;
        net = gross - prize;
        unsold = unsold - amount;
        unsoldValue = unsoldValue - value;
        tk.setActualGross(gross);
        tk.setActualPrizes(prize);
        tk.setActualNet(net);
        tk.setUnsoldAmt(unsoldValue);
        tk.setUnsoldTickets(unsold);
        TicketDAO tkDAO = new TicketDAO();
        tkDAO.updateTickets(tk);


    }

    public void tillTape(Users us, Customers cust, Locations loc, int bin, int sale, int prize, int invoice) {
        //serial, name, time, sale_amount, prize_amount, users_user_id, customers_cust_id, locations_loc_id, invoice, sale closed, void
        TillTape tt = new TillTape();
        TillTapeId ttid = new TillTapeId();
        TillTapeDAO ttDAO = new TillTapeDAO();
        Users usr = new Users();

        Tickets tk = new Tickets();
        TicketDAO tkDAO = new TicketDAO();

        tk = tkDAO.getTByBin(bin); //Get ticket by bin
        tt.setSerial(tk.getId().getSerial());
        tt.setName(tk.getId().getGameTemplatesPartNum()); //TODO: change to game name instead of part num
        tt.setSaleAmount(sale);
        tt.setPrizeAmount(prize);

        ttid.setCustomersCustId(cust.getCustId());
        ttid.setLocationsLocId(loc.getLocId());
        ttid.setUsersUserId(us.getUserId());

        tt.setId(ttid);
        tt.setTime(getCurrentTimeStamp());
        tt.setCustomers(cust);
        tt.setLocations(loc);
        tt.setInvoice(invoice);
        tt.setVoid_(false);

        ttDAO.addTrans(tt);

    }

    public boolean findPrizeAmt(Tickets tk, Integer prizeAmt) {
        //TODO: needs to detect if the the prizeAmt is valid, if so subtract one from the ticket
        int amount;
        GameTemplates gt = new GameTemplates();
        GameTemplateDAO gtDAO = new GameTemplateDAO();
        TicketDAO ttDAO = new TicketDAO();
        //Load the gametemplate based on the part number
        gt = gtDAO.getGTById(tk.getId().getGameTemplatesPartNum());
        //TODO:need to add the last sale
        List<Integer> gameTemps = Arrays.asList(gt.getPrizeAmt1(), gt.getPrizeAmt2(), gt.getPrizeAmt3(), gt.getPrizeAmt4(), gt.getPrizeAmt5(), gt.getPrizeAmt6(),
                gt.getPrizeAmt7(), gt.getPrizeAmt8(), gt.getPrizeAmt9(), gt.getPrizeAmt10(), gt.getPrizeAmt11(), gt.getPrizeAmt12(), gt.getPrizeAmt13(), gt.getPrizeAmt14(), gt.getPrizeAmt15());
        for (int i =0; i < gameTemps.size(); i++){
            int num = gameTemps.get(i);
            if (num == 0){
                return false;
            }
            if (prizeAmt == num){

                if (i == 0){
                    amount = tk.getPrizeRem1();
                    tk.setPrizeRem1(amount--);
                    break;
                }else if (i == 1) {
                    amount = tk.getPrizeRem2();
                    tk.setPrizeRem2(amount--);
                    break;
                }else if (i == 2){
                    amount = tk.getPrizeRem3();
                    tk.setPrizeRem3(amount--);
                    break;
                }else if (i == 3){
                    amount = tk.getPrizeRem4();
                    tk.setPrizeRem4(amount--);
                    break;
                }else if (i == 4 ){
                    amount = tk.getPrizeRem5();
                    tk.setPrizeRem5(amount--);
                    break;
                }else if (i == 5){
                    amount = tk.getPrizeRem6();
                    tk.setPrizeRem6(amount--);
                    break;
                }else if (i == 6){
                    amount = tk.getPrizeRem7();
                    tk.setPrizeRem7(amount--);
                    break;
                }else if (i == 7){
                    amount = tk.getPrizeRem8();
                    tk.setPrizeRem8(amount--);
                    break;
                }else if (i == 8){
                    amount = tk.getPrizeRem9();
                    tk.setPrizeRem9(amount--);
                    break;
                }else if (i == 9){
                    amount = tk.getPrizeRem10();
                    tk.setPrizeRem10(amount--);
                    break;
                }else if (i == 10){
                    amount = tk.getPrizeRem11();
                    tk.setPrizeRem12(amount--);
                    break;
                }else if (i == 11){
                    amount = tk.getPrizeRem12();
                    tk.setPrizeRem12(amount--);
                    break;
                }else if (i == 12){
                    amount = tk.getPrizeRem13();
                    tk.setPrizeRem13(amount--);
                    break;
                }else if (i ==13){
                    amount = tk.getPrizeRem14();
                    tk.setPrizeRem14(amount--);
                    break;
                }else if (i== 14) {
                    amount = tk.getPrizeRem15();
                    tk.setPrizeRem15(amount--);
                    break;
                }else{
                    return false;
                }

            }
        }
        //Update the ticket
        ttDAO.addTickets(tk);
        return true;
    }
    public boolean closeTransaction(List<TxObject> lst){
        ss = new SaleSessions();
        ssDAO = new SaleSessDAO();
        tks = new Tickets();
        final int len = lst.size();

        for (int i = 0; i < len; i++){
            if (lst.get(i).getType() == 1){
                //sale
                tks = getTicketBin(lst.get(i).getBin());
                Sale(tks, (int)lst.get(i).getValue(), (int)lst.get(i).getValue());
                tillTape(SellingMain.usr,SellingMain.cust,SellingMain.loc, lst.get(i).getBin(),(int)lst.get(i).getValue(), 0, SellingMain.invoice);
                ss = ssDAO.getSSById(String.valueOf(SellingMain.sessionNum));
                double gross = ss.getGrossSales();
                double bank = ss.getCurrentbank();
                ss.setGrossSales(gross + lst.get(i).getValue());
                ss.setCurrentbank(bank + lst.get(i).getValue());
                ss.setGrossNet(ss.getGrossSales() - ss.getGrossPrizes());
                ssDAO.addSession(ss);
            }else if (lst.get(i).getType() == 2){
                //prize
                tks = SellingMain.tk;
                Prize(tks, (int)lst.get(i).getValue());
                tillTape(SellingMain.usr,SellingMain.cust,SellingMain.loc, lst.get(i).getBin(),0, (int)lst.get(i).getValue(), SellingMain.invoice);
                ss = ssDAO.getSSById(String.valueOf(SellingMain.sessionNum));
                double grossSale = ss.getGrossSales();
                double grossPrize = ss.getGrossPrizes();
                ss.setGrossPrizes(grossSale + lst.get(i).getValue());
                ss.setCurrentbank(grossPrize - lst.get(i).getValue());
                ss.setGrossNet(ss.getGrossSales() - ss.getGrossPrizes());
                ssDAO.addSession(ss);

            }
        }
        return true;
    }

}
