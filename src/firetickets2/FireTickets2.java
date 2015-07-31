/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firetickets2;

import entity.Game_Templates;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import db.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Switcher
 */
public class FireTickets2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
        String test = "Test";
          
        Game_Templates gt = (Game_Templates) session.get(Game_Templates.class, test);
        String gamename = gt.getGameName();
        System.out.println("Game name:" + gamename);
    
//      Game_Templates gt = new Game_Templates(5);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(FireTickets2.class.getName()).log(Level.SEVERE, null, ex);
//        }
      //gt.setPartNum(test);
        session.save(gt);  
        session.getTransaction().commit();  
          
        session.close();  
  
    }
    
}
