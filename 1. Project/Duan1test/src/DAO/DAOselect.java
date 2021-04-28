/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Lop;
import model.Sinhvien;
import model.User;

/**
 *
 * @author Admin
 */
public class DAOselect {

    private static PreparedStatement pstm;
    private static Statement st;
    private static String sqlselectlop = "SELECT * FROM CLASSES";
    private static String sqlselectSV = "select STUDENTS.SVID,STUDENTS.NAMES,STCL.trangthai,STCL.phongthi,CATHI.maca,NGAYTHI.ngaythi from\n"
            + "STUDENTS join STCL on STUDENTS.SVID = STCL.SVID join CATHI on STCL.macathi = CATHI.maca join NGAYTHI on STCL.mangaythi = NGAYTHI.mangay\n"
            + "join CLASSES on STCL.CLASSID = CLASSES.CLASSID where CLASSES.CLASSID = ";

    public static List<Lop> getlstlop() {
        List<Lop> lst = new ArrayList<>();
        try {
            st = Dbconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlselectlop);
            while (rs.next()) {
                Lop x = new Lop();
                x.setMalop(rs.getString(1));
                x.setMamon(rs.getString(2));
                lst.add(x);
            }
        } catch (Exception e) {
        }
        return lst;
    }
    
        public static List<Sinhvien> getlstSV(String malop) {
        List<Sinhvien> lst = new ArrayList<>();
        try {
            st = Dbconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlselectSV+malop);
            while (rs.next()) {
                Sinhvien x = new Sinhvien();
                x.setMasv(rs.getString(1));
                x.setTensv(rs.getString(2));
                x.setTrangthai(rs.getString(3));
                x.setPhongthi(rs.getString(4));
                x.setCathi(rs.getInt(5));
                x.setNgaythi(rs.getString(6));
                lst.add(x);
            }
        } catch (Exception e) {
        }
        return lst;
    }

    public static void main(String[] args) {
        for (Lop lop : getlstlop()) {
            System.out.println(lop.getMalop());
        }
    }
}
