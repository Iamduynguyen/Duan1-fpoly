/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.List;
import model.Lop;
import model.Sinhvien;

/**
 *
 * @author Admin
 */
public class DAOinsert {

    private static PreparedStatement pstm;
    private static String insertSV = "INSERT STUDENTS (SVID,NAMES) VALUES(?,?)";
    private static String insertlop = "INSERT CLASSES (CLASSID,Mamon,KIHOC,TIMES,USERID) VALUES(?,?,?,?,?)";
    private static String insertSVLop = "INSERT STCL (CLASSID,SVID,macathi,mangaythi,trangthai,phongthi) VALUES(?,?,?,?,?,?)";
    private static String insertngathi ="insert NGAYTHI(mangay,ngaythi) values(?,?)";

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
                pstm.setInt(4, sv.getMangay());
                pstm.setString(6, sv.getPhongthi());
            } else {
                pstm.setInt(3,0);
                pstm.setInt(4,0);
                pstm.setString(6,null);
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
            pstm.setString(2, lop.getMamon());
            pstm.setString(3, lop.getKihoc());
            pstm.setString(4, lop.getThoigian());
            pstm.setString(5, lop.getMauser());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("loi :" + e);
        }
        return false;
    }
    
        public static boolean insertngaythi(String ngaythi,int ma) {
        try {
            pstm = Dbconnection.getConnection().prepareCall(insertngathi);
            pstm.setInt(1, ma);
            pstm.setString(2,Help.Formartday.convertdaytoyear(ngaythi));
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("loi :" + e);
        }
        return false;
    }
        public static void main(String[] args) {
            insertngaythi("02-01-2021", 1);
    }

}
