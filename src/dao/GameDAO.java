package dao;

import entity.Game;
import main.resources.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;

/**
 * Created by Switcher on 10/8/2015.
 */
public class GameDAO {
  Transaction trns = null;
    Session session;
    public Game getGameId(String serial){
        Game game = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String qString = "from GameTemplates gt, Tickets t where gt.id.partNum = t.id.gameTemplatesPartNum and t.id.serial = :serial";
            Query q = session.createQuery(qString);
            q.setParameter("serial", serial);
            game = (Game) q.uniqueResult();
        } catch (RuntimeException e){
            if (trns != null){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No game by that serial: " + serial);
            }
        } finally {
            releaseResources();
        }return game;
    }
    public void releaseResources(){
        session.flush();
        session.close();
    }

}
