package dao;

import db.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.FormatFlagsConversionMismatchException;

/**
 * Created by Ryan on 10/13/2015.
 */
public class Worker extends Thread{
    private Session session = null;
    Worker(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        session.setFlushMode(FlushMode.ALWAYS);
    }
    public void run(){
//        for ()
//        {
//
//        }
    }
}
