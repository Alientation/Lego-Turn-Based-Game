package com.alientation.legogame;

import org.json.simple.JSONObject;

public class Player {
	public static JSONObject dataFile;
	
	private String name;
	
	public static int baseChanceDying = 40;
	
	private double Suspicion, prevSuspicion;
	private double Attack, prevAttack;
	private double Health, prevHealth;
	
	private int coinPurse, prevCoinPurse;
	private int totalTerritories, prevTotalTerritories;
	
	private int amountRifleAmmo, prevAmountRifleAmmo;
	private int amountSniperAmmo, prevAmountSniperAmmo;
	private int amountRPGAmmo, prevAmountRPGAmmo;
	/*
	 * Stats
	 */
	
	private int killCount = 0, injureCount = 0, healCount = 0, shootCount = 0, ammoSaveCount = 0, territoryGainCount = 0, purchaseAmmoCount = 0, purchaseVehiclesCount = 0, purchaseSoldierCount = 0;
	private double gainAttackEXP = 0, gainHealthEXP = 0, gainSuspicionEXP = 0;
	
	public Player(double sus, double att, double hea, int coin, int numTer, int rifleAmmo, int sniperAmmo, int rpgAmmo, String name) {
		this.name = name;
		this.Suspicion = sus;
		this.Attack = att;
		this.Health = hea;
		this.coinPurse = coin;
		this.totalTerritories = numTer;
		this.amountRifleAmmo = rifleAmmo;
		this.amountSniperAmmo = sniperAmmo;
		this.amountRPGAmmo = rpgAmmo;
		
		this.prevSuspicion = sus;
		this.prevAttack = att;
		this.prevHealth = hea;
		this.prevCoinPurse = coin;
		this.prevTotalTerritories = numTer;
		this.prevAmountRifleAmmo = rifleAmmo;
		this.prevAmountSniperAmmo = sniperAmmo;
		this.prevAmountRPGAmmo = rpgAmmo;
	}
	
	public void init(JSONObject jo) {
		dataFile = jo;
		
		Suspicion = (double) GameFileHandler.load(name + "Suspicion", Suspicion);
		Attack = (double) GameFileHandler.load(name + "Attack", Attack);
		Health = (double) GameFileHandler.load(name + "Health", Health);
		coinPurse = (int) (long) GameFileHandler.load(name + "Coins", coinPurse);
		totalTerritories = (int) (long) GameFileHandler.load(name + "Territories", totalTerritories);
		amountRifleAmmo = (int) (long) GameFileHandler.load(name + "RifleAmmo", amountRifleAmmo);
		amountSniperAmmo = (int) (long) GameFileHandler.load(name + "SniperAmmo", amountSniperAmmo);
		amountRPGAmmo = (int) (long) GameFileHandler.load(name + "RPGAmmo", amountRPGAmmo);
		
		
		prevSuspicion = (double) GameFileHandler.load(name + "PrevSuspicion", prevSuspicion);
		prevAttack = (double) GameFileHandler.load(name + "PrevAttack", prevAttack);
		prevHealth = (double) GameFileHandler.load(name + "PrevHealth", prevHealth);
		prevCoinPurse = (int) (long) GameFileHandler.load(name + "PrevCoins", prevCoinPurse);
		prevTotalTerritories = (int) (long) GameFileHandler.load(name + "PrevTerritories", prevTotalTerritories);
		prevAmountRifleAmmo = (int) (long) GameFileHandler.load(name + "PrevRifleAmmo", prevAmountRifleAmmo);
		prevAmountSniperAmmo = (int) (long) GameFileHandler.load(name + "PrevSniperAmmo", prevAmountSniperAmmo);
		prevAmountRPGAmmo = (int) (long) GameFileHandler.load(name + "PrevRPGAmmo", prevAmountRPGAmmo);
		
		
		killCount = (int) (long) GameFileHandler.load(name + "killCount", killCount);
		injureCount = (int) (long) GameFileHandler.load(name + "injureCount", injureCount);
		healCount = (int) (long) GameFileHandler.load(name + "healCount", healCount);
		shootCount = (int) (long) GameFileHandler.load(name + "shootCount", shootCount);
		ammoSaveCount = (int) (long) GameFileHandler.load(name + "ammoSaveCount", ammoSaveCount);
		territoryGainCount = (int) (long) GameFileHandler.load(name + "territoryGainCount", territoryGainCount);
		purchaseAmmoCount = (int) (long) GameFileHandler.load(name + "purchaseAmmoCount", purchaseAmmoCount);
		purchaseVehiclesCount = (int) (long) GameFileHandler.load(name + "purchaseVehiclesCount", purchaseVehiclesCount);
		purchaseSoldierCount = (int) (long) GameFileHandler.load(name + "purchaseSoldierCount", purchaseSoldierCount);
		
		
		gainAttackEXP = (double) GameFileHandler.load(name + "gainAttackEXP", gainAttackEXP);
		gainHealthEXP = (double) GameFileHandler.load(name + "gainHealthEXP", gainHealthEXP);
		gainSuspicionEXP = (double) GameFileHandler.load(name + "gainSuspicionEXP", gainSuspicionEXP);
	}
	
	public void saveGame() {
		
		GameFileHandler.save(name + "Suspicion", Suspicion);
		GameFileHandler.save(name + "Attack", Attack);
		GameFileHandler.save(name + "Health", Health);
		GameFileHandler.save(name + "Coins", coinPurse);
		GameFileHandler.save(name + "Territories", totalTerritories);
		GameFileHandler.save(name + "RifleAmmo", amountRifleAmmo);
		GameFileHandler.save(name + "SniperAmmo", amountSniperAmmo);
		GameFileHandler.save(name + "RPGAmmo", amountRPGAmmo);
		
		
		GameFileHandler.save(name + "PrevSuspicion", prevSuspicion);
		GameFileHandler.save(name + "PrevAttack", prevAttack);
		GameFileHandler.save(name + "PrevHealth", prevHealth);
		GameFileHandler.save(name + "PrevCoins", prevCoinPurse);
		GameFileHandler.save(name + "PrevTerritories", prevTotalTerritories);
		GameFileHandler.save(name + "PrevRifleAmmo", prevAmountRifleAmmo);
		GameFileHandler.save(name + "PrevSniperAmmo", prevAmountSniperAmmo);
		GameFileHandler.save(name + "PrevRPGAmmo", prevAmountRPGAmmo);
		
		
		GameFileHandler.save(name + "killCount", killCount);
		GameFileHandler.save(name + "injureCount", injureCount);
		GameFileHandler.save(name + "healCount", healCount);
		GameFileHandler.save(name + "shootCount", shootCount);
		GameFileHandler.save(name + "ammoSaveCount", ammoSaveCount);
		GameFileHandler.save(name + "territoryGainCount", territoryGainCount);
		GameFileHandler.save(name + "purchaseAmmoCount", purchaseAmmoCount);
		GameFileHandler.save(name + "purchaseVehiclesCount", purchaseVehiclesCount);
		GameFileHandler.save(name + "purchaseSoldierCount", purchaseSoldierCount);
		
		GameFileHandler.save(name + "gainAttackEXP", gainAttackEXP);
		GameFileHandler.save(name + "gainHealthEXP", gainHealthEXP);
		GameFileHandler.save(name + "gainSuspicionEXP", gainSuspicionEXP);
	}
	
	public void roundEnd(int coinPerRound, int coinPerTerritory, double coinMultiplier) {
		if (Suspicion > 0)
			Suspicion -= Math.min(Game.suspicionLostPerRound + Math.sqrt(Suspicion), Suspicion);
		if (Attack > 0)
			Attack -= Math.min(Game.attackLostPerRound + Math.sqrt(Attack) / 2, Attack);
		if (Health > 0)
			Health -= Math.min(Game.healthLostPerRound + Math.sqrt(Health) / 2, Health);
		coinPurse += (int) Math.round((coinPerRound + coinPerTerritory * totalTerritories) * coinMultiplier);
	}
	
	public void refreshData() {
		this.prevSuspicion = this.Suspicion;
		this.prevAttack = this.Attack;
		this.prevHealth = this.Health;
		this.prevCoinPurse = this.coinPurse;
		this.prevTotalTerritories = this.totalTerritories;
		this.prevAmountRifleAmmo = this.amountRifleAmmo;
		this.prevAmountSniperAmmo = this.amountSniperAmmo;
		this.prevAmountRPGAmmo = this.amountRPGAmmo;
	}

	public boolean rollSuspicion() {
		int roll = (int)(Math.random() * 100 + 1);
		if (roll <= Suspicion) {
			return true;
		}
		return false;
	}

	public int gainSuspicion(int numSoldiers, int territoriesFromEnemy) {
		double increase = numSoldiers * (Game.suspicionGainPerAction + Math.max(8 - territoriesFromEnemy, 0));
		if (territoriesFromEnemy == 0) {
			increase = 100 - Suspicion;
		}
		gainSuspicionEXP += increase;
		Suspicion += increase;
		return (int) (increase);
	}
	
	public void gainAttack() {
		gainAttackEXP += Game.attackGainPerShot;
		Attack += Game.attackGainPerShot;
	}
	
	public boolean rollAttackAmmo(int ammo) {
		shootCount++;
		gainAttack();
		int roll = (int)(Math.random() * 100 + 1);
		if (roll <= Attack) {
			ammoSaveCount++;
			return false;
		}
		return true;
	}
	
	public boolean rollAttackWeapon(int weaponType) {
		int baseChance = 0;
		if (weaponType == 0) {
			baseChance = Game.rifleDestroyedChance;
		} else if (weaponType == 1) {
			baseChance = Game.sniperDestroyedChance;
		} else if (weaponType == 2){
			baseChance = Game.rpgDestroyedChance;
		} else {
			baseChance = 0;
		}
		int roll = (int)(Math.random() * 100 + 1);
		if (roll <= baseChance - Attack/20) {
			return true;
		}
		return false;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean rollAttackHit(int ammoChance, int attacker, int target) {
		switch(attacker) {
		case 0:
			if (target >= 10) {
				return false;
			}
			int roll = (int)(Math.random() * 100 + 1);
			if (roll <= Attack/5 + ammoChance) {
				return true;
			}
			break;
		case 1:
			if (target >= 10) {
				return false;
			}
			int r = (int)(Math.random() * 100 + 1);
			if (r <= Attack/5 + ammoChance) {
				return true;
			}
			break;
		default:
			int ro = (int)(Math.random() * 100 + 1);
			if (ro <= Attack/5 + ammoChance) {
					return true;
			}
			break;
		}
		return false;
	}

	public int gainHealth() {
		int roll = (int)(Math.random() * (Game.healthMaxGainPerFood - Game.healthBaseGainPerFood) + Game.healthBaseGainPerFood);
		gainHealthEXP += roll;
		Health += roll;
		return roll;
	}
	/*
	public void rollHealth() {
		int roll = (int)(Math.random() * (Game.healthMaxLostPerHit - Game.healthBaseLostPerHit) + Game.healthBaseLostPerHit);
		Health -= roll;
	}
	*/
	
	public boolean rollHealthKilled(int attacker, int target) {
		// false -> injured | true -> killed
		
		int roll = (int)(Math.random() * 100 + 1);
		if (target < 10 && roll <= baseChanceDying - Health/5) {
			return true;
		} else if (target == 11 && roll <= Game.unarmedVehicleDestroyedChance - Health/5) {
			return true;
		} else if (target == 12 && roll <= Game.armedVehicleDestroyedChance - Health/5) {
			return true;
		} else if (target == 13 && roll <= Game.flightVehicleDestroyedChance - Health/5) {
			return true;
		}
		return false;
	}
	
	public boolean rollHealthHeal() {
		int roll = (int)(Math.random() * 100 + 1);
		if (roll <= 25 + Health / 2) {
			healCount++;
			return true;
		}
		return false;
	}
	
	public void loseHealth() {
		int roll = (int) (Math.random() * (Game.healthMaxLostPerHit - Game.healthBaseLostPerHit) + Game.healthBaseLostPerHit);
		Health -= Math.min(roll,Health);
	}
	
	
	public int getAmountRifleAmmo() { return amountRifleAmmo; }
	public void setAmountRifleAmmo(int amountRifleAmmo) { this.amountRifleAmmo = amountRifleAmmo; }
	public int getAmountSniperAmmo() { return amountSniperAmmo; }
	public void setAmountSniperAmmo(int amountSniperAmmo) { this.amountSniperAmmo = amountSniperAmmo; }
	public int getAmountRPGAmmo() { return amountRPGAmmo; }
	public void setAmountRPGAmmo(int amountRPGAmmo) { this.amountRPGAmmo = amountRPGAmmo; }
	public double getSuspicion() { return ((int)Math.round(Suspicion*10)) / 10.0; }
	public void setSuspicion(double suspicion) { Suspicion = suspicion; }
	public double getAttack() { return ((int)Math.round(Attack*10)) / 10.0; }
	public void setAttack(double attack) { Attack = attack; }
	public double getHealth() { return ((int)Math.round(Health*10)) / 10.0; }
	public void setHealth(double health) { Health = health; }
	public int getCoinPurse() { return coinPurse; }
	public void setCoinPurse(int coinPurse) { this.coinPurse = coinPurse; }
	public int getTotalTerritories() { return totalTerritories; }
	public void setTotalTerritories(int totalTerritories) { this.totalTerritories = totalTerritories; }

	public double getPrevSuspicion() {
		return ((int)Math.round(prevSuspicion*10)) / 10.0;
	}

	public void setPrevSuspicion(double prevSuspicion) {
		this.prevSuspicion = prevSuspicion;
	}

	public double getPrevAttack() {
		return ((int)Math.round(prevAttack*10)) / 10.0;
	}

	public void setPrevAttack(double prevAttack) {
		this.prevAttack = prevAttack;
	}

	public double getPrevHealth() {
		return ((int)Math.round(prevHealth*10)) / 10.0;
	}

	public void setPrevHealth(double prevHealth) {
		this.prevHealth = prevHealth;
	}

	public int getPrevCoinPurse() {
		return prevCoinPurse;
	}

	public void setPrevCoinPurse(int prevCoinPurse) {
		this.prevCoinPurse = prevCoinPurse;
	}

	public int getPrevTotalTerritories() {
		return prevTotalTerritories;
	}

	public void setPrevTotalTerritories(int prevTotalTerritories) {
		this.prevTotalTerritories = prevTotalTerritories;
	}

	public int getPrevAmountRifleAmmo() {
		return prevAmountRifleAmmo;
	}

	public void setPrevAmountRifleAmmo(int prevAmountRifleAmmo) {
		this.prevAmountRifleAmmo = prevAmountRifleAmmo;
	}

	public int getPrevAmountSniperAmmo() {
		return prevAmountSniperAmmo;
	}

	public void setPrevAmountSniperAmmo(int prevAmountSniperAmmo) {
		this.prevAmountSniperAmmo = prevAmountSniperAmmo;
	}

	public int getPrevAmountRPGAmmo() {
		return prevAmountRPGAmmo;
	}

	public void setPrevAmountRPGAmmo(int prevAmountRPGAmmo) {
		this.prevAmountRPGAmmo = prevAmountRPGAmmo;
	}
	
	public String getName() {
		return name;
	}

	public int getKillCount() {
		return killCount;
	}

	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}

	public int getInjureCount() {
		return injureCount;
	}

	public void setInjureCount(int injureCount) {
		this.injureCount = injureCount;
	}

	public int getHealCount() {
		return healCount;
	}

	public void setHealCount(int healCount) {
		this.healCount = healCount;
	}

	public int getShootCount() {
		return shootCount;
	}

	public void setShootCount(int shootCount) {
		this.shootCount = shootCount;
	}

	public int getAmmoSaveCount() {
		return ammoSaveCount;
	}

	public void setAmmoSaveCount(int ammoSaveCount) {
		this.ammoSaveCount = ammoSaveCount;
	}

	public int getTerritoryGainCount() {
		return territoryGainCount;
	}

	public void setTerritoryGainCount(int territoryGainCount) {
		this.territoryGainCount = territoryGainCount;
	}

	public int getPurchaseAmmoCount() {
		return purchaseAmmoCount;
	}

	public void setPurchaseAmmoCount(int purchaseAmmoCount) {
		this.purchaseAmmoCount = purchaseAmmoCount;
	}

	public int getPurchaseVehiclesCount() {
		return purchaseVehiclesCount;
	}

	public void setPurchaseVehiclesCount(int purchaseVehiclesCount) {
		this.purchaseVehiclesCount = purchaseVehiclesCount;
	}

	public int getPurchaseSoldierCount() {
		return purchaseSoldierCount;
	}

	public void setPurchaseSoldierCount(int purchaseSoldierCount) {
		this.purchaseSoldierCount = purchaseSoldierCount;
	}

	public double getGainAttackEXP() {
		return gainAttackEXP;
	}

	public void setGainAttackEXP(double gainAttackEXP) {
		this.gainAttackEXP = gainAttackEXP;
	}

	public double getGainHealthEXP() {
		return gainHealthEXP;
	}

	public void setGainHealthEXP(double gainHealthEXP) {
		this.gainHealthEXP = gainHealthEXP;
	}

	public double getGainSuspicionEXP() {
		return gainSuspicionEXP;
	}

	public void setGainSuspicionEXP(double gainSuspicionEXP) {
		this.gainSuspicionEXP = gainSuspicionEXP;
	}

	public static JSONObject getDataFile() {
		return dataFile;
	}

	public static void setDataFile(JSONObject dataFile) {
		Player.dataFile = dataFile;
	}
}
