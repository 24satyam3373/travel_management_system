package com.model;



	import java.sql.Date;

	public class Booking {
	    private int bookingId;
	    private int userId;
	    private int packageId;
	    private Date bookingDate;
	    private String status;

	    // Constructors
	    public Booking() {}

	    public Booking(int bookingId, int userId, int packageId, Date bookingDate, String status) {
	        this.bookingId = bookingId;
	        this.userId = userId;
	        this.packageId = packageId;
	        this.bookingDate = bookingDate;
	        this.status = status;
	    }

	    // Getters and Setters
	    public int getBookingId() { return bookingId; }
	    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

	    public int getUserId() { return userId; }
	    public void setUserId(int userId) { this.userId = userId; }

	    public int getPackageId() { return packageId; }
	    public void setPackageId(int packageId) { this.packageId = packageId; }

	    public Date getBookingDate() { return bookingDate; }
	    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }
	}

