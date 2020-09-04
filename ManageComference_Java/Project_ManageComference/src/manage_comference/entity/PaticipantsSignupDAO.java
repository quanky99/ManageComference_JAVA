/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_comference.entity;

import java.util.List;
import manage_comference.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class PaticipantsSignupDAO {

    public static List<ParticipantsSignup> searchtenHN(int iduser, String tenhn) {
        List<ParticipantsSignup> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM ParticipantsSignup par JOIN par.hoinghi hn WHERE par.adUser.idAccount=:iduser AND hn.tenHn=:tenHn ";
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

    public static List<ParticipantsSignup> searchtenDD(int iduser, String tendd) {
        List<ParticipantsSignup> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM ParticipantsSignup par JOIN par.hoinghi hn JOIN hn.diadiem dd WHERE par.adUser.idAccount=:iduser AND dd.tenDd=:tendd ";
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

    public static List<ParticipantsSignup> layDanhSachKhachDangKy(String idHn) {
        List<ParticipantsSignup> ds2 = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql2 = "SELECT par FROM ParticipantsSignup par WHERE par.hoinghi=" + idHn;
            Query query = session.createQuery(hql2);
            ds2 = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds2;
    }

    public static List<ParticipantsSignup> checkdangkyhn(int iduser, int idcom) {
        List<ParticipantsSignup> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM ParticipantsSignup par WHERE par.adUser.idAccount=:iduser and par.hoinghi.idHn=:idcom";
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

    public static List<ParticipantsSignup> laydsdadangky(int iduser) {
        List<ParticipantsSignup> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM ParticipantsSignup par WHERE par.adUser.idAccount=:iduser";
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

    public static List<ParticipantsSignup> laytatcadsdadangky() {
        List<ParticipantsSignup> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT par FROM ParticipantsSignup par ";
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
}
