package com.model;


	import java.math.BigDecimal;
	import java.sql.Date;

	public class Package {
	    private int packageId;
	    private int destinationId;
	    private String packageName;
	    private String description;
	    private BigDecimal price;
	    private Date availableFrom;
	    private Date availableTo;

	    // Constructors
	    public Package() {}

	    public Package(int packageId, int destinationId, String packageName, String description, BigDecimal price, Date availableFrom, Date availableTo) {
	        this.packageId = packageId;
	        this.destinationId = destinationId;
	        this.packageName = packageName;
	        this.description = description;
	        this.price = price;
	        this.availableFrom = availableFrom;
	        this.availableTo = availableTo;
	    }

	    // Getters and Setters
	    public int getPackageId() { return packageId; }
	    public void setPackageId(int packageId) { this.packageId = packageId; }

	    public int getDestinationId() { return destinationId; }
	    public void setDestinationId(int destinationId) { this.destinationId = destinationId; }

	    public String getPackageName() { return packageName; }
	    public void setPackageName(String packageName) { this.packageName = packageName; }

	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

	    public BigDecimal getPrice() { return price; }
	    public void setPrice(BigDecimal price) { this.price = price; }

	    public Date getAvailableFrom() { return availableFrom; }
	    public void setAvailableFrom(Date availableFrom) { this.availableFrom = availableFrom; }

	    public Date getAvailableTo() { return availableTo; }
	    public void setAvailableTo(Date availableTo) { this.availableTo = availableTo; }
	}

	
	
	
	
	

