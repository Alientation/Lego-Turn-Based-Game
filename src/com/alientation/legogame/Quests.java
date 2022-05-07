package com.alientation.legogame;

import java.util.Scanner;

import org.json.simple.JSONObject;

public class Quests {
	public static JSONObject dataFile = null;
	public static Scanner console = null;
	
	public static int RebelResetPrice = 100;
	public static int rebelCurrentQuest = -1;
	public static int rebelQuestAmountRequired = -1;
	public static int rebelRoundsSinceQuestStarted = -1;
	public static int rebelQuestReward = 150;
	
	public static int SPFResetPrice = 100;
	public static int SPFCurrentQuest = -1;
	public static int SPFQuestAmountRequired = -1;
	public static int SPFRoundsSinceQuestStarted = -1;
	public static int SPFQuestReward = 100;
	
	
	
	public static int killMin = 2, killMax = 10, injureMin = 4, injureMax = 15, healMin = 2, healMax = 4, shootMin = 10, shootMax = 50, saveAmmoMin = 10, saveAmmoMax = 50, gainAttackMin = 10, gainAttackMax = 200, gainHealthMin = 10, gainHealthMax = 200, gainSuspicionMin = 10, gainSuspicionMax = 200, gainTerritoriesMin = 1, gainTerritoriesMax = 5, purchaseAmmoMin = 10, purchaseAmmoMax = 50, purchaseVehiclesMin = 1, purchaseVehiclesMax = 2, purchaseSoldiersMin = 5, purchaseSoldiersMax = 10;
	public static final int totalUniqueQuests = 12;
	
	public static void init(JSONObject data) {
		console = Main.console;
		dataFile = data;
		
		RebelResetPrice = (int) (long) GameFileHandler.load("RebelResetPrice", RebelResetPrice);
		rebelCurrentQuest = (int) (long) GameFileHandler.load("rebelCurrentQuest", rebelCurrentQuest);
		rebelQuestAmountRequired = (int) (long) GameFileHandler.load("rebelQuestAmountRequired", rebelQuestAmountRequired);
		rebelRoundsSinceQuestStarted = (int) (long) GameFileHandler.load("rebelRoundsSinceQuestStarted", rebelRoundsSinceQuestStarted);
		rebelQuestReward = (int) (long) GameFileHandler.load("rebelQuestReward", rebelQuestReward);
		
		SPFResetPrice = (int) (long) GameFileHandler.load("SPFResetPrice", SPFResetPrice);
		SPFCurrentQuest = (int) (long) GameFileHandler.load("SPFCurrentQuest", SPFCurrentQuest);
		SPFQuestAmountRequired = (int) (long) GameFileHandler.load("SPFQuestAmountRequired", SPFQuestAmountRequired);
		SPFRoundsSinceQuestStarted = (int) (long) GameFileHandler.load("SPFRoundsSinceQuestStarted", SPFRoundsSinceQuestStarted);
		SPFQuestReward = (int) (long) GameFileHandler.load("SPFQuestReward", SPFQuestReward);
		
		killMin = (int) (long) GameFileHandler.load("killMin", killMin);
		killMax = (int) (long) GameFileHandler.load("killMax", killMax);
		injureMin = (int) (long) GameFileHandler.load("injureMin", injureMin);
		injureMax = (int) (long) GameFileHandler.load("injureMax", injureMax);
		healMin = (int) (long) GameFileHandler.load("healMin", healMin);
		healMax = (int) (long) GameFileHandler.load("healMax", healMax);
		shootMin = (int) (long) GameFileHandler.load("shootMin", shootMin);
		shootMax = (int) (long) GameFileHandler.load("shootMax", shootMax);
		saveAmmoMin = (int) (long) GameFileHandler.load("saveAmmoMin", saveAmmoMin);
		saveAmmoMax = (int) (long) GameFileHandler.load("saveAmmoMax", saveAmmoMax);
		gainAttackMin = (int) (long) GameFileHandler.load("gainAttackMin", gainAttackMin);
		gainAttackMax = (int) (long) GameFileHandler.load("gainAttackMax", gainAttackMax);
		gainHealthMin = (int) (long) GameFileHandler.load("gainHealthMin", gainHealthMin);
		gainHealthMax = (int) (long) GameFileHandler.load("gainHealthMax", gainHealthMax);
		gainSuspicionMin = (int) (long) GameFileHandler.load("gainSuspicionMin", gainSuspicionMin);
		gainSuspicionMax = (int) (long) GameFileHandler.load("gainSuspicionMax", gainSuspicionMax);
		gainTerritoriesMin = (int) (long) GameFileHandler.load("gainTerritoriesMin", gainTerritoriesMin);
		gainTerritoriesMax = (int) (long) GameFileHandler.load("gainTerritoriesMax", gainTerritoriesMax);
		purchaseAmmoMin = (int) (long) GameFileHandler.load("purchaseAmmoMin", purchaseAmmoMin);
		purchaseAmmoMax = (int) (long) GameFileHandler.load("purchaseAmmoMax", purchaseAmmoMax);
		purchaseVehiclesMin = (int)  (long) GameFileHandler.load("purchaseVehiclesMin", purchaseVehiclesMin);
		purchaseVehiclesMax = (int) (long) GameFileHandler.load("purchaseVehiclesMax", purchaseVehiclesMax);
		purchaseSoldiersMin = (int) (long) GameFileHandler.load("purchaseSoldiersMin", purchaseSoldiersMin);
		purchaseSoldiersMax = (int) (long) GameFileHandler.load("purchaseSoldiersMax", purchaseSoldiersMax);
	}
	
	public static void saveGame() {
		
		GameFileHandler.save("killMin", killMin);
		GameFileHandler.save("killMax", killMax);
		GameFileHandler.save("injureMin", injureMin);
		GameFileHandler.save("injureMax", injureMax);
		GameFileHandler.save("healMin", healMin);
		GameFileHandler.save("healMax", healMax);
		GameFileHandler.save("shootMin", shootMin);
		GameFileHandler.save("shootMax", shootMax);
		GameFileHandler.save("saveAmmoMin", saveAmmoMin);
		GameFileHandler.save("saveAmmoMax", saveAmmoMax);
		GameFileHandler.save("gainAttackMin", gainAttackMin);
		GameFileHandler.save("gainAttackMax", gainAttackMax);
		GameFileHandler.save("gainHealthMin", gainHealthMin);
		GameFileHandler.save("gainHealthMax", gainHealthMax);
		GameFileHandler.save("gainSuspicionMin", gainSuspicionMin);
		GameFileHandler.save("gainSuspicionMax", gainSuspicionMax);
		GameFileHandler.save("gainTerritoriesMin", gainTerritoriesMin);
		GameFileHandler.save("gainTerritoriesMax", gainTerritoriesMax);
		GameFileHandler.save("purchaseAmmoMin", purchaseAmmoMin);
		GameFileHandler.save("purchaseAmmoMax", purchaseAmmoMax);
		GameFileHandler.save("purchaseVehiclesMin", purchaseVehiclesMin);
		GameFileHandler.save("purchaseVehiclesMax", purchaseVehiclesMax);
		GameFileHandler.save("purchaseSoldiersMin", purchaseSoldiersMin);
		GameFileHandler.save("purchaseSoldiersMax", purchaseSoldiersMax);
		
		
		GameFileHandler.save("RebelResetPrice", RebelResetPrice);
		GameFileHandler.save("rebelCurrentQuest", rebelCurrentQuest);
		GameFileHandler.save("rebelQuestAmountRequired", rebelQuestAmountRequired);
		GameFileHandler.save("rebelRoundsSinceQuestStarted", rebelRoundsSinceQuestStarted);
		GameFileHandler.save("rebelQuestReward", rebelQuestReward);
		
		GameFileHandler.save("SPFResetPrice", SPFResetPrice);
		GameFileHandler.save("SPFCurrentQuest", SPFCurrentQuest);
		GameFileHandler.save("SPFQuestAmountRequired", SPFQuestAmountRequired);
		GameFileHandler.save("SPFRoundsSinceQuestStarted", SPFRoundsSinceQuestStarted);
		GameFileHandler.save("SPFQuestReward", SPFQuestReward);
	}
	
	public static boolean isRebelQuestCompleted() {
		switch(rebelCurrentQuest) {
		case 1:
			if (Game.Rebels.getKillCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 2:
			if (Game.Rebels.getInjureCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 3:
			if (Game.Rebels.getHealCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 4:
			if (Game.Rebels.getShootCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 5:
			if (Game.Rebels.getAmmoSaveCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 6:
			if (Game.Rebels.getGainAttackEXP() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 7:
			if (Game.Rebels.getGainHealthEXP() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 8:
			if (Game.Rebels.getGainSuspicionEXP() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 9:
			if (Game.Rebels.getTerritoryGainCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 10:
			if (Game.Rebels.getPurchaseAmmoCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 11:
			if (Game.Rebels.getPurchaseVehiclesCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		case 12:
			if (Game.Rebels.getPurchaseSoldierCount() >= rebelQuestAmountRequired) {
				return true;
			}
			break;
		default:
			break;
		}
		return false;
	}
	
	
	public static boolean isSPFQuestCompleted() {
		switch(SPFCurrentQuest) {
		case 1:
			if (Game.SPF.getKillCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 2:
			if (Game.SPF.getInjureCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 3:
			if (Game.SPF.getHealCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 4:
			if (Game.SPF.getShootCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 5:
			if (Game.SPF.getAmmoSaveCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 6:
			if (Game.SPF.getGainAttackEXP() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 7:
			if (Game.SPF.getGainHealthEXP() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 8:
			if (Game.SPF.getGainSuspicionEXP() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 9:
			if (Game.SPF.getTerritoryGainCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 10:
			if (Game.SPF.getPurchaseAmmoCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 11:
			if (Game.SPF.getPurchaseVehiclesCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		case 12:
			if (Game.SPF.getPurchaseSoldierCount() >= SPFQuestAmountRequired) {
				return true;
			}
			break;
		default:
			break;
		}
		return false;
	}
	
	public static void completeRebelQuest() {
		switch(rebelCurrentQuest) {
		case 1:
			Game.Rebels.setKillCount(0);
			break;
		case 2:
			Game.Rebels.setInjureCount(0);
			break;
		case 3:
			Game.Rebels.setHealCount(0);
			break;
		case 4:
			Game.Rebels.setShootCount(0);
			break;
		case 5:
			Game.Rebels.setAmmoSaveCount(0);
			break;
		case 6:
			Game.Rebels.setGainAttackEXP(0);
			break;
		case 7:
			Game.Rebels.setGainHealthEXP(0);
			break;
		case 8:
			Game.Rebels.setGainSuspicionEXP(0);
			break;
		case 9:
			Game.Rebels.setTerritoryGainCount(0);
			break;
		case 10:
			Game.Rebels.setPurchaseAmmoCount(0);
			break;
		case 11:
			Game.Rebels.setPurchaseVehiclesCount(0);
			break;
		case 12:
			Game.Rebels.setPurchaseSoldierCount(0);
			break;
		default:
			break;
		}
		Game.Rebels.setCoinPurse(Game.Rebels.getCoinPurse() + Math.max(rebelQuestReward, rebelQuestReward * ((10 - rebelRoundsSinceQuestStarted)/10)));
		System.out.println(Main.lineSeparator + "\nRebels earned " + Math.max(rebelQuestReward, rebelQuestReward * ((10 - rebelRoundsSinceQuestStarted)/10)) + "$ for completing their quest!\n" + Main.lineSeparator);
		rebelGetNewQuest();
	}
	
	public static void completeSPFQuest() {
		switch(SPFCurrentQuest) {
		case 1:
			Game.SPF.setKillCount(0);
			break;
		case 2:
			Game.SPF.setInjureCount(0);
			break;
		case 3:
			Game.SPF.setHealCount(0);
			break;
		case 4:
			Game.SPF.setShootCount(0);
			break;
		case 5:
			Game.SPF.setAmmoSaveCount(0);
			break;
		case 6:
			Game.SPF.setGainAttackEXP(0);
			break;
		case 7:
			Game.SPF.setGainHealthEXP(0);
			break;
		case 8:
			Game.SPF.setGainSuspicionEXP(0);
			break;
		case 9:
			Game.SPF.setTerritoryGainCount(0);
			break;
		case 10:
			Game.SPF.setPurchaseAmmoCount(0);
			break;
		case 11:
			Game.SPF.setPurchaseVehiclesCount(0);
			break;
		case 12:
			Game.SPF.setPurchaseSoldierCount(0);
			break;
		default:
			break;
		}
		Game.SPF.setCoinPurse(Game.SPF.getCoinPurse() + Math.max(SPFQuestReward, SPFQuestReward * ((10 - SPFRoundsSinceQuestStarted)/10)));
		System.out.println(Main.lineSeparator + "\nSPF earned " + Math.max(SPFQuestReward, SPFQuestReward * ((10 - SPFRoundsSinceQuestStarted)/10)) + "$ for completing their quest!\n" + Main.lineSeparator);
		SPFGetNewQuest();
	}
	
	/* Quest Details
	 * 01 -> Kill     (02 - 010)  Enemies
	 * 02 -> Injure   (04 - 015)  Enemies
	 * 03 -> Heal     (02 - 004)  Soldiers
	 * 04 -> Shoot    (10 - 050)  times
	 * 05 -> Save     (10 - 050)  Ammo
	 * 06 -> Gain     (10 - 200)  Attack Skill
	 * 07 -> Gain     (10 - 200)  Health Skill
	 * 08 -> Gain     (10 - 200)  Suspicion
	 * 09 -> Gain     (01 - 005)  Territories
	 * 10 -> Purchase (10 - 050)  Ammo
	 * 11 -> Purchase (01 - 002)  Vehicles
	 * 12 -> Purchase (05 - 010)  Soldiers
	 */
	
	public static void rebelOutputCurrentQuestDetails() {
		switch(rebelCurrentQuest) {
		case 1:
			System.out.println("Current Rebel Quest  ->  Kill " + rebelQuestAmountRequired + " Enemies");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getKillCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Kill " + (rebelQuestAmountRequired - Game.Rebels.getKillCount()) + " more enemies to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 2:
			System.out.println("Current Rebel Quest  ->  Injure " + rebelQuestAmountRequired + " Enemies");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getInjureCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Injure " + (rebelQuestAmountRequired - Game.Rebels.getInjureCount()) + " more enemies to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 3:
			System.out.println("Current Rebel Quest  ->  Heal " + rebelQuestAmountRequired + " Injured Soldiers");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getHealCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Heal " + (rebelQuestAmountRequired - Game.Rebels.getHealCount()) + " more injured soldiers to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 4:
			System.out.println("Current Rebel Quest  ->  Shoot " + rebelQuestAmountRequired + " times");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getShootCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Shoot " + (rebelQuestAmountRequired - Game.Rebels.getShootCount()) + " more times to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 5:
			System.out.println("Current Rebel Quest  ->  Save " + rebelQuestAmountRequired + " Ammo");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getAmmoSaveCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Save " + (rebelQuestAmountRequired - Game.Rebels.getAmmoSaveCount()) + " more ammo to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 6:
			System.out.println("Current Rebel Quest  ->  Gain " + rebelQuestAmountRequired + " Attack EXP");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getGainAttackEXP() * 100.0)/ rebelQuestAmountRequired)) + "%  (Gain " + (rebelQuestAmountRequired - Game.Rebels.getGainAttackEXP()) + " more Attack EXP to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 7:
			System.out.println("Current Rebel Quest  ->  Gain " + rebelQuestAmountRequired + " Health EXP");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getGainHealthEXP() * 100.0)/ rebelQuestAmountRequired)) + "%  (Gain " + (rebelQuestAmountRequired - Game.Rebels.getGainHealthEXP()) + " more Health EXP to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 8:
			System.out.println("Current Rebel Quest  ->  Gain " + rebelQuestAmountRequired + " Suspicion EXP");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getGainSuspicionEXP() * 100.0)/ rebelQuestAmountRequired)) + "%  (Gain " + (rebelQuestAmountRequired - Game.Rebels.getGainSuspicionEXP()) + " more Suspicion EXP to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 9:
			System.out.println("Current Rebel Quest  ->  Gain " + rebelQuestAmountRequired + " Territories");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getTerritoryGainCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Gain " + (rebelQuestAmountRequired - Game.Rebels.getTerritoryGainCount()) + " more territories to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 10:
			System.out.println("Current Rebel Quest  ->  Purchase " + rebelQuestAmountRequired + " Ammo");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getPurchaseAmmoCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Purchase " + (rebelQuestAmountRequired - Game.Rebels.getPurchaseAmmoCount()) + " more ammo to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 11:
			System.out.println("Current Rebel Quest  ->  Purchase " + rebelQuestAmountRequired + " Vehicles");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getPurchaseVehiclesCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Purchase " + (rebelQuestAmountRequired - Game.Rebels.getPurchaseVehiclesCount()) + " more vehicles to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		case 12:
			System.out.println("Current Rebel Quest  ->  Purchase " + rebelQuestAmountRequired + " Soldiers");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.Rebels.getPurchaseSoldierCount() * 100.0)/ rebelQuestAmountRequired)) + "%  (Purchase " + (rebelQuestAmountRequired - Game.Rebels.getPurchaseSoldierCount()) + " more soldiers to complete)");
			System.out.println("Time Since  Started  ->  " + rebelRoundsSinceQuestStarted + " Rounds");
			break;
		default:
			break;
		}
	}
	
	public static void SPFOutputCurrentQuestDetails() {
		switch(SPFCurrentQuest) {
		case 1:
			System.out.println("Current  SPF  Quest  ->  Kill " + SPFQuestAmountRequired + " Enemies");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getKillCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Kill " + (SPFQuestAmountRequired - Game.SPF.getKillCount()) + " more enemies to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 2:
			System.out.println("Current  SPF  Quest  ->  Injure " + SPFQuestAmountRequired + " Enemies");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getInjureCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Injure " + (SPFQuestAmountRequired - Game.SPF.getInjureCount()) + " more enemies to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 3:
			System.out.println("Current  SPF  Quest  ->  Heal " + SPFQuestAmountRequired + " Injured Soldiers");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getHealCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Heal " + (SPFQuestAmountRequired - Game.SPF.getHealCount()) + " more injured soldiers to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 4:
			System.out.println("Current  SPF  Quest  ->  Shoot " + SPFQuestAmountRequired + " times");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getShootCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Shoot " + (SPFQuestAmountRequired - Game.SPF.getShootCount()) + " more times to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 5:
			System.out.println("Current  SPF  Quest  ->  Save " + SPFQuestAmountRequired + " Ammo");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getAmmoSaveCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Save " + (SPFQuestAmountRequired - Game.SPF.getAmmoSaveCount()) + " more ammo to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 6:
			System.out.println("Current  SPF  Quest  ->  Gain " + SPFQuestAmountRequired + " Attack EXP");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getGainAttackEXP() * 100.0)/ SPFQuestAmountRequired)) + "%  (Gain " + (SPFQuestAmountRequired - Game.SPF.getGainAttackEXP()) + " more Attack EXP to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 7:
			System.out.println("Current  SPF  Quest  ->  Gain " + SPFQuestAmountRequired + " Health EXP");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getGainHealthEXP() * 100.0)/ SPFQuestAmountRequired)) + "%  (Gain " + (SPFQuestAmountRequired - Game.SPF.getGainHealthEXP()) + " more Health EXP to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 8:
			System.out.println("Current  SPF  Quest  ->  Gain " + SPFQuestAmountRequired + " Suspicion EXP");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getGainSuspicionEXP() * 100.0)/ SPFQuestAmountRequired)) + "%  (Gain " + (SPFQuestAmountRequired - Game.SPF.getGainSuspicionEXP()) + " more Suspicion EXP to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 9:
			System.out.println("Current  SPF  Quest  ->  Gain " + SPFQuestAmountRequired + " Territories");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getTerritoryGainCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Gain " + (SPFQuestAmountRequired - Game.SPF.getTerritoryGainCount()) + " more territories to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 10:
			System.out.println("Current  SPF  Quest  ->  Purchase " + SPFQuestAmountRequired + " Ammo");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getPurchaseAmmoCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Purchase " + (SPFQuestAmountRequired - Game.SPF.getPurchaseAmmoCount()) + " more ammo to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 11:
			System.out.println("Current  SPF  Quest  ->  Purchase " + SPFQuestAmountRequired + " Vehicles");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getPurchaseVehiclesCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Purchase " + (SPFQuestAmountRequired - Game.SPF.getPurchaseVehiclesCount()) + " more vehicles to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		case 12:
			System.out.println("Current  SPF  Quest  ->  Purchase " + SPFQuestAmountRequired + " Soldiers");
			System.out.println("Quest   Progression  ->  " + ((int)((Game.SPF.getPurchaseSoldierCount() * 100.0)/ SPFQuestAmountRequired)) + "%  (Purchase " + (SPFQuestAmountRequired - Game.SPF.getPurchaseSoldierCount()) + " more soldiers to complete)");
			System.out.println("Time Since  Started  ->  " + SPFRoundsSinceQuestStarted + " Rounds");
			break;
		default:
			break;
		}
	}
	
	public static void rebelGetNewQuest() {
		int randomQuest = (int) (Math.random() * totalUniqueQuests + 1);
		int amount = 0;
		switch(randomQuest) {
		case 1:
			amount = (int) (Math.random() * (killMax - killMin) + killMin);
			break;
		case 2:
			amount = (int) (Math.random() * (injureMax - injureMin) + injureMin);
			break;
		case 3:
			amount = (int) (Math.random() * (healMax - healMin) + healMin);
			break;
		case 4:
			amount = (int) (Math.random() * (shootMax - shootMin) + shootMin);
			break;
		case 5:
			amount = (int) (Math.random() * (saveAmmoMax - saveAmmoMin) + saveAmmoMin);
			break;
		case 6:
			amount = (int) (Math.random() * (gainAttackMax - gainAttackMin) + gainAttackMin);
			break;
		case 7:
			amount = (int) (Math.random() * (gainHealthMax - gainHealthMin) + gainHealthMin);
			break;
		case 8:
			amount = (int) (Math.random() * (gainSuspicionMax - gainSuspicionMin) + gainSuspicionMin);
			break;
		case 9:
			amount = (int) (Math.random() * (gainTerritoriesMax - gainTerritoriesMin) + gainTerritoriesMin);
			break;
		case 10:
			amount = (int) (Math.random() * (purchaseAmmoMax - purchaseAmmoMin) + purchaseAmmoMin);
			break;
		case 11:
			amount = (int) (Math.random() * (purchaseVehiclesMax - purchaseVehiclesMin) + purchaseVehiclesMin);
			break;
		case 12:
			amount = (int) (Math.random() * (purchaseSoldiersMax - purchaseSoldiersMin) + purchaseSoldiersMin);
			break;
		default:
			System.out.println("Sorry I don't understand your dumb dumb input!");
			Main.hold();
			break;
		}
		rebelCurrentQuest = randomQuest;
		rebelQuestAmountRequired = amount;
		rebelRoundsSinceQuestStarted = 0;
	}
	
	public static void SPFGetNewQuest() {
		int randomQuest = (int) (Math.random() * totalUniqueQuests + 1);
		int amount = 0;
		switch(randomQuest) {
		case 1:
			amount = (int) (Math.random() * (killMax - killMin) + killMin);
			break;
		case 2:
			amount = (int) (Math.random() * (injureMax - injureMin) + injureMin);
			break;
		case 3:
			amount = (int) (Math.random() * (healMax - healMin) + healMin);
			break;
		case 4:
			amount = (int) (Math.random() * (shootMax - shootMin) + shootMin);
			break;
		case 5:
			amount = (int) (Math.random() * (saveAmmoMax - saveAmmoMin) + saveAmmoMin);
			break;
		case 6:
			amount = (int) (Math.random() * (gainAttackMax - gainAttackMin) + gainAttackMin);
			break;
		case 7:
			amount = (int) (Math.random() * (gainHealthMax - gainHealthMin) + gainHealthMin);
			break;
		case 8:
			amount = (int) (Math.random() * (gainSuspicionMax - gainSuspicionMin) + gainSuspicionMin);
			break;
		case 9:
			amount = (int) (Math.random() * (gainTerritoriesMax - gainTerritoriesMin) + gainTerritoriesMin);
			break;
		case 10:
			amount = (int) (Math.random() * (purchaseAmmoMax - purchaseAmmoMin) + purchaseAmmoMin);
			break;
		case 11:
			amount = (int) (Math.random() * (purchaseVehiclesMax - purchaseVehiclesMin) + purchaseVehiclesMin);
			break;
		case 12:
			amount = (int) (Math.random() * (purchaseSoldiersMax - purchaseSoldiersMin) + purchaseSoldiersMin);
			break;
		default:
			System.out.println("Sorry I don't understand your dumb dumb input!");
			Main.hold();
			break;
		}
		SPFCurrentQuest = randomQuest;
		SPFQuestAmountRequired = amount;
		SPFRoundsSinceQuestStarted = 0;
	}
	
	public static void generateNewQuests() {
		rebelGetNewQuest();
		SPFGetNewQuest();
	}
	

	public static JSONObject getDataFile() {
		return dataFile;
	}

	public static Scanner getConsole() {
		return console;
	}

	public static int getRebelCurrentQuest() {
		return rebelCurrentQuest;
	}

	public static int getRebelRoundsSinceQuestStarted() {
		return rebelRoundsSinceQuestStarted;
	}

	public static int getRebelQuestReward() {
		return rebelQuestReward;
	}

	public static int getSPFCurrentQuest() {
		return SPFCurrentQuest;
	}

	public static int getSPFRoundsSinceQuestStarted() {
		return SPFRoundsSinceQuestStarted;
	}

	public static int getSPFQuestReward() {
		return SPFQuestReward;
	}

	public static void setDataFile(JSONObject dataFile) {
		Quests.dataFile = dataFile;
	}

	public static void setConsole(Scanner console) {
		Quests.console = console;
	}

	public static void setRebelCurrentQuest(int rebelCurrentQuest) {
		Quests.rebelCurrentQuest = rebelCurrentQuest;
	}

	public static void setRebelRoundsSinceQuestStarted(int rebelRoundsSinceQuestStarted) {
		Quests.rebelRoundsSinceQuestStarted = rebelRoundsSinceQuestStarted;
	}

	public static void setRebelQuestReward(int rebelQuestReward) {
		Quests.rebelQuestReward = rebelQuestReward;
	}

	public static void setSPFCurrentQuest(int sPFCurrentQuest) {
		SPFCurrentQuest = sPFCurrentQuest;
	}

	public static void setSPFRoundsSinceQuestStarted(int sPFRoundsSinceQuestStarted) {
		SPFRoundsSinceQuestStarted = sPFRoundsSinceQuestStarted;
	}

	public static void setSPFQuestReward(int sPFQuestReward) {
		SPFQuestReward = sPFQuestReward;
	}

	public static int getRebelQuestAmountRequired() {
		return rebelQuestAmountRequired;
	}

	public static int getSPFQuestAmountRequired() {
		return SPFQuestAmountRequired;
	}

	public static int getKillMin() {
		return killMin;
	}

	public static int getKillMax() {
		return killMax;
	}

	public static int getInjureMin() {
		return injureMin;
	}

	public static int getInjureMax() {
		return injureMax;
	}

	public static int getHealMin() {
		return healMin;
	}

	public static int getHealMax() {
		return healMax;
	}

	public static int getShootMin() {
		return shootMin;
	}

	public static int getShootMax() {
		return shootMax;
	}

	public static int getSaveAmmoMin() {
		return saveAmmoMin;
	}

	public static int getSaveAmmoMax() {
		return saveAmmoMax;
	}

	public static int getGainAttackMin() {
		return gainAttackMin;
	}

	public static int getGainAttackMax() {
		return gainAttackMax;
	}

	public static int getGainHealthMin() {
		return gainHealthMin;
	}

	public static int getGainHealthMax() {
		return gainHealthMax;
	}

	public static int getGainSuspicionMin() {
		return gainSuspicionMin;
	}

	public static int getGainSuspicionMax() {
		return gainSuspicionMax;
	}

	public static int getGainTerritoriesMin() {
		return gainTerritoriesMin;
	}

	public static int getGainTerritoriesMax() {
		return gainTerritoriesMax;
	}

	public static int getPurchaseAmmoMin() {
		return purchaseAmmoMin;
	}

	public static int getPurchaseAmmoMax() {
		return purchaseAmmoMax;
	}

	public static int getPurchaseVehiclesMin() {
		return purchaseVehiclesMin;
	}

	public static int getPurchaseVehiclesMax() {
		return purchaseVehiclesMax;
	}

	public static int getPurchaseSoldiersMin() {
		return purchaseSoldiersMin;
	}

	public static int getPurchaseSoldiersMax() {
		return purchaseSoldiersMax;
	}

	public static int getTotaluniquequests() {
		return totalUniqueQuests;
	}

	public static void setRebelQuestAmountRequired(int rebelQuestAmountRequired) {
		Quests.rebelQuestAmountRequired = rebelQuestAmountRequired;
	}

	public static void setSPFQuestAmountRequired(int sPFQuestAmountRequired) {
		SPFQuestAmountRequired = sPFQuestAmountRequired;
	}

	public static void setKillMin(int killMin) {
		Quests.killMin = killMin;
	}

	public static void setKillMax(int killMax) {
		Quests.killMax = killMax;
	}

	public static void setInjureMin(int injureMin) {
		Quests.injureMin = injureMin;
	}

	public static void setInjureMax(int injureMax) {
		Quests.injureMax = injureMax;
	}

	public static void setHealMin(int healMin) {
		Quests.healMin = healMin;
	}

	public static void setHealMax(int healMax) {
		Quests.healMax = healMax;
	}

	public static void setShootMin(int shootMin) {
		Quests.shootMin = shootMin;
	}

	public static void setShootMax(int shootMax) {
		Quests.shootMax = shootMax;
	}

	public static void setSaveAmmoMin(int saveAmmoMin) {
		Quests.saveAmmoMin = saveAmmoMin;
	}

	public static void setSaveAmmoMax(int saveAmmoMax) {
		Quests.saveAmmoMax = saveAmmoMax;
	}

	public static void setGainAttackMin(int gainAttackMin) {
		Quests.gainAttackMin = gainAttackMin;
	}

	public static void setGainAttackMax(int gainAttackMax) {
		Quests.gainAttackMax = gainAttackMax;
	}

	public static void setGainHealthMin(int gainHealthMin) {
		Quests.gainHealthMin = gainHealthMin;
	}

	public static void setGainHealthMax(int gainHealthMax) {
		Quests.gainHealthMax = gainHealthMax;
	}

	public static void setGainSuspicionMin(int gainSuspicionMin) {
		Quests.gainSuspicionMin = gainSuspicionMin;
	}

	public static void setGainSuspicionMax(int gainSuspicionMax) {
		Quests.gainSuspicionMax = gainSuspicionMax;
	}

	public static void setGainTerritoriesMin(int gainTerritoriesMin) {
		Quests.gainTerritoriesMin = gainTerritoriesMin;
	}

	public static void setGainTerritoriesMax(int gainTerritoriesMax) {
		Quests.gainTerritoriesMax = gainTerritoriesMax;
	}

	public static void setPurchaseAmmoMin(int purchaseAmmoMin) {
		Quests.purchaseAmmoMin = purchaseAmmoMin;
	}

	public static void setPurchaseAmmoMax(int purchaseAmmoMax) {
		Quests.purchaseAmmoMax = purchaseAmmoMax;
	}

	public static void setPurchaseVehiclesMin(int purchaseVehiclesMin) {
		Quests.purchaseVehiclesMin = purchaseVehiclesMin;
	}

	public static void setPurchaseVehiclesMax(int purchaseVehiclesMax) {
		Quests.purchaseVehiclesMax = purchaseVehiclesMax;
	}

	public static void setPurchaseSoldiersMin(int purchaseSoldiersMin) {
		Quests.purchaseSoldiersMin = purchaseSoldiersMin;
	}

	public static void setPurchaseSoldiersMax(int purchaseSoldiersMax) {
		Quests.purchaseSoldiersMax = purchaseSoldiersMax;
	}

	public static int getRebelResetPrice() {
		return RebelResetPrice;
	}

	public static int getSPFResetPrice() {
		return SPFResetPrice;
	}

	public static void setRebelResetPrice(int rebelResetPrice) {
		RebelResetPrice = rebelResetPrice;
	}

	public static void setSPFResetPrice(int sPFResetPrice) {
		SPFResetPrice = sPFResetPrice;
	}
	
}
