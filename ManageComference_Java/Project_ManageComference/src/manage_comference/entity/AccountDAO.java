/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_comference.entity;

import java.util.List;
import manage_comference.util.NewHibernateUtil;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
/**
 *
 * @author Admin
 */
public class AccountDAO {

    public static List<AdUser> checktontaiAccount(String username) {
        List<AdUser> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT acc FROM AdUser acc WHERE acc.username=:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static List<AdUser> checklogin(String username,String pass) {
        List<AdUser> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT acc FROM AdUser acc WHERE acc.username=:username and acc.passwordAcc=:pass";
            Query query = session.createQuery(hql);
            query.setString("username",username);
            query.setString("pass",pass);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static boolean addAcc(AdUser acc) {
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
//        if (SinhVienDAO.layThongTinSinhVien(sv.getMaSinhVien()) != null) {
//            return false;
//        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(acc);
            transaction.commit();
        } catch (HibernateException ex) {
//Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    
}
