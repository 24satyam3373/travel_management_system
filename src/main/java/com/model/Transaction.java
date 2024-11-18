package com.model;



	import java.math.BigDecimal;
	import java.sql.Timestamp;

	public class Transaction {
	    private int transactionId;
	    private int bookingId;
	    private BigDecimal amount;
	    private Timestamp transactionDate;
	    private String paymentStatus;

	    // Constructors
	    public Transaction() {}

	    public Transaction(int transactionId, int bookingId, BigDecimal amount, Timestamp transactionDate, String paymentStatus) {
	        this.transactionId = transactionId;
	        this.bookingId = bookingId;
	        this.amount = amount;
	        this.transactionDate = transactionDate;
	        this.paymentStatus = paymentStatus;
	    }

	    // Getters and Setters
	    public int getTransactionId() { return transactionId; }
	    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

	    public int getBookingId() { return bookingId; }
	    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

	    public BigDecimal getAmount() { return amount; }
	    public void setAmount(BigDecimal amount) { this.amount = amount; }

	    public Timestamp getTransactionDate() { return transactionDate; }
	    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }

	    public String getPaymentStatus() { return paymentStatus; }
	    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
	}

