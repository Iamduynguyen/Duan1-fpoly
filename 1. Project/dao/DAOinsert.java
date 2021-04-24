/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import model.Lop;
import model.Sinhvien;

/**
 *
 * @author Admin
 */
public class DAOinsert {

    private static PreparedStatement pstm;
    private static String insertSV = "INSERT STUDENTS (SVID,NAMES) VALUES(?,?)";
    private static String insertlop = "INSERT CLASSES (CLASSID,KIHOC,TIMES,USERID) VALUES(?,?,?,?)";
    private static String insertSVLop = "INSERT STCL (CLASSID,SVID,macathi,ngaythi,trangthai) VALUES(?,?,?,?,?)";

    public static boolean insertSV(Sinhvien x) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(insertSV);
            pstm.setString(1, x.getMasv());
            pstm.setString(2, x.getTensv());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean insertSVLOP(Sinhvien sv, Lop lop) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(insertSVLop);
            pstm.setString(1, lop.getMalop());
            pstm.setString(2, sv.getMasv());
            pstm.setString(5, sv.getTrangthai());
            if (sv.getTrangthai().equals("OK")) {
                pstm.setInt(3, sv.getCathi());
                pstm.setString(4, help.Formartday.convertdaytoyear(sv.getNgaythi()));
            } else {
                pstm.setInt(3,0);
                pstm.setString(4,null);
            }
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertLOP(Lop lop) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(insertlop);
            pstm.setString(1, lop.getMalop());
            pstm.setString(2, lop.getKihoc());
            pstm.setString(3, lop.getThoigian());
            pstm.setString(4, lop.getMauser());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("loi :" + e);
        }
        return false;
    }

//    public static void main(String[] args) {
//        Sinhvien sv = new Sinhvien();
//        sv.setMasv("abc");
//        sv.setTrangthai("");
//        Lop lop = new Lop();
//        lop.setMalop("lopa");
//        lop.setMauser("duytn");
//        insertSVLOP(sv, lop);
//    }

}
