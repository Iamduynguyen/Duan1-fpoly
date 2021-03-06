/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Lop;
import model.Sinhvien;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Thongke extends JInternalFrame {

    public static List<Sinhvien> _lstSV;
    public static Lop _lop;
    DefaultTableModel tbmModel = new DefaultTableModel();

    /**
     * Creates new form Thongke
     */
    public Thongke() {
        initComponents();
        loadtb();
        if (_lstSV != null) {
            setjfreechart();
        }
    }

    void loadtb() {
        tbmModel = (DefaultTableModel) tbdslop.getModel();
        tbmModel.setRowCount(0);
        List<Lop> lst = DAO.DAOselect.getlstlop();
        for (Lop lop : lst) {
            tbmModel.addRow(new Object[]{lop.getMalop(), lop.getMamon()});
        }
    }

    public static void getlstsv(List<Sinhvien> lstsv) {
        _lstSV = lstsv;
    }

    void setjfreechart() {
        JFreeChart pieChart = createChart(createDataset(getdouble(_lstSV)));
        ChartPanel chartPanel = new ChartPanel(pieChart);
        getContentPane().add(chartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 400, 300));
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ phân tích tỉ lệ đủ điều kiện thi lớp: " + _lop.getMalop(), dataset, true, true, true);
        return chart;
    }

    private static PieDataset createDataset(Double[] x) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("SV trượt điẻm Quiz", new Double(x[0] * 100));
        dataset.setValue("SV trượt điểm danh", new Double(x[1] * 100));
        dataset.setValue("Sv đủ điều kiện", new Double(x[2] * 100));
        return dataset;
    }

    Double[] getdouble(List<Sinhvien> lst) {
        Double[] x = new Double[3];
        if (lst.size() == 0) {
            System.out.println("loi cvvcva");
        }
        int a = 0;
        int b = 0;
        int c = 0;
        for (Sinhvien sv : lst) {
            if (sv.getTrangthai().equals("OK")) {
                c++;
            }
            if (sv.getTrangthai().equals("Trượt điểm danh")) {
                b++;
            }
            if (sv.getTrangthai().equals("Trượt điểm Quizz")) {
                a++;
            }
        }
        x[0] = (double) a / lst.size();
        x[1] = (double) b / lst.size();
        x[2] = (double) c / lst.size();
        System.out.println(x[0]);
        System.out.println(x[1]);
        System.out.println(x[2]);
        return x;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbdslop = new javax.swing.JTable();
        lblanh = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbdslop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma lop", "Ten lop"
            }
        ));
        tbdslop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdslopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbdslop);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, 280));
        getContentPane().add(lblanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbdslopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdslopMouseClicked
        // TODO add your handling code here:
        String malop = tbdslop.getValueAt(tbdslop.getSelectedRow(), 1).toString();
        _lstSV = DAO.DAOselect.getlstSV(malop);
        setjfreechart();
    }//GEN-LAST:event_tbdslopMouseClicked

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
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thongke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblanh;
    private javax.swing.JTable tbdslop;
    // End of variables declaration//GEN-END:variables
}
