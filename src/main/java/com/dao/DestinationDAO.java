package com.dao;



	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import com.model.Destination;

	public class DestinationDAO {
	    private Connection connection;

	    public DestinationDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public boolean addDestination(Destination destination) throws SQLException {
	        String query = "INSERT INTO destinations (name, location, description, image_url) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, destination.getName());
	            stmt.setString(2, destination.getLocation());
	            stmt.setString(3, destination.getDescription());
	            stmt.setString(4, destination.getImageUrl());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public Destination getDestinationById(int destinationId) throws SQLException {
	        String query = "SELECT * FROM destinations WHERE destination_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, destinationId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Destination(
	                        rs.getInt("destination_id"),
	                        rs.getString("name"),
	                        rs.getString("location"),
	                        rs.getString("description"),
	                        rs.getString("image_url"));
	            }
	        }
	        return null;
	    }

	    public boolean updateDestination(Destination destination) throws SQLException {
	        String query = "UPDATE destinations SET name = ?, location = ?, description = ?, image_url = ? WHERE destination_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, destination.getName());
	            stmt.setString(2, destination.getLocation());
	            stmt.setString(3, destination.getDescription());
	            stmt.setString(4, destination.getImageUrl());
	            stmt.setInt(5, destination.getDestinationId());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public boolean deleteDestination(int destinationId) throws SQLException {
	        String query = "DELETE FROM destinations WHERE destination_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, destinationId);
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public List<Destination> getAllDestinations() throws SQLException {
	        List<Destination> destinations = new ArrayList<>();
	        String query = "SELECT * FROM destinations";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                destinations.add(new Destination(
	                        rs.getInt("destination_id"),
	                        rs.getString("name"),
	                        rs.getString("location"),
	                        rs.getString("description"),
	                        rs.getString("image_url")));
	            }
	        }
	        return destinations;
	    }
	}

