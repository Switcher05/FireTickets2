package dao;

import db.HibernateUtil;
import entity.Tickets;
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

    public void addTickets(Tickets gt){

        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.save(gt);
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
    public void deleteTicketsint gtid){
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
    public void updateTickets(Tickets gt){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.update(gt);
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
        return gts;
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
    public void releaseResources(){
        session.flush();
        session.close();
    }
}
