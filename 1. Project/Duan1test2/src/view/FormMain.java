/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.Lop;
import model.Sinhvien;
import model.User;

/**
 *
 * @author Admin
 */
public class FormMain extends javax.swing.JFrame {

    static User _userlog;
    static List<Sinhvien> _lstSV;
    static Lop _lop;

    /**
     * Creates new form FormMain
     */
    public FormMain() {
        initComponents();
    }

    public static void getuserlog(User x) {
        _userlog = x;
    }

    public static void setlstSV(List<Sinhvien> lst) {
        _lstSV = lst;
    }

    public static void setlop(Lop x) {
        _lop = x;
    }

    public void actionform1(boolean a) {
        FormInput.setUserlog(_userlog);
        FormInput x = new FormInput();
        dtpane.add(x);
        x.setVisible(a);
    }

    public void actionform2(boolean a) {
        Formkehoach.getlop(_lop);
        Formkehoach.getlstsv(_lstSV);
        Formkehoach x = new Formkehoach();
        dtpane.add(x);
        x.setVisible(a);
    }

    public void actionform3(boolean a) {
        Outputkehoachthi.getlstSV(_lstSV);
        Outputkehoachthi.getlop(_lop);
        Outputkehoachthi x = new Outputkehoachthi();
        dtpane.add(x);
        x.setVisible(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btninput = new javax.swing.JButton();
        btnsetdk = new javax.swing.JButton();
        btnchiaca = new javax.swing.JButton();
        dtpane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btninput.setBackground(new java.awt.Color(255, 255, 255));
        btninput.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninput.setForeground(new java.awt.Color(255, 0, 51));
        btninput.setText("Nhập file Excel");
        btninput.setFocusable(false);
        btninput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btninput.setMargin(new java.awt.Insets(2, 25, 2, 25));
        btninput.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btninput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninputActionPerformed(evt);
            }
        });
        jToolBar1.add(btninput);

        btnsetdk.setBackground(new java.awt.Color(255, 255, 255));
        btnsetdk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsetdk.setForeground(new java.awt.Color(255, 0, 51));
        btnsetdk.setText("Danh sách đủ điều kiện và cấm thi");
        btnsetdk.setFocusable(false);
        btnsetdk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsetdk.setMargin(new java.awt.Insets(2, 25, 2, 25));
        btnsetdk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsetdk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsetdkActionPerformed(evt);
            }
        });
        jToolBar1.add(btnsetdk);

        btnchiaca.setBackground(new java.awt.Color(255, 255, 255));
        btnchiaca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnchiaca.setForeground(new java.awt.Color(255, 0, 51));
        btnchiaca.setText("Chia buổi thi");
        btnchiaca.setFocusable(false);
        btnchiaca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnchiaca.setMargin(new java.awt.Insets(2, 25, 2, 25));
        btnchiaca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnchiaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchiacaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnchiaca);

        javax.swing.GroupLayout dtpaneLayout = new javax.swing.GroupLayout(dtpane);
        dtpane.setLayout(dtpaneLayout);
        dtpaneLayout.setHorizontalGroup(
            dtpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1400, Short.MAX_VALUE)
        );
        dtpaneLayout.setVerticalGroup(
            dtpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Import file Excel");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem4.setText("Danh sách thi");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem5.setText("Kế hoạch thi");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Đăng xuất");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpane)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(dtpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 639, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninputActionPerformed
        actionform1(true);
    }//GEN-LAST:event_btninputActionPerformed

    private void btnsetdkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsetdkActionPerformed
        actionform2(true);
    }//GEN-LAST:event_btnsetdkActionPerformed

    private void btnchiacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchiacaActionPerformed

        actionform3(true);
    }//GEN-LAST:event_btnchiacaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchiaca;
    private javax.swing.JButton btninput;
    private javax.swing.JButton btnsetdk;
    private javax.swing.JDesktopPane dtpane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
