package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Enrolment;
import model.Student;
import service.SQLServerConnUtils;

public class DbEnrolmentDAO implements EnrolmentDAO {
	private static final String SELECT_ALL_ENROLMENT = "SELECT * FROM ENROLMENT";
	private static final String SELECT_ENROLMENT_BY_ID = "SELECT STUDENT_ID, COURSE_ID, ELIGIBILITY FROM ENROLMENT WHERE STUDENT_ID = ? AND COURSE_ID = ?";
	private static final String INSERT_ENROLMENT_SQL = "INSERT INTO ENROLMENT (STUDENT_ID, COURSE_ID, ELIGIBILITY) VALUES (?, ?, ?);";
	private static final String UPDATE_ENROLMENT_SQL = "UPDATE ENROLMENT SET ELIGIBILITY = ? WHERE STUDENT_ID = ? AND COURSE_ID= ?;";
	private static final String DELETE_ENROLMENT_SQL = "DELETE FROM ENROLMENT WHERE STUDENT_ID = ? AND COURSE_ID= ?;";

	@Override
	public List<Enrolment> getAll() throws Exception {
		List<Enrolment> enrolments = new ArrayList<>();

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ENROLMENT);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String sid = rs.getString("STUDENT_ID");
				int cid = rs.getInt("COURSE_ID");
				boolean eli = rs.getBoolean("ELIGIBILITY");
				enrolments.add(new Enrolment(sid, cid, eli));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrolments;
	}

	@Override
	public Enrolment getById(String sid, int cid) throws Exception {
		Enrolment enrolment = null;

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ENROLMENT_BY_ID);) {
			preparedStatement.setString(1, sid);
			preparedStatement.setInt(2, cid);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				boolean eli = rs.getBoolean("ELIGIBILITY");
				enrolment = new Enrolment(sid, cid, eli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrolment;
	}

	@Override
	public boolean add(Enrolment enrolment) throws Exception {
		boolean added = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ENROLMENT_SQL)) {
			preparedStatement.setString(1, enrolment.getStudent_id());
			preparedStatement.setInt(2, enrolment.getCourse_id());
			preparedStatement.setBoolean(3, enrolment.isEligibility());
			added = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean update(Enrolment enrolment) throws Exception {
		boolean updated = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ENROLMENT_SQL);) {
			statement.setBoolean(1, enrolment.isEligibility());
			statement.setString(2, enrolment.getStudent_id());
			statement.setInt(3, enrolment.getCourse_id());
			updated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean delete(Enrolment enrolment) throws Exception {
		boolean deleted;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ENROLMENT_SQL);) {
			statement.setString(1, enrolment.getStudent_id());
			statement.setInt(2, enrolment.getCourse_id());
			deleted = statement.executeUpdate() > 0;
		}
		return deleted;
	}

}
