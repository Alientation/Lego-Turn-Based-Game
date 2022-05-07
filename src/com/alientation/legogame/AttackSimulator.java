package com.alientation.legogame;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class AttackSimulator {
	public static JSONObject dataFile;
	
	
	public static int rebelAttackChanceReduction = 1;
	public static int SPFAttackChanceReduction = 2;
	
	public static int defenseAttackChanceReduction = 0;
	public static int offenseAttackChanceReduction = 2;
	
	public static int defenseAttackChanceIncrease = 2;
	public static int offenseAttackChanceIncrease = 0;
	
	/*
	 * 2 Modes
	 * Guerrilla and All Out Battle
	 * 
	 * 2 types of armies
	 * 1 - army that can fire (ex not including unarmed vehicles)
	 * 2 - army that can get shot (ex including unarmed vehicles)
	 * 
	 * fix -1 issue
	 */
	
	public static String names[] = {
			"Rifle Soldier",
			"Sniper Soldier",
			"RPG Soldier",
			null,null,null,null,null,null,null,
			"Unarmed Vehicle",
			"Armed Vehicle",
			"Flight Vehicle"
	}; 
	
	
	public static void init(JSONObject jo) {
		dataFile = jo;
		
		rebelAttackChanceReduction = (int) (long) GameFileHandler.load("rebelAttackChanceReduction", rebelAttackChanceReduction);
		SPFAttackChanceReduction = (int) (long) GameFileHandler.load("SPFAttackChanceReduction", SPFAttackChanceReduction);
		defenseAttackChanceReduction = (int) (long) GameFileHandler.load("defenseAttackChanceReduction", defenseAttackChanceReduction);
		offenseAttackChanceReduction = (int) (long) GameFileHandler.load("offenseAttackChanceReduction", offenseAttackChanceReduction);
		defenseAttackChanceIncrease = (int) (long) GameFileHandler.load("defenseAttackChanceIncrease", defenseAttackChanceIncrease);
		offenseAttackChanceIncrease = (int) (long) GameFileHandler.load("offenseAttackChanceIncrease", offenseAttackChanceIncrease);
	}
	
	public static void saveGame() {
		GameFileHandler.save("rebelAttackChanceReduction", rebelAttackChanceReduction);
		GameFileHandler.save("SPFAttackChanceReduction", SPFAttackChanceReduction);
		GameFileHandler.save("defenseAttackChanceReduction", defenseAttackChanceReduction);
		GameFileHandler.save("offenseAttackChanceReduction", offenseAttackChanceReduction);
		GameFileHandler.save("defenseAttackChanceIncrease", defenseAttackChanceIncrease);
		GameFileHandler.save("offenseAttackChanceIncrease", offenseAttackChanceIncrease);
	}
	
	public static int[] createMinAmmo(int ra, int sa, int ea) {
		int[] ammo = {ra, sa, ea};
		return ammo;
	}
	
	
	public static void BeginAttack(Player defense, Player offense, ArrayList<Integer> defenseArmy, ArrayList<Integer> offenseArmy, int defenseAutoSurrender, int offenseAutoSurrender, int maxRounds, int[] defenseMinAmmo, int[] offenseMinAmmo) {
		Game.addBlankLines();
		System.out.println("Commencing Attack\n" + Main.lineSeparator);
		
		ArrayList<Integer> defenseCasualties = new ArrayList<Integer>(); //used for final fire
		ArrayList<Integer> offenseCasualties = new ArrayList<Integer>();
		
		/*
		 * [00] -> number rifle soldiers dead
		 * [01] -> number sniper soldiers dead
		 * [02] -> number rpg soldiers dead
		 * 
		 * [03] -> number rifle soldiers injured
		 * [04] -> number sniper soldiers injured
		 * [05] -> number rpg soldiers injured
		 * 
		 * 
		 * [10] -> number unarmed vehicles destroyed
		 * [11] -> number armed vehicles destroyed
		 * [12] -> number flight vehicles destroyed
		 * 
		 * [13] -> number unarmed vehicles damaged
		 * [14] -> number armed vehicles damaged
		 * [15] -> number flight vehicles damaged
		 * 
		 * 
		 * [20] -> number rifle ammo spent
		 * [21] -> number sniper ammo spent
		 * [22] -> number rpg ammo spent
		 * 
		 * [23] -> number rifle shots
		 * [24] -> number sniper shots
		 * [25] -> number rpg shots
		 * 
		 * [26] -> number rifle shot hits
		 * [27] -> number sniper shot hits
		 * [28] -> number rpg shot hits
		 * 
		 * [30] -> number rifle weapon destroyed
		 * [31] -> number rifle weapon destroyed
		 * [32] -> number rifle weapon destroyed
		 */
		int[] defenseBattleReport = new int[33]; 
		int[] offenseBattleReport = new int[33];
		
		int defenseAttackChanceChange = defenseAttackChanceIncrease - defenseAttackChanceReduction;
		int offenseAttackChanceChange = offenseAttackChanceIncrease - offenseAttackChanceReduction;
		if (defense.getName().equals("SPF")) {
			defenseAttackChanceChange -= SPFAttackChanceReduction;
		} else {
			defenseAttackChanceChange -= rebelAttackChanceReduction;
		}
		
		Player winner = null;
		int rounds = 0;
		while (defenseArmy.size() > defenseAutoSurrender && offenseArmy.size() > offenseAutoSurrender && rounds < maxRounds && checkAmmo(defense, defenseMinAmmo) && checkAmmo(offense, offenseMinAmmo)) {
			for (int i = 0; i < offenseArmy.size() + offenseCasualties.size(); i++) {
				if (offenseArmy.size() <= offenseAutoSurrender || defenseArmy.size() <= defenseAutoSurrender || rounds >= maxRounds || checkAmmo(defense, defenseMinAmmo) == false || checkAmmo(offense, offenseMinAmmo) == false) {
					break;
				}
				int randomAttacker = i;
				int randomDTarget = (int)(Math.random() * defenseArmy.size());
				switch(randomAttacker < offenseArmy.size() ? offenseArmy.get(randomAttacker) : offenseCasualties.get(randomAttacker - offenseArmy.size())) {
				case 0:
					if (offense.getAmountRifleAmmo() <= 0) {
						System.out.println(offense.getName() + " Rifle Soldier ran out of ammo");
					} else {
						offenseBattleReport[23]++;
						if (offense.rollAttackHit(Game.rifleAmmoChance + offenseAttackChanceChange,  0, defenseArmy.get(randomDTarget))) {
							offenseBattleReport[26]++;
							
							if (defense.rollHealthKilled(0, defenseArmy.get(randomDTarget))) {
								defenseBattleReport[defenseArmy.get(randomDTarget)]++;
								System.out.println(offense.getName() + " Rifle Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							} else {
								defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
								System.out.println(offense.getName() + " Rifle Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							}
							defenseCasualties.add(defenseArmy.get(randomDTarget));
							defenseArmy.remove(randomDTarget);
						} else {
							System.out.println(offense.getName() + " Rifle Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						
						if (offense.rollAttackAmmo(0)) {
							offense.setAmountRifleAmmo(offense.getAmountRifleAmmo() - 1);
							offenseBattleReport[20]++;
						}
						
						if (offense.rollAttackWeapon(0) && randomAttacker < offenseArmy.size()) {
							offenseArmy.remove(randomAttacker);
							i--;
							offenseBattleReport[30]++;
						}
					}
					break;
				case 1:
					if (offense.getAmountSniperAmmo() <= 0) {
						System.out.println(offense.getName() + " Sniper Soldier ran out of ammo");
					} else {
						offenseBattleReport[24]++;
						if (offense.rollAttackHit(Game.sniperAmmoChance + offenseAttackChanceChange, 1, defenseArmy.get(randomDTarget))) {
							offenseBattleReport[27]++;
							if (defense.rollHealthKilled(1, defenseArmy.get(randomDTarget))) {
								defenseBattleReport[defenseArmy.get(randomDTarget)]++;
								System.out.println(offense.getName() + " Sniper Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							} else {
								defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
								System.out.println(offense.getName() + " Sniper Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							}
							defenseCasualties.add(defenseArmy.get(randomDTarget));
							defenseArmy.remove(randomDTarget);
						} else {
							System.out.println(offense.getName() + " Sniper Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						
						if (offense.rollAttackAmmo(1)) {
							offense.setAmountSniperAmmo(offense.getAmountSniperAmmo() - 1);
							offenseBattleReport[21]++;
						}
						
						if (offense.rollAttackWeapon(1)  && randomAttacker < offenseArmy.size()) {
							offenseArmy.remove(randomAttacker);
							i--;
							offenseBattleReport[31]++;
						}
					}
					break;
				case 2:
					if (offense.getAmountRPGAmmo() <= 0) {
						System.out.println(offense.getName() + " RPG Soldier ran out of ammo");
					} else {
						offenseBattleReport[25]++;
						if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, 2, defenseArmy.get(randomDTarget))) {
							offenseBattleReport[28]++;
							if (defense.rollHealthKilled(2, defenseArmy.get(randomDTarget))) {
								defenseBattleReport[defenseArmy.get(randomDTarget)]++;
								System.out.println(offense.getName() + " RPG Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							} else {
								defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
								System.out.println(offense.getName() + " RPG Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							}
							defenseCasualties.add(defenseArmy.get(randomDTarget));
							defenseArmy.remove(randomDTarget);
						} else {
							System.out.println(offense.getName() + " RPG Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						
						if (offense.rollAttackAmmo(2)) {
							offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
							offenseBattleReport[22]++;
						}
						
						if (offense.rollAttackWeapon(2) && randomAttacker < offenseArmy.size()) {
							offenseArmy.remove(randomAttacker);
							i--;
							offenseBattleReport[32]++;
						}
					}
					break;
				case 10:
					System.out.println("Unarmed Vehicle did nothing!");
					break;
				case 11:
					if (offense.getAmountRPGAmmo() <= 0) {
						System.out.println(offense.getName() + " Armed Vehicle ran out of ammo");
					} else {
						offenseBattleReport[25]++;
						if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, 11, defenseArmy.get(randomDTarget))) {
							offenseBattleReport[28]++;
							if (defense.rollHealthKilled(11, defenseArmy.get(randomDTarget))) {
								defenseBattleReport[defenseArmy.get(randomDTarget)]++;
								System.out.println(offense.getName() + " Armed Vehicle killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							} else {
								defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
								System.out.println(offense.getName() + " Armed Vehicle injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							}
							defenseCasualties.add(defenseArmy.get(randomDTarget));
							defenseArmy.remove(randomDTarget);
						} else {
							System.out.println(offense.getName() + " Armed Vehicle missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						
						if (offense.rollAttackAmmo(11)) {
							offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
							offenseBattleReport[22]++;
						}
						
						if (offense.rollAttackWeapon(11) && randomAttacker < offenseArmy.size()) {
							offenseArmy.remove(randomAttacker);
							i--;
							offenseBattleReport[32]++;
						}
					}
					break;
				case 12:
					if (offense.getAmountRPGAmmo() <= 0) {
						System.out.println(offense.getName() + " Flight Vehicle ran out of ammo");
					} else {
						offenseBattleReport[25]++;
						if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, 12, defenseArmy.get(randomDTarget))) {
							offenseBattleReport[28]++;
							if (defense.rollHealthKilled(12, defenseArmy.get(randomDTarget))) {
								defenseBattleReport[defenseArmy.get(randomDTarget)]++;
								System.out.println(offense.getName() + " Flight Vehicle killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							} else {
								defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
								System.out.println(offense.getName() + " Flight Vehicle injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
							}
							defenseCasualties.add(defenseArmy.get(randomDTarget));
							defenseArmy.remove(randomDTarget);
						} else {
							System.out.println(offense.getName() + " Flight Vehicle missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						
						if (offense.rollAttackAmmo(12)) {
							offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
							offenseBattleReport[22]++;
						}
						
						if (offense.rollAttackWeapon(12) && randomAttacker < offenseArmy.size()) {
							offenseArmy.remove(randomAttacker);
							i--;
							offenseBattleReport[32]++;
						}
					}
					break;
				default:
					System.out.println("Invalid Soldier fought bravely but too bad its invalid so it doesn't count. Take the L!");
					break;
				}
				rounds++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			offenseCasualties.clear();
			for (int i = 0; i < defenseArmy.size() + defenseCasualties.size(); i++) {
				int randomDefender = i;
				int randomOTarget = (int)(Math.random() * offenseArmy.size());
				switch(i < defenseArmy.size() ? defenseArmy.get(randomDefender) : defenseCasualties.get(i - defenseArmy.size())) {
				case 0:
					if (defense.getAmountRifleAmmo() <= 0) {
						System.out.println(defense.getName() + " Rifle Soldier ran out of ammo");
					} else {
						defenseBattleReport[23]++;
						if (defense.rollAttackHit(Game.rifleAmmoChance + defenseAttackChanceChange,  0, offenseArmy.get(randomOTarget))) {
							defenseBattleReport[26]++;
							if (offense.rollHealthKilled(0, offenseArmy.get(randomOTarget))) {
								offenseBattleReport[offenseArmy.get(randomOTarget)]++;
								System.out.println(defense.getName() + " Rifle Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							} else {
								offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
								System.out.println(defense.getName() + " Rifle Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							}
							offenseCasualties.add(offenseArmy.get(randomOTarget));
							offenseArmy.remove(randomOTarget);
						} else {
							System.out.println(defense.getName() + " Rifle Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						
						if (defense.rollAttackAmmo(0)) {
							defense.setAmountRifleAmmo(defense.getAmountRifleAmmo() - 1);
							defenseBattleReport[20]++;
						}
					
						if (defense.rollAttackWeapon(0) && randomDefender < defenseArmy.size()) {
							defenseArmy.remove(randomDefender);
							i--;
							defenseBattleReport[30]++;
						}
					}
					break;
				case 1:
					if (defense.getAmountSniperAmmo() <= 0) {
						System.out.println(defense.getName() + " Sniper Soldier ran out of ammo");
					} else {
						defenseBattleReport[24]++;
						if (defense.rollAttackHit(Game.sniperAmmoChance + defenseAttackChanceChange, 1, offenseArmy.get(randomOTarget))) {
							defenseBattleReport[27]++;
							if (offense.rollHealthKilled(1, offenseArmy.get(randomOTarget))) {
								offenseBattleReport[offenseArmy.get(randomOTarget)]++;
								System.out.println(defense.getName() + " Sniper Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							} else {
								offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
								System.out.println(defense.getName() + " Sniper Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							}
							offenseCasualties.add(offenseArmy.get(randomOTarget));
							offenseArmy.remove(randomOTarget);
						} else {
							System.out.println(defense.getName() + " Sniper Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						
						if (defense.rollAttackAmmo(1)) {
							defense.setAmountSniperAmmo(defense.getAmountSniperAmmo() - 1);
							defenseBattleReport[21]++;
						}
						
						if (defense.rollAttackWeapon(1) && randomDefender < defenseArmy.size()) {
							defenseArmy.remove(randomDefender);
							i--;
							defenseBattleReport[31]++;
						}
					}
					break;
				case 2:
					if (defense.getAmountRPGAmmo() <= 0) {
						System.out.println(defense.getName() + " RPG Soldier ran out of ammo");
					} else {
						defenseBattleReport[25]++;
						if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, 2, offenseArmy.get(randomOTarget))) {
							defenseBattleReport[28]++;
							if (offense.rollHealthKilled(2, offenseArmy.get(randomOTarget))) {
								offenseBattleReport[offenseArmy.get(randomOTarget)]++;
								System.out.println(defense.getName() + " RPG Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							} else {
								offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
								System.out.println(defense.getName() + " RPG Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							}
							offenseCasualties.add(offenseArmy.get(randomOTarget));
							offenseArmy.remove(randomOTarget);
						} else {
							System.out.println(defense.getName() + " RPG Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						
						if (defense.rollAttackAmmo(2)) {
							defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
							defenseBattleReport[22]++;
						}
						
						if (defense.rollAttackWeapon(2) && randomDefender < defenseArmy.size()) {
							defenseArmy.remove(randomDefender);
							i--;
							defenseBattleReport[32]++;
						}
					}
					break;
				case 10:
					System.out.println("Unarmed Vehicle did nothing!");
					break;
				case 11:
					if (defense.getAmountRPGAmmo() <= 0) {
						System.out.println(defense.getName() + " Armed Vehicle ran out of ammo");
					} else {
						defenseBattleReport[25]++;
						if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, 11, offenseArmy.get(randomOTarget))) {
							defenseBattleReport[28]++;
							if (offense.rollHealthKilled(11, offenseArmy.get(randomOTarget))) {
								offenseBattleReport[offenseArmy.get(randomOTarget)]++;
								System.out.println(defense.getName() + " Armed Vehicle killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							} else {
								offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
								System.out.println(defense.getName() + " Armed Vehicle injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							}
							offenseCasualties.add(offenseArmy.get(randomOTarget));
							offenseArmy.remove(randomOTarget);
						} else {
							System.out.println(defense.getName() + " Armed Vehicle missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						
						if (defense.rollAttackAmmo(11)) {
							defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
							defenseBattleReport[22]++;
						}
						
						if (defense.rollAttackWeapon(11) && randomDefender < defenseArmy.size()) {
							defenseArmy.remove(randomDefender);
							i--;
							defenseBattleReport[32]++;
						}
					}
					break;
				case 12:
					if (defense.getAmountRPGAmmo() <= 0) {
						System.out.println(defense.getName() + " Flight Vehicle ran out of ammo");
					} else {
						defenseBattleReport[25]++;
						if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, 12, offenseArmy.get(randomOTarget))) {
							defenseBattleReport[28]++;
							if (offense.rollHealthKilled(12, offenseArmy.get(randomOTarget))) {
								offenseBattleReport[offenseArmy.get(randomOTarget)]++;
								System.out.println(defense.getName() + " Flight Vehicle killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							} else {
								offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
								System.out.println(defense.getName() + " Flight Vehicle injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
							}
							offenseCasualties.add(offenseArmy.get(randomOTarget));
							offenseArmy.remove(randomOTarget);
						} else {
							System.out.println(defense.getName() + " Flight Vehicle missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						
						if (defense.rollAttackAmmo(12)) {
							defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
							defenseBattleReport[22]++;
						}
					
						if (defense.rollAttackWeapon(12) && randomDefender < defenseArmy.size()) {
							defenseArmy.remove(randomDefender);
							i--;
							defenseBattleReport[32]++;
						}
					}
					break;
				default:
					System.out.println("Invalid Soldier fought bravely but too bad its invalid so it doesn't count. Take the L!");
					break;
				}
				defenseCasualties.clear();
				rounds++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				/*
				 * Offense Team receives attack chance reduction of 10%
				 */
			}
		}
		
		for (int i = 0; i < offenseCasualties.size(); i++) {
			if (defenseArmy.size() == 0 || checkAmmo(defense, defenseMinAmmo) == false || checkAmmo(offense, offenseMinAmmo) == false) {
				break;
			}
			int randomAttacker = i;
			int randomDTarget = (int)(Math.random() * defenseArmy.size());
			switch(offenseCasualties.get(randomAttacker)) {
			case 0:
				if (offense.getAmountRifleAmmo() <= 0) {
					System.out.println(offense.getName() + " Rifle Soldier ran out of ammo");
				} else {
					offenseBattleReport[23]++;
					if (offense.rollAttackHit(Game.rifleAmmoChance + offenseAttackChanceChange,  0, defenseArmy.get(randomDTarget))) {
						offenseBattleReport[26]++;
						
						if (defense.rollHealthKilled(0, defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " Rifle Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " Rifle Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Rifle Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(0)) {
						offense.setAmountRifleAmmo(offense.getAmountRifleAmmo() - 1);
						offenseBattleReport[20]++;
					}
				}
				break;
			case 1:
				if (offense.getAmountSniperAmmo() <= 0) {
					System.out.println(offense.getName() + " Sniper Soldier ran out of ammo");
				} else {
					offenseBattleReport[24]++;
					if (offense.rollAttackHit(Game.sniperAmmoChance + offenseAttackChanceChange, 1, defenseArmy.get(randomDTarget))) {
						offenseBattleReport[27]++;
						if (defense.rollHealthKilled(1, defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " Sniper Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " Sniper Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Sniper Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(1)) {
						offense.setAmountSniperAmmo(offense.getAmountSniperAmmo() - 1);
						offenseBattleReport[21]++;
					}
				}
				break;
			case 2:
				if (offense.getAmountRPGAmmo() <= 0) {
					System.out.println(offense.getName() + " RPG Soldier ran out of ammo");
				} else {
					offenseBattleReport[25]++;
					if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, 2, defenseArmy.get(randomDTarget))) {
						offenseBattleReport[28]++;
						if (defense.rollHealthKilled(2, defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " RPG Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " RPG Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " RPG Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(2)) {
						offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
						offenseBattleReport[22]++;
					}
				}
				break;
			case 10:
				System.out.println("Unarmed Vehicle did nothing!");
				break;
			case 11:
				if (offense.getAmountRPGAmmo() <= 0) {
					System.out.println(offense.getName() + " Armed Vehicle ran out of ammo");
				} else {
					offenseBattleReport[25]++;
					if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, 11, defenseArmy.get(randomDTarget))) {
						offenseBattleReport[28]++;
						if (defense.rollHealthKilled(11, defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " Armed Vehicle killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " Armed Vehicle injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Armed Vehicle missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(11)) {
						offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
						offenseBattleReport[22]++;
					}
				}
				break;
			case 12:
				if (offense.getAmountRPGAmmo() <= 0) {
					System.out.println(offense.getName() + " Flight Vehicle ran out of ammo");
				} else {
					offenseBattleReport[25]++;
					if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, 12, defenseArmy.get(randomDTarget))) {
						offenseBattleReport[28]++;
						if (defense.rollHealthKilled(12, defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " Flight Vehicle killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " Flight Vehicle injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Flight Vehicle missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(12)) {
						offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
						offenseBattleReport[22]++;
					}
				}
				break;
			default:
				System.out.println("Invalid Soldier fought bravely but too bad its invalid so it doesn't count. Take the L!");
				break;
			}
			rounds++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < defenseCasualties.size(); i++) {
			if (offenseArmy.size() == 0 || checkAmmo(defense, defenseMinAmmo) == false || checkAmmo(offense, offenseMinAmmo) == false) {
				break;
			}
			int randomOTarget = (int)(Math.random() * offenseArmy.size());
			switch(defenseCasualties.get(i)) {
			case 0:
				if (defense.getAmountRifleAmmo() <= 0) {
					System.out.println(defense.getName() + " Rifle Soldier ran out of ammo");
				} else {
					defenseBattleReport[23]++;
					if (defense.rollAttackHit(Game.rifleAmmoChance + defenseAttackChanceChange,  0, offenseArmy.get(randomOTarget))) {
						defenseBattleReport[26]++;
						if (offense.rollHealthKilled(0, offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Rifle Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Rifle Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Rifle Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(0)) {
						defense.setAmountRifleAmmo(defense.getAmountRifleAmmo() - 1);
						defenseBattleReport[20]++;
					}
				}
				break;
			case 1:
				if (defense.getAmountSniperAmmo() <= 0) {
					System.out.println(defense.getName() + " Sniper Soldier ran out of ammo");
				} else {
					defenseBattleReport[24]++;
					if (defense.rollAttackHit(Game.sniperAmmoChance + defenseAttackChanceChange, 1, offenseArmy.get(randomOTarget))) {
						defenseBattleReport[27]++;
						if (offense.rollHealthKilled(1, offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Sniper Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Sniper Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Sniper Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(1)) {
						defense.setAmountSniperAmmo(defense.getAmountSniperAmmo() - 1);
						defenseBattleReport[21]++;
					}
				}
				break;
			case 2:
				if (defense.getAmountRPGAmmo() <= 0) {
					System.out.println(defense.getName() + " RPG Soldier ran out of ammo");
				} else {
					defenseBattleReport[25]++;
					if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, 2, offenseArmy.get(randomOTarget))) {
						defenseBattleReport[28]++;
						if (offense.rollHealthKilled(2, offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " RPG Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " RPG Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " RPG Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(2)) {
						defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
						defenseBattleReport[22]++;
					}
				}
				break;
			case 10:
				System.out.println("Unarmed Vehicle did nothing!");
				break;
			case 11:
				if (defense.getAmountRPGAmmo() <= 0) {
					System.out.println(defense.getName() + " Armed Vehicle ran out of ammo");
				} else {
					defenseBattleReport[25]++;
					if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, 11, offenseArmy.get(randomOTarget))) {
						defenseBattleReport[28]++;
						if (offense.rollHealthKilled(11, offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Armed Vehicle killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Armed Vehicle injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Armed Vehicle missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(11)) {
						defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
						defenseBattleReport[22]++;
					}
				}
				break;
			case 12:
				if (defense.getAmountRPGAmmo() <= 0) {
					System.out.println(defense.getName() + " Flight Vehicle ran out of ammo");
				} else {
					defenseBattleReport[25]++;
					if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, 12, offenseArmy.get(randomOTarget))) {
						defenseBattleReport[28]++;
						if (offense.rollHealthKilled(12, offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Flight Vehicle killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Flight Vehicle injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Flight Vehicle missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(12)) {
						defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
						defenseBattleReport[22]++;
					}
				}
				break;
			default:
				System.out.println("Invalid Soldier fought bravely but too bad its invalid so it doesn't count. Take the L!");
				break;
			}
			rounds++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (defenseArmy.size() <= defenseAutoSurrender || !checkAmmo(defense, defenseMinAmmo)) {
			winner = offense;
		}
		if (offenseArmy.size() <= offenseAutoSurrender || !checkAmmo(offense, offenseMinAmmo)) {
			if (winner != null) {
				winner = null;
			} else {
				winner = defense;
			}
		}
		System.out.println(Main.lineSeparator + "\nBattle Report\t-\t\t(Defender) " + defense.getName() + " vs (Attacker) " + offense.getName() +"\n" + Main.lineSeparator);
		if (winner == null)
			System.out.println("\t\tTied Battle!");
		else
			System.out.println("\t\t" + winner.getName() + " won the Battle!");
		System.out.println(Main.lineSeparator + "\n(Defender Summary) " + defense.getName() + "\n" + Main.lineSeparator);
		System.out.println("Number Rifle Soldiers  Dead -> " + defenseBattleReport[0] +"\t\tNumber Rifle Soldiers  Injured -> " + defenseBattleReport[3] +"\t\tNumber Rifle  Ammo Shot/Spent/Hit -> " + defenseBattleReport[23] + "/" + defenseBattleReport[20] + "/" + defenseBattleReport[26]);
		System.out.println("Number Sniper Soldiers Dead -> " + defenseBattleReport[1] +"\t\tNumber Sniper Soldiers Injured -> " + defenseBattleReport[4] +"\t\tNumber Sniper Ammo Shot/Spent/Hit -> " + defenseBattleReport[24] + "/" + defenseBattleReport[21] + "/" + defenseBattleReport[27]);
		System.out.println("Number  RPG  Soldiers  Dead -> " + defenseBattleReport[2] +"\t\tNumber  RPG  Soldiers  Injured -> " + defenseBattleReport[5] +"\t\tNumber  RPG  Ammo  Shot/Spent/Hit -> " + defenseBattleReport[25] + "/" + defenseBattleReport[22] + "/" + defenseBattleReport[28]);
		
		System.out.println("Number Unarmed Vehicles Destroyed -> " + defenseBattleReport[10] +"\t\tNumber Unarmed Vehicles Damaged -> " + defenseBattleReport[13]);
		System.out.println("Number  Armed Vehicles  Destroyed -> " + defenseBattleReport[11] +"\t\tNumber Armed  Vehicles  Damaged -> " + defenseBattleReport[14]);
		System.out.println("Number  Flight Vehicles Destroyed -> " + defenseBattleReport[12] +"\t\tNumber Flight  Vehicles Damaged -> " + defenseBattleReport[15]);
		
		System.out.println(Main.lineSeparator +"\nStats\n" + Main.lineSeparator);
		System.out.println("Number Saved Ammo -> " + (defenseBattleReport[23]+defenseBattleReport[24]+defenseBattleReport[25] - (defenseBattleReport[20]+defenseBattleReport[21]+defenseBattleReport[22])) +"\t\tShot Accuracy Rate -> " + (100 * ((double)defenseBattleReport[26]+defenseBattleReport[27]+defenseBattleReport[28])/(defenseBattleReport[23]+defenseBattleReport[24]+defenseBattleReport[25]+defenseBattleReport[26]+defenseBattleReport[27]+defenseBattleReport[28])) + "%");
		System.out.println("Number Rifle Weapons Destroyed -> " + defenseBattleReport[30]);
		System.out.println("Number Sniper Weapons Destroyed -> " + defenseBattleReport[31]);
		System.out.println("Number RPG Weapons Destroyed -> " + defenseBattleReport[32]);
		System.out.println(Main.lineSeparator + "\n\n");
		
		
		System.out.println(Main.lineSeparator + "\n(Attacker Summary) " + offense.getName() + "\n" + Main.lineSeparator);
		System.out.println("Number Rifle Soldiers  Dead -> " + offenseBattleReport[0] +"\t\tNumber Rifle Soldiers  Injured -> " + offenseBattleReport[3] +"\t\tNumber Rifle  Ammo Shot/Spent/Hit -> " + offenseBattleReport[23] + "/" + offenseBattleReport[20] + "/" + offenseBattleReport[26]);
		System.out.println("Number Sniper Soldiers Dead -> " + offenseBattleReport[1] +"\t\tNumber Sniper Soldiers Injured -> " + offenseBattleReport[4] +"\t\tNumber Sniper Ammo Shot/Spent/Hit -> " + offenseBattleReport[24] + "/" + offenseBattleReport[21] + "/" + offenseBattleReport[27]);
		System.out.println("Number  RPG  Soldiers  Dead -> " + offenseBattleReport[2] +"\t\tNumber  RPG  Soldiers  Injured -> " + offenseBattleReport[5] +"\t\tNumber  RPG  Ammo  Shot/Spent/Hit -> " + offenseBattleReport[25] + "/" + offenseBattleReport[22] + "/" + offenseBattleReport[28]);
		
		System.out.println("Number Unarmed Vehicles Destroyed -> " + offenseBattleReport[10] +"\t\tNumber Unarmed Vehicles Damaged -> " + offenseBattleReport[13]);
		System.out.println("Number  Armed Vehicles  Destroyed -> " + offenseBattleReport[11] +"\t\tNumber Armed  Vehicles  Damaged -> " + offenseBattleReport[14]);
		System.out.println("Number  Flight Vehicles Destroyed -> " + offenseBattleReport[12] +"\t\tNumber Flight  Vehicles Damaged -> " + offenseBattleReport[15]);
		
		System.out.println(Main.lineSeparator +"\nStats\n" + Main.lineSeparator);
		System.out.println("Number Saved Ammo -> " + (offenseBattleReport[23]+offenseBattleReport[24]+offenseBattleReport[25] - (offenseBattleReport[20]+offenseBattleReport[21]+offenseBattleReport[22])) +"\t\tShot Accuracy Rate -> " + (100 * ((double)offenseBattleReport[26]+offenseBattleReport[27]+offenseBattleReport[28])/(offenseBattleReport[23]+offenseBattleReport[24]+offenseBattleReport[25]+offenseBattleReport[26]+offenseBattleReport[27]+offenseBattleReport[28])) + "%");
		System.out.println("Number Rifle Weapons Destroyed -> " + offenseBattleReport[30]);
		System.out.println("Number Sniper Weapons Destroyed -> " + offenseBattleReport[31]);
		System.out.println("Number RPG Weapons Destroyed -> " + offenseBattleReport[32]);
		System.out.println(Main.lineSeparator);
		
		
		defense.setKillCount(defense.getKillCount() + offenseBattleReport[0] + offenseBattleReport[1] + offenseBattleReport[2]);
		defense.setInjureCount(defense.getInjureCount() + offenseBattleReport[3] + offenseBattleReport[4] + offenseBattleReport[5]);
		
		offense.setKillCount(offense.getKillCount() + defenseBattleReport[0] + defenseBattleReport[1] + defenseBattleReport[2]);
		offense.setInjureCount(offense.getInjureCount() + defenseBattleReport[3] + defenseBattleReport[4] + defenseBattleReport[5]);
		
		Main.hold();
	}
	
	
	
	public static void savedBeginAttack(Player defense, Player offense, ArrayList<Integer> defenseArmy, ArrayList<Integer> offenseArmy, int defenseAutoSurrender, int offenseAutoSurrender, int maxRounds, int[] defenseMinAmmo, int[] offenseMinAmmo) {
		Game.addBlankLines();
		System.out.println("Commencing Attack\n" + Main.lineSeparator);
		/*
		 * [00] -> number rifle soldiers dead
		 * [01] -> number sniper soldiers dead
		 * [02] -> number rpg soldiers dead
		 * 
		 * [03] -> number rifle soldiers injured
		 * [04] -> number sniper soldiers injured
		 * [05] -> number rpg soldiers injured
		 * 
		 * 
		 * [10] -> number unarmed vehicles destroyed
		 * [11] -> number armed vehicles destroyed
		 * [12] -> number flight vehicles destroyed
		 * 
		 * [13] -> number unarmed vehicles damaged
		 * [14] -> number armed vehicles damaged
		 * [15] -> number flight vehicles damaged
		 * 
		 * 
		 * [20] -> number rifle ammo spent
		 * [21] -> number sniper ammo spent
		 * [22] -> number rpg ammo spent
		 * 
		 * [23] -> number rifle shots
		 * [24] -> number sniper shots
		 * [25] -> number rpg shots
		 * 
		 * [26] -> number rifle shot hits
		 * [27] -> number sniper shot hits
		 * [28] -> number rpg shot hits
		 * 
		 * [30] -> number rifle weapon destroyed
		 * [31] -> number rifle weapon destroyed
		 * [32] -> number rifle weapon destroyed
		 */
		int[] defenseBattleReport = new int[33]; 
		int[] offenseBattleReport = new int[33];
		
		int defenseAttackChanceChange = defenseAttackChanceIncrease - defenseAttackChanceReduction;
		int offenseAttackChanceChange = offenseAttackChanceIncrease - offenseAttackChanceReduction;
		if (defense.getName().equals("SPF")) {
			defenseAttackChanceChange -= SPFAttackChanceReduction;
		} else {
			defenseAttackChanceChange -= rebelAttackChanceReduction;
		}
		
		Player winner = null;
		int rounds = 0;
		while (defenseArmy.size() > defenseAutoSurrender && offenseArmy.size() > offenseAutoSurrender && rounds < maxRounds && checkAmmo(defense, defenseMinAmmo) && checkAmmo(offense, offenseMinAmmo)) {
			int randomDefender = (int)(Math.random() * defenseArmy.size());
			int randomOTarget = (int)(Math.random() * offenseArmy.size());
			switch(defenseArmy.get(randomDefender)) {
			case 0:
				if (defense.getAmountRifleAmmo() <= 0) {
					System.out.println(defense.getName() + " Rifle Soldier ran out of ammo");
				} else {
					defenseBattleReport[23]++;
					if (defense.rollAttackHit(Game.rifleAmmoChance + defenseAttackChanceChange,  defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
						defenseBattleReport[26]++;
						if (offense.rollHealthKilled(defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Rifle Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Rifle Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Rifle Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(defenseArmy.get(randomDefender))) {
						defense.setAmountRifleAmmo(defense.getAmountRifleAmmo() - 1);
						defenseBattleReport[20]++;
					}
					
					if (defense.rollAttackWeapon(defenseArmy.get(randomDefender))) {
						defenseArmy.remove(randomDefender);
						defenseBattleReport[30]++;
					}
				}
				break;
			case 1:
				if (defense.getAmountSniperAmmo() <= 0) {
					System.out.println(defense.getName() + " Sniper Soldier ran out of ammo");
				} else {
					defenseBattleReport[24]++;
					if (defense.rollAttackHit(Game.sniperAmmoChance + defenseAttackChanceChange, defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
						defenseBattleReport[27]++;
						if (offense.rollHealthKilled(defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Sniper Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Sniper Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Sniper Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(defenseArmy.get(randomDefender))) {
						defense.setAmountSniperAmmo(defense.getAmountSniperAmmo() - 1);
						defenseBattleReport[21]++;
					}
					
					if (defense.rollAttackWeapon(defenseArmy.get(randomDefender))) {
						defenseArmy.remove(randomDefender);
						defenseBattleReport[31]++;
					}
				}
				break;
			case 2:
				if (defense.getAmountRPGAmmo() <= 0) {
					System.out.println(defense.getName() + " RPG Soldier ran out of ammo");
				} else {
					defenseBattleReport[25]++;
					if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
						defenseBattleReport[28]++;
						if (offense.rollHealthKilled(defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " RPG Soldier killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " RPG Soldier injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " RPG Soldier missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(defenseArmy.get(randomDefender))) {
						defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
						defenseBattleReport[22]++;
					}
					
					if (defense.rollAttackWeapon(defenseArmy.get(randomDefender))) {
						defenseArmy.remove(randomDefender);
						defenseBattleReport[32]++;
					}
				}
				break;
			case 10:
				System.out.println("Unarmed Vehicle did nothing!");
				break;
			case 11:
				if (defense.getAmountRPGAmmo() <= 0) {
					System.out.println(defense.getName() + " Armed Vehicle ran out of ammo");
				} else {
					defenseBattleReport[25]++;
					if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
						defenseBattleReport[28]++;
						if (offense.rollHealthKilled(defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Armed Vehicle killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Armed Vehicle injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Armed Vehicle missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(defenseArmy.get(randomDefender))) {
						defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
						defenseBattleReport[22]++;
					}
					
					if (defense.rollAttackWeapon(defenseArmy.get(randomDefender))) {
						defenseArmy.remove(randomDefender);
						defenseBattleReport[32]++;
					}
				}
				break;
			case 12:
				if (defense.getAmountRPGAmmo() <= 0) {
					System.out.println(defense.getName() + " Flight Vehicle ran out of ammo");
				} else {
					defenseBattleReport[25]++;
					if (defense.rollAttackHit(Game.rpgAmmoChance + defenseAttackChanceChange, defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
						defenseBattleReport[28]++;
						if (offense.rollHealthKilled(defenseArmy.get(randomDefender), offenseArmy.get(randomOTarget))) {
							offenseBattleReport[offenseArmy.get(randomOTarget)]++;
							System.out.println(defense.getName() + " Flight Vehicle killed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						} else {
							offenseBattleReport[offenseArmy.get(randomOTarget) + 3]++;
							System.out.println(defense.getName() + " Flight Vehicle injured his target (" + names[offenseArmy.get(randomOTarget)] + ")");
						}
						offenseArmy.remove(randomOTarget);
					} else {
						System.out.println(defense.getName() + " Flight Vehicle missed his target (" + names[offenseArmy.get(randomOTarget)] + ")");
					}
					
					if (defense.rollAttackAmmo(defenseArmy.get(randomDefender))) {
						defense.setAmountRPGAmmo(defense.getAmountRPGAmmo() - 1);
						defenseBattleReport[22]++;
					}
					
					if (defense.rollAttackWeapon(defenseArmy.get(randomDefender))) {
						defenseArmy.remove(randomDefender);
						defenseBattleReport[32]++;
					}
				}
				break;
			default:
				System.out.println("Invalid Soldier fought bravely but too bad its invalid so it doesn't count. Take the L!");
				break;
			}
			
			rounds++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			/*
			 * Offense Team receives attack chance reduction of 10%
			 */
			
			if (offenseArmy.size() <= offenseAutoSurrender || defenseArmy.size() <= defenseAutoSurrender || rounds >= maxRounds || checkAmmo(defense, defenseMinAmmo) == false || checkAmmo(offense, offenseMinAmmo) == false) {
				break;
			}
			int randomAttacker = (int)(Math.random() * offenseArmy.size());
			int randomDTarget = (int)(Math.random() * defenseArmy.size());
			switch(offenseArmy.get(randomAttacker)) {
			case 0:
				if (offense.getAmountRifleAmmo() <= 0) {
					System.out.println(offense.getName() + " Rifle Soldier ran out of ammo");
				} else {
					offenseBattleReport[23]++;
					if (offense.rollAttackHit(Game.rifleAmmoChance + offenseAttackChanceChange,  offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
						offenseBattleReport[26]++;
						if (defense.rollHealthKilled(offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " Rifle Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " Rifle Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Rifle Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(offenseArmy.get(randomAttacker))) {
						offense.setAmountRifleAmmo(offense.getAmountRifleAmmo() - 1);
						offenseBattleReport[20]++;
					}
					
					if (offense.rollAttackWeapon(offenseArmy.get(randomAttacker))) {
						offenseArmy.remove(randomAttacker);
						offenseBattleReport[30]++;
					}
				}
				break;
			case 1:
				if (offense.getAmountSniperAmmo() <= 0) {
					System.out.println(offense.getName() + " Sniper Soldier ran out of ammo");
				} else {
					offenseBattleReport[24]++;
					if (offense.rollAttackHit(Game.sniperAmmoChance + offenseAttackChanceChange, offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
						offenseBattleReport[27]++;
						if (defense.rollHealthKilled(offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(defense.getName() + " Sniper Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(defense.getName() + " Sniper Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Sniper Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(offenseArmy.get(randomAttacker))) {
						offense.setAmountSniperAmmo(offense.getAmountSniperAmmo() - 1);
						offenseBattleReport[21]++;
					}
					
					if (offense.rollAttackWeapon(offenseArmy.get(randomAttacker))) {
						offenseArmy.remove(randomAttacker);
						offenseBattleReport[31]++;
					}
				}
				break;
			case 2:
				if (offense.getAmountRPGAmmo() <= 0) {
					System.out.println(offense.getName() + " RPG Soldier ran out of ammo");
				} else {
					offenseBattleReport[25]++;
					if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
						offenseBattleReport[28]++;
						if (defense.rollHealthKilled(offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " RPG Soldier killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " RPG Soldier injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " RPG Soldier missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(offenseArmy.get(randomAttacker))) {
						offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
						offenseBattleReport[22]++;
					}
					
					if (offense.rollAttackWeapon(offenseArmy.get(randomAttacker))) {
						offenseArmy.remove(randomAttacker);
						offenseBattleReport[32]++;
					}
				}
				break;
			case 10:
				System.out.println("Unarmed Vehicle did nothing!");
				break;
			case 11:
				if (offense.getAmountRPGAmmo() <= 0) {
					System.out.println(offense.getName() + " Armed Vehicle ran out of ammo");
				} else {
					offenseBattleReport[25]++;
					if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
						offenseBattleReport[28]++;
						if (defense.rollHealthKilled(offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " Armed Vehicle killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " Armed Vehicle injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Armed Vehicle missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(offenseArmy.get(randomAttacker))) {
						offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
						offenseBattleReport[22]++;
					}
					
					if (offense.rollAttackWeapon(offenseArmy.get(randomAttacker))) {
						offenseArmy.remove(randomAttacker);
						offenseBattleReport[32]++;
					}
				}
				break;
			case 12:
				if (offense.getAmountRPGAmmo() <= 0) {
					System.out.println(offense.getName() + " Flight Vehicle ran out of ammo");
				} else {
					offenseBattleReport[25]++;
					if (offense.rollAttackHit(Game.rpgAmmoChance + offenseAttackChanceChange, offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
						offenseBattleReport[28]++;
						if (defense.rollHealthKilled(offenseArmy.get(randomAttacker), defenseArmy.get(randomDTarget))) {
							defenseBattleReport[defenseArmy.get(randomDTarget)]++;
							System.out.println(offense.getName() + " Flight Vehicle killed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						} else {
							defenseBattleReport[defenseArmy.get(randomDTarget) + 3]++;
							System.out.println(offense.getName() + " Flight Vehicle injured his target (" + names[defenseArmy.get(randomDTarget)] + ")");
						}
						defenseArmy.remove(randomDTarget);
					} else {
						System.out.println(offense.getName() + " Flight Vehicle missed his target (" + names[defenseArmy.get(randomDTarget)] + ")");
					}
					
					if (offense.rollAttackAmmo(offenseArmy.get(randomAttacker))) {
						offense.setAmountRPGAmmo(offense.getAmountRPGAmmo() - 1);
						offenseBattleReport[22]++;
					}
					
					if (offense.rollAttackWeapon(offenseArmy.get(randomAttacker))) {
						offenseArmy.remove(randomAttacker);
						offenseBattleReport[32]++;
					}
				}
				break;
			default:
				System.out.println("Invalid Soldier fought bravely but too bad its invalid so it doesn't count. Take the L!");
				break;
			}
			rounds++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (defenseArmy.size() <= defenseAutoSurrender || !checkAmmo(defense, defenseMinAmmo)) {
			winner = offense;
		}
		if (offenseArmy.size() <= offenseAutoSurrender || !checkAmmo(offense, offenseMinAmmo)) {
			if (winner != null) {
				winner = null;
			} else {
				winner = defense;
			}
		}
		System.out.println(Main.lineSeparator + "\nBattle Report\t-\t\t(Defender) " + defense.getName() + " vs (Attacker) " + offense.getName() +"\n" + Main.lineSeparator);
		if (winner == null)
			System.out.println("\t\tTied Battle!");
		else
			System.out.println("\t\t" + winner.getName() + " won the Battle!");
		System.out.println(Main.lineSeparator + "\n(Defender Summary) " + defense.getName() + "\n" + Main.lineSeparator);
		System.out.println("Number Rifle Soldiers  Dead -> " + defenseBattleReport[0] +"\t\tNumber Rifle Soldiers  Injured -> " + defenseBattleReport[3] +"\t\tNumber Rifle  Ammo Shot/Spent/Hit -> " + defenseBattleReport[23] + "/" + defenseBattleReport[20] + "/" + defenseBattleReport[26]);
		System.out.println("Number Sniper Soldiers Dead -> " + defenseBattleReport[1] +"\t\tNumber Sniper Soldiers Injured -> " + defenseBattleReport[4] +"\t\tNumber Sniper Ammo Shot/Spent/Hit -> " + defenseBattleReport[24] + "/" + defenseBattleReport[21] + "/" + defenseBattleReport[27]);
		System.out.println("Number  RPG  Soldiers  Dead -> " + defenseBattleReport[2] +"\t\tNumber  RPG  Soldiers  Injured -> " + defenseBattleReport[5] +"\t\tNumber  RPG  Ammo  Shot/Spent/Hit -> " + defenseBattleReport[25] + "/" + defenseBattleReport[22] + "/" + defenseBattleReport[28]);
		
		System.out.println("Number Unarmed Vehicles Destroyed -> " + defenseBattleReport[10] +"\t\tNumber Unarmed Vehicles Damaged -> " + defenseBattleReport[13]);
		System.out.println("Number  Armed Vehicles  Destroyed -> " + defenseBattleReport[11] +"\t\tNumber Armed  Vehicles  Damaged -> " + defenseBattleReport[14]);
		System.out.println("Number  Flight Vehicles Destroyed -> " + defenseBattleReport[12] +"\t\tNumber Flight  Vehicles Damaged -> " + defenseBattleReport[15]);
		
		System.out.println(Main.lineSeparator +"\nStats\n" + Main.lineSeparator);
		System.out.println("Number Saved Ammo -> " + (defenseBattleReport[23]+defenseBattleReport[24]+defenseBattleReport[25] - (defenseBattleReport[20]+defenseBattleReport[21]+defenseBattleReport[22])) +"\t\tShot Accuracy Rate -> " + (100 * ((double)defenseBattleReport[26]+defenseBattleReport[27]+defenseBattleReport[28])/(defenseBattleReport[23]+defenseBattleReport[24]+defenseBattleReport[25]+defenseBattleReport[26]+defenseBattleReport[27]+defenseBattleReport[28])) + "%");
		System.out.println("Number Rifle Weapons Destroyed -> " + defenseBattleReport[30]);
		System.out.println("Number Sniper Weapons Destroyed -> " + defenseBattleReport[31]);
		System.out.println("Number RPG Weapons Destroyed -> " + defenseBattleReport[32]);
		System.out.println(Main.lineSeparator + "\n\n");
		
		
		System.out.println(Main.lineSeparator + "\n(Attacker Summary) " + offense.getName() + "\n" + Main.lineSeparator);
		System.out.println("Number Rifle Soldiers  Dead -> " + offenseBattleReport[0] +"\t\tNumber Rifle Soldiers  Injured -> " + offenseBattleReport[3] +"\t\tNumber Rifle  Ammo Shot/Spent/Hit -> " + offenseBattleReport[23] + "/" + offenseBattleReport[20] + "/" + offenseBattleReport[26]);
		System.out.println("Number Sniper Soldiers Dead -> " + offenseBattleReport[1] +"\t\tNumber Sniper Soldiers Injured -> " + offenseBattleReport[4] +"\t\tNumber Sniper Ammo Shot/Spent/Hit -> " + offenseBattleReport[24] + "/" + offenseBattleReport[21] + "/" + offenseBattleReport[27]);
		System.out.println("Number  RPG  Soldiers  Dead -> " + offenseBattleReport[2] +"\t\tNumber  RPG  Soldiers  Injured -> " + offenseBattleReport[5] +"\t\tNumber  RPG  Ammo  Shot/Spent/Hit -> " + offenseBattleReport[25] + "/" + offenseBattleReport[22] + "/" + offenseBattleReport[28]);
		
		System.out.println("Number Unarmed Vehicles Destroyed -> " + offenseBattleReport[10] +"\t\tNumber Unarmed Vehicles Damaged -> " + offenseBattleReport[13]);
		System.out.println("Number  Armed Vehicles  Destroyed -> " + offenseBattleReport[11] +"\t\tNumber Armed  Vehicles  Damaged -> " + offenseBattleReport[14]);
		System.out.println("Number  Flight Vehicles Destroyed -> " + offenseBattleReport[12] +"\t\tNumber Flight  Vehicles Damaged -> " + offenseBattleReport[15]);
		
		System.out.println(Main.lineSeparator +"\nStats\n" + Main.lineSeparator);
		System.out.println("Number Saved Ammo -> " + (offenseBattleReport[23]+offenseBattleReport[24]+offenseBattleReport[25] - (offenseBattleReport[20]+offenseBattleReport[21]+offenseBattleReport[22])) +"\t\tShot Accuracy Rate -> " + (100 * ((double)offenseBattleReport[26]+offenseBattleReport[27]+offenseBattleReport[28])/(offenseBattleReport[23]+offenseBattleReport[24]+offenseBattleReport[25]+offenseBattleReport[26]+offenseBattleReport[27]+offenseBattleReport[28])) + "%");
		System.out.println("Number Rifle Weapons Destroyed -> " + offenseBattleReport[30]);
		System.out.println("Number Sniper Weapons Destroyed -> " + offenseBattleReport[31]);
		System.out.println("Number RPG Weapons Destroyed -> " + offenseBattleReport[32]);
		System.out.println(Main.lineSeparator);
		
		
		defense.setKillCount(defense.getKillCount() + offenseBattleReport[0] + offenseBattleReport[1] + offenseBattleReport[2]);
		defense.setInjureCount(defense.getInjureCount() + offenseBattleReport[3] + offenseBattleReport[4] + offenseBattleReport[5]);
		
		offense.setKillCount(offense.getKillCount() + defenseBattleReport[0] + defenseBattleReport[1] + defenseBattleReport[2]);
		offense.setInjureCount(offense.getInjureCount() + defenseBattleReport[3] + defenseBattleReport[4] + defenseBattleReport[5]);
		
		Main.hold();
	}
	
	
	/*
	 * 00 -> rifle soldier
	 * 01 -> sniper soldier
	 * 02 -> rpg soldier
	 * 
	 * 10 -> unarmed vehicle
	 * 11 -> armed vehicle
	 * 12 -> flight vehicle
	 */
	public static ArrayList<Integer> CreateArmy(int rs, int ss, int es, int uv, int av, int fv) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int x = 0; x < rs; x++) {
			al.add(0);
		}
		
		for (int x = 0; x < ss; x++) {
			al.add(1);
		}
		
		for (int x = 0; x < es; x++) {
			al.add(2);
		}
		
		for (int x = 0; x < uv; x++) {
			al.add(10);
		}
		
		for (int x = 0; x < av; x++) {
			al.add(11);
		}
		
		for (int x = 0; x < fv; x++) {
			al.add(12);
		}
		
		for (int x = 0; x < 20; x++) {
			int pos1 = (int)(Math.random()*al.size());
			int pos2 = (int)(Math.random()*al.size());
			int temp = al.get(pos1);
			al.set(pos1, al.get(pos2));
			al.set(pos2, temp);
		}
		
		return al;
	}
	
	
	public static boolean checkAmmo(Player target, int[] ammoMin) {
		/*
		 * [0] rifle ammo
		 * [1] sniper ammo
		 * [2] rpg ammo
		 */
		if ((target.getAmountRifleAmmo() <= ammoMin[0] && ammoMin[0] != -1) || (target.getAmountSniperAmmo() <= ammoMin[1] && ammoMin[1] != -1) || (target.getAmountRPGAmmo() <= ammoMin[2] && ammoMin[2] != -1)) {
			return false;
		}
		return true;
	}

	public static JSONObject getDataFile() {
		return dataFile;
	}

	public static int getRebelAttackChanceReduction() {
		return rebelAttackChanceReduction;
	}

	public static int getSPFAttackChanceReduction() {
		return SPFAttackChanceReduction;
	}

	public static int getDefenseAttackChanceReduction() {
		return defenseAttackChanceReduction;
	}

	public static int getOffenseAttackChanceReduction() {
		return offenseAttackChanceReduction;
	}

	public static int getDefenseAttackChanceIncrease() {
		return defenseAttackChanceIncrease;
	}

	public static int getOffenseAttackChanceIncrease() {
		return offenseAttackChanceIncrease;
	}

	public static void setDataFile(JSONObject dataFile) {
		AttackSimulator.dataFile = dataFile;
	}

	public static void setRebelAttackChanceReduction(int rebelAttackChanceReduction) {
		AttackSimulator.rebelAttackChanceReduction = rebelAttackChanceReduction;
	}

	public static void setSPFAttackChanceReduction(int sPFAttackChanceReduction) {
		SPFAttackChanceReduction = sPFAttackChanceReduction;
	}

	public static void setDefenseAttackChanceReduction(int defenseAttackChanceReduction) {
		AttackSimulator.defenseAttackChanceReduction = defenseAttackChanceReduction;
	}

	public static void setOffenseAttackChanceReduction(int offenseAttackChanceReduction) {
		AttackSimulator.offenseAttackChanceReduction = offenseAttackChanceReduction;
	}

	public static void setDefenseAttackChanceIncrease(int defenseAttackChanceIncrease) {
		AttackSimulator.defenseAttackChanceIncrease = defenseAttackChanceIncrease;
	}

	public static void setOffenseAttackChanceIncrease(int offenseAttackChanceIncrease) {
		AttackSimulator.offenseAttackChanceIncrease = offenseAttackChanceIncrease;
	}
}
