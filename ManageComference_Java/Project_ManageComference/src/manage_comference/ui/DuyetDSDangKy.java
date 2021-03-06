/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_comference.ui;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import manage_comference.entity.AccountDAO;
import manage_comference.entity.AdUser;
import manage_comference.entity.Participants;
import manage_comference.entity.ParticipantsDAO;
import manage_comference.entity.ParticipantsSignup;
import manage_comference.entity.PaticipantsSignupDAO;
import manage_comference.util.NewHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class DuyetDSDangKy extends javax.swing.JFrame {

    /**
     * Creates new form DuyetDSDangKy
     */
    public DuyetDSDangKy() {
        initComponents();
        myinit();
    }

    public void myinit() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        //System.out.println("username " + userName.getText());
        //System.out.println("id " + list4.get(0).getIdAccount());
        List<ParticipantsSignup> list = PaticipantsSignupDAO.laytatcadsdadangky();
        //System.out.println("aaa");
//        List<ParticipantsSignup> list6 = PaticipantsSignupDAO.laydsdadangky(list4.get(0).getIdAccount());
        //System.out.println(list);

        for (ParticipantsSignup p : list) {
            Vector row = new Vector();
            row.add(p.getId());
            row.add(p.getAdUser().getIdAccount());
            row.add(p.getAdUser().getHoten());
            row.add(p.getHoinghi().getIdHn());
            row.add(p.getHoinghi().getTenHn());

            model.addRow(row);
        }
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("DUYỆT DANH SÁCH ĐĂNG KÝ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "ID Tài khoản", "Tên tài khoản", "ID Hội nghị", "Tên hội nghị"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(102, 255, 51));
        jButton1.setText("Duyệt vào danh sách tham dự");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Quay về trang chính");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(259, 259, 259))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();

        index = jTable1.convertRowIndexToModel(index);
//        model.getValueAt(index, 0))
        Session session = NewHibernateUtil.getSessionFactory()
                .openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query q = session.createSQLQuery("insert into participants values(null,:ID_PAR,:ID_COMFERENCE)");
//                System.out.println(getMd5(new String(mk.getText())));
            q.setParameter("ID_PAR", (int) model.getValueAt(index, 1));
            q.setParameter("ID_COMFERENCE", (int) model.getValueAt(index, 3));
            q.executeUpdate();
            transaction.commit();

            session = NewHibernateUtil.getSessionFactory()
                    .openSession();

            transaction = null;
            try {
                transaction = session.beginTransaction();
                q = session.createSQLQuery("DELETE FROM participants_signup WHERE ID=:id");
                q.setParameter("id", (int) model.getValueAt(index, 0));
                q.executeUpdate();
                transaction.commit();

                JOptionPane.showMessageDialog(null,
                        "Duyệt thành công");
                DuyetDSDangKy duyet = new DuyetDSDangKy();
                duyet.setVisible(false);
                 DuyetDSDangKy duyet2 = new DuyetDSDangKy();
                duyet2.setVisible(true);
                dispose();

            } catch (HibernateException ex) {
//Log the exception
                System.err.println(ex);
            } finally {
                session.close();
            }

        } catch (HibernateException ex) {
//Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          ListComference_User LU = new ListComference_User();
                LU.setVisible(true);
                //System.out.println(list.get(0).getUsername());
                LU.nameAcc.setText("admin2");
                LU.nameAcc.setVisible(true);
                LU.account.setVisible(true);
                LU.comboxLogIn.setVisible(false);

                LU.duyetds.setVisible(true);
                LU.suadoi.setVisible(true);

                dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DuyetDSDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DuyetDSDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DuyetDSDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DuyetDSDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DuyetDSDangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
