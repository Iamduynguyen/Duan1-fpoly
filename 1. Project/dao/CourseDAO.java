package dao;

import java.util.List;

import model.Course;

public interface CourseDAO {
	List<Course> getAll() throws Exception;

	Course getById(int id) throws Exception;

	boolean add(Course course) throws Exception;

	boolean update(Course course) throws Exception;

	boolean delete(Course course) throws Exception;
}
