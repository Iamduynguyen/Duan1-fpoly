package dao;

import java.util.stream.Stream;

import model.User;

import java.util.List;
import java.util.Optional;

public interface userDAO {

	List<User> getAll() throws Exception;

	User getById(String username) throws Exception;

	boolean add(User user) throws Exception;

	boolean update(User user) throws Exception;

	boolean delete(User user) throws Exception;

}
