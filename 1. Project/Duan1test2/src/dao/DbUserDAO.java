package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import model.User;
import service.SQLServerConnUtils;

public class DbUserDAO implements userDAO {
	private static final String SELECT_ALL_USERS = "SELECT * FROM USERS";
	private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM USERS WHERE USERNAME = ?";
	private static final String INSERT_USERS_SQL = "INSERT INTO USERS (USERNAME, PASS) VALUES (?, ?);";
	private static final String UPDATE_USERS_SQL = "UPDATE USERS SET PASS = ? WHERE USERNAME = ?;";
	private static final String DELETE_USERS_SQL = "DELETE FROM USERS WHERE USERNAME = ?;";

	@Override
	public List<User> getAll() throws Exception {
		List<User> users = new ArrayList<>();

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("USERNAME");
				String pass = rs.getString("PASS");
				users.add(new User(name, pass));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
        
        public static void main(String[] args) {
            try {
                DbUserDAO x =new DbUserDAO();
                System.out.println(x.getAll().get(0).getUsername());
            } catch (Exception e) {
            }
    }

	@Override
	public User getById(String username) throws Exception {
		User user = null;

		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);) {
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("USERNAME");
				String pass = rs.getString("PASS");
				user = new User(name, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean add(User user) throws Exception {
		boolean added = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			added = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public boolean update(User user) throws Exception {
		boolean updated = false;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getUsername());

			updated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean delete(User user) throws Exception {
		boolean deleted;
		try (Connection connection = SQLServerConnUtils.getSQLServerConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, user.getUsername());
			deleted = statement.executeUpdate() > 0;
		}
		return deleted;
	}

}
