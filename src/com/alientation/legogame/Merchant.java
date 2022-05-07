package com.alientation.legogame;

import org.json.simple.JSONObject;

public class Merchant {
	public static int foodSupply = 20;
	public static double foodBaseCost = 3;
	public static double foodCost = 5;
	public static int foodMinResupply = 5;
	public static int foodMaxResupply = 15;
	public static int foodResupplyChance = 66;
	/*
	 * Each time food is sold, food cost increases by a percentage of supply sold
	 * Each time food stock is gained, food cost decreases by a percentage of supply gained
	 */
	public static int rifleSupply = 5;
	public static double rifleBaseCost = 25;
	public static double rifleCost = 50;
	public static int rifleMinResupply = 2;
	public static int rifleMaxResupply = 5;
	public static int rifleResupplyChance = 50;
	
	public static int sniperSupply = 2;
	public static double sniperBaseCost = 75;
	public static double sniperCost = 125;
	public static int sniperMinResupply = 1;
	public static int sniperMaxResupply = 3;
	public static int sniperResupplyChance = 40;
	
	public static int rpgSupply = 1;
	public static double rpgBaseCost = 150;
	public static double rpgCost = 250;
	public static int rpgMinResupply = 1;
	public static int rpgMaxResupply = 2;
	public static int rpgResupplyChance = 30;
	
	
	public static int rifleAmmoSupply = 60;
	public static double rifleBaseAmmoCost = 0.1;
	public static double rifleAmmoCost = 3;
	public static int rifleAmmoMinResupply = 30;
	public static int rifleAmmoMaxResupply = 90;
	public static int rifleAmmoResupplyChance = 80;
	
	public static int sniperAmmoSupply = 30;
	public static double sniperBaseAmmoCost = 3;
	public static double sniperAmmoCost = 6;
	public static int sniperAmmoMinResupply = 15;
	public static int sniperAmmoMaxResupply = 40;
	public static int sniperAmmoResupplyChance = 70;
	
	public static int rpgAmmoSupply = 20;
	public static double rpgBaseAmmoCost = 20;
	public static double rpgAmmoCost = 40;
	public static int rpgAmmoMinResupply = 5;
	public static int rpgAmmoMaxResupply = 20;
	public static int rpgAmmoResupplyChance = 50;
	
	
	public static int soldierHealSupply = 10;
	public static double soldierBaseHealCost = 20;
	public static double soldierHealCost = 40;
	public static int soldierHealMinResupply = 5;
	public static int soldierHealMaxResupply = 15;
	public static int soldierHealResupplyChance = 40;
	
	
	public static int unarmedVehicleRepairSupply = 0;
	public static double unarmedVehicleBaseRepairCost = 100;
	public static double unarmedVehicleRepairCost = 200;
	public static int unarmedVehicleRepairMinResupply = 1;
	public static int unarmedVehicleRepairMaxResupply = 3;
	public static int unarmedVehicleRepairResupplyChance = 30;
	
	
	public static int armedVehicleRepairSupply = 0;
	public static double armedVehicleBaseRepairCost = 200;
	public static double armedVehicleRepairCost = 400;
	public static int armedVehicleRepairMinResupply = 1;
	public static int armedVehicleRepairMaxResupply = 2;
	public static int armedVehicleRepairResupplyChance = 20;
	
	
	public static int flightVehicleRepairSupply = 0;
	public static double flightVehicleBaseRepairCost = 400;
	public static double flightVehicleRepairCost = 800;
	public static int flightVehicleRepairMinResupply = 1;
	public static int flightVehicleRepairMaxResupply = 2;
	public static int flightVehicleRepairResupplyChance = 10;
	
	
	public static JSONObject dataFile;
	
	public static void init(JSONObject data) {
		dataFile = data;
		
		foodSupply = (int) (long) GameFileHandler.load("foodSupply", foodSupply);
		foodBaseCost = (double) GameFileHandler.load("foodBaseCost", foodBaseCost);
		foodCost = (double) GameFileHandler.load("foodCost", foodCost);
		foodMinResupply = (int) (long) GameFileHandler.load("foodMinResupply", foodMinResupply);
		foodMaxResupply = (int) (long) GameFileHandler.load("foodMaxResupply", foodMaxResupply);
		foodResupplyChance = (int) (long) GameFileHandler.load("foodResupplyChance", foodResupplyChance);
		
		
		rifleSupply = (int) (long) GameFileHandler.load("rifleSupply", rifleSupply);
		rifleBaseCost = (double) GameFileHandler.load("rifleBaseCost", rifleBaseCost);
		rifleCost = (double) GameFileHandler.load("rifleCost", rifleCost);
		rifleMinResupply = (int) (long) GameFileHandler.load("rifleMinResupply", rifleMinResupply);
		rifleMaxResupply = (int) (long) GameFileHandler.load("rifleMaxResupply", rifleMaxResupply);
		rifleResupplyChance = (int) (long) GameFileHandler.load("rifleResupplyChance", rifleResupplyChance);
		
		
		sniperSupply = (int) (long) GameFileHandler.load("sniperSupply", sniperSupply);
		sniperBaseCost = (double) GameFileHandler.load("sniperBaseCost", sniperBaseCost);
		sniperCost = (double) GameFileHandler.load("sniperCost", sniperCost);
		sniperMinResupply = (int) (long) GameFileHandler.load("sniperMinResupply", sniperMinResupply);
		sniperMaxResupply = (int) (long) GameFileHandler.load("sniperMaxResupply", sniperMaxResupply);
		sniperResupplyChance = (int) (long) GameFileHandler.load("sniperResupplyChance", sniperResupplyChance);
		
		
		rpgSupply = (int) (long) GameFileHandler.load("rpgSupply", rpgSupply);
		rpgBaseCost = (double) GameFileHandler.load("rpgBaseCost", rpgBaseCost);
		rpgCost = (double) GameFileHandler.load("rpgCost", rpgCost);
		rpgMinResupply = (int) (long) GameFileHandler.load("rpgMinResupply", rpgMinResupply);
		rpgMaxResupply = (int) (long) GameFileHandler.load("rpgMaxResupply", rpgMaxResupply);
		rpgResupplyChance = (int) (long) GameFileHandler.load("rpgResupplyChance", rpgResupplyChance);
		
		
		rifleAmmoSupply = (int) (long) GameFileHandler.load("rifleAmmoSupply", rifleAmmoSupply);
		rifleBaseAmmoCost = (double) GameFileHandler.load("rifleBaseAmmoCost", rifleBaseAmmoCost);
		rifleAmmoCost = (double) GameFileHandler.load("rifleAmmoCost", rifleAmmoCost);
		rifleAmmoMinResupply = (int) (long) GameFileHandler.load("rifleAmmoMinResupply", rifleAmmoMinResupply);
		rifleAmmoMaxResupply = (int) (long) GameFileHandler.load("rifleAmmoMaxResupply", rifleAmmoMaxResupply);
		rifleAmmoResupplyChance = (int) (long) GameFileHandler.load("rifleAmmoResupplyChance", rifleAmmoResupplyChance);
		
		
		sniperAmmoSupply = (int) (long) GameFileHandler.load("sniperAmmoSupply", sniperAmmoSupply);
		sniperBaseAmmoCost = (double) GameFileHandler.load("sniperBaseAmmoCost", sniperBaseAmmoCost);
		sniperAmmoCost = (double) GameFileHandler.load("sniperAmmoCost", sniperAmmoCost);
		sniperAmmoMinResupply = (int) (long) GameFileHandler.load("sniperAmmoMinResupply", sniperAmmoMinResupply);
		sniperAmmoMaxResupply = (int) (long) GameFileHandler.load("sniperAmmoMaxResupply", sniperAmmoMaxResupply);
		sniperAmmoResupplyChance = (int) (long) GameFileHandler.load("sniperAmmoResupplyChance", sniperAmmoResupplyChance);
		
		
		rpgAmmoSupply = (int) (long) GameFileHandler.load("rpgAmmoSupply", rpgAmmoSupply);
		rpgBaseAmmoCost = (double) GameFileHandler.load("rpgBaseAmmoCost", rpgBaseAmmoCost);
		rpgAmmoCost = (double) GameFileHandler.load("rpgAmmoCost", rpgAmmoCost);
		rpgAmmoMinResupply = (int) (long) GameFileHandler.load("rpgAmmoMinResupply", rpgAmmoMinResupply);
		rpgAmmoMaxResupply = (int) (long) GameFileHandler.load("rpgAmmoMaxResupply", rpgAmmoMaxResupply);
		rpgAmmoResupplyChance = (int) (long) GameFileHandler.load("rpgAmmoResupplyChance", rpgAmmoResupplyChance);
		
		
		soldierHealSupply = (int) (long) GameFileHandler.load("soldierHealSupply", soldierHealSupply);
		soldierBaseHealCost = (double) GameFileHandler.load("soldierBaseHealCost", soldierBaseHealCost);
		soldierHealCost = (double) GameFileHandler.load("soldierHealCost", soldierHealCost);
		soldierHealMinResupply = (int) (long) GameFileHandler.load("soldierHealMinResupply", soldierHealMinResupply);
		soldierHealMaxResupply = (int) (long) GameFileHandler.load("soldierHealMaxResupply", soldierHealMaxResupply);
		soldierHealResupplyChance = (int) (long) GameFileHandler.load("soldierHealResupplyChance", soldierHealResupplyChance);
		
		
		unarmedVehicleRepairSupply = (int) (long) GameFileHandler.load("unarmedVehicleRepairSupply", unarmedVehicleRepairSupply);
		unarmedVehicleBaseRepairCost = (double) GameFileHandler.load("unarmedVehicleBaseRepairCost", unarmedVehicleBaseRepairCost);
		unarmedVehicleRepairCost = (double) GameFileHandler.load("unarmedVehicleRepairCost", unarmedVehicleRepairCost);
		unarmedVehicleRepairMinResupply = (int) (long) GameFileHandler.load("unarmedVehicleRepairMinResupply", unarmedVehicleRepairMinResupply);
		unarmedVehicleRepairMaxResupply = (int) (long) GameFileHandler.load("unarmedVehicleRepairMaxResupply", unarmedVehicleRepairMaxResupply);
		unarmedVehicleRepairResupplyChance = (int) (long) GameFileHandler.load("unarmedVehicleRepairResupplyChance", unarmedVehicleRepairResupplyChance);
		
		
		armedVehicleRepairSupply = (int) (long) GameFileHandler.load("armedVehicleRepairSupply", armedVehicleRepairSupply);
		armedVehicleBaseRepairCost = (double) GameFileHandler.load("armedVehicleBaseRepairCost", armedVehicleBaseRepairCost);
		armedVehicleRepairCost = (double) GameFileHandler.load("armedVehicleRepairCost", armedVehicleRepairCost);
		armedVehicleRepairMinResupply = (int) (long) GameFileHandler.load("armedVehicleRepairMinResupply", armedVehicleRepairMinResupply);
		armedVehicleRepairMaxResupply = (int) (long) GameFileHandler.load("armedVehicleRepairMaxResupply", armedVehicleRepairMaxResupply);
		armedVehicleRepairResupplyChance = (int) (long) GameFileHandler.load("armedVehicleRepairResupplyChance", armedVehicleRepairResupplyChance);
		
		
		flightVehicleRepairSupply = (int) (long) GameFileHandler.load("flightVehicleRepairSupply", flightVehicleRepairSupply);
		flightVehicleBaseRepairCost = (double) GameFileHandler.load("flightVehicleBaseRepairCost", flightVehicleBaseRepairCost);
		flightVehicleRepairCost = (double) GameFileHandler.load("flightVehicleRepairCost", flightVehicleRepairCost);
		flightVehicleRepairMinResupply = (int) (long) GameFileHandler.load("flightVehicleRepairMinResupply", flightVehicleRepairMinResupply);
		flightVehicleRepairMaxResupply = (int) (long) GameFileHandler.load("flightVehicleRepairMaxResupply", flightVehicleRepairMaxResupply);
		flightVehicleRepairResupplyChance = (int) (long) GameFileHandler.load("flightVehicleRepairResupplyChance", flightVehicleRepairResupplyChance);
	}
	
	public static void saveGame() {
		
		GameFileHandler.save("foodSupply", foodSupply);
		GameFileHandler.save("foodBaseCost", foodBaseCost);
		GameFileHandler.save("foodCost", foodCost);
		GameFileHandler.save("foodMinResupply", foodMinResupply);
		GameFileHandler.save("foodMaxResupply", foodMaxResupply);
		GameFileHandler.save("foodResupplyChance", foodResupplyChance);
		
		GameFileHandler.save("rifleSupply", rifleSupply);
		GameFileHandler.save("rifleBaseCost", rifleBaseCost);
		GameFileHandler.save("rifleCost", rifleCost);
		GameFileHandler.save("rifleMinResupply", rifleMinResupply);
		GameFileHandler.save("rifleMaxResupply", rifleMaxResupply);
		GameFileHandler.save("rifleResupplyChance", rifleResupplyChance);
		
		GameFileHandler.save("sniperSupply", sniperSupply);
		GameFileHandler.save("sniperBaseCost", sniperBaseCost);
		GameFileHandler.save("sniperCost", sniperCost);
		GameFileHandler.save("sniperMinResupply", sniperMinResupply);
		GameFileHandler.save("sniperMaxResupply", sniperMaxResupply);
		GameFileHandler.save("sniperResupplyChance", sniperResupplyChance);
		
		GameFileHandler.save("rpgSupply", rpgSupply);
		GameFileHandler.save("rpgBaseCost", rpgBaseCost);
		GameFileHandler.save("rpgCost", rpgCost);
		GameFileHandler.save("rpgMinResupply", rpgMinResupply);
		GameFileHandler.save("rpgMaxResupply", rpgMaxResupply);
		GameFileHandler.save("rpgResupplyChance", rpgResupplyChance);
		
		GameFileHandler.save("rifleAmmoSupply", rifleAmmoSupply);
		GameFileHandler.save("rifleBaseAmmoCost", rifleBaseAmmoCost);
		GameFileHandler.save("rifleAmmoCost", rifleAmmoCost);
		GameFileHandler.save("rifleAmmoMinResupply", rifleAmmoMinResupply);
		GameFileHandler.save("rifleAmmoMaxResupply", rifleAmmoMaxResupply);
		GameFileHandler.save("rifleAmmoResupplyChance", rifleAmmoResupplyChance);
		
		GameFileHandler.save("sniperAmmoSupply", sniperAmmoSupply);
		GameFileHandler.save("sniperBaseAmmoCost", sniperBaseAmmoCost);
		GameFileHandler.save("sniperAmmoCost", sniperAmmoCost);
		GameFileHandler.save("sniperAmmoMinResupply", sniperAmmoMinResupply);
		GameFileHandler.save("sniperAmmoMaxResupply", sniperAmmoMaxResupply);
		GameFileHandler.save("sniperAmmoResupplyChance", sniperAmmoResupplyChance);
		
		GameFileHandler.save("rpgAmmoSupply", rpgAmmoSupply);
		GameFileHandler.save("rpgBaseAmmoCost", rpgBaseAmmoCost);
		GameFileHandler.save("rpgAmmoCost", rpgAmmoCost);
		GameFileHandler.save("rpgAmmoMinResupply", rpgAmmoMinResupply);
		GameFileHandler.save("rpgAmmoMaxResupply", rpgAmmoMaxResupply);
		GameFileHandler.save("rpgAmmoResupplyChance", rpgAmmoResupplyChance);
		
		GameFileHandler.save("soldierHealSupply", soldierHealSupply);
		GameFileHandler.save("soldierBaseHealCost", soldierBaseHealCost);
		GameFileHandler.save("soldierHealCost", soldierHealCost);
		GameFileHandler.save("soldierHealMinResupply", soldierHealMinResupply);
		GameFileHandler.save("soldierHealMaxResupply", soldierHealMaxResupply);
		GameFileHandler.save("soldierHealResupplyChance", soldierHealResupplyChance);
		
		GameFileHandler.save("unarmedVehicleRepairSupply", unarmedVehicleRepairSupply);
		GameFileHandler.save("unarmedVehicleBaseRepairCost", unarmedVehicleBaseRepairCost);
		GameFileHandler.save("unarmedVehicleRepairCost", unarmedVehicleRepairCost);
		GameFileHandler.save("unarmedVehicleRepairMinResupply", unarmedVehicleRepairMinResupply);
		GameFileHandler.save("unarmedVehicleRepairMaxResupply", unarmedVehicleRepairMaxResupply);
		GameFileHandler.save("unarmedVehicleRepairResupplyChance", unarmedVehicleRepairResupplyChance);
		
		GameFileHandler.save("armedVehicleRepairSupply", armedVehicleRepairSupply);
		GameFileHandler.save("armedVehicleBaseRepairCost", armedVehicleBaseRepairCost);
		GameFileHandler.save("armedVehicleRepairCost", armedVehicleRepairCost);
		GameFileHandler.save("armedVehicleRepairMinResupply", armedVehicleRepairMinResupply);
		GameFileHandler.save("armedVehicleRepairMaxResupply", armedVehicleRepairMaxResupply);
		GameFileHandler.save("armedVehicleRepairResupplyChance", armedVehicleRepairResupplyChance);
		
		GameFileHandler.save("flightVehicleRepairSupply", flightVehicleRepairSupply);
		GameFileHandler.save("flightVehicleBaseRepairCost", flightVehicleBaseRepairCost);
		GameFileHandler.save("flightVehicleRepairCost", flightVehicleRepairCost);
		GameFileHandler.save("flightVehicleRepairMinResupply", flightVehicleRepairMinResupply);
		GameFileHandler.save("flightVehicleRepairMaxResupply", flightVehicleRepairMaxResupply);
		GameFileHandler.save("flightVehicleRepairResupplyChance", flightVehicleRepairResupplyChance);
	}
	
	public static void RefreshStock() {
		Game.addBlankLines();
		System.out.println(Main.lineSeparator + "\nMerchant Restock\n" + Main.lineSeparator);
		int roll = (int)(Math.random() * 100 + 1);
		int amount = 0;
		if (roll <= foodResupplyChance) {
			amount = (int)(Math.random() * (foodMaxResupply - foodMinResupply) + foodMinResupply);
			foodSupply += amount;
			foodCost -= amount * foodBaseCost * .05;
			if (foodCost < foodBaseCost/4) {
				foodCost = foodBaseCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " food! Total is at " + foodSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= rifleResupplyChance) {
			amount = (int)(Math.random() * (rifleMaxResupply - rifleMinResupply) + rifleMinResupply);
			rifleSupply += amount;
			rifleCost -= amount * rifleBaseCost * .05;
			if (rifleCost < rifleBaseCost/4) {
				rifleCost = rifleBaseCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " rifles! Total is at " + rifleSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= rifleAmmoResupplyChance) {
			amount = (int)(Math.random() * (rifleAmmoMaxResupply - rifleAmmoMinResupply) + rifleAmmoMinResupply);
			rifleAmmoSupply += amount;
			rifleAmmoCost -= amount * rifleBaseAmmoCost * .05;
			if (rifleAmmoCost < rifleBaseAmmoCost/4) {
				rifleAmmoCost = rifleBaseAmmoCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " rifle ammo! Total is at " + rifleAmmoSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= sniperResupplyChance) {
			amount = (int)(Math.random() * (sniperMaxResupply - sniperMinResupply) + sniperMinResupply);
			sniperSupply += amount;
			sniperCost -= amount * sniperBaseCost * .05;
			if (sniperCost < sniperBaseCost/4) {
				sniperCost = sniperBaseCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " snipers! Total is at " + sniperSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= sniperAmmoResupplyChance) {
			amount = (int)(Math.random() * (sniperAmmoMaxResupply - sniperAmmoMinResupply) + sniperAmmoMinResupply);
			sniperAmmoSupply += amount;
			sniperAmmoCost -= amount * sniperBaseAmmoCost * .05;
			if (sniperAmmoCost < sniperBaseAmmoCost/4) {
				sniperAmmoCost = sniperBaseAmmoCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " sniper ammo! Total is at " + sniperAmmoSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= rpgResupplyChance) {
			amount = (int)(Math.random() * (rpgMaxResupply - rpgMinResupply) + rpgMinResupply);
			rpgSupply += amount;
			rpgCost -= amount * rpgBaseCost * .05;
			if (rpgCost < rpgBaseCost/4) {
				rpgCost = rpgBaseCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " rpgs! Total is at " + rpgSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= rpgAmmoResupplyChance) {
			amount = (int)(Math.random() * (rpgAmmoMaxResupply - rpgAmmoMinResupply) + rpgAmmoMinResupply);
			rpgAmmoSupply += amount;
			rpgAmmoCost -= amount * rpgBaseAmmoCost * .05;
			if (rpgAmmoCost < rpgBaseAmmoCost/4) {
				rpgAmmoCost = rpgBaseAmmoCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " rpg ammo! Total is at " + rpgAmmoSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= unarmedVehicleRepairResupplyChance) {
			amount = (int)(Math.random() * (unarmedVehicleRepairMaxResupply - unarmedVehicleRepairMinResupply) + unarmedVehicleRepairMinResupply);
			unarmedVehicleRepairSupply += amount;
			unarmedVehicleRepairCost -= amount * unarmedVehicleBaseRepairCost * .05;
			if (unarmedVehicleRepairCost < unarmedVehicleBaseRepairCost/4) {
				unarmedVehicleRepairCost = unarmedVehicleBaseRepairCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " unarmed vehicle repairs! Total is at " + unarmedVehicleRepairSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= armedVehicleRepairResupplyChance) {
			amount = (int)(Math.random() * (armedVehicleRepairMaxResupply - armedVehicleRepairMinResupply) + armedVehicleRepairMinResupply);
			armedVehicleRepairSupply += amount;
			armedVehicleRepairCost -= amount * armedVehicleBaseRepairCost * .05;
			if (armedVehicleRepairCost < armedVehicleBaseRepairCost/4) {
				armedVehicleRepairCost = armedVehicleBaseRepairCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " armed vehicle repairs! Total is at " + armedVehicleRepairSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= flightVehicleRepairResupplyChance) {
			amount = (int)(Math.random() * (flightVehicleRepairMaxResupply - flightVehicleRepairMinResupply) + flightVehicleRepairMinResupply);
			flightVehicleRepairSupply += amount;
			flightVehicleRepairCost -= amount * flightVehicleBaseRepairCost * .05;
			if (flightVehicleRepairCost < flightVehicleBaseRepairCost/4) {
				flightVehicleRepairCost = flightVehicleBaseRepairCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " flight vehicle repairs! Total is at " + flightVehicleRepairSupply);
		}
		roll = (int)(Math.random() * 100 + 1);
		if (roll <= soldierHealResupplyChance) {
			amount = (int)(Math.random() * (soldierHealMaxResupply - soldierHealMinResupply) + soldierHealMinResupply);
			soldierHealSupply += amount;
			soldierHealCost -= amount * soldierBaseHealCost * .05;
			if (soldierHealCost < soldierBaseHealCost/4) {
				soldierHealCost = soldierBaseHealCost/4;
			}
			System.out.println("Merchant recieved a resupply of " + amount + " soldier heals! Total is at " + soldierHealSupply);
		}
		Main.hold();
	}
	
	public static void purchaseFood(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + foodCost <= player.getCoinPurse() && count < amount) {
			cost+=foodCost;
			foodCost += foodBaseCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		int sum = 0;
		for (int x = 0; x < count; x++) {
			sum += player.gainHealth();
		}
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " purchased " + (count) + " food and gained " + sum + " Health EXP for " + cost + "$");
		Main.hold();
	}
	
	public static int maxPurchaseFood(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempFoodCost = foodCost;
		while (cost + tempFoodCost <= player.getCoinPurse() && count < foodSupply) {
			cost+=tempFoodCost;
			tempFoodCost += foodBaseCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void purchaseRifle(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + rifleCost <= player.getCoinPurse() && count < amount) {
			cost+=rifleCost;
			rifleCost += rifleBaseCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " purchased " + (count) + " rifles for " + cost + "$");
		Main.hold();
	}
	
	public static int maxPurchaseRifle(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = rifleCost;
		while (cost + tempCost <= player.getCoinPurse() && count < rifleSupply) {
			cost+=tempCost;
			tempCost += rifleBaseCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void purchaseRifleAmmo(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + rifleAmmoCost <= player.getCoinPurse() && count < amount) {
			cost+=rifleAmmoCost;
			rifleAmmoCost += rifleBaseAmmoCost * 0.1;
			count++;
		}
		player.setAmountRifleAmmo(player.getAmountRifleAmmo() + count);
		player.setPurchaseAmmoCount(player.getPurchaseAmmoCount() + count);
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " purchased " + (count) + " rifle ammo for " + cost + "$");
		Main.hold();
	}
	
	public static int maxPurchaseRifleAmmo(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = rifleAmmoCost;
		while (cost + tempCost <= player.getCoinPurse() && count < rifleAmmoSupply) {
			cost+=tempCost;
			tempCost += rifleBaseAmmoCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void purchaseSniper(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + sniperCost <= player.getCoinPurse() && count < amount) {
			cost+=sniperCost;
			sniperCost += sniperBaseCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " purchased " + (count) + " snipers for " + cost + "$");
		Main.hold();
	}
	
	public static int maxPurchaseSniper(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = sniperCost;
		while (cost + tempCost <= player.getCoinPurse() && count < sniperSupply) {
			cost+=tempCost;
			tempCost += sniperBaseCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void purchaseSniperAmmo(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + sniperAmmoCost <= player.getCoinPurse() && count < amount) {
			cost+=sniperAmmoCost;
			sniperAmmoCost += sniperBaseAmmoCost * 0.1;
			count++;
		}
		player.setPurchaseAmmoCount(player.getPurchaseAmmoCount() + count);
		player.setAmountSniperAmmo(player.getAmountSniperAmmo() + count);
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " purchased " + (count) + " sniper ammo for " + cost + "$");
		Main.hold();
	}
	
	public static int maxPurchaseSniperAmmo(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = sniperAmmoCost;
		while (cost + tempCost <= player.getCoinPurse() && count < sniperAmmoSupply) {
			cost+=tempCost;
			tempCost += sniperBaseAmmoCost * 0.1;
			count++;
		}
		return count;
	}

	public static void purchaseRPG(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + rpgCost <= player.getCoinPurse() && count < amount) {
			cost+=rpgCost;
			rpgCost += rpgBaseCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " purchased " + (count) + " rpg for " + cost + "$");
		Main.hold();
	}
	
	public static int maxPurchaseRPG(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = rpgCost;
		while (cost + tempCost <= player.getCoinPurse() && count < rpgSupply) {
			cost+=tempCost;
			tempCost += rpgBaseCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void purchaseRPGAmmo(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + rpgAmmoCost <= player.getCoinPurse() && count < amount) {
			cost+=rpgAmmoCost;
			rpgAmmoCost += rpgBaseAmmoCost * 0.1;
			count++;
		}
		player.setPurchaseAmmoCount(player.getPurchaseAmmoCount() + count);
		player.setAmountRPGAmmo(player.getAmountRPGAmmo() + count);
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " purchased " + (count) + " rpg ammo for " + cost + "$");
		Main.hold();
	}
	
	public static int maxPurchaseRPGAmmo(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = rpgAmmoCost;
		while (cost + tempCost <= player.getCoinPurse() && count < rpgAmmoSupply) {
			cost+=tempCost;
			tempCost += rpgBaseAmmoCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void repairUnarmedVehicle(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + unarmedVehicleRepairCost <= player.getCoinPurse() && count < amount) {
			cost+=unarmedVehicleRepairCost;
			unarmedVehicleRepairCost += unarmedVehicleBaseRepairCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " repaired " + (count) + " unarmed vehicles for " + cost + "$");
		Main.hold();
	}
	
	public static int maxRepairUnarmedVehicle(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = unarmedVehicleRepairCost;
		while (cost + tempCost <= player.getCoinPurse() && count < unarmedVehicleRepairSupply) {
			cost+=tempCost;
			tempCost += unarmedVehicleBaseRepairCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void repairArmedVehicle(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + armedVehicleRepairCost <= player.getCoinPurse() && count < amount) {
			cost+=armedVehicleRepairCost;
			armedVehicleRepairCost += armedVehicleBaseRepairCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " repaired " + (count) + " armed vehicles for " + cost + "$");
		Main.hold();
	}
	
	public static int maxRepairArmedVehicle(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = armedVehicleRepairCost;
		while (cost + tempCost <= player.getCoinPurse() && count < armedVehicleRepairSupply) {
			cost+=tempCost;
			tempCost += armedVehicleBaseRepairCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void repairFlightVehicle(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + flightVehicleRepairCost <= player.getCoinPurse() && count < amount) {
			cost+=flightVehicleRepairCost;
			flightVehicleRepairCost += flightVehicleBaseRepairCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " repaired " + (count) + " flight vehicles for " + cost + "$");
		Main.hold();
	}
	
	public static int maxRepairFlightVehicle(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = flightVehicleRepairCost;
		while (cost + tempCost <= player.getCoinPurse() && count < flightVehicleRepairSupply) {
			cost+=tempCost;
			tempCost += flightVehicleBaseRepairCost * 0.1;
			count++;
		}
		return count;
	}
	
	public static void healInjuredSoldier(int amount, Player player) {
		int count = 0;
		double cost = 0;
		
		while (cost + soldierHealCost <= player.getCoinPurse() && count < amount) {
			cost+=soldierHealCost;
			soldierHealCost += soldierBaseHealCost * 0.1;
			count++;
		}
		player.setCoinPurse((int) (player.getCoinPurse() - cost));
		System.out.println(Main.lineSeparator + "\n" + player.getName() + " healed " + (count) + " injured soldiers for " + cost + "$");
		Main.hold();
	}
	
	public static int maxHealInjuredSoldier(Player player) {
		int count = 0;
		double cost = 0;
		
		double tempCost = soldierHealCost;
		while (cost + tempCost <= player.getCoinPurse() && count < soldierHealSupply) {
			cost+=tempCost;
			tempCost += soldierBaseHealCost * 0.1;
			count++;
		}
		return count;
	}

	public static int getFoodSupply() {
		return foodSupply;
	}

	public static double getFoodBaseCost() {
		return foodBaseCost;
	}

	public static double getFoodCost() {
		return foodCost;
	}

	public static int getFoodMinResupply() {
		return foodMinResupply;
	}

	public static int getFoodMaxResupply() {
		return foodMaxResupply;
	}

	public static int getFoodResupplyChance() {
		return foodResupplyChance;
	}

	public static int getRifleSupply() {
		return rifleSupply;
	}

	public static double getRifleBaseCost() {
		return rifleBaseCost;
	}

	public static double getRifleCost() {
		return rifleCost;
	}

	public static int getRifleMinResupply() {
		return rifleMinResupply;
	}

	public static int getRifleMaxResupply() {
		return rifleMaxResupply;
	}

	public static int getRifleResupplyChance() {
		return rifleResupplyChance;
	}

	public static int getSniperSupply() {
		return sniperSupply;
	}

	public static double getSniperBaseCost() {
		return sniperBaseCost;
	}

	public static double getSniperCost() {
		return sniperCost;
	}

	public static int getSniperMinResupply() {
		return sniperMinResupply;
	}

	public static int getSniperMaxResupply() {
		return sniperMaxResupply;
	}

	public static int getSniperResupplyChance() {
		return sniperResupplyChance;
	}

	public static int getRpgSupply() {
		return rpgSupply;
	}

	public static double getRpgBaseCost() {
		return rpgBaseCost;
	}

	public static double getRpgCost() {
		return rpgCost;
	}

	public static int getRpgMinResupply() {
		return rpgMinResupply;
	}

	public static int getRpgMaxResupply() {
		return rpgMaxResupply;
	}

	public static int getRpgResupplyChance() {
		return rpgResupplyChance;
	}

	public static int getRifleAmmoSupply() {
		return rifleAmmoSupply;
	}

	public static double getRifleBaseAmmoCost() {
		return rifleBaseAmmoCost;
	}

	public static double getRifleAmmoCost() {
		return rifleAmmoCost;
	}

	public static int getRifleAmmoMinResupply() {
		return rifleAmmoMinResupply;
	}

	public static int getRifleAmmoMaxResupply() {
		return rifleAmmoMaxResupply;
	}

	public static int getRifleAmmoResupplyChance() {
		return rifleAmmoResupplyChance;
	}

	public static int getSniperAmmoSupply() {
		return sniperAmmoSupply;
	}

	public static double getSniperBaseAmmoCost() {
		return sniperBaseAmmoCost;
	}

	public static double getSniperAmmoCost() {
		return sniperAmmoCost;
	}

	public static int getSniperAmmoMinResupply() {
		return sniperAmmoMinResupply;
	}

	public static int getSniperAmmoMaxResupply() {
		return sniperAmmoMaxResupply;
	}

	public static int getSniperAmmoResupplyChance() {
		return sniperAmmoResupplyChance;
	}

	public static int getRpgAmmoSupply() {
		return rpgAmmoSupply;
	}

	public static double getRpgBaseAmmoCost() {
		return rpgBaseAmmoCost;
	}

	public static double getRpgAmmoCost() {
		return rpgAmmoCost;
	}

	public static int getRpgAmmoMinResupply() {
		return rpgAmmoMinResupply;
	}

	public static int getRpgAmmoMaxResupply() {
		return rpgAmmoMaxResupply;
	}

	public static int getRpgAmmoResupplyChance() {
		return rpgAmmoResupplyChance;
	}

	public static int getSoldierHealSupply() {
		return soldierHealSupply;
	}

	public static double getSoldierBaseHealCost() {
		return soldierBaseHealCost;
	}

	public static double getSoldierHealCost() {
		return soldierHealCost;
	}

	public static int getSoldierHealMinResupply() {
		return soldierHealMinResupply;
	}

	public static int getSoldierHealMaxResupply() {
		return soldierHealMaxResupply;
	}

	public static int getSoldierHealResupplyChance() {
		return soldierHealResupplyChance;
	}

	public static int getUnarmedVehicleRepairSupply() {
		return unarmedVehicleRepairSupply;
	}

	public static double getUnarmedVehicleBaseRepairCost() {
		return unarmedVehicleBaseRepairCost;
	}

	public static double getUnarmedVehicleRepairCost() {
		return unarmedVehicleRepairCost;
	}

	public static int getUnarmedVehicleRepairMinResupply() {
		return unarmedVehicleRepairMinResupply;
	}

	public static int getUnarmedVehicleRepairMaxResupply() {
		return unarmedVehicleRepairMaxResupply;
	}

	public static int getUnarmedVehicleRepairResupplyChance() {
		return unarmedVehicleRepairResupplyChance;
	}

	public static int getArmedVehicleRepairSupply() {
		return armedVehicleRepairSupply;
	}

	public static double getArmedVehicleBaseRepairCost() {
		return armedVehicleBaseRepairCost;
	}

	public static double getArmedVehicleRepairCost() {
		return armedVehicleRepairCost;
	}

	public static int getArmedVehicleRepairMinResupply() {
		return armedVehicleRepairMinResupply;
	}

	public static int getArmedVehicleRepairMaxResupply() {
		return armedVehicleRepairMaxResupply;
	}

	public static int getArmedVehicleRepairResupplyChance() {
		return armedVehicleRepairResupplyChance;
	}

	public static int getFlightVehicleRepairSupply() {
		return flightVehicleRepairSupply;
	}

	public static double getFlightVehicleBaseRepairCost() {
		return flightVehicleBaseRepairCost;
	}

	public static double getFlightVehicleRepairCost() {
		return flightVehicleRepairCost;
	}

	public static int getFlightVehicleRepairMinResupply() {
		return flightVehicleRepairMinResupply;
	}

	public static int getFlightVehicleRepairMaxResupply() {
		return flightVehicleRepairMaxResupply;
	}

	public static int getFlightVehicleRepairResupplyChance() {
		return flightVehicleRepairResupplyChance;
	}

	public static void setFoodSupply(int foodSupply) {
		Merchant.foodSupply = foodSupply;
	}

	public static void setFoodBaseCost(double foodBaseCost) {
		Merchant.foodBaseCost = foodBaseCost;
	}

	public static void setFoodCost(double foodCost) {
		Merchant.foodCost = foodCost;
	}

	public static void setFoodMinResupply(int foodMinResupply) {
		Merchant.foodMinResupply = foodMinResupply;
	}

	public static void setFoodMaxResupply(int foodMaxResupply) {
		Merchant.foodMaxResupply = foodMaxResupply;
	}

	public static void setFoodResupplyChance(int foodResupplyChance) {
		Merchant.foodResupplyChance = foodResupplyChance;
	}

	public static void setRifleSupply(int rifleSupply) {
		Merchant.rifleSupply = rifleSupply;
	}

	public static void setRifleBaseCost(double rifleBaseCost) {
		Merchant.rifleBaseCost = rifleBaseCost;
	}

	public static void setRifleCost(double rifleCost) {
		Merchant.rifleCost = rifleCost;
	}

	public static void setRifleMinResupply(int rifleMinResupply) {
		Merchant.rifleMinResupply = rifleMinResupply;
	}

	public static void setRifleMaxResupply(int rifleMaxResupply) {
		Merchant.rifleMaxResupply = rifleMaxResupply;
	}

	public static void setRifleResupplyChance(int rifleResupplyChance) {
		Merchant.rifleResupplyChance = rifleResupplyChance;
	}

	public static void setSniperSupply(int sniperSupply) {
		Merchant.sniperSupply = sniperSupply;
	}

	public static void setSniperBaseCost(double sniperBaseCost) {
		Merchant.sniperBaseCost = sniperBaseCost;
	}

	public static void setSniperCost(double sniperCost) {
		Merchant.sniperCost = sniperCost;
	}

	public static void setSniperMinResupply(int sniperMinResupply) {
		Merchant.sniperMinResupply = sniperMinResupply;
	}

	public static void setSniperMaxResupply(int sniperMaxResupply) {
		Merchant.sniperMaxResupply = sniperMaxResupply;
	}

	public static void setSniperResupplyChance(int sniperResupplyChance) {
		Merchant.sniperResupplyChance = sniperResupplyChance;
	}

	public static void setRpgSupply(int rpgSupply) {
		Merchant.rpgSupply = rpgSupply;
	}

	public static void setRpgBaseCost(double rpgBaseCost) {
		Merchant.rpgBaseCost = rpgBaseCost;
	}

	public static void setRpgCost(double rpgCost) {
		Merchant.rpgCost = rpgCost;
	}

	public static void setRpgMinResupply(int rpgMinResupply) {
		Merchant.rpgMinResupply = rpgMinResupply;
	}

	public static void setRpgMaxResupply(int rpgMaxResupply) {
		Merchant.rpgMaxResupply = rpgMaxResupply;
	}

	public static void setRpgResupplyChance(int rpgResupplyChance) {
		Merchant.rpgResupplyChance = rpgResupplyChance;
	}

	public static void setRifleAmmoSupply(int rifleAmmoSupply) {
		Merchant.rifleAmmoSupply = rifleAmmoSupply;
	}

	public static void setRifleBaseAmmoCost(double rifleBaseAmmoCost) {
		Merchant.rifleBaseAmmoCost = rifleBaseAmmoCost;
	}

	public static void setRifleAmmoCost(double rifleAmmoCost) {
		Merchant.rifleAmmoCost = rifleAmmoCost;
	}

	public static void setRifleAmmoMinResupply(int rifleAmmoMinResupply) {
		Merchant.rifleAmmoMinResupply = rifleAmmoMinResupply;
	}

	public static void setRifleAmmoMaxResupply(int rifleAmmoMaxResupply) {
		Merchant.rifleAmmoMaxResupply = rifleAmmoMaxResupply;
	}

	public static void setRifleAmmoResupplyChance(int rifleAmmoResupplyChance) {
		Merchant.rifleAmmoResupplyChance = rifleAmmoResupplyChance;
	}

	public static void setSniperAmmoSupply(int sniperAmmoSupply) {
		Merchant.sniperAmmoSupply = sniperAmmoSupply;
	}

	public static void setSniperBaseAmmoCost(double sniperBaseAmmoCost) {
		Merchant.sniperBaseAmmoCost = sniperBaseAmmoCost;
	}

	public static void setSniperAmmoCost(double sniperAmmoCost) {
		Merchant.sniperAmmoCost = sniperAmmoCost;
	}

	public static void setSniperAmmoMinResupply(int sniperAmmoMinResupply) {
		Merchant.sniperAmmoMinResupply = sniperAmmoMinResupply;
	}

	public static void setSniperAmmoMaxResupply(int sniperAmmoMaxResupply) {
		Merchant.sniperAmmoMaxResupply = sniperAmmoMaxResupply;
	}

	public static void setSniperAmmoResupplyChance(int sniperAmmoResupplyChance) {
		Merchant.sniperAmmoResupplyChance = sniperAmmoResupplyChance;
	}

	public static void setRpgAmmoSupply(int rpgAmmoSupply) {
		Merchant.rpgAmmoSupply = rpgAmmoSupply;
	}

	public static void setRpgBaseAmmoCost(double rpgBaseAmmoCost) {
		Merchant.rpgBaseAmmoCost = rpgBaseAmmoCost;
	}

	public static void setRpgAmmoCost(double rpgAmmoCost) {
		Merchant.rpgAmmoCost = rpgAmmoCost;
	}

	public static void setRpgAmmoMinResupply(int rpgAmmoMinResupply) {
		Merchant.rpgAmmoMinResupply = rpgAmmoMinResupply;
	}

	public static void setRpgAmmoMaxResupply(int rpgAmmoMaxResupply) {
		Merchant.rpgAmmoMaxResupply = rpgAmmoMaxResupply;
	}

	public static void setRpgAmmoResupplyChance(int rpgAmmoResupplyChance) {
		Merchant.rpgAmmoResupplyChance = rpgAmmoResupplyChance;
	}

	public static void setSoldierHealSupply(int soldierHealSupply) {
		Merchant.soldierHealSupply = soldierHealSupply;
	}

	public static void setSoldierBaseHealCost(double soldierBaseHealCost) {
		Merchant.soldierBaseHealCost = soldierBaseHealCost;
	}

	public static void setSoldierHealCost(double soldierHealCost) {
		Merchant.soldierHealCost = soldierHealCost;
	}

	public static void setSoldierHealMinResupply(int soldierHealMinResupply) {
		Merchant.soldierHealMinResupply = soldierHealMinResupply;
	}

	public static void setSoldierHealMaxResupply(int soldierHealMaxResupply) {
		Merchant.soldierHealMaxResupply = soldierHealMaxResupply;
	}

	public static void setSoldierHealResupplyChance(int soldierHealResupplyChance) {
		Merchant.soldierHealResupplyChance = soldierHealResupplyChance;
	}

	public static void setUnarmedVehicleRepairSupply(int unarmedVehicleRepairSupply) {
		Merchant.unarmedVehicleRepairSupply = unarmedVehicleRepairSupply;
	}

	public static void setUnarmedVehicleBaseRepairCost(double unarmedVehicleBaseRepairCost) {
		Merchant.unarmedVehicleBaseRepairCost = unarmedVehicleBaseRepairCost;
	}

	public static void setUnarmedVehicleRepairCost(double unarmedVehicleRepairCost) {
		Merchant.unarmedVehicleRepairCost = unarmedVehicleRepairCost;
	}

	public static void setUnarmedVehicleRepairMinResupply(int unarmedVehicleRepairMinResupply) {
		Merchant.unarmedVehicleRepairMinResupply = unarmedVehicleRepairMinResupply;
	}

	public static void setUnarmedVehicleRepairMaxResupply(int unarmedVehicleRepairMaxResupply) {
		Merchant.unarmedVehicleRepairMaxResupply = unarmedVehicleRepairMaxResupply;
	}

	public static void setUnarmedVehicleRepairResupplyChance(int unarmedVehicleRepairResupplyChance) {
		Merchant.unarmedVehicleRepairResupplyChance = unarmedVehicleRepairResupplyChance;
	}

	public static void setArmedVehicleRepairSupply(int armedVehicleRepairSupply) {
		Merchant.armedVehicleRepairSupply = armedVehicleRepairSupply;
	}

	public static void setArmedVehicleBaseRepairCost(double armedVehicleBaseRepairCost) {
		Merchant.armedVehicleBaseRepairCost = armedVehicleBaseRepairCost;
	}

	public static void setArmedVehicleRepairCost(double armedVehicleRepairCost) {
		Merchant.armedVehicleRepairCost = armedVehicleRepairCost;
	}

	public static void setArmedVehicleRepairMinResupply(int armedVehicleRepairMinResupply) {
		Merchant.armedVehicleRepairMinResupply = armedVehicleRepairMinResupply;
	}

	public static void setArmedVehicleRepairMaxResupply(int armedVehicleRepairMaxResupply) {
		Merchant.armedVehicleRepairMaxResupply = armedVehicleRepairMaxResupply;
	}

	public static void setArmedVehicleRepairResupplyChance(int armedVehicleRepairResupplyChance) {
		Merchant.armedVehicleRepairResupplyChance = armedVehicleRepairResupplyChance;
	}

	public static void setFlightVehicleRepairSupply(int flightVehicleRepairSupply) {
		Merchant.flightVehicleRepairSupply = flightVehicleRepairSupply;
	}

	public static void setFlightVehicleBaseRepairCost(double flightVehicleBaseRepairCost) {
		Merchant.flightVehicleBaseRepairCost = flightVehicleBaseRepairCost;
	}

	public static void setFlightVehicleRepairCost(double flightVehicleRepairCost) {
		Merchant.flightVehicleRepairCost = flightVehicleRepairCost;
	}

	public static void setFlightVehicleRepairMinResupply(int flightVehicleRepairMinResupply) {
		Merchant.flightVehicleRepairMinResupply = flightVehicleRepairMinResupply;
	}

	public static void setFlightVehicleRepairMaxResupply(int flightVehicleRepairMaxResupply) {
		Merchant.flightVehicleRepairMaxResupply = flightVehicleRepairMaxResupply;
	}

	public static void setFlightVehicleRepairResupplyChance(int flightVehicleRepairResupplyChance) {
		Merchant.flightVehicleRepairResupplyChance = flightVehicleRepairResupplyChance;
	}

	public static JSONObject getDataFile() {
		return dataFile;
	}

	public static void setDataFile(JSONObject dataFile) {
		Merchant.dataFile = dataFile;
	}

}