package com.alientation.legogame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class Game {
	public static String gameVersion = "1.1";
	
	
	public static Scanner console;
	public static Player SPF;
	public static Player Rebels;
	public static double rebelInitialSuspicion = 10, rebelInitialAttack = 20, rebelInitialHealth = 20, SPFInitialSuspicion = 5, SPFInitialAttack = 40, SPFInitialHealth = 30;
	public static int rebelInitialCoins = 300, rebelInitialTerritories = 11, SPFInitialCoins = 300, SPFInitialTerritories = 15;
	public static int rebelInitialRifleAmmo = 150, rebelInitialSniperAmmo = 35, rebelInitialRPGAmmo = 15, SPFInitialRifleAmmo = 175, SPFInitialSniperAmmo = 45, SPFInitialRPGAmmo = 20;
	
	public static int rifleAmmoChance = 40, rifleDestroyedChance = 5;
	public static int sniperAmmoChance = 70, sniperDestroyedChance = 7;
	public static int rpgAmmoChance = 40, rpgDestroyedChance = 7;
	
	public static int unarmedVehicleDamagedChance = 50, unarmedVehicleDestroyedChance = 25;
	public static int armedVehicleDamagedChance = 40, armedVehicleDestroyedChance = 20;
	public static int flightVehicleDamagedChance = 20, flightVehicleDestroyedChance = 15;
	
	public static int rebelCoinsPerRound = 60, rebelCoinsPerTerritory = 6;
	public static double rebelCoinMultiplier = 1, rebelCoinMultiplierIncrease = .1;
	public static int SPFCoinsPerRound = 50, SPFCoinsPerTerritory = 5;
	public static double SPFCoinMultiplier = 1, SPFCoinMultiplierIncrease = .1;
	
	
	public static double suspicionLostPerRound = 5, suspicionGainPerAction = 2;
	public static double attackLostPerRound = 1, attackGainPerShot = 0.5;
	public static double healthLostPerRound = 1, healthBaseGainPerFood = 3, healthMaxGainPerFood = 6, healthBaseLostPerHit = 1, healthMaxLostPerHit = 2;
	
	
	public static void initGame() {
		console = Main.console;
		addBlankLines();
		Rebels = new Player(rebelInitialSuspicion,rebelInitialAttack,rebelInitialHealth,rebelInitialCoins,rebelInitialTerritories,rebelInitialRifleAmmo,rebelInitialSniperAmmo,rebelInitialRPGAmmo, "Rebels");
		SPF = new Player(SPFInitialSuspicion,SPFInitialAttack,SPFInitialHealth,SPFInitialCoins,SPFInitialTerritories,SPFInitialRifleAmmo,SPFInitialSniperAmmo,SPFInitialRPGAmmo, "SPF");
		Player.setDataFile(Main.data);
		Auctioneer.setDataFile(Main.data);
		Auctioneer.console = Main.console;
		Merchant.setDataFile(Main.data);
		Upgrades.setDataFile(Main.data);
		Upgrades.setConsole(Main.console);
		AttackSimulator.setDataFile(Main.data);
	}
	
	public static void initData() {
		JSONObject data = Main.data;
		
		rebelInitialSuspicion = (double) GameFileHandler.load("rebelInitialSuspicion", rebelInitialSuspicion);
		rebelInitialAttack = (double) GameFileHandler.load("rebelInitialAttack", rebelInitialAttack);
		rebelInitialHealth = (double) GameFileHandler.load("rebelInitialHealth", rebelInitialHealth);
		SPFInitialSuspicion = (double) GameFileHandler.load("SPFInitialSuspicion", SPFInitialSuspicion);
		SPFInitialAttack = (double) GameFileHandler.load("SPFInitialAttack", SPFInitialAttack);
		SPFInitialHealth = (double) GameFileHandler.load("SPFInitialHealth", SPFInitialHealth);
		rebelInitialCoins = (int) (long) GameFileHandler.load("rebelInitialCoins", rebelInitialCoins);
		rebelInitialTerritories = (int) (long) GameFileHandler.load("rebelInitialTerritories", rebelInitialTerritories);
		SPFInitialCoins = (int) (long) GameFileHandler.load("SPFInitialCoins", SPFInitialCoins);
		SPFInitialTerritories = (int) (long) GameFileHandler.load("SPFInitialTerritories", SPFInitialTerritories);
		rebelInitialRifleAmmo = (int) (long) GameFileHandler.load("rebelInitialRifleAmmo", rebelInitialRifleAmmo);
		rebelInitialSniperAmmo = (int) (long) GameFileHandler.load("rebelInitialSniperAmmo", rebelInitialSniperAmmo);
		rebelInitialRPGAmmo = (int) (long) GameFileHandler.load("rebelInitialRPGAmmo", rebelInitialRPGAmmo);
		SPFInitialRifleAmmo = (int) (long) GameFileHandler.load("SPFInitialRifleAmmo", SPFInitialRifleAmmo);
		SPFInitialSniperAmmo = (int) (long) GameFileHandler.load("SPFInitialSniperAmmo", SPFInitialSniperAmmo);
		SPFInitialRPGAmmo = (int) (long) GameFileHandler.load("SPFInitialRPGAmmo", SPFInitialRPGAmmo);
		
		
		rifleAmmoChance = (int) (long) GameFileHandler.load("rifleAmmoChance", rifleAmmoChance);
		rifleDestroyedChance = (int) (long) GameFileHandler.load("rifleDestroyedChance", rifleDestroyedChance);
		sniperAmmoChance = (int) (long) GameFileHandler.load("sniperAmmoChance", sniperAmmoChance);
		sniperDestroyedChance = (int) (long) GameFileHandler.load("sniperDestroyedChance", sniperDestroyedChance);
		rpgAmmoChance = (int) (long) GameFileHandler.load("rpgAmmoChance", rpgAmmoChance);
		rpgDestroyedChance = (int) (long) GameFileHandler.load("rpgDestroyedChance", rpgDestroyedChance);
		
		
		
		unarmedVehicleDamagedChance = (int) (long) GameFileHandler.load("unarmedVehicleDamagedChance", unarmedVehicleDamagedChance);
		unarmedVehicleDestroyedChance = (int) (long) GameFileHandler.load("unarmedVehicleDestroyedChance", unarmedVehicleDestroyedChance);
		armedVehicleDamagedChance = (int) (long) GameFileHandler.load("armedVehicleDamagedChance", armedVehicleDamagedChance);
		armedVehicleDestroyedChance = (int) (long) GameFileHandler.load("armedVehicleDestroyedChance", armedVehicleDestroyedChance);
		flightVehicleDamagedChance = (int) (long) GameFileHandler.load("flightVehicleDamagedChance", flightVehicleDamagedChance);
		flightVehicleDestroyedChance = (int) (long) GameFileHandler.load("flightVehicleDestroyedChance", flightVehicleDestroyedChance);
		
		
		
		rebelCoinsPerRound = (int) (long) GameFileHandler.load("rebelCoinsPerRound", rebelCoinsPerRound);
		rebelCoinsPerTerritory = (int) (long) GameFileHandler.load("rebelCoinsPerTerritory", rebelCoinsPerTerritory);
		rebelCoinMultiplier = (double) GameFileHandler.load("rebelCoinMultiplier", rebelCoinMultiplier);
		rebelCoinMultiplierIncrease = (double) GameFileHandler.load("rebelCoinMultiplierIncrease", rebelCoinMultiplierIncrease);
		SPFCoinsPerRound = (int) (long) GameFileHandler.load("SPFCoinsPerRound", SPFCoinsPerRound);
		SPFCoinsPerTerritory = (int) (long) GameFileHandler.load("SPFCoinsPerTerritory", SPFCoinsPerTerritory);
		SPFCoinMultiplier = (double) GameFileHandler.load("SPFCoinMultiplier", SPFCoinMultiplier);
		SPFCoinMultiplierIncrease = (double) GameFileHandler.load("SPFCoinMultiplierIncrease", SPFCoinMultiplierIncrease);
		
		
		suspicionLostPerRound = (double) GameFileHandler.load("suspicionLostPerRound", suspicionLostPerRound);
		suspicionGainPerAction = (double) GameFileHandler.load("suspicionGainPerAction", suspicionGainPerAction);
		attackLostPerRound = (double) GameFileHandler.load("attackLostPerRound", attackLostPerRound);
		attackGainPerShot = (double) GameFileHandler.load("attackGainPerShot", attackGainPerShot);
		healthLostPerRound = (double) GameFileHandler.load("healthLostPerRound", healthLostPerRound);
		healthBaseGainPerFood = (double) GameFileHandler.load("healthBaseGainPerFood", healthBaseGainPerFood);
		healthMaxGainPerFood = (double) GameFileHandler.load("healthMaxGainPerFood", healthMaxGainPerFood);
		healthBaseLostPerHit = (double) GameFileHandler.load("healthBaseLostPerHit", healthBaseLostPerHit);
		healthMaxLostPerHit = (double) GameFileHandler.load("healthMaxLostPerHit", healthMaxLostPerHit);
		
		
		Rebels.init(data);
		SPF.init(data);
		Auctioneer.init(data);
		Merchant.init(data);
		AttackSimulator.init(data);
		Quests.init(data);
	}
	
	public static void saveGame() {
		GameFileHandler.save("gameVersion", gameVersion);
		GameFileHandler.save("rebelInitialSuspicion", rebelInitialSuspicion);
		GameFileHandler.save("rebelInitialAttack", rebelInitialAttack);
		GameFileHandler.save("rebelInitialHealth", rebelInitialHealth);
		GameFileHandler.save("SPFInitialSuspicion", SPFInitialSuspicion);
		GameFileHandler.save("SPFInitialAttack", SPFInitialAttack);
		GameFileHandler.save("SPFInitialHealth", SPFInitialHealth);
		GameFileHandler.save("rebelInitialCoins", rebelInitialCoins);
		GameFileHandler.save("rebelInitialTerritories", rebelInitialTerritories);
		GameFileHandler.save("SPFInitialCoins", SPFInitialCoins);
		GameFileHandler.save("SPFInitialTerritories", SPFInitialTerritories);
		GameFileHandler.save("rebelInitialRifleAmmo", rebelInitialRifleAmmo);
		GameFileHandler.save("rebelInitialSniperAmmo", rebelInitialSniperAmmo);
		GameFileHandler.save("rebelInitialRPGAmmo", rebelInitialRPGAmmo);
		GameFileHandler.save("SPFInitialRifleAmmo", SPFInitialRifleAmmo);
		GameFileHandler.save("SPFInitialSniperAmmo", SPFInitialSniperAmmo);
		GameFileHandler.save("SPFInitialRPGAmmo", SPFInitialRPGAmmo);
		
		
		GameFileHandler.save("rifleAmmoChance", rifleAmmoChance);
		GameFileHandler.save("rifleDestroyedChance", rifleDestroyedChance);
		GameFileHandler.save("sniperAmmoChance", sniperAmmoChance);
		GameFileHandler.save("sniperDestroyedChance", sniperDestroyedChance);
		GameFileHandler.save("rpgAmmoChance", rpgAmmoChance);
		GameFileHandler.save("rpgDestroyedChance", rpgDestroyedChance);
		
		
		GameFileHandler.save("unarmedVehicleDamagedChance", unarmedVehicleDamagedChance);
		GameFileHandler.save("unarmedVehicleDestroyedChance", unarmedVehicleDestroyedChance);
		GameFileHandler.save("armedVehicleDamagedChance", armedVehicleDamagedChance);
		GameFileHandler.save("armedVehicleDestroyedChance", armedVehicleDestroyedChance);
		GameFileHandler.save("flightVehicleDamagedChance", flightVehicleDamagedChance);
		GameFileHandler.save("flightVehicleDestroyedChance", flightVehicleDestroyedChance);
		
		
		GameFileHandler.save("rebelCoinsPerRound", rebelCoinsPerRound);
		GameFileHandler.save("rebelCoinsPerTerritory", rebelCoinsPerTerritory);
		GameFileHandler.save("rebelCoinMultiplier", rebelCoinMultiplier);
		GameFileHandler.save("rebelCoinMultiplierIncrease", rebelCoinMultiplierIncrease);
		GameFileHandler.save("SPFCoinsPerRound", SPFCoinsPerRound);
		GameFileHandler.save("SPFCoinsPerTerritory", SPFCoinsPerTerritory);
		GameFileHandler.save("SPFCoinMultiplier", SPFCoinMultiplier);
		GameFileHandler.save("SPFCoinMultiplierIncrease", SPFCoinMultiplierIncrease);
		
		
		GameFileHandler.save("suspicionLostPerRound", suspicionLostPerRound);
		GameFileHandler.save("suspicionGainPerAction", suspicionGainPerAction);
		GameFileHandler.save("attackLostPerRound", attackLostPerRound);
		GameFileHandler.save("attackGainPerShot", attackGainPerShot);
		GameFileHandler.save("healthLostPerRound", healthLostPerRound);
		GameFileHandler.save("healthBaseGainPerFood", healthBaseGainPerFood);
		GameFileHandler.save("healthMaxGainPerFood", healthMaxGainPerFood);
		GameFileHandler.save("healthBaseLostPerHit", healthBaseLostPerHit);
		GameFileHandler.save("healthMaxLostPerHit", healthMaxLostPerHit);
		
		
		Rebels.saveGame();
		SPF.saveGame();
		Auctioneer.saveGame();
		Merchant.saveGame();
		AttackSimulator.saveGame();
		Quests.saveGame();
		FileWriter fw = null;
		try {
			File f = new File(Main.savePath);
			if (f.exists()) {
				f.delete();
			}
			fw = new FileWriter(Main.savePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (fw == null) {
			System.out.println("Something went wrong whilst attempting to save game");
		} else {
			try {
				fw.write(Main.data.toJSONString());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void endGame() {
		addBlankLines();
		System.out.println("Successfully Saved and Ended Game!");
	}
	
	public Game() {
		int input = 0;
		gameloop:
		while (input != -1) {
			outputHeader();
			input = console.nextInt();
			console.nextLine();
			switch (input) {
			case 1:
				rebelAction();
				break;
			case 2:
				SPFAction();
				break;
			case 3:
				endRound();
				Quests.setSPFRoundsSinceQuestStarted(Quests.getSPFRoundsSinceQuestStarted() + 1);
				Quests.setRebelRoundsSinceQuestStarted(Quests.getRebelRoundsSinceQuestStarted() + 1);
				saveGame();
				break;
			case 10:
				addBlankLines();
				System.out.print(Main.lineSeparator + "\nDo you want to leave a note?\n" + Main.lineSeparator + "\n(1) Yes\n(2) No\n>>> ");
				input = console.nextInt();
				console.nextLine();
				if (input == 1) {
					System.out.print(Main.lineSeparator + "\nType it out below\n" + Main.lineSeparator + "\n>>> ");
					String note = console.nextLine();
					GameFileHandler.save("note", note);
				} else {
					GameFileHandler.save("note", "");
				}
				saveGame();
				endGame();
				break gameloop;
			default:
				System.out.println(Main.lineSeparator + "\nWhy can't you follow basic instructions!");
				Main.hold();
				break;
			}
		}
		
	}
	
	public void rebelAction() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tRebel Action\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(1) Attack\n(2) Add Territories\n(3) Purchase Items\n(4) Upgrades\n(5) Quests\n(10) Back\n(11) Tools\n(12) Suspicion\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		console.nextLine();
		switch(input) {
		case 1:
			rebelAttack();
			break;
		case 2:
			rebelTerritories();
			break;
		case 3:
			rebelPurchaseItems();
			break;
		case 4:
			rebelUpgrades();
			break;
		case 5:
			rebelQuests();
			break;
		case 10:
			break;
		case 11:
			rebelTools();
			break;
		case 12:
			rebelSuspicion();
			break;
		default:
			break;
		}
	}
	
	public void SPFAction() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tSPF Action\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(1) Attack\n(2) Add Territories\n(3) Purchase Items\n(4) Upgrades\n(5) Quests\n(10) Back\n(11) Tools\n(12) Suspicion\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		console.nextLine();
		switch(input) {
		case 1:
			SPFAttack();
			break;
		case 2:
			SPFTerritories();
			break;
		case 3:
			SPFPurchaseItems();
			break;
		case 4:
			SPFUpgrades();
			break;
		case 5:
			SPFQuests();
			break;
		case 10:
			break;
		case 11:
			SPFTools();
			break;
		case 12:
			SPFSuspicion();
			break;
		default:
			break;
		}
	}
	
	public void endRound() {
		Rebels.roundEnd(rebelCoinsPerRound, rebelCoinsPerTerritory, rebelCoinMultiplier);
		SPF.roundEnd(SPFCoinsPerRound, SPFCoinsPerTerritory, SPFCoinMultiplier);
		
		if (Rebels.getTotalTerritories() - Rebels.getPrevTotalTerritories() >= 0) {
			rebelCoinMultiplier += rebelCoinMultiplierIncrease;
		} else {
			rebelCoinMultiplier = 1;
		}
		if (SPF.getTotalTerritories() - SPF.getPrevTotalTerritories() >= 0) {
			SPFCoinMultiplier += SPFCoinMultiplierIncrease;
		} else {
			SPFCoinMultiplier = 1;
		}
		System.out.print("Game: " + Main.gameName + "\t-\tEnd Round\n" + Main.lineSeparator + "\n" + playerStats() + "\n" + Main.lineSeparator + "\n");
		Main.hold();
		Rebels.refreshData();
		SPF.refreshData();
		Merchant.RefreshStock();
		startAuction();
	}
	
	public void startAuction() {
		Auctioneer.rollAuction();
	}
	
	public void rebelAttack() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tAttacking Team\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(<R> <S> <E>) Attack with R Riflemen, S Snipers, and E RPG soldiers\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int rs = console.nextInt();
		if (rs < 0) {
			console.nextLine();
		} else {
			int ss = console.nextInt();
			int es = console.nextInt();
			System.out.print(Main.lineSeparator + "\n(<U> <A> <F>) Attack with U Unarmed Vehicles, A Armed Vehicles, F Flight Vehicles\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
			int uv = console.nextInt();
			if (uv < 0) {
				console.nextLine();
			} else {
				int av = console.nextInt();
				int fv = console.nextInt();
				System.out.print(Main.lineSeparator + "\n(<S> <RA> <SA> <EA>) Auto Surrender with S Soldiers left, RA Rifle Ammo left, SA Sniper Ammo left, or EA RPG Ammo left\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
				int s = console.nextInt();
				if (s < 0) {
					console.nextLine();
				} else {
					int RA = Math.min(console.nextInt(), Rebels.getAmountRifleAmmo());
					int SA = Math.min(console.nextInt(), Rebels.getAmountSniperAmmo());
					int EA = Math.min(console.nextInt(), Rebels.getAmountRPGAmmo());
					
					System.out.print("Defending Team\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(<R> <S> <E>) Defend with R Riflemen, S Snipers, and E RPG soldiers\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
					int dRS = console.nextInt();
					if (dRS < 0) {
						console.nextLine();
					} else {
						int dSS = console.nextInt();
						int dES = console.nextInt();
						System.out.print(Main.lineSeparator + "\n(<U> <A> <F>) Defend with U Unarmed Vehicles, A Armed Vehicles, F Flight Vehicles\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
						int dUV = console.nextInt();
						if (dUV < 0) {
							console.nextLine();
						} else {
							int dAV = console.nextInt();
							int dFV = console.nextInt();
							System.out.print(Main.lineSeparator + "\n(<S> <RA> <SA> <EA>) Auto Surrender with S Soldiers left, RA Rifle Ammo left, SA Sniper Ammo left, or EA RPG Ammo left\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
							int dS = console.nextInt();
							if (dS < 0) {
								console.nextLine();
							} else {
								int dRA = Math.min(console.nextInt(), SPF.getAmountRifleAmmo());
								int dSA = Math.min(console.nextInt(), SPF.getAmountSniperAmmo());
								int dEA = Math.min(console.nextInt(), SPF.getAmountRPGAmmo());
								System.out.print(Main.lineSeparator + "\nBattle Settings\n" + Main.lineSeparator + "\n(<M>) M Max Rounds\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
								int M = console.nextInt();
								if (M < 0) {
									console.nextLine();
								} else {
									console.nextLine();
									if (M == 0) {
										M+=1;
									}
									AttackSimulator.BeginAttack(SPF, Rebels, AttackSimulator.CreateArmy(dRS, dSS, dES, dUV, dAV, dFV), AttackSimulator.CreateArmy(rs, ss, es, uv, av, fv), dS, s, M, AttackSimulator.createMinAmmo(dRA, dSA, dEA), AttackSimulator.createMinAmmo(RA, SA, EA));
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void SPFAttack() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tAttacking Team\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(<R> <S> <E>) Attack with R Riflemen, S Snipers, and E RPG soldiers\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int rs = console.nextInt();
		if (rs < 0) {
			console.nextLine();
		} else {
			int ss = console.nextInt();
			int es = console.nextInt();
			System.out.print(Main.lineSeparator + "\n(<U> <A> <F>) Attack with U Unarmed Vehicles, A Armed Vehicles, F Flight Vehicles\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
			int uv = console.nextInt();
			if (uv < 0) {
				console.nextLine();
			} else {
				int av = console.nextInt();
				int fv = console.nextInt();
				System.out.print(Main.lineSeparator + "\n(<S> <RA> <SA> <EA>) Auto Surrender with S Soldiers left, RA Rifle Ammo left, SA Sniper Ammo left, or EA RPG Ammo left\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
				int s = console.nextInt();
				if (s < 0) {
					console.nextLine();
				} else {
					int RA = Math.min(console.nextInt(), SPF.getAmountRifleAmmo());
					int SA = Math.min(console.nextInt(), SPF.getAmountSniperAmmo());
					int EA = Math.min(console.nextInt(), SPF.getAmountRPGAmmo());
					
					System.out.print("Defending Team\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(<R> <S> <E>) Defend with R Riflemen, S Snipers, and E RPG soldiers\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
					int dRS = console.nextInt();
					if (dRS < 0) {
						console.nextLine();
					} else {
						int dSS = console.nextInt();
						int dES = console.nextInt();
						System.out.print(Main.lineSeparator + "\n(<U> <A> <F>) Defend with U Unarmed Vehicles, A Armed Vehicles, F Flight Vehicles\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
						int dUV = console.nextInt();
						if (dUV < 0) {
							console.nextLine();
						} else {
							int dAV = console.nextInt();
							int dFV = console.nextInt();
							System.out.print(Main.lineSeparator + "\n(<S> <RA> <SA> <EA>) Auto Surrender with S Soldiers left, RA Rifle Ammo left, SA Sniper Ammo left, or EA RPG Ammo left\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
							int dS = console.nextInt();
							if (dS < 0) {
								console.nextLine();
							} else {
								int dRA = Math.min(console.nextInt(), Rebels.getAmountRifleAmmo());
								int dSA = Math.min(console.nextInt(), Rebels.getAmountSniperAmmo());
								int dEA = Math.min(console.nextInt(), Rebels.getAmountRPGAmmo());
								System.out.print(Main.lineSeparator + "\nBattle Settings\n" + Main.lineSeparator + "\n(<M>) M Max Rounds\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
								int M = console.nextInt();
								if (M < 0) {
									console.nextLine();
								} else {
									console.nextLine();
									if (M == 0) {
										M+=1;
									}
									AttackSimulator.BeginAttack(Rebels, SPF, AttackSimulator.CreateArmy(dRS, dSS, dES, dUV, dAV, dFV), AttackSimulator.CreateArmy(rs, ss, es, uv, av, fv), dS, s, M, AttackSimulator.createMinAmmo(dRA, dSA, dEA), AttackSimulator.createMinAmmo(RA, SA, EA));
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void rebelTerritories() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tRebel Territories\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(1 <N>) Add N Territories\n(2 <N>) Remove N Territories\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		switch(input) {
		case 1:
			int add = console.nextInt();
			Rebels.setTotalTerritories(Rebels.getTotalTerritories() + add);
			SPF.setTotalTerritories(SPF.getTotalTerritories() - add);
			System.out.println("Added " + add + " Territories to the Rebels");
			Rebels.setTerritoryGainCount(Rebels.getTerritoryGainCount() + add);
			console.nextLine();
			Main.hold();
			break;
		case 2:
			int subtract = console.nextInt();
			Rebels.setTotalTerritories(Rebels.getTotalTerritories() - subtract);
			SPF.setTotalTerritories(SPF.getTotalTerritories() + subtract);
			SPF.setTerritoryGainCount(SPF.getTerritoryGainCount() + subtract);
			System.out.println("Subtracted " + subtract + " Territories of the Rebels");
			console.nextLine();
			Main.hold();
			break;
		default:
			console.nextLine();
			break;
		}
	}
	
	public void SPFTerritories() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tSPF Territories\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(1 <N>) Add N Territories\n(2 <N>) Remove N Territories\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		switch(input) {
		case 1:
			int add = console.nextInt();
			SPF.setTotalTerritories(SPF.getTotalTerritories() + add);
			Rebels.setTotalTerritories(Rebels.getTotalTerritories() - add);
			System.out.println("Added " + add + " Territories to the SPF");
			SPF.setTerritoryGainCount(SPF.getTerritoryGainCount() + add);
			console.nextLine();
			Main.hold();
			break;
		case 2:
			int subtract = console.nextInt();
			SPF.setTotalTerritories(SPF.getTotalTerritories() - subtract);
			Rebels.setTotalTerritories(Rebels.getTotalTerritories() + subtract);
			System.out.println("Subtracted " + subtract + " Territories of the SPF");
			Rebels.setTerritoryGainCount(Rebels.getTerritoryGainCount() + subtract);
			console.nextLine();
			Main.hold();
			break;
		default:
			console.nextLine();
			break;
		}
	}
	
	public void rebelPurchaseItems() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tRebel Purchase\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(1) Purchase Food\n(2 <T>) Purchase weapon T | 1 -> Rifle   2 -> Sniper   3 -> RPG\n(3 <T>) Purchase ammo T | 1 -> Rifle Ammo   2 -> Sniper Ammo   3 -> RPG Ammo\n(4 <T>) Repair vehicle T | 1 -> Unarmed Vehicle   2 -> Armed Vehicle   3 -> Flight Vehicle\n(5) Heal injured soldiers\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		int amount = 0;
		switch(input) {
		case 1:
			console.nextLine();
			System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Food (Max Food Rebels can purchase is " + Merchant.maxPurchaseFood(Rebels) + " at " + Merchant.foodCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
			amount = console.nextInt();
			console.nextLine();
			if (amount > 0 && amount <= Merchant.maxPurchaseFood(Rebels)) {
				Merchant.purchaseFood(amount, Rebels);
			} else if (amount <= 0){
				System.out.println("C'mon dude why you buying " + amount + " food!??!?!");
				Main.hold();
			} else {
				System.out.println("C'mon dude why you buying " + amount + " food!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseFood(Rebels) + " FOOD!!");
				Main.hold();
			}
			break;
		case 2:
			int weaponType = console.nextInt();
			console.nextLine();
			switch(weaponType) {
			case 1:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Rifles (Max Rifles Rebels can purchase is " + Merchant.maxPurchaseRifle(Rebels) + " at " + Merchant.rifleCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRifle(Rebels)) {
					Merchant.purchaseRifle(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Rifles!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Rifles!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRifle(Rebels) + " Rifles!!");
					Main.hold();
				}
				break;
			case 2:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Snipers (Max Snipers Rebels can purchase is " + Merchant.maxPurchaseSniper(Rebels)+ " at " + Merchant.sniperCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseSniper(Rebels)) {
					Merchant.purchaseSniper(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Snipers!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Snipers!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseSniper(Rebels) + " Snipers!!");
					Main.hold();
				}
				break;
			case 3:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N RPG (Max RPG Rebels can purchase is " + Merchant.maxPurchaseRPG(Rebels)+ " at " + Merchant.rpgCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRPG(Rebels)) {
					Merchant.purchaseRPG(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " RPG!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " RPG!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRPG(Rebels) + " RPG!!");
					Main.hold();
				}
				break;
			default:
				System.out.println("Didn't understand your input, please try again");
				Main.hold();
				break;
			}
			break;
		case 3:
			int ammoType = console.nextInt();
			console.nextLine();
			switch(ammoType) {
			case 1:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Rifle Ammo (Max Rifle Ammo Rebels can purchase is " + Merchant.maxPurchaseRifleAmmo(Rebels) + " at " + Merchant.rifleAmmoCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRifleAmmo(Rebels)) {
					Merchant.purchaseRifleAmmo(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Rifle Ammo!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Rifle Ammo!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRifleAmmo(Rebels) + " Rifle Ammo!!");
					Main.hold();
				}
				break;
			case 2:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Sniper Ammo (Max Sniper Ammo Rebels can purchase is " + Merchant.maxPurchaseSniperAmmo(Rebels) + " at " + Merchant.sniperAmmoCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseSniperAmmo(Rebels)) {
					Merchant.purchaseSniperAmmo(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Sniper Ammo!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Sniper Ammo!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseSniperAmmo(Rebels) + " Sniper Ammo!!");
					Main.hold();
				}
				break;
			case 3:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N RPG Ammo (Max RPG Ammo Rebels can purchase is " + Merchant.maxPurchaseRPGAmmo(Rebels) + " at " + Merchant.rpgAmmoCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRPGAmmo(Rebels)) {
					Merchant.purchaseRPGAmmo(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " RPG Ammo!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " RPG Ammo!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRPGAmmo(Rebels) + " RPG Ammo!!");
					Main.hold();
				}
				break;
			default:
				System.out.println("Didn't understand your input, please try again idiot!");
				Main.hold();
				break;
			}
			break;
		case 4:
			int vehicleType = console.nextInt();
			console.nextLine();
			switch(vehicleType) {
			case 1:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Unarmed Vehicle Repairs (Max Unarmed Vehicle Repairs Rebels can purchase is " + Merchant.maxRepairUnarmedVehicle(Rebels) + " at " + Merchant.unarmedVehicleRepairCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxRepairUnarmedVehicle(Rebels)) {
					Merchant.repairUnarmedVehicle(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Unarmed Vehicle Repairs!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Unarmed Vehicle Repairs!??!?! YOU CAN ONLY BUY " + Merchant.maxRepairUnarmedVehicle(Rebels) + " Unarmed Vehicle Repairs!!");
					Main.hold();
				}
				break;
			case 2:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Armed Vehicle Repairs (Max Armed Vehicle Repairs Rebels can purchase is " + Merchant.maxRepairArmedVehicle(Rebels) + " at " + Merchant.armedVehicleRepairCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxRepairArmedVehicle(Rebels)) {
					Merchant.repairArmedVehicle(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Armed Vehicle Repairs!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Armed Vehicle Repairs!??!?! YOU CAN ONLY BUY " + Merchant.maxRepairArmedVehicle(Rebels) + " Armed Vehicle Repairs!!");
					Main.hold();
				}
				break;
			case 3:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Flight Vehicle Repairs (Max Flight Vehicle Repairs Rebels can purchase is " + Merchant.maxRepairFlightVehicle(Rebels) + " at " + Merchant.flightVehicleRepairCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxRepairFlightVehicle(Rebels)) {
					Merchant.repairFlightVehicle(amount, Rebels);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Flight Vehicle Repairs!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Flight Vehicle Repairs!??!?! YOU CAN ONLY BUY " + Merchant.maxRepairFlightVehicle(Rebels) + " Flight Vehicle Repairs!!");
					Main.hold();
				}
				break;
			default:
				System.out.println("Didn't understand your input, please try again idiot!");
				Main.hold();
				break;
			}
			break;
		case 5:
			console.nextLine();
			System.out.print(Main.lineSeparator + "\n(<N>) Heal N Injured Soldiers (Max Injured Soldiers Rebels can Heal is " + Merchant.maxHealInjuredSoldier(Rebels) + " at " + Merchant.soldierHealCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
			amount = console.nextInt();
			console.nextLine();
			if (amount > 0 && amount <= Merchant.maxHealInjuredSoldier(Rebels)) {
				Merchant.healInjuredSoldier(amount, Rebels);
			} else if (amount <= 0){
				System.out.println("C'mon dude why you healing " + amount + " Injured Soldiers!??!?!");
				Main.hold();
			} else {
				System.out.println("C'mon dude why you healing " + amount + " Injured Soldiers!??!?! YOU CAN ONLY HEAL " + Merchant.maxHealInjuredSoldier(Rebels) + " Injured Soldiers!!");
				Main.hold();
			}
			break;
		default:
			console.nextLine();
			System.out.println("Didn't understand your input, please try again idiot!");
			Main.hold();
			break;
		}
	}
	
	public void SPFPurchaseItems() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tSPF Purchase\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(1) Purchase Food\n(2 <T>) Purchase weapon T | 1 -> Rifle   2 -> Sniper   3 -> RPG\n(3 <T>) Purchase ammo T | 1 -> Rifle Ammo   2 -> Sniper Ammo   3 -> RPG Ammo\n(4 <T>) Repair vehicle T | 1 -> Unarmed Vehicle   2 -> Armed Vehicle   3 -> Flight Vehicle\n(5) Heal injured soldiers\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		int amount = 0;
		switch(input) {
		case 1:
			console.nextLine();
			System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Food (Max Food SPF can purchase is " + Merchant.maxPurchaseFood(SPF) + " at " + Merchant.foodCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
			amount = console.nextInt();
			console.nextLine();
			if (amount > 0 && amount <= Merchant.maxPurchaseFood(SPF)) {
				Merchant.purchaseFood(amount, SPF);
			} else if (amount <= 0){
				System.out.println("C'mon dude why you buying " + amount + " food!??!?!");
				Main.hold();
			} else {
				System.out.println("C'mon dude why you buying " + amount + " food!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseFood(SPF) + " FOOD!!");
				Main.hold();
			}
			break;
		case 2:
			int weaponType = console.nextInt();
			console.nextLine();
			switch(weaponType) {
			case 1:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Rifles (Max Rifles SPF can purchase is " + Merchant.maxPurchaseRifle(SPF) + " at " + Merchant.rifleCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRifle(SPF)) {
					Merchant.purchaseRifle(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Rifles!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Rifles!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRifle(SPF) + " Rifles!!");
					Main.hold();
				}
				break;
			case 2:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Snipers (Max Snipers SPF can purchase is " + Merchant.maxPurchaseSniper(SPF) + " at " + Merchant.sniperCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseSniper(SPF)) {
					Merchant.purchaseSniper(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Snipers!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Snipers!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseSniper(SPF) + " Snipers!!");
					Main.hold();
				}
				break;
			case 3:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N RPG (Max RPG SPF can purchase is " + Merchant.maxPurchaseRPG(SPF) + " at " + Merchant.rpgCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRPG(SPF)) {
					Merchant.purchaseRPG(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " RPG!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " RPG!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRPG(SPF) + " RPG!!");
					Main.hold();
				}
				break;
			default:
				System.out.println("Didn't understand your input, please try again");
				Main.hold();
				break;
			}
			break;
		case 3:
			int ammoType = console.nextInt();
			console.nextLine();
			switch(ammoType) {
			case 1:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Rifle Ammo (Max Rifle Ammo SPF can purchase is " + Merchant.maxPurchaseRifleAmmo(SPF) + " at " + Merchant.rifleAmmoCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRifleAmmo(SPF)) {
					Merchant.purchaseRifleAmmo(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Rifle Ammo!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Rifle Ammo!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRifleAmmo(SPF) + " Rifle Ammo!!");
					Main.hold();
				}
				break;
			case 2:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Sniper Ammo (Max Sniper Ammo SPF can purchase is " + Merchant.maxPurchaseSniperAmmo(SPF) + " at " + Merchant.sniperAmmoCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseSniperAmmo(SPF)) {
					Merchant.purchaseSniperAmmo(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Sniper Ammo!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Sniper Ammo!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseSniperAmmo(SPF) + " Sniper Ammo!!");
					Main.hold();
				}
				break;
			case 3:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N RPG Ammo (Max RPG Ammo SPF can purchase is " + Merchant.maxPurchaseRPGAmmo(SPF) + " at " + Merchant.rpgAmmoCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxPurchaseRPGAmmo(SPF)) {
					Merchant.purchaseRPGAmmo(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " RPG Ammo!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " RPG Ammo!??!?! YOU CAN ONLY BUY " + Merchant.maxPurchaseRPGAmmo(SPF) + " RPG Ammo!!");
					Main.hold();
				}
				break;
			default:
				System.out.println("Didn't understand your input, please try again idiot!");
				Main.hold();
				break;
			}
			break;
		case 4:
			int vehicleType = console.nextInt();
			console.nextLine();
			switch(vehicleType) {
			case 1:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Unarmed Vehicle Repairs (Max Unarmed Vehicle Repairs SPF can purchase is " + Merchant.maxRepairUnarmedVehicle(SPF) + " at " + Merchant.unarmedVehicleRepairCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxRepairUnarmedVehicle(SPF)) {
					Merchant.repairUnarmedVehicle(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Unarmed Vehicle Repairs!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Unarmed Vehicle Repairs!??!?! YOU CAN ONLY BUY " + Merchant.maxRepairUnarmedVehicle(SPF) + " Unarmed Vehicle Repairs!!");
					Main.hold();
				}
				break;
			case 2:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Armed Vehicle Repairs (Max Armed Vehicle Repairs SPF can purchase is " + Merchant.maxRepairArmedVehicle(SPF) + " at " + Merchant.armedVehicleRepairCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxRepairArmedVehicle(SPF)) {
					Merchant.repairArmedVehicle(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Armed Vehicle Repairs!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Armed Vehicle Repairs!??!?! YOU CAN ONLY BUY " + Merchant.maxRepairArmedVehicle(SPF) + " Armed Vehicle Repairs!!");
					Main.hold();
				}
				break;
			case 3:
				System.out.print(Main.lineSeparator + "\n(<N>) Purchase N Flight Vehicle Repairs (Max Flight Vehicle Repairs SPF can purchase is " + Merchant.maxRepairFlightVehicle(SPF) + " at " + Merchant.flightVehicleRepairCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
				amount = console.nextInt();
				console.nextLine();
				if (amount > 0 && amount <= Merchant.maxRepairFlightVehicle(SPF)) {
					Merchant.repairFlightVehicle(amount, SPF);
				} else if (amount <= 0){
					System.out.println("C'mon dude why you buying " + amount + " Flight Vehicle Repairs!??!?!");
					Main.hold();
				} else {
					System.out.println("C'mon dude why you buying " + amount + " Flight Vehicle Repairs!??!?! YOU CAN ONLY BUY " + Merchant.maxRepairFlightVehicle(SPF) + " Flight Vehicle Repairs!!");
					Main.hold();
				}
				break;
			default:
				System.out.println("Didn't understand your input, please try again idiot!");
				Main.hold();
				break;
			}
			break;
		case 5:
			console.nextLine();
			System.out.print(Main.lineSeparator + "\n(<N>) Heal N Injured Soldiers (Max Injured Soldiers SPF can Heal is " + Merchant.maxHealInjuredSoldier(SPF) + " at " + Merchant.soldierHealCost + "$ per)\n" + Main.lineSeparator +"\n>>> ");
			amount = console.nextInt();
			console.nextLine();
			if (amount > 0 && amount <= Merchant.maxHealInjuredSoldier(SPF)) {
				Merchant.healInjuredSoldier(amount, SPF);
			} else if (amount <= 0){
				System.out.println("C'mon dude why you healing " + amount + " Injured Soldiers!??!?!");
				Main.hold();
			} else {
				System.out.println("C'mon dude why you healing " + amount + " Injured Soldiers!??!?! YOU CAN ONLY HEAL " + Merchant.maxHealInjuredSoldier(SPF) + " Injured Soldiers!!");
				Main.hold();
			}
			break;
		default:
			console.nextLine();
			System.out.println("Didn't understand your input, please try again idiot!");
			Main.hold();
			break;
		}
	}
	
	public void rebelUpgrades() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tRebel Upgrades\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(1) Increase Maximum Soldier Auctioned by 1\n(2) Increase Unarmed Vehicle Auction Chance by 1\n(3) Increase Armed Vehicle Auction Chance by 1\n(4) Increase Flight Vehicle Auction Chance by 1\n(5) Increase Coins Per Round By 2\n(6) Increase Coins Per Territory by 1\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		console.nextLine();
		switch(input) {
		case 1:
			Upgrades.increaseMaximumSoldierAuctioned(Rebels);
			break;
		case 2:
			Upgrades.increaseUnarmedVehicleAuctionChance(Rebels);
			break;
		case 3:
			Upgrades.increaseArmedVehicleAuctionChance(Rebels);
			break;
		case 4:
			Upgrades.increaseFlightVehicleAuctionChance(Rebels);
			break;
		case 5:
			Upgrades.rebelIncreaseCoinsPerRound(Rebels);
			break;
		case 6:
			Upgrades.rebelIncreaseCoinsPerTerritory(Rebels);
			break;
		case -1:
			break;
		default:
			System.out.println("Sorry your input could not be read, please try again!");
			Main.hold();
			break;
		}
	}
	
	public void SPFUpgrades() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tSPF Upgrades\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(1) Increase Maximum Soldier Auctioned by 1\n(2) Increase Unarmed Vehicle Auction Chance by 1\n(3) Increase Armed Vehicle Auction Chance by 1\n(4) Increase Flight Vehicle Auction Chance by 1\n(5) Increase Coins Per Round By 2\n(6) Increase Coins Per Territory by 1\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		console.nextLine();
		switch(input) {
		case 1:
			Upgrades.increaseMaximumSoldierAuctioned(SPF);
			break;
		case 2:
			Upgrades.increaseUnarmedVehicleAuctionChance(SPF);
			break;
		case 3:
			Upgrades.increaseArmedVehicleAuctionChance(SPF);
			break;
		case 4:
			Upgrades.increaseFlightVehicleAuctionChance(SPF);
			break;
		case 5:
			Upgrades.SPFIncreaseCoinsPerRound(SPF);
			break;
		case 6:
			Upgrades.SPFIncreaseCoinsPerTerritory(SPF);
			break;
		case -1:
			break;
		default:
			System.out.println("Sorry your input could not be read, please try again!");
			Main.hold();
			break;
		}
	}
	
	public void rebelQuests() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tRebel Quests\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n");
		Quests.rebelOutputCurrentQuestDetails();
		if (Quests.isRebelQuestCompleted()) {
			System.out.println(Main.lineSeparator + "\n(1) Claim Quest Rewards");
			System.out.print(Main.lineSeparator + "\n>>> ");
			int input = console.nextInt();
			console.nextLine();
			switch(input) {
			case 1:
				Quests.completeRebelQuest();
				break;
			default:
				System.out.println("Sorry your input could not be read, please try again!");
				Main.hold();
				break;
			}
		} else {
			System.out.print(Main.lineSeparator + "\n(1) Generate New Quest For " + Quests.RebelResetPrice + "$\n(-1) Cancel\n" + Main.lineSeparator + "\n>>> ");
			int input = console.nextInt();
			console.nextLine();
			switch(input) {
			case 1:
				if (Rebels.getCoinPurse() < Quests.RebelResetPrice) {
					System.out.println("You can't afford it idiot!");
					Main.hold();
					break;
				} else {
					Quests.rebelGetNewQuest();
					Rebels.setCoinPurse(Rebels.getCoinPurse() - Quests.RebelResetPrice);
					addBlankLines();
					System.out.print("Game: " + Main.gameName + "\t-\tRebel Generated Quests\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n");
					Quests.rebelOutputCurrentQuestDetails();
					System.out.println(Main.lineSeparator);
					Main.hold();
				}
				break;
			case -1:
				break;
			default:
				System.out.println("Sorry your input could not be read, please try again!");
				Main.hold();
				break;
			}
		}
	}
	
	public void SPFQuests() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tSPF Quests\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n");
		Quests.SPFOutputCurrentQuestDetails();
		if (Quests.isSPFQuestCompleted()) {
			System.out.println(Main.lineSeparator + "\n(1) Claim Quest Rewards");
			System.out.print(Main.lineSeparator + "\n>>> ");
			int input = console.nextInt();
			console.nextLine();
			switch(input) {
			case 1:
				Quests.completeSPFQuest();
				break;
			default:
				System.out.println("Sorry your input could not be read, please try again!");
				Main.hold();
				break;
			}
		} else {
			System.out.print(Main.lineSeparator + "\n(1) Generate New Quest For " + Quests.SPFResetPrice + "$\n(-1) Cancel\n" + Main.lineSeparator +  "\n>>> ");
			int input = console.nextInt();
			console.nextLine();
			switch(input) {
			case 1:
				if (SPF.getCoinPurse() < Quests.SPFResetPrice) {
					System.out.println("You can't afford it idiot!");
					Main.hold();
					break;
				} else {
					Quests.SPFGetNewQuest();
					SPF.setCoinPurse(SPF.getCoinPurse() - Quests.SPFResetPrice);
					addBlankLines();
					System.out.print("Game: " + Main.gameName + "\t-\tSPF Generated Quests\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n");
					Quests.SPFOutputCurrentQuestDetails();
					System.out.println(Main.lineSeparator);
					Main.hold();
				}
				break;
			case -1:
				break;
			default:
				System.out.println("Sorry your input could not be read, please try again!");
				Main.hold();
				break;
			}
		}
	}
	
	public void rebelTools() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tRebel Tools\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(1 <N>) Add N$\n(2 <T> <N>) Add N pts to skill T (1 -> Suspicion | 2 -> Attack | 3 -> Health)\n(3 <T> <N>) Add N ammo to ammotype T (1 -> Rifle Ammo | 2 -> Sniper Ammo | 3 -> RPG Ammo)\n(10) Back\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		switch(input) {
		case 1:
			int numCoins = console.nextInt();
			console.nextLine();
			Rebels.setCoinPurse(Rebels.getCoinPurse() + numCoins);
			System.out.println("Added " + numCoins + "$ to Rebel's balance");
			Main.hold();
			break;
		case 2:
			int skillType = console.nextInt();
			double numExp = console.nextDouble();
			console.nextLine();
			switch(skillType) {
			case 1:
				Rebels.setSuspicion(Rebels.getSuspicion() + numExp);
				System.out.println("Added " + numExp + " exp to Rebel's Suspicion Skill");
				break;
			case 2:
				Rebels.setAttack(Rebels.getAttack() + numExp);
				System.out.println("Added " + numExp + " exp to Rebel's Attack Skill");
				break;
			case 3:
				Rebels.setHealth(Rebels.getHealth() + numExp);
				System.out.println("Added " + numExp + " exp to Rebel's Health Skill");
				break;
			default:
				System.out.println("What did you even type dumb dumb!");
				break;
			}
			Main.hold();
			break;
		case 3:
			int ammoType = console.nextInt();
			int numAmmo = console.nextInt();
			console.nextLine();
			switch(ammoType) {
			case 1:
				Rebels.setAmountRifleAmmo(Rebels.getAmountRifleAmmo() + numAmmo);
				System.out.println("Added " + numAmmo + " Rifle Ammo to Rebels");
				break;
			case 2:
				Rebels.setAmountSniperAmmo(Rebels.getAmountSniperAmmo() + numAmmo);
				System.out.println("Added " + numAmmo + " Sniper Ammo to Rebels");
				break;
			case 3:
				Rebels.setAmountRPGAmmo(Rebels.getAmountRPGAmmo() + numAmmo);
				System.out.println("Added " + numAmmo + " RPG Ammo to Rebels");
				break;
			default:
				System.out.println("C'mon Kiddo!");
				break;
			}
			Main.hold();
			break;
		case 10:
			rebelAction();
			break;
		default:
			System.out.println("C'mon you can't even follow simple directions!");
			break;
		}
	}
	
	public void SPFTools() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tSPF Tools\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(1 <N>) Add N$\n(2 <T> <N>) Add N pts to skill T (1 -> Suspicion | 2 -> Attack | 3 -> Health)\n(3 <T> <N>) Add N ammo to ammotype T (1 -> Rifle Ammo | 2 -> Sniper Ammo | 3 -> RPG Ammo)\n(10) Back\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		switch(input) {
		case 1:
			int numCoins = console.nextInt();
			console.nextLine();
			SPF.setCoinPurse(SPF.getCoinPurse() + numCoins);
			System.out.println("Added " + numCoins + "$ to SPF's balance");
			Main.hold();
			break;
		case 2:
			int skillType = console.nextInt();
			double numExp = console.nextDouble();
			console.nextLine();
			switch(skillType) {
			case 1:
				SPF.setSuspicion(SPF.getSuspicion() + numExp);
				System.out.println("Added " + numExp + " exp to SPF's Suspicion Skill");
				break;
			case 2:
				SPF.setAttack(SPF.getAttack() + numExp);
				System.out.println("Added " + numExp + " exp to SPF's Attack Skill");
				break;
			case 3:
				SPF.setHealth(SPF.getHealth() + numExp);
				System.out.println("Added " + numExp + " exp to SPF's Health Skill");
				break;
			default:
				System.out.println("What did you even type dumb dumb!");
				break;
			}
			Main.hold();
			break;
		case 3:
			int ammoType = console.nextInt();
			int numAmmo = console.nextInt();
			console.nextLine();
			switch(ammoType) {
			case 1:
				SPF.setAmountRifleAmmo(SPF.getAmountRifleAmmo() + numAmmo);
				System.out.println("Added " + numAmmo + " Rifle Ammo to SPF");
				break;
			case 2:
				SPF.setAmountSniperAmmo(SPF.getAmountSniperAmmo() + numAmmo);
				System.out.println("Added " + numAmmo + " Sniper Ammo to SPF");
				break;
			case 3:
				SPF.setAmountRPGAmmo(SPF.getAmountRPGAmmo() + numAmmo);
				System.out.println("Added " + numAmmo + " RPG Ammo to SPF");
				break;
			default:
				System.out.println("C'mon Kiddo!");
				break;
			}
			Main.hold();
			break;
		case 10:
			SPFAction();
			break;
		default:
			System.out.println("C'mon you can't even follow simple directions!");
			break;
		}
	}
	
	public void rebelSuspicion() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tRebel Suspicion\n" + Main.lineSeparator + "\n" + rebelStats() + "\n" + Main.lineSeparator + "\n(1 <N> <T>) Add Suspicion for N soldiers at T territories from nearest enemy\n(2) (10) Back\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		switch (input) {
		case 1:
			int Nsoldiers = console.nextInt();
			int Tterritories = console.nextInt();
			console.nextLine();
			System.out.println(Main.lineSeparator + "\nRebels gained " + Rebels.gainSuspicion(Nsoldiers, Tterritories) + " Suspicion\n" + Main.lineSeparator);
			Main.hold();
			break;
		case 10:
			console.nextLine();
			break;
		default:
			console.nextLine();
			break;
		}
	}
	
	
	public void SPFSuspicion() {
		addBlankLines();
		System.out.print("Game: " + Main.gameName + "\t-\tSPF Suspicion\n" + Main.lineSeparator + "\n" + SPFStats() + "\n" + Main.lineSeparator + "\n(1 <N> <T>) Add Suspicion for N soldiers at T territories from nearest enemy\n(10) Back\n" + Main.lineSeparator + "\n>>> ");
		int input = console.nextInt();
		switch (input) {
		case 1:
			int Nsoldiers = console.nextInt();
			int Tterritories = console.nextInt();
			console.nextLine();
			System.out.println(Main.lineSeparator + "\nSPF gained " + SPF.gainSuspicion(Nsoldiers, Tterritories) + " Suspicion\n" + Main.lineSeparator);
			Main.hold();
			break;
		case 10:
			console.nextLine();
			break;
		default:
			console.nextLine();
			break;
		}
	}
	
	public static String rebelStats() {
		String str = "Rebel Alliance Team -\t" + Rebels.getCoinPurse() + "$  +(" + (Rebels.getCoinPurse() - Rebels.getPrevCoinPurse()) + ")\t" + Rebels.getAmountRifleAmmo() + "R  +(" + (Rebels.getAmountRifleAmmo() - Rebels.getPrevAmountRifleAmmo()) + ")\t" + Rebels.getAmountSniperAmmo() + "S  +(" + (Rebels.getAmountSniperAmmo() - Rebels.getPrevAmountSniperAmmo()) + ")\t" + Rebels.getAmountRPGAmmo() + "E  +(" + (Rebels.getAmountRPGAmmo() - Rebels.getPrevAmountRPGAmmo()) + ")\n- Suspicion\t" + Rebels.getSuspicion() + "  +(" + (Rebels.getSuspicion() - Rebels.getPrevSuspicion()) + ")\n- Attack\t" + Rebels.getAttack() + "  +(" + ( Rebels.getAttack() - Rebels.getPrevAttack()) + ")\n- Health\t" + Rebels.getHealth() + "  +(" + (Rebels.getHealth() - Rebels.getPrevHealth()) + ")\n- Territories \t" + Rebels.getTotalTerritories() + " +(" + (Rebels.getTotalTerritories() - Rebels.getPrevTotalTerritories()) + ")";
		return str;
	}
	
	public static String SPFStats() {
		String str = "SPF Team -\t" + SPF.getCoinPurse() + "$  +(" + (SPF.getCoinPurse() - SPF.getPrevCoinPurse()) + ")\t" + SPF.getAmountRifleAmmo() + "R  +(" + (SPF.getAmountRifleAmmo() - SPF.getPrevAmountRifleAmmo()) + ")\t" + SPF.getAmountSniperAmmo() + "S  +(" + (SPF.getAmountSniperAmmo() - SPF.getPrevAmountSniperAmmo()) + ")\t" + SPF.getAmountRPGAmmo() + "E  +(" + (SPF.getAmountRPGAmmo() - SPF.getPrevAmountRPGAmmo()) + ")\n- Suspicion\t" + SPF.getSuspicion() + "  +(" + (SPF.getSuspicion() - SPF.getPrevSuspicion()) + ")\n- Attack\t" + SPF.getAttack() + "  +(" + ( SPF.getAttack() - SPF.getPrevAttack()) + ")\n- Health\t" + SPF.getHealth() + "  +(" + (SPF.getHealth() - SPF.getPrevHealth()) + ")\n- Territories\t" + SPF.getTotalTerritories() + " +(" + (SPF.getTotalTerritories() - SPF.getPrevTotalTerritories()) + ")";
		return str;
	}
	
	public void outputHeader() {
		System.out.print("Game: " + Main.gameName + "\t-\tGame Actions\n" + Main.lineSeparator + "\n" + playerStats() + "\n" + Main.lineSeparator + "\n(1) Rebel Action\n(2) SPF Action\n(3) End Round\n(10) Save and Exit Game\n" + Main.lineSeparator + "\n>>> ");
	}
	
	public static String playerStats() {
		String str = rebelStats() + "\n\n" + SPFStats();
		return str;
	}

	public static void addBlankLines() {
		for (int x = 0; x < 5; x++) {
			System.out.println();
		}
	}

	public static Scanner getConsole() {
		return console;
	}

	public static Player getSPF() {
		return SPF;
	}

	public static Player getRebels() {
		return Rebels;
	}

	public static double getRebelInitialSuspicion() {
		return rebelInitialSuspicion;
	}

	public static double getRebelInitialAttack() {
		return rebelInitialAttack;
	}

	public static double getRebelInitialHealth() {
		return rebelInitialHealth;
	}

	public static double getSPFInitialSuspicion() {
		return SPFInitialSuspicion;
	}

	public static double getSPFInitialAttack() {
		return SPFInitialAttack;
	}

	public static double getSPFInitialHealth() {
		return SPFInitialHealth;
	}

	public static int getRebelInitialCoins() {
		return rebelInitialCoins;
	}

	public static int getRebelInitialTerritories() {
		return rebelInitialTerritories;
	}

	public static int getSPFInitialCoins() {
		return SPFInitialCoins;
	}

	public static int getSPFInitialTerritories() {
		return SPFInitialTerritories;
	}

	public static int getRebelInitialRifleAmmo() {
		return rebelInitialRifleAmmo;
	}

	public static int getRebelInitialSniperAmmo() {
		return rebelInitialSniperAmmo;
	}

	public static int getRebelInitialRPGAmmo() {
		return rebelInitialRPGAmmo;
	}

	public static int getSPFInitialRifleAmmo() {
		return SPFInitialRifleAmmo;
	}

	public static int getSPFInitialSniperAmmo() {
		return SPFInitialSniperAmmo;
	}

	public static int getSPFInitialRPGAmmo() {
		return SPFInitialRPGAmmo;
	}

	public static int getRifleAmmoChance() {
		return rifleAmmoChance;
	}

	public static int getRifleDestroyedChance() {
		return rifleDestroyedChance;
	}

	public static int getSniperAmmoChance() {
		return sniperAmmoChance;
	}

	public static int getSniperDestroyedChance() {
		return sniperDestroyedChance;
	}

	public static int getRpgAmmoChance() {
		return rpgAmmoChance;
	}

	public static int getRpgDestroyedChance() {
		return rpgDestroyedChance;
	}

	public static int getUnarmedVehicleDamagedChance() {
		return unarmedVehicleDamagedChance;
	}

	public static int getUnarmedVehicleDestroyedChance() {
		return unarmedVehicleDestroyedChance;
	}

	public static int getArmedVehicleDamagedChance() {
		return armedVehicleDamagedChance;
	}

	public static int getArmedVehicleDestroyedChance() {
		return armedVehicleDestroyedChance;
	}

	public static int getFlightVehicleDamagedChance() {
		return flightVehicleDamagedChance;
	}

	public static int getFlightVehicleDestroyedChance() {
		return flightVehicleDestroyedChance;
	}

	public static int getRebelCoinsPerRound() {
		return rebelCoinsPerRound;
	}

	public static int getRebelCoinsPerTerritory() {
		return rebelCoinsPerTerritory;
	}

	public static double getRebelCoinMultiplier() {
		return rebelCoinMultiplier;
	}

	public static double getRebelCoinMultiplierIncrease() {
		return rebelCoinMultiplierIncrease;
	}

	public static int getSPFCoinsPerRound() {
		return SPFCoinsPerRound;
	}

	public static int getSPFCoinsPerTerritory() {
		return SPFCoinsPerTerritory;
	}

	public static double getSPFCoinMultiplier() {
		return SPFCoinMultiplier;
	}

	public static double getSPFCoinMultiplierIncrease() {
		return SPFCoinMultiplierIncrease;
	}

	public static double getSuspicionLostPerRound() {
		return suspicionLostPerRound;
	}

	public static double getSuspicionGainPerAction() {
		return suspicionGainPerAction;
	}

	public static double getAttackLostPerRound() {
		return attackLostPerRound;
	}

	public static double getAttackGainPerShot() {
		return attackGainPerShot;
	}

	public static double getHealthLostPerRound() {
		return healthLostPerRound;
	}

	public static double getHealthBaseGainPerFood() {
		return healthBaseGainPerFood;
	}

	public static double getHealthMaxGainPerFood() {
		return healthMaxGainPerFood;
	}

	public static double getHealthBaseLostPerHit() {
		return healthBaseLostPerHit;
	}

	public static double getHealthMaxLostPerHit() {
		return healthMaxLostPerHit;
	}

	public static void setConsole(Scanner console) {
		Game.console = console;
	}

	public static void setSPF(Player sPF) {
		SPF = sPF;
	}

	public static void setRebels(Player rebels) {
		Rebels = rebels;
	}

	public static void setRebelInitialSuspicion(double rebelInitialSuspicion) {
		Game.rebelInitialSuspicion = rebelInitialSuspicion;
	}

	public static void setRebelInitialAttack(double rebelInitialAttack) {
		Game.rebelInitialAttack = rebelInitialAttack;
	}

	public static void setRebelInitialHealth(double rebelInitialHealth) {
		Game.rebelInitialHealth = rebelInitialHealth;
	}

	public static void setSPFInitialSuspicion(double sPFInitialSuspicion) {
		SPFInitialSuspicion = sPFInitialSuspicion;
	}

	public static void setSPFInitialAttack(double sPFInitialAttack) {
		SPFInitialAttack = sPFInitialAttack;
	}

	public static void setSPFInitialHealth(double sPFInitialHealth) {
		SPFInitialHealth = sPFInitialHealth;
	}

	public static void setRebelInitialCoins(int rebelInitialCoins) {
		Game.rebelInitialCoins = rebelInitialCoins;
	}

	public static void setRebelInitialTerritories(int rebelInitialTerritories) {
		Game.rebelInitialTerritories = rebelInitialTerritories;
	}

	public static void setSPFInitialCoins(int sPFInitialCoins) {
		SPFInitialCoins = sPFInitialCoins;
	}

	public static void setSPFInitialTerritories(int sPFInitialTerritories) {
		SPFInitialTerritories = sPFInitialTerritories;
	}

	public static void setRebelInitialRifleAmmo(int rebelInitialRifleAmmo) {
		Game.rebelInitialRifleAmmo = rebelInitialRifleAmmo;
	}

	public static void setRebelInitialSniperAmmo(int rebelInitialSniperAmmo) {
		Game.rebelInitialSniperAmmo = rebelInitialSniperAmmo;
	}

	public static void setRebelInitialRPGAmmo(int rebelInitialRPGAmmo) {
		Game.rebelInitialRPGAmmo = rebelInitialRPGAmmo;
	}

	public static void setSPFInitialRifleAmmo(int sPFInitialRifleAmmo) {
		SPFInitialRifleAmmo = sPFInitialRifleAmmo;
	}

	public static void setSPFInitialSniperAmmo(int sPFInitialSniperAmmo) {
		SPFInitialSniperAmmo = sPFInitialSniperAmmo;
	}

	public static void setSPFInitialRPGAmmo(int sPFInitialRPGAmmo) {
		SPFInitialRPGAmmo = sPFInitialRPGAmmo;
	}

	public static void setRifleAmmoChance(int rifleAmmoChance) {
		Game.rifleAmmoChance = rifleAmmoChance;
	}

	public static void setRifleDestroyedChance(int rifleDestroyedChance) {
		Game.rifleDestroyedChance = rifleDestroyedChance;
	}

	public static void setSniperAmmoChance(int sniperAmmoChance) {
		Game.sniperAmmoChance = sniperAmmoChance;
	}

	public static void setSniperDestroyedChance(int sniperDestroyedChance) {
		Game.sniperDestroyedChance = sniperDestroyedChance;
	}

	public static void setRpgAmmoChance(int rpgAmmoChance) {
		Game.rpgAmmoChance = rpgAmmoChance;
	}

	public static void setRpgDestroyedChance(int rpgDestroyedChance) {
		Game.rpgDestroyedChance = rpgDestroyedChance;
	}

	public static void setUnarmedVehicleDamagedChance(int unarmedVehicleDamagedChance) {
		Game.unarmedVehicleDamagedChance = unarmedVehicleDamagedChance;
	}

	public static void setUnarmedVehicleDestroyedChance(int unarmedVehicleDestroyedChance) {
		Game.unarmedVehicleDestroyedChance = unarmedVehicleDestroyedChance;
	}

	public static void setArmedVehicleDamagedChance(int armedVehicleDamagedChance) {
		Game.armedVehicleDamagedChance = armedVehicleDamagedChance;
	}

	public static void setArmedVehicleDestroyedChance(int armedVehicleDestroyedChance) {
		Game.armedVehicleDestroyedChance = armedVehicleDestroyedChance;
	}

	public static void setFlightVehicleDamagedChance(int flightVehicleDamagedChance) {
		Game.flightVehicleDamagedChance = flightVehicleDamagedChance;
	}

	public static void setFlightVehicleDestroyedChance(int flightVehicleDestroyedChance) {
		Game.flightVehicleDestroyedChance = flightVehicleDestroyedChance;
	}

	public static void setRebelCoinsPerRound(int rebelCoinsPerRound) {
		Game.rebelCoinsPerRound = rebelCoinsPerRound;
	}

	public static void setRebelCoinsPerTerritory(int rebelCoinsPerTerritory) {
		Game.rebelCoinsPerTerritory = rebelCoinsPerTerritory;
	}

	public static void setRebelCoinMultiplier(double rebelCoinMultiplier) {
		Game.rebelCoinMultiplier = rebelCoinMultiplier;
	}

	public static void setRebelCoinMultiplierIncrease(double rebelCoinMultiplierIncrease) {
		Game.rebelCoinMultiplierIncrease = rebelCoinMultiplierIncrease;
	}

	public static void setSPFCoinsPerRound(int sPFCoinsPerRound) {
		SPFCoinsPerRound = sPFCoinsPerRound;
	}

	public static void setSPFCoinsPerTerritory(int sPFCoinsPerTerritory) {
		SPFCoinsPerTerritory = sPFCoinsPerTerritory;
	}

	public static void setSPFCoinMultiplier(double sPFCoinMultiplier) {
		SPFCoinMultiplier = sPFCoinMultiplier;
	}

	public static void setSPFCoinMultiplierIncrease(double sPFCoinMultiplierIncrease) {
		SPFCoinMultiplierIncrease = sPFCoinMultiplierIncrease;
	}

	public static void setSuspicionLostPerRound(double suspicionLostPerRound) {
		Game.suspicionLostPerRound = suspicionLostPerRound;
	}

	public static void setSuspicionGainPerAction(double suspicionGainPerAction) {
		Game.suspicionGainPerAction = suspicionGainPerAction;
	}

	public static void setAttackLostPerRound(double attackLostPerRound) {
		Game.attackLostPerRound = attackLostPerRound;
	}

	public static void setAttackGainPerShot(double attackGainPerShot) {
		Game.attackGainPerShot = attackGainPerShot;
	}

	public static void setHealthLostPerRound(double healthLostPerRound) {
		Game.healthLostPerRound = healthLostPerRound;
	}

	public static void setHealthBaseGainPerFood(double healthBaseGainPerFood) {
		Game.healthBaseGainPerFood = healthBaseGainPerFood;
	}

	public static void setHealthMaxGainPerFood(double healthMaxGainPerFood) {
		Game.healthMaxGainPerFood = healthMaxGainPerFood;
	}

	public static void setHealthBaseLostPerHit(double healthBaseLostPerHit) {
		Game.healthBaseLostPerHit = healthBaseLostPerHit;
	}

	public static void setHealthMaxLostPerHit(double healthMaxLostPerHit) {
		Game.healthMaxLostPerHit = healthMaxLostPerHit;
	}
}
