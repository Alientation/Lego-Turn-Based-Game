package com.alientation.legogame;

import java.util.Scanner;

import org.json.simple.JSONObject;

public class Upgrades {
	public static Scanner console;
	public static JSONObject dataFile = null;
	public static double increment = 1.1;
	
	
	public static double increaseMaximumSoldierAuctionedPrice = 60;
	public static double increaseUnarmedVehicleAuctionChance = 150;
	public static double increaseArmedVehicleAuctionChance = 250;
	public static double increaseFlightVehicleAuctionChance = 400;
	
	public static double rebelIncreaseCoinsPerRound = 20;
	public static double rebelIncreaseCoinsPerTerritory = 100;
	
	
	public static double SPFIncreaseCoinsPerRound = 20;
	public static double SPFIncreaseCoinsPerTerritory = 100;
	
	
	
	public static void init(JSONObject data) {
		console = Main.console;
		dataFile = data;
		
		increaseMaximumSoldierAuctionedPrice = (double) GameFileHandler.load("increaseMaximumSoldierAuctionedPrice", increaseMaximumSoldierAuctionedPrice);
		increaseUnarmedVehicleAuctionChance = (double) GameFileHandler.load("increaseUnarmedVehicleAuctionChance", increaseUnarmedVehicleAuctionChance);
		increaseArmedVehicleAuctionChance = (double) GameFileHandler.load("increaseArmedVehicleAuctionChance", increaseArmedVehicleAuctionChance);
		increaseFlightVehicleAuctionChance = (double) GameFileHandler.load("increaseFlightVehicleAuctionChance", increaseFlightVehicleAuctionChance);
		
		rebelIncreaseCoinsPerRound = (double) GameFileHandler.load("rebelIncreaseCoinsPerRound", rebelIncreaseCoinsPerRound);
		rebelIncreaseCoinsPerTerritory = (double) GameFileHandler.load("rebelIncreaseCoinsPerTerritory", rebelIncreaseCoinsPerTerritory);
		
		SPFIncreaseCoinsPerRound = (double) GameFileHandler.load("SPFIncreaseCoinsPerRound", SPFIncreaseCoinsPerRound);
		SPFIncreaseCoinsPerTerritory = (double) GameFileHandler.load("SPFIncreaseCoinsPerTerritory", SPFIncreaseCoinsPerTerritory);
		
		/*
		increaseMaximumSoldierAuctionedPrice = (double) dataFile.get("increaseMaximumSoldierAuctionedPrice");
		increaseUnarmedVehicleAuctionChance = (double) dataFile.get("increaseUnarmedVehicleAuctionChance");
		increaseArmedVehicleAuctionChance = (double) dataFile.get("increaseArmedVehicleAuctionChance");
		increaseFlightVehicleAuctionChance = (double) dataFile.get("increaseFlightVehicleAuctionChance");
		
		rebelIncreaseCoinsPerRound = (double) dataFile.get("rebelIncreaseCoinsPerRound");
		rebelIncreaseCoinsPerTerritory = (double) dataFile.get("rebelIncreaseCoinsPerTerritory");
		
		SPFIncreaseCoinsPerRound = (double) dataFile.get("SPFIncreaseCoinsPerRound");
		SPFIncreaseCoinsPerTerritory = (double) dataFile.get("SPFIncreaseCoinsPerTerritory");
		*/
	}
	
	public static void saveGame() {
		GameFileHandler.save("increaseMaximumSoldierAuctionedPrice", increaseMaximumSoldierAuctionedPrice);
		GameFileHandler.save("increaseUnarmedVehicleAuctionChance", increaseUnarmedVehicleAuctionChance);
		GameFileHandler.save("increaseArmedVehicleAuctionChance", increaseArmedVehicleAuctionChance);
		GameFileHandler.save("increaseFlightVehicleAuctionChance", increaseFlightVehicleAuctionChance);
		
		GameFileHandler.save("rebelIncreaseCoinsPerRound", rebelIncreaseCoinsPerRound);
		GameFileHandler.save("rebelIncreaseCoinsPerTerritory", rebelIncreaseCoinsPerTerritory);
		
		GameFileHandler.save("SPFIncreaseCoinsPerRound", SPFIncreaseCoinsPerRound);
		GameFileHandler.save("SPFIncreaseCoinsPerTerritory", SPFIncreaseCoinsPerTerritory);
	}
	
	public static void increaseMaximumSoldierAuctioned(Player player) {
		System.out.println("Increase Maximum Soldier Auctioned Upgrade - " + increaseMaximumSoldierAuctionedPrice + "$");
		if (player.getCoinPurse() < increaseMaximumSoldierAuctionedPrice) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) increaseMaximumSoldierAuctionedPrice - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) increaseMaximumSoldierAuctionedPrice) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) increaseMaximumSoldierAuctionedPrice);
			Auctioneer.setSoldierMaxAuctionAmount(Auctioneer.getSoldierMaxAuctionAmount() + 1);
			Auctioneer.setSoldierMaxAuctionPrice(Auctioneer.getSoldierMaxAuctionPrice() + 5);
			increaseMaximumSoldierAuctionedPrice *= increment;
			Main.hold();
		}
	}

	public static void increaseUnarmedVehicleAuctionChance(Player player) {
		System.out.println("Increase Unarmed Vehicle Auction Chance Upgrade - " + increaseUnarmedVehicleAuctionChance + "$");
		if (player.getCoinPurse() < increaseUnarmedVehicleAuctionChance) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) increaseUnarmedVehicleAuctionChance - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) increaseUnarmedVehicleAuctionChance) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) increaseUnarmedVehicleAuctionChance);
			Auctioneer.setUnarmedVehicleAuctionChance(Auctioneer.getUnarmedVehicleAuctionChance() + 1);
			Auctioneer.setUnarmedVehicleMaxAuctionPrice(Auctioneer.getUnarmedVehicleMaxAuctionPrice() + 30);
			increaseUnarmedVehicleAuctionChance *= increment;
			Main.hold();
		}
	}
	
	public static void increaseArmedVehicleAuctionChance(Player player) {
		System.out.println("Increase Armed Vehicle Auction Chance Upgrade - " + increaseArmedVehicleAuctionChance + "$");
		if (player.getCoinPurse() < increaseArmedVehicleAuctionChance) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) increaseArmedVehicleAuctionChance - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) increaseArmedVehicleAuctionChance) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) increaseArmedVehicleAuctionChance);
			Auctioneer.setArmedVehicleAuctionChance(Auctioneer.getArmedVehicleAuctionChance() + 1);
			Auctioneer.setArmedVehicleMaxAuctionPrice(Auctioneer.getArmedVehicleMaxAuctionPrice() + 75);
			increaseArmedVehicleAuctionChance *= increment;
			Main.hold();
		}
	}
	
	public static void increaseFlightVehicleAuctionChance(Player player) {
		System.out.println("Increase Flight Vehicle Auction Chance Upgrade - " + increaseFlightVehicleAuctionChance + "$");
		if (player.getCoinPurse() < increaseFlightVehicleAuctionChance) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) increaseFlightVehicleAuctionChance - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) increaseFlightVehicleAuctionChance) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) increaseFlightVehicleAuctionChance);
			Auctioneer.setFlightVehicleAuctionChance(Auctioneer.getFlightVehicleAuctionChance() + 1);
			Auctioneer.setFlightVehicleMaxAuctionPrice(Auctioneer.getFlightVehicleMaxAuctionPrice() + 125);
			increaseFlightVehicleAuctionChance *= increment;
			Main.hold();
		}
	}
	
	public static void rebelIncreaseCoinsPerRound(Player player) {
		System.out.println("Increase Rebel Coins Per Round Upgrade - " + rebelIncreaseCoinsPerRound + "$");
		if (player.getCoinPurse() < rebelIncreaseCoinsPerRound) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) rebelIncreaseCoinsPerRound - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) rebelIncreaseCoinsPerRound) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) rebelIncreaseCoinsPerRound);
			Game.setRebelCoinsPerRound(Game.getRebelCoinsPerRound() + 2);
			rebelIncreaseCoinsPerRound *= increment;
			Main.hold();
		}
	}
	
	public static void rebelIncreaseCoinsPerTerritory(Player player) {
		System.out.println("Increase Rebel Coins Per Territory Upgrade - " + rebelIncreaseCoinsPerTerritory + "$");
		if (player.getCoinPurse() < rebelIncreaseCoinsPerTerritory) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) rebelIncreaseCoinsPerTerritory - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) rebelIncreaseCoinsPerTerritory) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) rebelIncreaseCoinsPerTerritory);
			Game.setRebelCoinsPerTerritory(Game.getRebelCoinsPerTerritory() + 1);
			rebelIncreaseCoinsPerTerritory *= increment;
			Main.hold();
		}
	}
	
	public static void SPFIncreaseCoinsPerRound(Player player) {
		System.out.println("Increase SPF Coins Per Round Upgrade - " + SPFIncreaseCoinsPerRound + "$");
		if (player.getCoinPurse() < SPFIncreaseCoinsPerRound) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) SPFIncreaseCoinsPerRound - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) SPFIncreaseCoinsPerRound) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) SPFIncreaseCoinsPerRound);
			Game.setSPFCoinsPerRound(Game.getSPFCoinsPerRound() + 2);
			SPFIncreaseCoinsPerRound *= increment;
			Main.hold();
		}
	}
	
	public static void SPFIncreaseCoinsPerTerritory(Player player) {
		System.out.println("Increase SPF Coins Per Territory Upgrade - " + SPFIncreaseCoinsPerTerritory + "$");
		if (player.getCoinPurse() < SPFIncreaseCoinsPerTerritory) {
			System.out.println(Main.lineSeparator + "\nYou do not have enough coins to purchase this upgrade! Missing " + ((int) SPFIncreaseCoinsPerTerritory - player.getCoinPurse()) + "$");
			Main.hold();
		} else {
			System.out.println(Main.lineSeparator + "\nPurchasing this upgrade for " + ((int) SPFIncreaseCoinsPerTerritory) + "$");
			
			player.setCoinPurse(player.getCoinPurse() - (int) SPFIncreaseCoinsPerTerritory);
			Game.setSPFCoinsPerTerritory(Game.getSPFCoinsPerTerritory() + 1);
			SPFIncreaseCoinsPerTerritory *= increment;
			Main.hold();
		}
	}
	
	
	
	
	public static Scanner getConsole() {
		return console;
	}

	public static JSONObject getDataFile() {
		return dataFile;
	}

	public static double getIncrement() {
		return increment;
	}

	public static double getIncreaseMaximumSoldierAuctionedPrice() {
		return increaseMaximumSoldierAuctionedPrice;
	}

	public static double getIncreaseUnarmedVehicleAuctionChance() {
		return increaseUnarmedVehicleAuctionChance;
	}

	public static double getIncreaseArmedVehicleAuctionChance() {
		return increaseArmedVehicleAuctionChance;
	}

	public static double getIncreaseFlightVehicleAuctionChance() {
		return increaseFlightVehicleAuctionChance;
	}

	public static double getRebelIncreaseCoinsPerRound() {
		return rebelIncreaseCoinsPerRound;
	}

	public static double getRebelIncreaseCoinsPerTerritory() {
		return rebelIncreaseCoinsPerTerritory;
	}

	public static double getSPFIncreaseCoinsPerRound() {
		return SPFIncreaseCoinsPerRound;
	}

	public static double getSPFIncreaseCoinsPerTerritory() {
		return SPFIncreaseCoinsPerTerritory;
	}

	public static void setConsole(Scanner console) {
		Upgrades.console = console;
	}

	public static void setDataFile(JSONObject dataFile) {
		Upgrades.dataFile = dataFile;
	}

	public static void setIncrement(double increment) {
		Upgrades.increment = increment;
	}

	public static void setIncreaseMaximumSoldierAuctionedPrice(double increaseMaximumSoldierAuctionedPrice) {
		Upgrades.increaseMaximumSoldierAuctionedPrice = increaseMaximumSoldierAuctionedPrice;
	}

	public static void setIncreaseUnarmedVehicleAuctionChance(double increaseUnarmedVehicleAuctionChance) {
		Upgrades.increaseUnarmedVehicleAuctionChance = increaseUnarmedVehicleAuctionChance;
	}

	public static void setIncreaseArmedVehicleAuctionChance(double increaseArmedVehicleAuctionChance) {
		Upgrades.increaseArmedVehicleAuctionChance = increaseArmedVehicleAuctionChance;
	}

	public static void setIncreaseFlightVehicleAuctionChance(double increaseFlightVehicleAuctionChance) {
		Upgrades.increaseFlightVehicleAuctionChance = increaseFlightVehicleAuctionChance;
	}

	public static void setRebelIncreaseCoinsPerRound(double rebelIncreaseCoinsPerRound) {
		Upgrades.rebelIncreaseCoinsPerRound = rebelIncreaseCoinsPerRound;
	}

	public static void setRebelIncreaseCoinsPerTerritory(double rebelIncreaseCoinsPerTerritory) {
		Upgrades.rebelIncreaseCoinsPerTerritory = rebelIncreaseCoinsPerTerritory;
	}

	public static void setSPFIncreaseCoinsPerRound(double sPFIncreaseCoinsPerRound) {
		SPFIncreaseCoinsPerRound = sPFIncreaseCoinsPerRound;
	}

	public static void setSPFIncreaseCoinsPerTerritory(double sPFIncreaseCoinsPerTerritory) {
		SPFIncreaseCoinsPerTerritory = sPFIncreaseCoinsPerTerritory;
	}
	
	
	
	
	
}
