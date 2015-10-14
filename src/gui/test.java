/*
 * The MIT License
 *
 * Copyright 2015 Switcher.
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
package gui;

import dao.*;
import dao.Transaction;
import entity.*;
import db.DBUtil;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.HibernateUtil;
import entity.Customers;
import entity.GameTemplates;
import entity.Tickets;
import entity.SaleSessions;
import entity.Users;
import org.hibernate.Session;

import javax.transaction.*;

/**
 *
 * @author Switcher
 */
public class test {

    public static void main(String args[]){
//        int sale = 0;
//
//        sale = 90;
//        int prize = 0;
//        Transaction tx = new Transaction();
//        Users usr = new Users();
//        Customers cust = new Customers();
//        Locations loc = new Locations();
//        SaleSessions ss  = new SaleSessions();
//        SaleSessDAO ssDAO = new SaleSessDAO();
//
//        usr.setUserId(3);
//
//        loc.setLocId(1);
//        cust.setCustId(3);
//        tx.Sale(tx.getTicket("1164326"), sale, sale);
//        tx.tillTape(usr, cust, loc, 19, sale, prize, tx.getInvoice());
//        ssDAO.updateCurrent(81, sale, prize);


//        Transaction trn = new Transaction();
////        HashSet set1 = new HashSet();
////        set1.add(new User)
//       // trn.Sale(trn.getTicket("7536933"), 10, 10);
//        //trn.Prize(trn.getTicket("7536933"),);
//        int invoice = trn.getInvoice();
//        System.out.println("Invoice: " + invoice);
//        
        TillTape tt = new TillTape();
//        TillTapeId ttid = new TillTapeId();
        TillTapeDAO ttDAO = new TillTapeDAO();

        List<TillTape> ttlst = new ArrayList<>();
        ttlst = ttDAO.getAllTillTapeByInvoice(9999);
        tt = ttlst.get(0);
        System.out.println("Closed: " + tt.getSaleClosed());
        for (TillTape till : ttlst){
            till.setSaleClosed(true);
            ttDAO.updateTillTape(till);

        }



//        Users usr = new Users();
//        Customers cust = new Customers();
//        Locations loc = new Locations();
//        Tickets tk = new Tickets();
//        TicketDAO tkDAO = new TicketDAO();
//        //Get ticket by bin
//       tk = tkDAO.getTByBin(1);
//        tt.setSerial(tk.getId().getSerial());
//        tt.setName(tk.getId().getGameTemplatesPartNum());
//        tt.setSaleAmount(100);
//        tt.setPrizeAmount(0);
//
//       // ttid.getTId();
//        ttid.setCustomersCustId(3);
//        ttid.setLocationsLocId(1);
//        ttid.setUsersUserId(3);
//        tt.setId(ttid);
//      //  cust.setCustId(3);
//        //loc.setLocId(1);
//        //usr.setUserId(5);
//        //tt.setUsers(usr);
//        //tt.setCustomers(cust);
//       // tt.setLocations(loc);
//        tt.setInvoice(100);
//        tt.setVoid_(false);

//        ttDAO.addTrans(tt);

//        SaleSessDAO ssDAO = new SaleSessDAO();
//        SaleSessions ss = new SaleSessions();
//        //ssDAO.updateCurrent(68, "10");
//
//        CustomerDAO custDAO = new CustomerDAO();
//        Customers cust = new Customers();
//        cust.setFname("Josh");
//        cust.setLname("Duley");
//        cust.setAddress("133 Stone Road");
//        cust.setState("OH");
//        cust.setCity("Belpre");
//        cust.setTotalPrizes(0);
//        cust.setPhone("7404237234");
//        cust.setTotalSales(0);
//        custDAO.addCustomer(cust);
//        
//        custDAO.deleteCust(2);
//        cust.setAddress("704 washington blvd");
//        cust.setCustId(4);
//        custDAO.updateCustomer(cust);
//        custDAO.getAllCustomers().forEach(System.out::println);

//        GameTemplateDAO gtDAO = new GameTemplateDAO();
//        GameTemplates gt = new GameTemplates();
//        GameTemplatesId gtId = new GameTemplatesId();
//        gt = gtDAO.getGameTempByPart("ai0026");
//        System.out.println("Game name: " + gt.getGameName());
        /*
//        gt = gtDAO.getGTById("AI0026");
//        System.out.println(gt.getGameName());
            List<GameTemplates> gts = gtDAO.getAllGameTemplates();
            gt = (GameTemplates)gts.get(0);
            getAll(gt);
            gt = (GameTemplates)gts.get(20);
            getAll(gt);
        Tickets tk = new Tickets();
        TicketDAO tkdao = new TicketDAO();
        tk = tkdao.getTById("7536933");
        System.out.println(tk.getActualGross());

//           System.out.println("total" + gt.toString());
//        SaleSessDAO saleDAO = new SaleSessDAO();
//        SaleSessions saleses = new SaleSessions();
        //int id = saleses.getId();
//        int startbank = Integer.parseInt(saleses.getStartBank());
//        int gross = Integer.parseInt(saleses.getGrossSales());
//        int prizes = Integer.parseInt(saleses.getGrossPrizes());
//        int net = Integer.parseInt(saleses.getGrossNet());
//        double endbank = saleses.getEndingbank();
//        double curbank = saleses.getCurrentbank();
//        curbank += 100;
//        saleses.setCurrentbank(curbank);
//        saleDAO.updateCurrent(66,"100");
        
//        UserDAO dao = new UserDAO();
//        Users user = new Users();
//        user.setName("Josh");
//        user.setPassword("josh");
//       dao.addUser(user);
 

    }
        private static void getAll(GameTemplates gameTemplates){
                System.out.println("GameNAme:" + gameTemplates.getGameName());
                */
        }

}
