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

import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.SaleSessions;
import db.HibernateUtil;
import org.hibernate.Query;

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
            session.save(saleSess);
            session.getTransaction().commit();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.close();
            session.flush();
        }
    }
    public void updateCurrent(Integer SessionID, String sale){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            SaleSessions saleses = (SaleSessions)session.get(SaleSessions.class, SessionID);
            saleses.setStartBank(sale);
            
            session.update(saleses);
            session.getTransaction().commit();
        } catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
