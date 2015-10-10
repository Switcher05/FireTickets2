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

import db.HibernateUtil;
import entity.*;
import entity.Tickets;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;


/**
 *
 * @author Ryan
 */
public class Transaction {
    Session session;
    Query q;
    private String LOAD_BUTTON = "";
    public Tickets getTicket(String serial){
        TicketDAO tDAO = new TicketDAO();
        Tickets tk = new Tickets();
        tk = tDAO.getTById(serial);
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
    
    private Session getSession(){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
        }catch (HibernateException he) {
            he.printStackTrace();
        }
        return session;
    }
    public void Net(Tickets tk){
        //update net
        int net;
        net = tk.getActualGross() - tk.getActualPrizes();
        tk.setActualNet(net);
    }
    public void tillTape(Tickets tk, Users us, Customers cust, Locations loc, int sale, int prize, int invoice){
        //serial, name, time, sale_amount, prize_amount, users_user_id, customers_cust_id, locations_loc_id, invoice
        TillTape tt = new TillTape();
        TillTapeDAO ttDao = new TillTapeDAO();
        tt.setSerial(tk.getId().getSerial());
        //needs changed to game name
        tt.setName(tk.getId().getGameTemplatesPartNum());
        tt.setSaleAmount(sale);
        tt.setTime(getCurrentTimeStamp());
        tt.setPrizeAmount(prize);
        tt.setUsers(us);
        tt.setCustomers(cust);
        tt.setLocations(loc);
        tt.setInvoice(invoice);

        ttDao.addTrans(tt);
    }
    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
    public void SaleSessionUpdate(int sale, int prize){
        SaleSessions ss = new SaleSessions();
        SaleSessDAO ssDAO = new SaleSessDAO();
        //ss = ssDAO.updateCurrent();
    }
}
