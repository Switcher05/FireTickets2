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

import entity.Customers;
import main.resources.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Switcher
 */
public class CustomerDAO {
    Transaction trns = null;
    Session session;
    
    public void addCustomer(Customers cust){
        
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.save(cust);
            session.getTransaction().commit();
            
        }catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }
    }
    public void deleteCust(int custid){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            Customers cust = (Customers) session.load(Customers.class, new Integer(custid));
            session.delete(cust);
            session.getTransaction().commit();
            
        }catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateCustomer(Customers cust){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.update(cust);
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
    public List<Customers> getAllCustomers(){
        List<Customers> custs = new ArrayList<Customers>();
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            custs = session.createQuery("from Customers").list();
            
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return custs;
    }
    public Customers getCustById(String custid){
        Customers cust = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Customers where cust_id = :cust_id";
            Query q = session.createQuery(queryString);
            q.setParameter("cust_id", custid);
            cust = (Customers) q.uniqueResult();
        }catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cust;
    }
}
