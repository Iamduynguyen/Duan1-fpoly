package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.User;
import service.SQLServerConnUtils;

public class DbStudentDAO implements StudentDAO {
	private static final String SELECT_ALL_STUDENTS = "SELECT * FROM STUDENTS";
	private static final String SELECT_STUDENT_BY_ID = "SELECT STUDENT_ID, STUDENT_NAME FROM STUDENTS WHERE STUDENT_ID = ?";
	private static final String INSERT_STUDENT_SQL = "INSERT INTO STUDENTS (STUDENT_ID, STUDENT_NAME) VALUES (?, ?);";
	private static final String UPDATE_STUDENT_SQL = "UPDATE STUDENTS SET STUDENT_NAME = ? WHERE STUDENT_ID = ?;";
	private static final String DELETE_STUDENT_SQL = "DELETE FROM STUDENTS WHERE STUDENT_ID = ?;";

	@Override
	public List<Student> getAll() throws Exception {
		List<Student> students = new ArrayList<>();

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id = rs.getString("STUDENT_ID");
				String name = rs.getString("STUDENT_NAME");				
				students.add(new Student(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getById(String id) throws Exception {
		Student student = null;

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
			preparedStatement.setString(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("STUDENT_NAME");	
				student = new Student(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean add(Student student) throws Exception {
		boolean added = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, student.getStudent_id());
			preparedStatement.setString(2, student.getStudent_name());
			added = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean update(Student student) throws Exception {
		boolean updated = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL);) {
			statement.setString(1, student.getStudent_name());
			statement.setString(2, student.getStudent_id());

			updated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean delete(Student student) throws Exception {
		boolean deleted;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);) {
			statement.setString(1, student.getStudent_id());
			deleted = statement.executeUpdate() > 0;
		}
		return deleted;
	}

}
