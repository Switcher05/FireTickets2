package dao;

import entity.GameTemplates;
import entity.GameTemplatesId;
import main.resources.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by Switcher on 9/21/2015.
 */
public class GameTemplateDAO{
    private static final Logger LOG = Logger.getLogger(GameTemplateDAO.class.getName());
    Transaction tx = null;
    Session session;
    public GameTemplateDAO(){

    }

    public void addGameTemplate(GameTemplates gt){

        session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.save(gt);
            session.getTransaction().commit();

        }catch (RuntimeException e){
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            releaseResources();
        }
    }
    public void deleteGameTemplate(int gtid){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            GameTemplates gt = (GameTemplates) session.load(GameTemplates.class, new Integer(gtid));
            session.delete(gt);
            session.getTransaction().commit();

        }catch (RuntimeException e){
            if (tx != null){
                tx.rollback();
            }
        } finally {
            releaseResources();
        }
    }
    public void updateGameTemplate(GameTemplates gt){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            tx = session.beginTransaction();
            session.update(gt);
            session.getTransaction().commit();
        } catch (RuntimeException e){
            if (tx != null){
                tx.rollback();
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
            tx = session.beginTransaction();
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
            tx = session.beginTransaction();
            String queryString = "from GameTemplates gt where gt.id.partNum = :gtid";
            Query q = session.createQuery(queryString);
            q.setParameter("gtid", gtid);

            gt = (GameTemplates) q.uniqueResult();
        }catch (RuntimeException e){
            
            if(tx != null){
                 e.printStackTrace();
                 JOptionPane.showMessageDialog(null, "No Game Template found - " + gtid);
                 tx.rollback();
            }
        } finally {
            releaseResources();
        }
        return gt;
    }

    public GameTemplates getGameTempByPart(String partNum) {
        GameTemplates gt = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            GameTemplatesId gtId = new GameTemplatesId();
            gtId.setPartNum(partNum);
            gt = (GameTemplates) session.get(GameTemplates.class, gtId);
            System.out.println("Game name: " + gt.getGameName());
        } catch (RuntimeException e) {
            if (tx != null) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No game template by part number : " + partNum);
            }
        }
        return gt;
    }
    public void releaseResources(){
        session.flush();
        session.close();
    }
}
