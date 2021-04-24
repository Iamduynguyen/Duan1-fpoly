package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Student;
import service.SQLServerConnUtils;

public class DbCourseDAO implements CourseDAO {
	private static final String SELECT_ALL_COURSES = "SELECT * FROM COURSES";
	private static final String SELECT_COURSE_BY_ID = "SELECT COURSE_ID, COURSE_NAME FROM COURSES WHERE COURSE_ID = ?";
	private static final String INSERT_COURSE_SQL = "INSERT INTO COURSES (COURSE_NAME) VALUES (?);";
	private static final String UPDATE_COURSE_SQL = "UPDATE COURSES SET COURSE_NAME = ? WHERE COURSE_ID = ?;";
	private static final String DELETE_COURSE_SQL = "DELETE FROM COURSES WHERE COURSE_ID = ?;";

	@Override
	public List<Course> getAll() throws Exception {
		List<Course> courses = new ArrayList<>();

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("COURSE_ID");
				String name = rs.getString("COURSE_NAME");				
				courses.add(new Course(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public Course getById(int id) throws Exception {
		Course course = null;

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_BY_ID);) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("COURSE_NAME");	
				course = new Course(id, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public boolean add(Course course) throws Exception {
		boolean added = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE_SQL)) {
			preparedStatement.setString(1, course.getCourse_name());
			preparedStatement.setInt(2, course.getCourse_id());
			added = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean update(Course course) throws Exception {
		boolean updated = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_COURSE_SQL);) {
			statement.setString(1, course.getCourse_name());
			statement.setInt(2, course.getCourse_id());

			updated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean delete(Course course) throws Exception {
		boolean deleted;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_COURSE_SQL);) {
			statement.setInt(1, course.getCourse_id());
			deleted = statement.executeUpdate() > 0;
		}
		return deleted;
	}

}
