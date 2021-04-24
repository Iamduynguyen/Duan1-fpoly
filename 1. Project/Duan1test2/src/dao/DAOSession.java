package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

//import model.Lop;
//import model.Sinhvien;
import model.TestSession;

public class DAOSession {
	private static PreparedStatement pstm;
    private static String selectSession = "SELECT * FROM TESTSESSION WHERE COURSE_ID = ?";

    public static List<TestSession> selectSession(int course_id) {
        try {
            pstm = Dbconnection.getConnection().prepareStatement(selectSession);
            pstm.setInt(1, course_id);
            ResultSet rs = pstm.executeQuery();
            List<TestSession> lstTS;
            while(rs.next()){ 
            	System.out.println(rs.getInt(0));
            	System.out.println(rs.getString(1));
            	System.out.println(rs.getInt(2));
            	System.out.println(rs.getString(3));
            	System.out.println(rs.getString(4));
            	System.out.println(rs.getString(5));
            	System.out.println(rs.getString(6));
//            	 lstTS.add(new TestSession(rs.getInt(0), rs.get))
            }
            
        } catch (Exception e) {
        }
        return null;
    }
}
