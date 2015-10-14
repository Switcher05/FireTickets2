package dao;




import db.HibernateUtil;
import entity.TillTape;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import static db.HibernateUtil.getSessionFactory;

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
            sess.save(tt);
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
    public void closeSale(int invoice){
        sess = getSessionFactory().openSession();
        try{
            tx = sess.beginTransaction();
            String sql = "update TillTape tt set tt.saleClosed = true where tt.invoice = :invoice";
            String queryString = "from Tickets gt where gt.id.serial = :serial";
            Query q = sess.createQuery(sql);
            q.setParameter("invoice", invoice);
            int result = q.executeUpdate();
            System.out.println("Updated invoices: " + result + " from invoice num: " + invoice);
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
    public List<TillTape> getAllTillTapeByInvoice(int invoice){
        List<TillTape> tt = new ArrayList<TillTape>();
        sess = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = sess.beginTransaction();

            tt = sess.createQuery("from TillTape where invoice = :invoice")
                    .setParameter("invoice", invoice)
                    .list();



        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            releaseResources();
        }
        return tt;
    }
    public void releaseResources(){
        sess.flush();
        sess.close();
    }

}
