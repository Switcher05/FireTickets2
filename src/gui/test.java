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

import dao.SaleSessDAO;
import db.DBUtil;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.UserDAO;
import entity.SaleSessions;
import entity.Users;

/**
 *
 * @author Switcher
 */
public class test {
    public static void main(String args[]){
        SaleSessDAO saleDAO = new SaleSessDAO();
        SaleSessions saleses = new SaleSessions();
        //int id = saleses.getId();
//        int startbank = Integer.parseInt(saleses.getStartBank());
//        int gross = Integer.parseInt(saleses.getGrossSales());
//        int prizes = Integer.parseInt(saleses.getGrossPrizes());
//        int net = Integer.parseInt(saleses.getGrossNet());
//        double endbank = saleses.getEndingbank();
//        double curbank = saleses.getCurrentbank();
//        curbank += 100;
//        saleses.setCurrentbank(curbank);
        saleDAO.updateCurrent(66,"100");
        
//        UserDAO dao = new UserDAO();
//        Users user = new Users();
//        user.setName("Josh");
//        user.setPassword("josh");
//       dao.addUser(user);
    }
}
