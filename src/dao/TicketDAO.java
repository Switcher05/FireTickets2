package dao;

import entity.Tickets;
import main.resources.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Switcher on 9/22/2015.
 */
public class TicketDAO {
    Transaction trns = null;
    Session session;

    public void addTickets(Tickets tt) {

        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.saveOrUpdate(tt);
            session.getTransaction().commit();

        }catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }finally {
            releaseResources();
        }
    }
    public void deleteTickets(int gtid){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            Tickets gt = (Tickets) session.load(Tickets.class, new Integer(gtid));
            session.delete(gt);
            session.getTransaction().commit();

        }catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
        } finally {
            releaseResources();
        }
    }

    public void updateTickets(Tickets tk) {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            tk.setActualNet((tk.getActualGross() - tk.getActualPrizes()));
            session.update(tk);
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
    public List<Tickets> getAllTickets(){
        List<Tickets> ts = new ArrayList<Tickets>();
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            ts = session.createQuery("from Tickets").list();

        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            releaseResources();
        }
        return ts;
    }
    public List<Tickets> get30Tickets(){
        List<Tickets> ts = new ArrayList<Tickets>();
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            ts = session.createQuery("from Tickets where inplay = 1 and bin < 30 ORDER BY bin ASC").list();

        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            releaseResources();
        }
        return ts;
    }
    public Tickets getTById(String serial){
        Tickets gt = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Tickets gt where gt.id.serial = :serial";
            Query q = session.createQuery(queryString);
            q.setParameter("serial", serial);

            gt = (Tickets) q.uniqueResult();
        }catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            releaseResources();
        }
        return gt;
    }
    public Tickets getTByBin(int Bin){
        Tickets tk = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Tickets tk where inplay = 1 and tk.bin = :bin";
            Query q = session.createQuery(queryString);
            q.setParameter("bin", Bin);

            tk = (Tickets)q.uniqueResult();
        }catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            releaseResources();
        }
        return tk;
    }
    public void releaseResources(){
        session.flush();
        session.close();
    }
}
