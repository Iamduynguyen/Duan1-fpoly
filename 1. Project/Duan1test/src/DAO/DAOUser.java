/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import DAO.Dbconnection;

/**
 *
 * @author Admin
 */
public class DAOUser {
    private static Statement st;
    private static PreparedStatement pstm;
    private static String sqlselect = "SELECT * FROM USERS";
    private static String sqlinsert = "insert USERS (USERID,PASS,Names) values(?,?,?)";

    public DAOUser() {
    }
    
    public static List<User> getlstUser(){
        List<User> lst = new ArrayList<>();
        try {
            st = Dbconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sqlselect);
            while (rs.next()) {                
                User x = new User();
                x.setId(rs.getString(1));
                x.setPasswork(rs.getString(2));
                x.setName(rs.getString(3));
                lst.add(x);
            }
        } catch (Exception e) {
        }
        return lst;
    }
    
    public static boolean insertUser(User x){
        try {
            pstm = Dbconnection.getConnection().prepareCall(sqlinsert);
            pstm.setString(1, x.getId());
            pstm.setString(2, x.getPasswork());
            pstm.setString(3, x.getName());
            return pstm.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
    }
    
}
