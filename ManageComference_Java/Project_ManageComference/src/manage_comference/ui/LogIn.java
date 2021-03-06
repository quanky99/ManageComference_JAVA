/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_comference.ui;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JOptionPane;
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
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        idhn = new javax.swing.JLabel();
        loaimh = new javax.swing.JLabel();
        hn = new javax.swing.JLabel();
        sizeDiaDiem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1165, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");

        jLabel2.setText("Tên đăng nhập");

        jLabel3.setText("Mật khẩu");

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButton1.setText("Đăng Nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        loaimh.setText("jLabel4");

        hn.setText("jLabel4");

        sizeDiaDiem.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loaimh)
                            .addComponent(idhn)
                            .addComponent(hn))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sizeDiaDiem)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(487, 487, 487)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(482, 482, 482)
                        .addComponent(jLabel1)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jButton1)
                .addGap(22, 22, 22)
                .addComponent(loaimh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hn)
                    .addComponent(sizeDiaDiem))
                .addGap(35, 35, 35)
                .addComponent(idhn)
                .addGap(22, 22, 22))
        );

        loaimh.setVisible(false);
        hn.setVisible(false);
        sizeDiaDiem.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (userName.getText().isEmpty() || pass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng nhập đầy đủ thông tin");
        } else {
            System.out.println(getMd5(new String(pass.getText())));
            List<AdUser> list = AccountDAO.checklogin(userName.getText(), getMd5(new String(pass.getText()))); //check đúng tài khoản chưa
            //System.out.println(list.get(0).getHoten());
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Nhập sai tên đăng nhập hoặc mật khẩu");
            } else {
                //System.out.println(loaimh.getText()+" idhn: "+ hn.getText()+" size "+ sizeDiaDiem.getText());
                if (loaimh.getText().equals("detail_khach")) {
                    //check đăng kí hôi nghị chưa
                    System.out.println("idaccount: " + list.get(0).getIdAccount() + "mahn " + hn.getText());
                    List<Participants> list2 = ParticipantsDAO.checkdangkyhn(list.get(0).getIdAccount(), Integer.parseInt(hn.getText()));
                    List<ParticipantsSignup> list4 = PaticipantsSignupDAO.checkdangkyhn(list.get(0).getIdAccount(), Integer.parseInt(hn.getText()));
                    System.out.println(list2);
                    if (list4.isEmpty()) {
                        if (list2.isEmpty()) {
                            List<Long> listCountUser = ParticipantsDAO.countUser(Integer.parseInt(hn.getText()));
                            Long count = listCountUser.get(0);
                            System.out.println(count);
//                        System.out.println("countUser: " + listCountUser.get(0) + " size of diadiem: " + sizeDiaDiem.getText());
//                        Kiểm tra diadiem đó có full người tham dự chưa
                            if (count < Long.parseLong(sizeDiaDiem.getText())) {
                                Session session = NewHibernateUtil.getSessionFactory()
                                        .openSession();

                                Transaction transaction = null;

                                try {
                                    transaction = session.beginTransaction();
//                            System.out.println("id_par: " + list.get(0).getIdAccount() + " id_com " + Integer.parseInt(idhn.getText()));

                                    Query q = session.createSQLQuery("insert into participants_signup values(null,:ID_PAR,:ID_COMFERENCE)");
                                    q.setParameter("ID_PAR", list.get(0).getIdAccount());
                                    q.setParameter("ID_COMFERENCE", Integer.parseInt(hn.getText()));
                                    q.executeUpdate();
                                    transaction.commit();
                                    JOptionPane.showMessageDialog(null,
                                            "Đăng ký tham dự hội nghị thành công");

//                                 Quay lai trang listComference
                                    ListComference_User LU = new ListComference_User();
                                    LU.setVisible(true);
                                    LU.nameAcc.setText(list.get(0).getUsername());
                                    LU.nameAcc.setVisible(true);
                                    LU.account.setVisible(true);
                                    LU.comboxLogIn.setVisible(false);
                                    dispose();

                                } catch (HibernateException ex) {
//Log the exception
                                    System.err.println(ex);
                                } finally {
                                    session.close();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Hội nghị đã đủ chỗ, không đăng ký thêm được");
                            }

                            ListComference_User LU = new ListComference_User();
                            LU.setVisible(true);
                            LU.nameAcc.setText(userName.getText());
                            LU.nameAcc.setVisible(true);
                            LU.account.setVisible(true);
                            LU.comboxLogIn.setVisible(false);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Bạn đã đăng ký hội nghị này rồi");
                            ListComference_User LU = new ListComference_User();
                            LU.setVisible(true);
                            LU.nameAcc.setText(userName.getText());
                            LU.nameAcc.setVisible(true);
                            LU.account.setVisible(true);
                            LU.comboxLogIn.setVisible(false);
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Bạn đã đăng ký hội nghị này rồi, đang chờ admin duyệt");
                        ListComference_User LU = new ListComference_User();
                        LU.setVisible(true);
                        LU.nameAcc.setText(userName.getText());
                        LU.nameAcc.setVisible(true);
                        LU.account.setVisible(true);
                        LU.comboxLogIn.setVisible(false);
                        dispose();
                    }
                }else {
                     if (loaimh.getText().equals("list_khach")){
                         //                                 Quay lai trang listComference
                                    ListComference_User LU = new ListComference_User();
                                    LU.setVisible(true);
                                    System.out.println(list.get(0).getUsername());
                                    LU.nameAcc.setText(list.get(0).getUsername());
                                    LU.nameAcc.setVisible(true);
                                    LU.account.setVisible(true);
                                    LU.comboxLogIn.setVisible(false);
                                    if(list.get(0).getUsername().equals("admin2"))
                                    {   
                                        LU.duyetds.setVisible(true);
                                        LU.suadoi.setVisible(true);
                                    
                                    }
                                    dispose();
                     }
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    /**
     *
     * @param input
     * @return
     */
    public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel hn;
    private javax.swing.JLabel idhn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel loaimh;
    private javax.swing.JTextField pass;
    public javax.swing.JLabel sizeDiaDiem;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
