package com.dao;



	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import com.model.User;

	public class UserDAO {
	    private Connection connection;

	    public UserDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public boolean addUser(User user) throws SQLException {
	        String query = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getPassword());
	            stmt.setString(3, user.getEmail());
	            stmt.setString(4, user.getRole());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public User getUserById(int userId) throws SQLException {
	        String query = "SELECT * FROM users WHERE user_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, userId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new User(
	                        rs.getInt("user_id"),
	                        rs.getString("username"),
	                        rs.getString("password"),
	                        rs.getString("email"),
	                        rs.getString("role"));
	            }
	        }
	        return null;
	    }

	    public boolean updateUser(User user) throws SQLException {
	        String query = "UPDATE users SET username = ?, password = ?, email = ?, role = ? WHERE user_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getPassword());
	            stmt.setString(3, user.getEmail());
	            stmt.setString(4, user.getRole());
	            stmt.setInt(5, user.getUserId());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public boolean deleteUser(int userId) throws SQLException {
	        String query = "DELETE FROM users WHERE user_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, userId);
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public List<User> getAllUsers() throws SQLException {
	        List<User> users = new ArrayList<>();
	        String query = "SELECT * FROM users";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                users.add(new User(
	                        rs.getInt("user_id"),
	                        rs.getString("username"),
	                        rs.getString("password"),
	                        rs.getString("email"),
	                        rs.getString("role")));
	            }
	        }
	        return users;
	    }
	}

