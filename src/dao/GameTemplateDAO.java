package dao;

import db.HibernateUtil;
import entity.GameTemplates;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Switcher on 9/21/2015.
 */
public class GameTemplateDAO {
    Transaction trns = null;
    Session session;

    public void addGameTemplat(GameTemplates gt){

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
    public void deleteGameTemplate(int gtid){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            GameTemplates gt = (GameTemplates) session.load(GameTemplates.class, new Integer(gtid));
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
    public void updateGameTemplate(GameTemplates gt){
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
    public List<GameTemplates> getAllGameTemplates(){
        List<GameTemplates> gts = new ArrayList<GameTemplates>();
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            gts = session.createQuery("from GameTemplates").list();

        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            releaseResources();
        }
        return gts;
    }
    public GameTemplates getGTById(String gtid){
        GameTemplates gt = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from GameTemplates gt where gt.id.partNum = :gtid";
            Query q = session.createQuery(queryString);
            q.setParameter("gtid", gtid);

            gt = (GameTemplates) q.uniqueResult();
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
