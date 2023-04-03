package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckAppRefactored {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		FoodTruck[] foodTruckStorage;
		FoodTruckAppRefactored ftr = new FoodTruckAppRefactored();
		foodTruckStorage = ftr.addFoodTrucks(sc);
		ftr.menu(sc, foodTruckStorage);

	}

	public FoodTruck[] addFoodTrucks(Scanner sc) {
		FoodTruck[] output = new FoodTruck[5];
		String name, type;
		int rating = 0;

		System.out.println("Welcome to the foodtruck rater!");
		for (int i = 0; i < output.length; i++) {
			boolean keepGoing = true;
			System.out.println("What is the name of FoodTruck #" + (i + 1) + " ?:");
			name = sc.nextLine();
			if (name.toLowerCase().equals("quit")) {
				break;
			}
			System.out.println("What type of food does " + name + " serve?:");
			type = sc.nextLine();
			while (keepGoing) {
				try {
					System.out.println("Please enter a rating on a scale of 1 to 5 for " + name);
					rating = sc.nextInt();
					sc.nextLine();
					keepGoing = false;
				} catch (Exception e) {
					System.out.println("Please enter a valid number!");
					sc.nextLine();
				}
			}

			output[i] = new FoodTruck(name, type, rating);
		}

		return output;
	}

	public void menu(Scanner sc, FoodTruck[] inputFT) {
		boolean keepGoing = true;
		while (keepGoing) {
			int userInput = 0;
			System.out.println("");
			System.out.println(" __________________________________________________________________");
			System.out.println("/\\                                                                 \\");
			System.out.println("\\_|          Please pick from the following menu options:          |");
			System.out.println("  |           1.) List all existing food trucks                    |");
			System.out.println("  |           2.) See the average rating of food trucks            |");
			System.out.println("  |           3.) Display the highest-rated food truck             |");
			System.out.println("  |           4.) Quit the program                                 |");
			System.out.println("  |  ______________________________________________________________|_");
			System.out.println("  \\_/_______________________________________________________________/");
			System.out.println("");
			userInput = sc.nextInt();

			if (userInput == 1) {
				int fTCount = 0;
				for (int i = 0; i < inputFT.length; i++) {
					if (inputFT[i] == null) {
						break;
					}
					fTCount++;
					System.out.println("NAME: " + inputFT[i].getName() + " FOOD TYPE: " + inputFT[i].getFoodType()
							+ " RATING: " + inputFT[i].getRating());
				}
				if (fTCount == 0) {
					System.out.println("No Food Trucks");

				}
				sc.nextLine();
			}

			else if (userInput == 2) {
				double combined = 0.0;
				int fTCount = 0;
				for (int i = 0; i < inputFT.length; i++) {
					if (inputFT[i] == null) {
						break;
					}
					combined = combined + inputFT[i].getRating();
					fTCount++;
				}
				if (fTCount > 0) {
					System.out.println("The average rating of all of the Food Trucks is: " + (combined / fTCount));
					sc.nextLine();
				} else {
					System.out.println("There are no food Trucks");
				}
			}

			else if (userInput == 3) {
				int fTCount = 0;
				FoodTruck ft = new FoodTruck("","", 0);
				for (int i = 0; i < inputFT.length; i++) {
					if (inputFT[i] == null) {
						break;
					}
					fTCount++;
					if(inputFT[i].getRating() > ft.getRating()) {
						ft = inputFT[i];
					}
				}
				if (fTCount > 0) {
					System.out.println("NAME: " + ft.getName() + " FOOD TYPE: " + ft.getFoodType()
					+ " RATING: " + ft.getRating());
				}else {
					System.out.println("No Food Trucks");
					
				}
				sc.nextLine();
				
			}

			else if (userInput == 4) {
				System.out.println(
						" ________  ________  ________  ________  ________      ___    ___ _______   ___            ________  ________  _____ ______   _______           ________  ________  ________  ___  ________      ");
				System.out.println(
						"|\\   ____\\|\\   __  \\|\\   __  \\|\\   ___ \\|\\   __  \\    |\\  \\  /  /|\\  ___ \\ |\\  \\          |\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\         |\\   __  \\|\\   ____\\|\\   __  \\|\\  \\|\\   ___  \\    ");
				System.out.println(
						"\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  \\|\\ /_   \\ \\  \\/  / | \\   __/|\\ \\  \\         \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|        \\ \\  \\|\\  \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\ \\  \\\\ \\  \\   ");
				System.out.println(
						" \\ \\  \\  __\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\ \\   __  \\   \\ \\    / / \\ \\  \\_|/_\\ \\  \\         \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\  \\_|/__       \\ \\   __  \\ \\  \\  __\\ \\   __  \\ \\  \\ \\  \\\\ \\  \\  ");
				System.out.println(
						"  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\ \\  \\|\\  \\   \\/  /  /   \\ \\  \\_|\\ \\ \\__\\         \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\       \\ \\  \\ \\  \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\ \\  \\\\ \\  \\ ");
				System.out.println(
						"   \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\__/  / /      \\ \\_______\\|__|          \\ \\_______\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\       \\ \\__\\ \\__\\ \\_______\\ \\__\\ \\__\\ \\__\\ \\__\\\\ \\__\\");
				System.out.println(
						"    \\|_______|\\|_______|\\|_______|\\|_______|\\|_______|\\___/ /        \\|_______|   ___         \\|_______|\\|_______|\\|__|     \\|__|\\|_______|        \\|__|\\|__|\\|_______|\\|__|\\|__|\\|__|\\|__| \\|__|");
				System.out.println(
						"                                                     \\|___|/                     |\\__\\                                                                                                           ");
				System.out.println(
						"                                                                                 \\|__|                                                                                                           ");
				System.out.println(
						"                                                                                                                                                                                                 ");
				System.out.println("");
				keepGoing = false;
			} else {

			}
		}

	}

}
