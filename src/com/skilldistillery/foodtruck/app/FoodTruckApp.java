package com.skilldistillery.foodtruck.app;

import java.util.Scanner;
import com.skilldistillery.foodtruck.entities.FoodTruck; //idk if im supposed to import this??

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX_FOODTRUCK_REVIEWS = 5;
		FoodTruck[] foodTruckreviewStorage = new FoodTruck[MAX_FOODTRUCK_REVIEWS];
		boolean keepGoing = true;

		// array needs to go in here

		System.out.println("Welcome to the Food Truck review!");

		// loop to make the food trucks
		for (int i = 0; i < 5; i++) {
			System.out.println("Please enter the name of the food truck: ");
			String name = sc.nextLine();

			if (name.equals("quit")) {
				break;
			} else {
				System.out.println("Please enter the type of food the food truck served: ");
				String foodType = sc.nextLine();
				System.out.println("Please rate the food truck on a scale of 1 to 5: "); // change later
				int rating = sc.nextInt();
				sc.nextLine();
				foodTruckreviewStorage[i] = new FoodTruck(name, foodType, rating);
			}
		} // while loop curly brace
		keepGoing = true;
		while (keepGoing) {
			System.out.println("Would you like to:");
			System.out.println("1) Type \"L\" if you want to see a list of the food trucks you reviewed.");
			System.out.println("2) Type \"R\" if you want an average rating of all of the food trucks?");
			System.out.println("3) Type \"H\" if you want the highest rated food truck.");
			System.out.println("3) Type \"Quit\" if you want to quit the program.");
			String userInput = sc.nextLine();

			if (userInput.equalsIgnoreCase("L")) {
				for (int i = 0; i < foodTruckreviewStorage.length; i++) {
					if (foodTruckreviewStorage[i] != null) {
						System.out.println(foodTruckreviewStorage[i].getFTData());
					}
				}

			} else if (userInput.equalsIgnoreCase("R")) {
				double total = 0;
				int numTrucks = 0;
				for (int i = 0; i < foodTruckreviewStorage.length; i++) {
					if (foodTruckreviewStorage[i] != null) {
						total += foodTruckreviewStorage[i].getRating();
					} else {
						numTrucks = i;
						break;
					}
				}
				if (numTrucks == 0) {
					numTrucks = 5;
				}
				double ave = total / numTrucks;

				System.out.println("the total average rating for the food trucks is " + ave);

			} else if (userInput.equalsIgnoreCase("H")) {
				String foodTruckHighest = "";
				double maxRating = 0.0;
				for (int i = 0; i < foodTruckreviewStorage.length; i++) {
					if (foodTruckreviewStorage[i] != null) {
						if (maxRating < foodTruckreviewStorage[i].getRating()) {
							maxRating = foodTruckreviewStorage[i].getRating();
							foodTruckHighest = foodTruckreviewStorage[i].getFTData();
							
						}
					}

				}
				System.out.println("The food truck with the highest rating is: " + "\n" + foodTruckHighest);
				System.out.println();

			} else if (userInput.equalsIgnoreCase("quit")) {
				keepGoing = false;
				System.out.println("Thank you come again!");
				break;

			} else {
				System.out.println("Please enter a valid option from the menu!");
				continue;
			}

		}

		sc.close();
	}// main method curly brace

}
