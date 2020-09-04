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
public class ParticipantsDAO {

    public static List<Participants> checkdangkyhn(int iduser, int idcom) {
        List<Participants> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM Participants par WHERE par.adUser.idAccount=:iduser and par.hoinghi.idHn=:idcom";
            Query query = session.createQuery(hql);
            query.setInteger("iduser", iduser);
            query.setInteger("idcom", idcom);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
     public static List<Participants> laydsthamdu(int iduser) {
        List<Participants> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM Participants par WHERE par.adUser.idAccount=:iduser";
            Query query = session.createQuery(hql);
            query.setInteger("iduser", iduser);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static List<Long> countUser(Integer idcom) {
        List<Long> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT count(par.adUser.idAccount)  FROM Participants par WHERE par.hoinghi.idHn=" + idcom;
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
     public static List<Participants> searchtenHN(int iduser, String tenhn) {
        List<Participants> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM Participants par JOIN par.hoinghi hn WHERE par.adUser.idAccount=:iduser AND hn.tenHn=:tenHn ";
            Query query = session.createQuery(hql);
            query.setString("tenHn", tenhn);
            query.setInteger("iduser", iduser);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
      public static List<Participants> searchtenDD(int iduser, String tendd) {
        List<Participants> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM Participants par JOIN par.hoinghi hn JOIN hn.diadiem dd WHERE par.adUser.idAccount=:iduser AND dd.tenDd=:tendd ";
            Query query = session.createQuery(hql);
            query.setString("tendd", tendd);
            query.setInteger("iduser", iduser);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
}
