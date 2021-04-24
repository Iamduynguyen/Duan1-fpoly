package dao;

import java.util.List;

import model.Student;

public interface StudentDAO {
	List<Student> getAll() throws Exception;

	Student getById(String id) throws Exception;

	boolean add(Student student) throws Exception;

	boolean update(Student student) throws Exception;

	boolean delete(Student student) throws Exception;
}
