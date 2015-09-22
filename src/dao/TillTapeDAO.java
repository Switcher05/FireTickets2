package dao;




import entity.TillTape;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
