package com.dao;


import com.model.Package;

import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class PackageDAO {
	    private Connection connection;

	    public PackageDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public boolean addPackage(Package travelPackage) throws SQLException {
	        String query = "INSERT INTO packages (destination_id, package_name, description, price, available_from, available_to) VALUES (?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, travelPackage.getDestinationId());
	            stmt.setString(2, travelPackage.getPackageName());
	            stmt.setString(3, travelPackage.getDescription());
	            stmt.setBigDecimal(4, travelPackage.getPrice());
	            stmt.setDate(5, travelPackage.getAvailableFrom());
	            stmt.setDate(6, travelPackage.getAvailableTo());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public Package getPackageById(int packageId) throws SQLException {
	        String query = "SELECT * FROM packages WHERE package_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, packageId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Package(
	                        rs.getInt("package_id"),
	                        rs.getInt("destination_id"),
	                        rs.getString("package_name"),
	                        rs.getString("description"),
	                        rs.getBigDecimal("price"),
	                        rs.getDate("available_from"),
	                        rs.getDate("available_to"));
	            }
	        }
	        return null;
	    }

	    public boolean updatePackage(Package travelPackage) throws SQLException {
	        String query = "UPDATE packages SET destination_id = ?, package_name = ?, description = ?, price = ?, available_from = ?, available_to = ? WHERE package_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, travelPackage.getDestinationId());
	            stmt.setString(2, travelPackage.getPackageName());
	            stmt.setString(3, travelPackage.getDescription());
	            stmt.setBigDecimal(4, travelPackage.getPrice());
	            stmt.setDate(5, travelPackage.getAvailableFrom());
	            stmt.setDate(6, travelPackage.getAvailableTo());
	            stmt.setInt(7, travelPackage.getPackageId());
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public boolean deletePackage(int packageId) throws SQLException {
	        String query = "DELETE FROM packages WHERE package_id = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setInt(1, packageId);
	            return stmt.executeUpdate() > 0;
	        }
	    }

	    public List<Package> getAllPackages() throws SQLException {
	        List<Package> packages = new ArrayList<>();
	        String query = "SELECT * FROM packages";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                packages.add(new Package(
	                        rs.getInt("package_id"),
	                        rs.getInt("destination_id"),
	                        rs.getString("package_name"),
	                        rs.getString("description"),
	                        rs.getBigDecimal("price"),
	                        rs.getDate("available_from"),
	                        rs.getDate("available_to")));
	            }
	        }
	        return packages;
	    }
	}

