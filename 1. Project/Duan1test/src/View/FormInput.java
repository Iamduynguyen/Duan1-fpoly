/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Service.SVinput;
import java.io.File;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Diem;
import model.Lop;
import model.Sinhvien;
import Service.SVinputdd;
import javax.swing.JInternalFrame;
import model.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author dell
 */
public class FormInput extends JInternalFrame {

    DefaultTableModel tbmModel = new DefaultTableModel();
    DefaultTableModel tbmModeldd = new DefaultTableModel();
    Workbook _wb = new HSSFWorkbook();
    static String _path = null;
    static List<Diem> _lstdiem = new ArrayList<>();
    static List<Sinhvien> _lstSV = new ArrayList<>();
    static Lop _lop = new Lop();
    static User _user = new User();

    /**
     * Creates new form mmm
     */
    public FormInput() {
        initComponents();
        this.setTitle("Nhập dữ liệu");
        setResizable(false);
        setformtabquiz();
    }

    public static void setUserlog(User x) {
        _user = x;
    }

    private void setformtabquiz() {
        tbmModel = (DefaultTableModel) tbinput.getModel();
        tbmModeldd = (DefaultTableModel) tbinput1.getModel();
        tbmModeldd.setRowCount(0);
        tbmModeldd.setColumnCount(0);
        tbmModel.setColumnCount(0);
        tbmModel.setRowCount(0);
        groupradio();
        btnquiz.setIcon(new ImageIcon("img/file.png"));
        btndd1.setIcon(new ImageIcon("img/file.png"));
        btnnextform1.setIcon(new ImageIcon("img/next.png"));
    }

    private void groupradio() {
        ButtonGroup group = new ButtonGroup();
        group.add(rd75);
        group.add(rd10);
        rd10.setSelected(true);
    }

    private void loadtbquiz(String path) {
        tbmModel.setRowCount(0);
        tbmModel.setColumnCount(0);
        Workbook wb = Service.SVinput.getwb(path);
        _lstSV = Service.SVinput.getListSV(wb);
        _lstdiem = Service.SVinput.getlstDiems(wb);
        _lop = Service.SVinput.getlop(wb);
        String colums[] = {"STT", "Mã SV", "Tên SV", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5", "Quiz 6", "Quiz 7", "Quiz 8", "Quiz 9", "Quiz 10"};
        if (_lop.getCheck() == 1) {
            rd10.setSelected(true);
            for (int j = 0; j < colums.length; j++) {
                tbmModel.addColumn(colums[j]);
                if (j == 10 && _lop.getSodiemquiz() < 10) {
                    break;
                }
            }
            for (int j = 0; j < _lstSV.size(); j++) {
                tbmModel.addRow(new Object[]{j + 1, _lstSV.get(j).getMasv(), _lstSV.get(j).getTensv(),
                    _lstdiem.get(j).getDiem1(), _lstdiem.get(j).getDiem2(), _lstdiem.get(j).getDiem3(),
                    _lstdiem.get(j).getDiem4(), _lstdiem.get(j).getDiem5(), _lstdiem.get(j).getDiem6(),
                    _lstdiem.get(j).getDiem7(), _lstdiem.get(j).getDiem8(), _lstdiem.get(j).getDiem9(), _lstdiem.get(j).getDiem10()});
            }
        }
        if (_lop.getCheck() == 2) {
            rd75.setSelected(true);
            for (int i = 0; i < 3; i++) {
                tbmModel.addColumn(colums[i]);
            }
            tbmModel.addColumn("Điểm online");
            for (int i = 0; i < _lstSV.size(); i++) {
                tbmModel.addRow(new Object[]{i + 1, _lstSV.get(i).getMasv(), _lstSV.get(i).getTensv(), _lstdiem.get(i).getDiemonl()});
            }
        }
        if (_lop.getCheck() == 0) {
            for (int i = 0; i < 3; i++) {
                tbmModel.addColumn(colums[i]);
            }
            for (int i = 0; i < _lstSV.size(); i++) {
                tbmModel.addRow(new Object[]{i + 1, _lstSV.get(i).getMasv(), _lstSV.get(i).getTensv()});
            }
        }
    }

    private void loadtbdd(List<Sinhvien> lst) {
        try {
            tbmModeldd.setRowCount(0);
            tbmModeldd.setColumnCount(0);
            String comlums[] = {"STT", "Mã sinh viên", "Tên sinh viên", "Tỉ lệ nghỉ"};
            for (String comlum : comlums) {
                tbmModeldd.addColumn(comlum);
            }
            int i = 0;
            for (Sinhvien x : lst) {
                tbmModeldd.addRow(new Object[]{i++, x.getMasv(), x.getTensv(), x.getTilenghi() + "%"});
            }
        } catch (Exception e) {
            System.out.println("loi" + e);
        }
    }

    private String chooser() {
        try {
            File srcFile = null;
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                srcFile = chooser.getSelectedFile();
            }
            _path = srcFile.getAbsolutePath();
            return _path;
        } catch (Exception e) {
            return null;
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

        tabtb = new javax.swing.JTabbedPane();
        pndiemquiz = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbinput = new javax.swing.JTable();
        lbl_chek = new javax.swing.JLabel();
        rd10 = new javax.swing.JRadioButton();
        rd75 = new javax.swing.JRadioButton();
        lbllop = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbinput1 = new javax.swing.JTable();
        lbl_chek1 = new javax.swing.JLabel();
        txttilenghi = new javax.swing.JTextField();
        btndd1 = new javax.swing.JButton();
        btnquiz = new javax.swing.JButton();
        btnnextform1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabtb.setBackground(new java.awt.Color(204, 255, 255));
        tabtb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        pndiemquiz.setBackground(new java.awt.Color(255, 255, 255));

        tbinput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbinput);

        lbl_chek.setText("Check diem lab: ");

        rd10.setText("Diem = 10");

        rd75.setText("Diem >= 7.5");

        lbllop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbllop.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pndiemquizLayout = new javax.swing.GroupLayout(pndiemquiz);
        pndiemquiz.setLayout(pndiemquizLayout);
        pndiemquizLayout.setHorizontalGroup(
            pndiemquizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndiemquizLayout.createSequentialGroup()
                .addGroup(pndiemquizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pndiemquizLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lbl_chek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rd10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rd75)
                        .addGap(36, 36, 36)
                        .addComponent(lbllop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pndiemquizLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pndiemquizLayout.setVerticalGroup(
            pndiemquizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pndiemquizLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pndiemquizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd75)
                    .addComponent(rd10)
                    .addComponent(lbl_chek)
                    .addComponent(lbllop, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
        );

        tabtb.addTab("Danh sách điểm Quiz", pndiemquiz);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbinput1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbinput1);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1090, 280));

        lbl_chek1.setText("Tỉ lệ được phép nghỉ (%):");
        jPanel2.add(lbl_chek1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txttilenghi.setText("25");
        jPanel2.add(txttilenghi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 70, -1));

        tabtb.addTab("Danh sách điểm danh", jPanel2);

        getContentPane().add(tabtb, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1120, 370));

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
        getContentPane().add(btndd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

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
        getContentPane().add(btnquiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        btnnextform1.setBackground(new java.awt.Color(255, 255, 255));
        btnnextform1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnextform1.setForeground(new java.awt.Color(255, 0, 51));
        btnnextform1.setText("Kiểm tra điều kiện thi");
        btnnextform1.setFocusable(false);
        btnnextform1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnextform1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnextform1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextform1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnnextform1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 470, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnquizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquizActionPerformed
//        String l ="C:\\Users\\dell\\Desktop\\ppp.xlsx";
        if (SVinputdd.isfilediemdanh(_lstSV, SVinputdd.getListdd(SVinput.getwb(chooser())))) {
            tabtb.setSelectedIndex(1);
            loadtbdd(_lstSV);
        } else {
            JOptionPane.showMessageDialog(rootPane, "nhap sai");
        }
    }//GEN-LAST:event_btnquizActionPerformed

    private void btndd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndd1ActionPerformed
        String path = chooser();
        Workbook wb = Service.SVinput.getwb(path);
        _lop = Service.SVinput.getlop(wb);
        _lop.setMauser("duytn");
        DAO.DAOinsert.insertLOP(_lop);
        if (_lop.getCheck() == 1) {
            loadtbquiz(path);
            lbllop.setText("Lớp: " + _lop.getMalop() + "\t Môn: " + _lop.getMamon() + "\t Kì học: " + _lop.getKihoc() + "\t Thời gian: " + _lop.getThoigian());
        } else if (_lop.getCheck() == 2) {
            loadtbquiz(path);
            lbllop.setText("Lớp: " + _lop.getMalop() + "\t Môn: " + _lop.getMamon() + "\t Kì học: " + _lop.getKihoc() + "\t Thời gian: " + _lop.getThoigian());
        } else {
            lbllop.setText("");
            tbmModel.setColumnCount(0);
            tbmModel.setRowCount(0);
            loadtbquiz(path);
            lbllop.setText("Lớp: " + _lop.getMalop() + "\t Môn: " + _lop.getMamon() + "\t Kì học: " + _lop.getKihoc() + "\t Thời gian: " + _lop.getThoigian());
        }
    }//GEN-LAST:event_btndd1ActionPerformed

    private void btnnextform1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextform1ActionPerformed
        double a = 10;
        if (rd75.isSelected()) {
            a = 7.5;
        }
        int b = Integer.parseInt(txttilenghi.getText());
        if (txttilenghi.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Moi nhap thi le duco phep nghi");
            return;
        }
        for (int i = 0; i < _lstSV.size(); i++) {
            if (_lstSV.get(i).getTilenghi() > b) {
                _lstSV.get(i).setCheckfalse(false);
                _lstSV.get(i).setTrangthai("Điểm danh không đạt yêu cầu");
            } else if (Service.SVcheckdk.checksv(_lstdiem.get(i), _lop, a) == false) {
                _lstSV.get(i).setCheckfalse(false);
                _lstSV.get(i).setTrangthai("Điểm Quiz không đạt yêu cầu");
            } else {
                _lstSV.get(i).setCheckfalse(true);
                _lstSV.get(i).setTrangthai("OK");
            }
        }
        FormMain.setlop(_lop);
        FormMain.setlstSV(_lstSV);
        DAO.DAOinsert.insertLOP(_lop);
        for (Sinhvien sinhvien : _lstSV) {
            DAO.DAOinsert.insertSV(sinhvien);
        }
    }//GEN-LAST:event_btnnextform1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndd1;
    private javax.swing.JButton btnnextform1;
    private javax.swing.JButton btnquiz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_chek;
    private javax.swing.JLabel lbl_chek1;
    private javax.swing.JLabel lbllop;
    private javax.swing.JPanel pndiemquiz;
    private javax.swing.JRadioButton rd10;
    private javax.swing.JRadioButton rd75;
    private javax.swing.JTabbedPane tabtb;
    private javax.swing.JTable tbinput;
    private javax.swing.JTable tbinput1;
    private javax.swing.JTextField txttilenghi;
    // End of variables declaration//GEN-END:variables
}
