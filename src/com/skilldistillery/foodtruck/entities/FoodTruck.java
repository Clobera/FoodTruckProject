package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private String name;
	private String foodType;
	private int rating;
	private static int nextTruckId;
	private int id;
	public FoodTruck() { }
	
	public FoodTruck(String name, String foodType, int rating){
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		
		id = nextTruckId++;   
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public static int getNextTruckId() {
		return nextTruckId;
	}

	public static void setNextTruckId(int nextTruckId) {
		FoodTruck.nextTruckId = nextTruckId;
	}

	public int getId() {
		return id;
	}

	
	public String getFTData() {
		String FTData = "Name: " + name + " Type of food: " + foodType + " Rating: " + rating + " the id is: " + id ;
		
		return FTData;	
	}
	
	
}
