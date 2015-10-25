/*
 * The MIT License
 *
 * Copyright 2015 Switcher.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dao;

import entity.Users;
import main.resources.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Switcher
 */
public class UserDAO {
    Transaction trns = null;
    
    public void addUser(Users user){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            
        }catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        }finally {
            session.flush();
            session.close();
        }
    }
    public void deleteUser(int userid){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            Users user = (Users) session.load(Users.class, new Integer(userid));
            session.delete(user);
            session.getTransaction().commit();
            
        }catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    public void updateUser(Users user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e){
            if (trns != null){
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public List<Users> getAllUsers(){
        List<Users> users = new ArrayList<Users>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            users = session.createQuery("from Users").list();
            
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    public Users getUserById(int userid){
        Users user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String queryString = "from Users where user_id = :user_id";
            Query q = session.createQuery(queryString);
            q.setInteger("id", userid);
            user = (Users) q.uniqueResult();
        }catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }

    public boolean Login(Users usr) {
        Users user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Users where name = :name ";
            Query q = session.createQuery(queryString);
            q.setParameter("name", usr.getName());
            // .setParameter("password", usr.getPassword());
            user = (Users) q.uniqueResult();
            if (user != null) {
                if (user.getPassword().equals(usr.getPassword())) {
                    return true;
                }

            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return false;
    }
}
