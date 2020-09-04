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

/**
 *
 * @author Admin
 */
public class HoiNghiDAO {

    public static List<Hoinghi> layDanhSachHoiNghi() {
        List<Hoinghi> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "SELECT hn FROM Hoinghi hn";
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
    public static List<Hoinghi> layDanhSachHoiNghiTheoID(int idHn) {
        List<Hoinghi> ds = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
           String hql = "SELECT hn FROM Hoinghi hn WHERE hn.idHn=:idHn AND hn.thoigian < Now()";
            Query query = session.createQuery(hql);
            query.setInteger("idHn", idHn);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static List<Participants> layDanhSachKhachThamDu(String idHn) {
        List<Participants> ds2 = null;
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql2 = "SELECT par FROM Participants par WHERE par.hoinghi=:idHn";
            Query query = session.createQuery(hql2);
            query.setString("idHn", idHn);
            ds2 = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds2;
    }
}
