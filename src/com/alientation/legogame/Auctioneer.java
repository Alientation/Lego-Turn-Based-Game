package com.alientation.legogame;

import java.util.Scanner;

import org.json.simple.JSONObject;

public class Auctioneer {
	
	public static JSONObject dataFile;
	
	public static double soldierBaseAuctionPrice = 20;
	public static double soldierMaxAuctionPrice = 40;
	
	public static int soldierBaseAuctionAmount = 3;
	public static int soldierMaxAuctionAmount = 9;
	
	public static int unarmedVehicleAuctionChance = 20;
	public static int armedVehicleAuctionChance = 10;
	public static int flightVehicleAuctionChance = 7;
	
	public static double unarmedVehicleBaseAuctionPrice = 75;
	public static double unarmedVehicleMaxAuctionPrice = 150;
	public static double armedVehicleBaseAuctionPrice = 150;
	public static double armedVehicleMaxAuctionPrice = 300;
	public static double flightVehicleBaseAuctionPrice = 300;
	public static double flightVehicleMaxAuctionPrice = 600;
	
	public static Scanner console;
	
	public static void init(JSONObject data) {
		console = Main.console;
		dataFile = data;
		
		soldierBaseAuctionPrice = (double) GameFileHandler.load("soldierBaseAuctionPrice", soldierBaseAuctionPrice);
		soldierMaxAuctionPrice = (double) GameFileHandler.load("soldierMaxAuctionPrice", soldierMaxAuctionPrice);
		soldierBaseAuctionAmount = (int) (long) GameFileHandler.load("soldierBaseAuctionAmount", soldierBaseAuctionAmount);
		soldierMaxAuctionAmount = (int) (long) GameFileHandler.load("soldierMaxAuctionAmount", soldierMaxAuctionAmount);
		unarmedVehicleAuctionChance = (int) (long) GameFileHandler.load("unarmedVehicleAuctionChance", unarmedVehicleAuctionChance);
		armedVehicleAuctionChance = (int) (long) GameFileHandler.load("armedVehicleAuctionChance", armedVehicleAuctionChance);
		flightVehicleAuctionChance = (int) (long) GameFileHandler.load("flightVehicleAuctionChance", flightVehicleAuctionChance);
		
		unarmedVehicleBaseAuctionPrice = (double) GameFileHandler.load("unarmedVehicleBaseAuctionPrice", unarmedVehicleBaseAuctionPrice);
		unarmedVehicleMaxAuctionPrice = (double) GameFileHandler.load("unarmedVehicleMaxAuctionPrice", unarmedVehicleMaxAuctionPrice);
		armedVehicleBaseAuctionPrice = (double) GameFileHandler.load("armedVehicleBaseAuctionPrice", armedVehicleBaseAuctionPrice);
		armedVehicleMaxAuctionPrice = (double) GameFileHandler.load("armedVehicleMaxAuctionPrice", armedVehicleMaxAuctionPrice);
		flightVehicleBaseAuctionPrice = (double) GameFileHandler.load("flightVehicleBaseAuctionPrice", flightVehicleBaseAuctionPrice);
		flightVehicleMaxAuctionPrice = (double) GameFileHandler.load("flightVehicleMaxAuctionPrice", flightVehicleMaxAuctionPrice);
	}
	
	public static void saveGame() {
		GameFileHandler.save("soldierBaseAuctionPrice", soldierBaseAuctionPrice);
		GameFileHandler.save("soldierMaxAuctionPrice", soldierMaxAuctionPrice);
		GameFileHandler.save("soldierBaseAuctionAmount", soldierBaseAuctionAmount);
		GameFileHandler.save("soldierMaxAuctionAmount", soldierMaxAuctionAmount);
		GameFileHandler.save("unarmedVehicleAuctionChance", unarmedVehicleAuctionChance);
		GameFileHandler.save("armedVehicleAuctionChance", armedVehicleAuctionChance);
		GameFileHandler.save("flightVehicleAuctionChance", flightVehicleAuctionChance);
		
		GameFileHandler.save("unarmedVehicleBaseAuctionPrice", unarmedVehicleBaseAuctionPrice);
		GameFileHandler.save("unarmedVehicleMaxAuctionPrice", unarmedVehicleMaxAuctionPrice);
		GameFileHandler.save("armedVehicleBaseAuctionPrice", armedVehicleBaseAuctionPrice);
		GameFileHandler.save("armedVehicleMaxAuctionPrice", armedVehicleMaxAuctionPrice);
		GameFileHandler.save("flightVehicleBaseAuctionPrice", flightVehicleBaseAuctionPrice);
		GameFileHandler.save("flightVehicleMaxAuctionPrice", flightVehicleMaxAuctionPrice);
	}
	
	
	public static void rollAuction() {
		auctionSoldiers();
		Game.addBlankLines();
		int roll = (int) (Math.random()*100 + 1);
		if (roll <= flightVehicleAuctionChance) {
			beginAuction("Flight Vehicle", (int) (Math.random()*(flightVehicleMaxAuctionPrice - flightVehicleBaseAuctionPrice) + flightVehicleBaseAuctionPrice));
		} else if (roll <= armedVehicleAuctionChance) {
			beginAuction("Armed Vehicle", (int) (Math.random()*(armedVehicleMaxAuctionPrice - armedVehicleBaseAuctionPrice) + armedVehicleBaseAuctionPrice));
		} else if (roll <= unarmedVehicleAuctionChance) {
			beginAuction("Unarmed Vehicle", (int) (Math.random()*(unarmedVehicleMaxAuctionPrice - unarmedVehicleBaseAuctionPrice) + unarmedVehicleBaseAuctionPrice));
		}
	}
	
	public static void beginAuction(String name, int highestBid) {
		int whoIsHighest = -1;
		System.out.print("Current Game\t-\tAuctioneer\n" + Main.lineSeparator + "\n" + Game.playerStats() + "\n" + Main.lineSeparator + "\nAuctioning " + name + " for " + highestBid + "$\n(1 <amount>) Rebel Bid\n(2 <amount>) SPF Bid\n(3) End Auction\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		while (input != 3) {
			int amount = console.nextInt();
			console.nextLine();
			if (amount <= highestBid) {
				System.out.println(Main.lineSeparator + "\nError cannot bid less than highest bid idiot!");
				Main.hold();
			} else {
				switch(input) {
				case 1:
					if (amount <= Game.Rebels.getCoinPurse()) {
						highestBid = amount;
						whoIsHighest = 1;
					} else {
						System.out.println(Main.lineSeparator + "\nError cannot bid more that what you have idiot!");
						Main.hold();
					}
					break;
				case 2:
					if (amount <= Game.SPF.getCoinPurse()) {
						highestBid = amount;
						whoIsHighest = 2;
					} else {
						System.out.println(Main.lineSeparator + "\nError cannot bid more that what you have idiot!");
						Main.hold();
					}
					break;
				default:
					System.out.println(Main.lineSeparator + "\nError idiots what did you even input!");
					Main.hold();
					break;
				}
			}
			System.out.print("Current Game\n" + Main.lineSeparator + "\n" + Game.playerStats() + "\n" + Main.lineSeparator + "\nAuctioning " + name + " for " + highestBid + "$\n(1 <amount>) Rebel Bid\n(2 <amount>) SPF Bid\n(3) End Auction\n" + Main.lineSeparator + "\n>>> ");
			input = console.nextInt();
		}
		if (input == 3) {
			console.nextLine();
		}
		switch(whoIsHighest) {
		case -1:
			System.out.println(Main.lineSeparator + "\nI guess nobody wanted " + name + " for " + highestBid +"$");
			Main.hold();
			break;
		case 1:
			System.out.println(Main.lineSeparator + "\nCongratulation REBELS for purchasing " + name + " for " + highestBid + "$");
			Game.Rebels.setPurchaseVehiclesCount(Game.Rebels.getPurchaseVehiclesCount() + 1);
			Game.Rebels.setCoinPurse(Game.Rebels.getCoinPurse() - highestBid);
			Main.hold();
			break;
		case 2:
			System.out.println(Main.lineSeparator + "\nCongratulation SPF for purchasing " + name + " for " + highestBid + "$");
			Game.SPF.setPurchaseVehiclesCount(Game.SPF.getPurchaseVehiclesCount() + 1);
			Game.SPF.setCoinPurse(Game.SPF.getCoinPurse() - highestBid);
			Main.hold();
			break;
		default:
			break;
		}
	}
	
	public static void auctionSoldiers() {
		Game.addBlankLines();
		
		int numSoldiers = (int) (Math.random()*(soldierMaxAuctionAmount - soldierBaseAuctionAmount) + soldierBaseAuctionAmount);
		int highestBid = (int) (Math.random()*(soldierMaxAuctionPrice - soldierBaseAuctionPrice) + soldierBaseAuctionPrice) * numSoldiers;
		int whoIsHighest = -1;
		
		System.out.print("Current Game\t-\tAuctioneer\n" + Main.lineSeparator + "\n" + Game.playerStats() + "\n" + Main.lineSeparator + "\nAuctioning " + numSoldiers + " Soldiers for " + (highestBid) + "$\n(1 <amount>) Rebel Bid\n(2 <amount>) SPF Bid\n(3) End Auction\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		while (input != 3) {
			int amount = console.nextInt();
			console.nextLine();
			if (amount <= highestBid) {
				System.out.println(Main.lineSeparator + "\nError cannot bid less than highest bid idiot!");
				Main.hold();
			} else {
				switch(input) {
				case 1:
					if (amount <= Game.Rebels.getCoinPurse()) {
						highestBid = amount;
						whoIsHighest = 1;
					} else {
						System.out.println(Main.lineSeparator + "\nError cannot bid more that what you have idiot!");
						Main.hold();
					}
					break;
				case 2:
					if (amount <= Game.SPF.getCoinPurse()) {
						highestBid = amount;
						whoIsHighest = 2;
					} else {
						System.out.println(Main.lineSeparator + "\nError cannot bid more that what you have idiot!");
						Main.hold();
					}
					break;
				default:
					System.out.println(Main.lineSeparator + "\nError idiots what did you even input!");
					Main.hold();
					break;
				}
			}
			
			System.out.print("Current Game\n" + Main.lineSeparator + "\n" + Game.playerStats() + "\n" + Main.lineSeparator + "\nAuctioning " + numSoldiers + " Soldiers for " + (highestBid) + "$\n(1 <amount>) Rebel Bid\n(2 <amount>) SPF Bid\n(3) End Auction\n" + Main.lineSeparator + "\n>>> ");
			input = console.nextInt();
		}
		if (input == 3) {
			console.nextLine();
		}
		switch(whoIsHighest) {
		case -1:
			System.out.println(Main.lineSeparator + "\nI guess nobody wanted " + numSoldiers + " soldiers for " + highestBid +"$");
			Main.hold();
			break;
		case 1:
			System.out.println(Main.lineSeparator + "\nCongratulation REBELS for purchasing " + numSoldiers + " soldiers for " + highestBid + "$");
			Game.Rebels.setCoinPurse(Game.Rebels.getCoinPurse() - highestBid);
			Game.Rebels.setPurchaseSoldierCount(Game.Rebels.getPurchaseSoldierCount() + numSoldiers);
			Main.hold();
			break;
		case 2:
			System.out.println(Main.lineSeparator + "\nCongratulation SPF for purchasing " + numSoldiers + " soldiers for " + highestBid + "$");
			Game.SPF.setCoinPurse(Game.SPF.getCoinPurse() - highestBid);
			Game.SPF.setPurchaseSoldierCount(Game.SPF.getPurchaseSoldierCount() + numSoldiers);
			Main.hold();
			break;
		default:
			break;
		}
	}

	public static JSONObject getDataFile() {
		return dataFile;
	}

	public static double getSoldierBaseAuctionPrice() {
		return soldierBaseAuctionPrice;
	}

	public static double getSoldierMaxAuctionPrice() {
		return soldierMaxAuctionPrice;
	}

	public static int getSoldierBaseAuctionAmount() {
		return soldierBaseAuctionAmount;
	}

	public static int getSoldierMaxAuctionAmount() {
		return soldierMaxAuctionAmount;
	}

	public static int getUnarmedVehicleAuctionChance() {
		return unarmedVehicleAuctionChance;
	}

	public static int getArmedVehicleAuctionChance() {
		return armedVehicleAuctionChance;
	}

	public static int getFlightVehicleAuctionChance() {
		return flightVehicleAuctionChance;
	}

	public static void setDataFile(JSONObject dataFile) {
		Auctioneer.dataFile = dataFile;
	}

	public static void setSoldierBaseAuctionPrice(double soldierBaseAuctionPrice) {
		Auctioneer.soldierBaseAuctionPrice = soldierBaseAuctionPrice;
	}

	public static void setSoldierMaxAuctionPrice(double soldierMaxAuctionPrice) {
		Auctioneer.soldierMaxAuctionPrice = soldierMaxAuctionPrice;
	}

	public static void setSoldierBaseAuctionAmount(int soldierBaseAuctionAmount) {
		Auctioneer.soldierBaseAuctionAmount = soldierBaseAuctionAmount;
	}

	public static void setSoldierMaxAuctionAmount(int soldierMaxAuctionAmount) {
		Auctioneer.soldierMaxAuctionAmount = soldierMaxAuctionAmount;
	}

	public static void setUnarmedVehicleAuctionChance(int unarmedVehicleAuctionChance) {
		Auctioneer.unarmedVehicleAuctionChance = unarmedVehicleAuctionChance;
	}

	public static void setArmedVehicleAuctionChance(int armedVehicleAuctionChance) {
		Auctioneer.armedVehicleAuctionChance = armedVehicleAuctionChance;
	}

	public static void setFlightVehicleAuctionChance(int flightVehicleAuctionChance) {
		Auctioneer.flightVehicleAuctionChance = flightVehicleAuctionChance;
	}

	public static double getUnarmedVehicleBaseAuctionPrice() {
		return unarmedVehicleBaseAuctionPrice;
	}

	public static double getUnarmedVehicleMaxAuctionPrice() {
		return unarmedVehicleMaxAuctionPrice;
	}

	public static double getArmedVehicleBaseAuctionPrice() {
		return armedVehicleBaseAuctionPrice;
	}

	public static double getArmedVehicleMaxAuctionPrice() {
		return armedVehicleMaxAuctionPrice;
	}

	public static double getFlightVehicleBaseAuctionPrice() {
		return flightVehicleBaseAuctionPrice;
	}

	public static double getFlightVehicleMaxAuctionPrice() {
		return flightVehicleMaxAuctionPrice;
	}

	public static Scanner getConsole() {
		return console;
	}

	public static void setUnarmedVehicleBaseAuctionPrice(double unarmedVehicleBaseAuctionPrice) {
		Auctioneer.unarmedVehicleBaseAuctionPrice = unarmedVehicleBaseAuctionPrice;
	}

	public static void setUnarmedVehicleMaxAuctionPrice(double unarmedVehicleMaxAuctionPrice) {
		Auctioneer.unarmedVehicleMaxAuctionPrice = unarmedVehicleMaxAuctionPrice;
	}

	public static void setArmedVehicleBaseAuctionPrice(double armedVehicleBaseAuctionPrice) {
		Auctioneer.armedVehicleBaseAuctionPrice = armedVehicleBaseAuctionPrice;
	}

	public static void setArmedVehicleMaxAuctionPrice(double armedVehicleMaxAuctionPrice) {
		Auctioneer.armedVehicleMaxAuctionPrice = armedVehicleMaxAuctionPrice;
	}

	public static void setFlightVehicleBaseAuctionPrice(double flightVehicleBaseAuctionPrice) {
		Auctioneer.flightVehicleBaseAuctionPrice = flightVehicleBaseAuctionPrice;
	}

	public static void setFlightVehicleMaxAuctionPrice(double flightVehicleMaxAuctionPrice) {
		Auctioneer.flightVehicleMaxAuctionPrice = flightVehicleMaxAuctionPrice;
	}

	public static void setConsole(Scanner console) {
		Auctioneer.console = console;
	}
}
