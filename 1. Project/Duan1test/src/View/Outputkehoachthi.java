/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Service.SVChiacathi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Sinhvien;

/**
 *
 * @author dell
 */
public class Outputkehoachthi extends javax.swing.JFrame {

    ButtonGroup groupbutton = new ButtonGroup();
    DefaultTableModel tbmode2 = new DefaultTableModel();
    DefaultTableModel tbmode1 = new DefaultTableModel();
    DefaultTableModel tbmode3 = new DefaultTableModel();
    DefaultTableModel tbmode4 = new DefaultTableModel();
    DefaultTableModel tbmode5 = new DefaultTableModel();
    static List<Sinhvien> _lstSV = new ArrayList<>();
    List<String> _ngaythi = new ArrayList<>();
    int index = 1;

    /**
     * Creates new form Outputkehoachthi
     */
    public Outputkehoachthi() {
        initComponents();
        groupbuton();
        tab.removeAll();
    }

    private void addtab(int sobuoi, List<String> lst) {
        switch (sobuoi) {
            case 1:
                jScrollPane1.setViewportView(tb1);
                tab.add("Ngày " + lst.get(0), jScrollPane1);
                break;
            case 2:
                jScrollPane1.setViewportView(tb1);
                tab.add("Ngày " + lst.get(0), jScrollPane1);
                jScrollPane3.setViewportView(tb2);
                tab.add("Ngày " + lst.get(1), jScrollPane3);
                break;
            case 3:
                jScrollPane1.setViewportView(tb1);
                tab.add("Ngày " + lst.get(0), jScrollPane1);
                jScrollPane3.setViewportView(tb2);
                tab.add("Ngày " + lst.get(1), jScrollPane3);
                jScrollPane6.setViewportView(tb3);
                tab.add("Ngày " + lst.get(2), jScrollPane6);
                break;
            case 4:
                jScrollPane1.setViewportView(tb1);
                tab.add("Ngày " + lst.get(0), jScrollPane1);
                jScrollPane3.setViewportView(tb2);
                tab.add("Ngày " + lst.get(1), jScrollPane3);
                jScrollPane6.setViewportView(tb3);
                tab.add("Ngày " + lst.get(2), jScrollPane6);
                jScrollPane7.setViewportView(tb4);
                tab.add("Ngày " + lst.get(3), jScrollPane7);

                break;
            case 5:
                jScrollPane1.setViewportView(tb1);
                tab.add("Ngày " + lst.get(0), jScrollPane1);
                jScrollPane3.setViewportView(tb2);
                tab.add("Ngày " + lst.get(1), jScrollPane3);
                jScrollPane6.setViewportView(tb3);
                tab.add("Ngày " + lst.get(2), jScrollPane6);
                jScrollPane7.setViewportView(tb4);
                tab.add("Ngày " + lst.get(3), jScrollPane7);
                jScrollPane8.setViewportView(tb5);
                tab.add("Ngày " + lst.get(4), jScrollPane8);
                break;
        }
    }

    private void loadtb(List<Sinhvien> lst, int sosv) {
        tbmode1 = (DefaultTableModel) tb1.getModel();
        tbmode1.setRowCount(0);
        tbmode2 = (DefaultTableModel) tb2.getModel();
        tbmode2.setRowCount(0);
        tbmode3 = (DefaultTableModel) tb3.getModel();
        tbmode3.setRowCount(0);
        int i = 1;
        for (Sinhvien x : lst) {
            if (i <= sosv) {
                tbmode1.addRow(new Object[]{x.getTensv(), x.getNgaythi()});
            }
            if (i > sosv && i <= sosv * 2) {
                tbmode2.addRow(new Object[]{x.getTensv(), x.getNgaythi()});
            }
            if (i > sosv * 2 && i < sosv * 3) {
                tbmode3.addRow(new Object[]{x.getTensv(), x.getNgaythi()});
            }
            i++;
        }

    }

    public static void getlstSV(List<Sinhvien> lst) {
        _lstSV = lst;
    }

    void groupbuton() {
        groupbutton.add(rdthucong);
        groupbutton.add(rdTudong);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb5 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rdTudong = new javax.swing.JRadioButton();
        rdthucong = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        lblbuoithi = new javax.swing.JLabel();
        btntet1 = new javax.swing.JButton();
        btntet = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        spinsosv = new javax.swing.JSpinner();
        spinsobuoi = new javax.swing.JSpinner();
        jToolBar1 = new javax.swing.JToolBar();
        btndd1 = new javax.swing.JButton();
        btnquiz = new javax.swing.JButton();
        btnnextform1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ngày thi"
            }
        ));
        jScrollPane1.setViewportView(tb1);

        tab.addTab("Ngày thứ nhất", jScrollPane1);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ngày thi"
            }
        ));
        jScrollPane3.setViewportView(tb2);

        tab.addTab("Ngày thứ 2", jScrollPane3);

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ngày thi"
            }
        ));
        jScrollPane6.setViewportView(tb3);

        tab.addTab("Ngày thứ 3", jScrollPane6);

        tb4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ngày thi"
            }
        ));
        jScrollPane7.setViewportView(tb4);

        tab.addTab("Ngày thứ 4", jScrollPane7);

        tb5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ngày thi"
            }
        ));
        jScrollPane8.setViewportView(tb5);

        tab.addTab("Ngày thứ 5", jScrollPane8);

        getContentPane().add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 1080, 440));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rdTudong.setText("Chia buoi tu dong");
        jPanel1.add(rdTudong, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        rdthucong.setText("Chia buoi thu cong");
        jPanel1.add(rdthucong, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel5.setText("SO buoi thi");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 60, 20));

        jLabel6.setText("So SV moi buoi");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, 20));
        jPanel1.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 180, -1));

        lblbuoithi.setText("Buổi thi thứ nhất:");
        jPanel1.add(lblbuoithi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 20));

        btntet1.setText("OK");
        btntet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntet1ActionPerformed(evt);
            }
        });
        jPanel1.add(btntet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 70, -1));

        btntet.setText("RESET");
        btntet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntetActionPerformed(evt);
            }
        });
        jPanel1.add(btntet, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 70, -1));

        jButton1.setText("Xuat file Excel");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 120, -1));

        jButton2.setText("Nhap file nhom");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 120, -1));

        spinsosv.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(spinsosv, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 60, -1));

        spinsobuoi.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jPanel1.add(spinsobuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1070, 70));

        jToolBar1.setRollover(true);

        btndd1.setBackground(new java.awt.Color(255, 255, 255));
        btndd1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndd1.setForeground(new java.awt.Color(255, 0, 51));
        btndd1.setText("Nhập File điểm Quiz");
        btndd1.setFocusable(false);
        btndd1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndd1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btndd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndd1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btndd1);

        btnquiz.setBackground(new java.awt.Color(255, 255, 255));
        btnquiz.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnquiz.setForeground(new java.awt.Color(255, 0, 51));
        btnquiz.setText("Nhập File điểm danh");
        btnquiz.setFocusable(false);
        btnquiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnquiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnquiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquizActionPerformed(evt);
            }
        });
        jToolBar1.add(btnquiz);

        btnnextform1.setBackground(new java.awt.Color(255, 255, 255));
        btnnextform1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnextform1.setForeground(new java.awt.Color(255, 0, 51));
        btnnextform1.setText("Danh sách thi");
        btnnextform1.setFocusable(false);
        btnnextform1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnextform1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnextform1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextform1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnnextform1);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 60));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndd1ActionPerformed

    }//GEN-LAST:event_btndd1ActionPerformed

    private void btnquizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquizActionPerformed


    }//GEN-LAST:event_btnquizActionPerformed

    private void btnnextform1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextform1ActionPerformed


    }//GEN-LAST:event_btnnextform1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void btntet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntet1ActionPerformed
        // TODO add your handling code here:
        int sobuoi = 0;
        int sosv = 0;
        try {
            sobuoi = (int) spinsobuoi.getValue();
            sosv = (int) spinsosv.getValue();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "loi");
        }
        if (sobuoi == 0 && sosv == 0) {
            JOptionPane.showMessageDialog(rootPane, "Mời nhập lại số Buổi hoặc số SV mỗi buổi");
            return;
        }
        if (sobuoi > 0 && sosv == 0) {
            if (_lstSV.size() % sobuoi == 0) {
                sosv = _lstSV.size() / sobuoi;
            } else {
                sosv = _lstSV.size() / sobuoi + 1;
            }
        }
        if (sobuoi == 0 && sosv > 0) {
            if (_lstSV.size() % sosv == 0) {
                sobuoi = _lstSV.size() / sosv;
            } else {
                sobuoi = _lstSV.size() / sosv + 1;
            }
        }
        if (index < sobuoi) {
            switch (index) {
                case 1:
                    lblbuoithi.setText("Buổi thi thứ 2");
                    break;
                case 2:
                    lblbuoithi.setText("Buổi thi thứ 3");
                    break;
                case 3:
                    lblbuoithi.setText("Buổi thi thứ 4");
                    break;
                case 4:
                    lblbuoithi.setText("Buổi thi thứ 5");
                    break;
            }
            try {
                _ngaythi.add(SVChiacathi.formatdate(datechooser.getDate()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Mời bạn nhập ngày thi");
            }
            index++;
            return;
        } else {
            try {
                _ngaythi.add(SVChiacathi.formatdate(datechooser.getDate()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Mời bạn nhập ngày thi");
            }
            addtab(sobuoi,_ngaythi);
            loadtb(SVChiacathi.lstSVfinish(_lstSV, _ngaythi, sobuoi, sosv), sosv);
            for (String x : _ngaythi) {
                System.out.println(x);
            }
        }
    }//GEN-LAST:event_btntet1ActionPerformed

    private void btntetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntetActionPerformed
        // TODO add your handling code here:
        index = 1;
        lblbuoithi.setText("Buổi đầu");
        _ngaythi = new ArrayList<>();
        tab.removeAll();
    }//GEN-LAST:event_btntetActionPerformed

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
            java.util.logging.Logger.getLogger(Outputkehoachthi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Outputkehoachthi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Outputkehoachthi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Outputkehoachthi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Outputkehoachthi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndd1;
    private javax.swing.JButton btnnextform1;
    private javax.swing.JButton btnquiz;
    private javax.swing.JButton btntet;
    private javax.swing.JButton btntet1;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblbuoithi;
    private javax.swing.JRadioButton rdTudong;
    private javax.swing.JRadioButton rdthucong;
    private javax.swing.JSpinner spinsobuoi;
    private javax.swing.JSpinner spinsosv;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JTable tb5;
    // End of variables declaration//GEN-END:variables
}
