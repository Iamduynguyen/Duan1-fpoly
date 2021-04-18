/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Service.SVChiacathi;
import static View.Formkehoach._lop1;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Lop;
import model.Sinhvien;

/**
 *
 * @author dell
 */
public class Outputkehoachthi extends JInternalFrame {

    ButtonGroup groupbutton = new ButtonGroup();
    DefaultTableModel tbmode2 = new DefaultTableModel();
    DefaultTableModel tbmode1 = new DefaultTableModel();
    DefaultTableModel tbmode3 = new DefaultTableModel();
    DefaultTableModel tbmode4 = new DefaultTableModel();
    static List<Sinhvien> _lstSV;
    List<String> _ngaythi = new ArrayList<>();
    int index = 1;
    List<Integer> cathi = new ArrayList<>();
    static Lop _lop;

    /**
     * Creates new form Outputkehoachthi
     */
    public Outputkehoachthi() {
        initComponents();
        groupbuton();
        tab.removeAll();
        radioaction();
        spinsosv.setValue(13);
        setbuoithi();
    }

    public static void getlop(Lop x) {
        _lop = x;
    }

    void radioaction() {
        if (rdTudong.isSelected()) {
            btnnhapfilenhom.setVisible(false);
        } else {
            btnnhapfilenhom.setVisible(true);
        }
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
        }
    }

    private void loadtb(List<Sinhvien> lst, int sosv, int buoithi, List<String> ngaythi, List<Integer> cathi) {
        tbmode1 = (DefaultTableModel) tb1.getModel();
        tbmode1.setRowCount(0);
        tbmode2 = (DefaultTableModel) tb2.getModel();
        tbmode2.setRowCount(0);
        tbmode3 = (DefaultTableModel) tb3.getModel();
        tbmode3.setRowCount(0);
        String[] namecolums = {"STT", "Mã SV", "Tên SV", "Lớp", "Ngày thi", "Ca thi"};
        int i = 0;
        for (Sinhvien x : lst) {
            if (x.isCheckfalse()) {
                if (i <= sosv) {
                    x.setCathi(cathi.get(0));
                    x.setNgaythi(ngaythi.get(0));
                    tbmode1.addRow(new Object[]{i + 1, x.getMasv(), x.getTensv(), x.getCathi()});
                }
                if (i > sosv && i <= sosv * 2 && buoithi > 1) {
                    x.setCathi(cathi.get(1));
                    x.setNgaythi(ngaythi.get(1));
                    tbmode2.addRow(new Object[]{i + 1, x.getMasv(), x.getTensv(), x.getCathi()});
                }
                if (i > sosv * 2 && i < sosv * 3 && buoithi > 2) {
                    x.setCathi(cathi.get(2));
                    x.setNgaythi(ngaythi.get(2));
                    tbmode3.addRow(new Object[]{i + 1, x.getMasv(), x.getTensv(), x.getCathi()});
                }
                if (i > sosv * 3 && i <= sosv * 4 && buoithi >3) {
                    x.setCathi(cathi.get(3));
                    x.setNgaythi(ngaythi.get(3));
                    tbmode3.addRow(new Object[]{i + 1, x.getMasv(), x.getTensv(), x.getCathi()});
                }
                i++;
            }
        }

    }

    public static void getlstSV(List<Sinhvien> lst) {
        _lstSV = lst;
    }

    void groupbuton() {
        groupbutton.add(rdthucong);
        groupbutton.add(rdTudong);
        rdTudong.setSelected(true);
    }

    void setbuoithi() {
        int tongsosv = 40;
        int sovv = (int) spinsosv.getValue();
        if (tongsosv / sovv < 5 && tongsosv / sovv > 0) {
            if (tongsosv % sovv == 0) {
                spinsobuoi.setValue(tongsosv / sovv);
            } else {
                spinsobuoi.setValue(tongsosv / sovv + 1);
            }
        } else {
            if (tongsosv / sovv > 4) {
                JOptionPane.showMessageDialog(rootPane, "Không quá 4 buổi thi");
                spinsosv.setValue(tongsosv / 4 + 1);
            }
            if (tongsosv / sovv < 1) {
                JOptionPane.showMessageDialog(rootPane, "Vượt quá số Sinh viên");
                spinsosv.setValue(tongsosv);
            }
        }
    }

    void setsosv() {
        int tongsosv = 40;
        int sobuoi = (int) spinsobuoi.getValue();
        if (tongsosv % sobuoi == 0) {
            spinsosv.setValue(tongsosv / sobuoi);
        } else {
            spinsosv.setValue(tongsosv / sobuoi + 1);
        }
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
        jPanel1 = new javax.swing.JPanel();
        rdTudong = new javax.swing.JRadioButton();
        rdthucong = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        lblbuoithi = new javax.swing.JLabel();
        btntet = new javax.swing.JButton();
        btnnhapfilenhom = new javax.swing.JButton();
        spinsosv = new javax.swing.JSpinner();
        spinsobuoi = new javax.swing.JSpinner();
        btntet1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbcahoc = new javax.swing.JComboBox<>();
        btnnhapfilenhom1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ca thi"
            }
        ));
        jScrollPane1.setViewportView(tb1);

        tab.addTab("Ngày thứ nhất", jScrollPane1);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ca thi"
            }
        ));
        jScrollPane3.setViewportView(tb2);

        tab.addTab("Ngày thứ 2", jScrollPane3);

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ca thi"
            }
        ));
        jScrollPane6.setViewportView(tb3);

        tab.addTab("Ngày thứ 3", jScrollPane6);

        tb4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SV", "Tên SV", "Ca thi"
            }
        ));
        jScrollPane7.setViewportView(tb4);

        tab.addTab("Ngày thứ 4", jScrollPane7);

        getContentPane().add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1070, 380));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rdTudong.setText("Chia buoi tu dong");
        rdTudong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdTudongStateChanged(evt);
            }
        });
        rdTudong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTudongActionPerformed(evt);
            }
        });
        jPanel1.add(rdTudong, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        rdthucong.setText("Chia buoi thu cong");
        jPanel1.add(rdthucong, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel5.setText("SO buoi thi");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 60, 20));

        jLabel6.setText("Ca thi:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, 20));
        jPanel1.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 140, -1));

        lblbuoithi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblbuoithi.setForeground(new java.awt.Color(255, 0, 102));
        lblbuoithi.setText("Buổi thi thứ nhất:");
        jPanel1.add(lblbuoithi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 130, 20));

        btntet.setText("RESET");
        btntet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntetActionPerformed(evt);
            }
        });
        jPanel1.add(btntet, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 100, -1));

        btnnhapfilenhom.setText("Nhap file nhom");
        jPanel1.add(btnnhapfilenhom, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 120, -1));

        spinsosv.setModel(new javax.swing.SpinnerNumberModel(13, 5, null, 1));
        spinsosv.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                spinsosvHierarchyChanged(evt);
            }
        });
        spinsosv.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinsosvStateChanged(evt);
            }
        });
        spinsosv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spinsosvMouseClicked(evt);
            }
        });
        jPanel1.add(spinsosv, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 60, -1));

        spinsobuoi.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        spinsobuoi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinsobuoiStateChanged(evt);
            }
        });
        jPanel1.add(spinsobuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 60, -1));

        btntet1.setText("OK");
        btntet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntet1ActionPerformed(evt);
            }
        });
        jPanel1.add(btntet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 120, -1));

        jLabel7.setText("So SV moi buoi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, 20));

        jLabel8.setText("Ngày:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 20));

        cbbcahoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca1", "Ca 1", "Ca 3", "Ca4", "Ca 5", "Ca6" }));
        jPanel1.add(cbbcahoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 100, -1));

        btnnhapfilenhom1.setText("Luu DB");
        btnnhapfilenhom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnhapfilenhom1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnnhapfilenhom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1070, 70));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Xuat file Excel");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 500, 150, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntet1ActionPerformed
        // TODO add your handling code here:
        int sobuoi = (int) spinsobuoi.getValue();
        int sosv = (int) spinsosv.getValue();
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
            }
            try {
                _ngaythi.add(Help.Formartday.formatdateDD(datechooser.getDate()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Mời bạn nhập ngày thi");
                index = 0;
                return;
            }
            cathi.add(cbbcahoc.getSelectedIndex() + 1);
            index++;
            return;
        } else {
            try {
                _ngaythi.add(Help.Formartday.formatdateDD(datechooser.getDate()));
                cathi.add(cbbcahoc.getSelectedIndex() + 1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Mời bạn nhập ngày thi");
            }
            addtab(sobuoi, _ngaythi);
            loadtb(_lstSV, sosv, sobuoi, _ngaythi, cathi);
        }
    }//GEN-LAST:event_btntet1ActionPerformed

    private void btntetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntetActionPerformed
        // TODO add your handling code here:
        index = 1;
        lblbuoithi.setText("Buổi thi đầu tiên:");
        _ngaythi = new ArrayList<>();
        tab.removeAll();
    }//GEN-LAST:event_btntetActionPerformed

    private void spinsosvStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinsosvStateChanged
        // TODO add your handling code here:
        setbuoithi();
    }//GEN-LAST:event_spinsosvStateChanged

    private void rdTudongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTudongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTudongActionPerformed

    private void rdTudongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdTudongStateChanged
        // TODO add your handling code here:
        radioaction();
    }//GEN-LAST:event_rdTudongStateChanged

    private void spinsobuoiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinsobuoiStateChanged
        // TODO add your handling code here:
        setsosv();
    }//GEN-LAST:event_spinsobuoiStateChanged

    private void spinsosvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinsosvMouseClicked
        // TODO add your handling code here:
//    setbuoithi();
    }//GEN-LAST:event_spinsosvMouseClicked

    private void spinsosvHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_spinsosvHierarchyChanged
        // TODO add your handling code here:
        setbuoithi();
    }//GEN-LAST:event_spinsosvHierarchyChanged

    private void btnnhapfilenhom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnhapfilenhom1ActionPerformed
        // TODO add your handling code here:
        for (Sinhvien sinhvien : _lstSV) {
            DAO.DAOinsert.insertSVLOP(sinhvien, _lop);
        }
    }//GEN-LAST:event_btnnhapfilenhom1ActionPerformed

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
    private javax.swing.JButton btnnhapfilenhom;
    private javax.swing.JButton btnnhapfilenhom1;
    private javax.swing.JButton btntet;
    private javax.swing.JButton btntet1;
    private javax.swing.JComboBox<String> cbbcahoc;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
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
    // End of variables declaration//GEN-END:variables
}
