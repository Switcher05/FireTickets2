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
package dao;

import entity.SaleSessions;
import main.resources.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;

/**
 *
 * @author Switcher
 */
public class SaleSessDAO {
    Transaction trns = null;
    Session session;
    public void addSession(SaleSessions saleSess){

        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.saveOrUpdate(saleSess);
            session.getTransaction().commit();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            releaseResources();
        }
    }

    public void updateCurrent(Integer SessionID, int sale, int prize){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            SaleSessions saleses = (SaleSessions)session.get(SaleSessions.class, SessionID);
            double grossSales, grossPrizes, grossNet, currentBank;
            grossSales = saleses.getGrossSales();
            grossPrizes = saleses.getGrossPrizes();
            grossNet = saleses.getGrossNet();
            currentBank = saleses.getCurrentbank();
            grossSales = grossSales + sale;
            grossPrizes = grossPrizes + prize;
            grossNet = grossSales - grossPrizes;
            currentBank = currentBank + sale - prize;
            saleses.setCurrentbank(currentBank);
            saleses.setGrossSales(grossSales);
            saleses.setGrossPrizes(grossPrizes);
            saleses.setGrossNet(grossNet);

            session.update(saleses);
            session.getTransaction().commit();
        } catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            releaseResources();
        }
    }

    public SaleSessions getSSById(String ssid) {
        SaleSessions ss = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from SaleSessions ss where ss.id = :ssid";
            Query q = session.createQuery(queryString);
            q.setParameter("ssid", ssid);

            ss = (SaleSessions) q.uniqueResult();
        } catch (RuntimeException e) {

            if (trns != null) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No Sale Session found - " + ssid);
                trns.rollback();
            }
        } finally {
            releaseResources();
        }
        return ss;
    }

    public SaleSessions fetchOpenSS() {
        SaleSessions ss = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //a session from the same day, with endingbank as null, or max value of the session id
            String queryString = "from SaleSessions ss where ss.endingbank = 1";
            Query q = session.createQuery(queryString);

            ss = (SaleSessions) q.uniqueResult();
//            Criteria criteria = session
//                    .createCriteria(SaleSessions.class)
//                    .setProjection(Projections.max("id"))
//            ss = (SaleSessions)criteria.uniqueResult();
        } catch (RuntimeException e) {

            if (trns != null) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No Sale Session found");
                trns.rollback();
            }
        } finally {
            releaseResources();
        }
        return ss;
    }

    public void releaseResources() {
        session.flush();
        session.close();
    }
}
