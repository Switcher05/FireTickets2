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

import dao.CustomerDAO;
import dao.GameTemplateDAO;
import dao.SaleSessDAO;
import db.DBUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.UserDAO;
import db.HibernateUtil;
import entity.Customers;
import entity.GameTemplates;
import entity.SaleSessions;
import entity.Users;
import java.util.List;

/**
 *
 * @author Switcher
 */
public class test {
    public static void main(String args[]){
/*        CustomerDAO custDAO = new CustomerDAO();
        Customers cust = new Customers();
        cust.setFname("Josh");
        cust.setLname("Duley");
        cust.setAddress("133 Stone Road");
        cust.setState("OH");
        cust.setCity("Belpre");
        cust.setTotalPrizes(0);
        cust.setPhone("7404237234");
        cust.setTotalSales(0);
        custDAO.addCustomer(cust);
        
        custDAO.deleteCust(2);
        cust.setAddress("704 washington blvd");
        cust.setCustId(4);
        custDAO.updateCustomer(cust);
        custDAO.getAllCustomers().forEach(System.out::println);*/

        GameTemplateDAO gtDAO = new GameTemplateDAO();
        GameTemplates gt = new GameTemplates();
//        gt = gtDAO.getGTById("AI0026");
//        System.out.println(gt.getGameName());
            List<GameTemplates> gts = gtDAO.getAllGameTemplates();
            gt = (GameTemplates)gts.get(0);
            System.out.println(gt.getGameName());
            gt = (GameTemplates)gts.get(20);
            System.out.println("GameName:" + gt.getGameName());
           System.out.println("Game: "+ gt.getGameCost());
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
}
