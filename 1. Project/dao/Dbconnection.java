/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class Dbconnection {
    final static private String user = "duy";
    final static private String passwork = "1";
    final static private String dbname = "DUAN1";
    final static private String urldb = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" + dbname;
    static private Connection conn;

    public Dbconnection() {
    }
    
    private static void opendb(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(urldb, user, passwork);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        if (conn==null) {
            opendb();
        }
        return conn;
    }
    
    
}
