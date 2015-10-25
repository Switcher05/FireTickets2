package dao;


<<<<<<< HEAD
=======


import db.HibernateUtil;
>>>>>>> origin/master
import entity.TillTape;
import main.resources.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import static main.resources.HibernateUtil.getSessionFactory;
=======
import static db.HibernateUtil.getSessionFactory;
>>>>>>> origin/master

/**
 * Created by Switcher on 9/21/2015.
 */
public class TillTapeDAO {

    Transaction tx = null;
    Session sess;
    Query q;
    public void addTrans(TillTape tt){
        sess = getSessionFactory().openSession();
        try {
            tx = sess.beginTransaction();
            sess.saveOrUpdate(tt);
            sess.getTransaction().commit();
        } catch (RuntimeException re){
            if (tx != null){
                tx.rollback();
            }
            re.printStackTrace();
        } finally {
            sess.flush();
            sess.close();

        }
    }
    public void deleteTillTape(int ttid){
        sess = getSessionFactory().openSession();
        try{
            tx = sess.beginTransaction();
            TillTape tt = (TillTape) sess.load(TillTape.class, new Integer(ttid));
            sess.delete(tt);
            sess.getTransaction().commit();

        }catch (RuntimeException e){
            if (tx != null){
                tx.rollback();
            }
        } finally {
            sess.flush();
            sess.close();
        }
    }
    public void updateTillTape(TillTape tt){
        sess = getSessionFactory().openSession();
        try{
            tx = sess.beginTransaction();
            sess.update(tt);
            sess.getTransaction().commit();
        } catch (RuntimeException e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sess.flush();
            sess.close();
        }
    }
<<<<<<< HEAD

    public void closeSale(int invoice) {
        sess = getSessionFactory().openSession();
        try {
=======
    public void closeSale(int invoice){
        sess = getSessionFactory().openSession();
        try{
>>>>>>> origin/master
            tx = sess.beginTransaction();
            String sql = "update TillTape tt set tt.saleClosed = true where tt.invoice = :invoice";
            String queryString = "from Tickets gt where gt.id.serial = :serial";
            Query q = sess.createQuery(sql);
            q.setParameter("invoice", invoice);
            int result = q.executeUpdate();
            System.out.println("Updated invoices: " + result + " from invoice num: " + invoice);
            sess.getTransaction().commit();
<<<<<<< HEAD
        } catch (RuntimeException e) {
            if (tx != null) {
=======
        } catch (RuntimeException e){
            if (tx != null){
>>>>>>> origin/master
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            sess.flush();
            sess.close();
        }
    }
<<<<<<< HEAD

    public List<TillTape> getAllTillTapeByInvoice(int invoice) {
        List<TillTape> tt = new ArrayList<TillTape>();
        sess = HibernateUtil.getSessionFactory().openSession();
        try {
=======
    public List<TillTape> getAllTillTapeByInvoice(int invoice){
        List<TillTape> tt = new ArrayList<TillTape>();
        sess = HibernateUtil.getSessionFactory().openSession();
        try{
>>>>>>> origin/master
            tx = sess.beginTransaction();

            tt = sess.createQuery("from TillTape where invoice = :invoice")
                    .setParameter("invoice", invoice)
                    .list();


<<<<<<< HEAD
        } catch (RuntimeException e) {
=======

        } catch (RuntimeException e){
>>>>>>> origin/master
            e.printStackTrace();
        } finally {
            releaseResources();
        }
        return tt;
    }
<<<<<<< HEAD

    public void releaseResources() {
=======
    public void releaseResources(){
>>>>>>> origin/master
        sess.flush();
        sess.close();
    }

}
