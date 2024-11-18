package com.model;

public class Destination {

	
	    private int destinationId;
	    private String name;
	    private String location;
	    private String description;
	    private String imageUrl;

	    // Constructors
	    public Destination() {}

	    public Destination(int destinationId, String name, String location, String description, String imageUrl) {
	        this.destinationId = destinationId;
	        this.name = name;
	        this.location = location;
	        this.description = description;
	        this.imageUrl = imageUrl;
	    }

	    // Getters and Setters
	    public int getDestinationId() { return destinationId; }
	    public void setDestinationId(int destinationId) { this.destinationId = destinationId; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getLocation() { return location; }
	    public void setLocation(String location) { this.location = location; }

	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

	    public String getImageUrl() { return imageUrl; }
	    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
	}

	
	
	

