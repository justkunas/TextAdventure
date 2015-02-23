package player;

import java.util.Random;

import reference.Core;
import stages.StartZone;

public class Stats{
		
	public Magic magic = new Magic();
	
	private Random maxStat = new Random();
	private int playerHealth = (80+maxStat.nextInt(21));
	private int playerStrength = (25+maxStat.nextInt(6));
	private int playerSpeed = (80+maxStat.nextInt(21)); //0;
	private int playerDefence = (1+maxStat.nextInt(5));
	private int playerCoins = 0;
	private int playerIntelligence = (40+maxStat.nextInt(11));
	private int playerSanity = 100;
	private int playerKarma = 0;
	
	private int maxPlayerHealth;
	private int maxPlayerStrength;
	private int maxPlayerSpeed;
	private int maxPlayerDefence;
	private int maxPlayerCoins;
	private int maxPlayerIntelligence;
	private int maxPlayerSanity;
	
	protected void initiaizeStats(){
		maxPlayerHealth = playerHealth;
		maxPlayerStrength = playerStrength;
		maxPlayerSpeed = playerSpeed;
		maxPlayerDefence = playerDefence;
		maxPlayerCoins = Integer.MAX_VALUE;
		maxPlayerIntelligence = playerIntelligence;
		maxPlayerSanity = 100;
		playerSanity = -100;
		Magic.initialize();
	}
	
	public int getMaxHealth(){
		return maxPlayerHealth;
	}
	
	public int getMaxStrength(){
		return maxPlayerStrength;
	}
	
	public int getMaxSpeed(){
		return maxPlayerSpeed;
	}
	
	public int getMaxDefence(){
		return maxPlayerDefence;
	}
	
	public int getMaxCoins(){
		return maxPlayerCoins;
	}
	
	public int getMaxIntelligence(){
		return maxPlayerIntelligence;
	}
	
	public int getMaxSanity(){
		return maxPlayerSanity;
	}
	
	//Getting Current Stat's
	
	public int getHealth(){
		return playerHealth;
	}
	
	public int getStrength(){
		return playerStrength;
	}
	
	public int getSpeed(){
		return playerSpeed;
	}
	
	public int getDefence(){
		return playerDefence;
	}
	
	public int getCoins(){
		return playerCoins;
	}
	
	public int getIntelligence(){
		return playerIntelligence;
	}
	
	public int getSanity(){
		return playerSanity;
	}
	
	public int getKarma(){
		return playerKarma;
	}
	
	//Setting Stat's
	
	public int healthChange(int int1){
		if(playerHealth+int1 < 0){
			playerHealth = 0;
			return playerHealth;
		}else if(playerHealth+int1 >= maxPlayerHealth){
			playerHealth = maxPlayerHealth;
			return playerHealth;
		}else{
			playerHealth = playerHealth + int1;
			return playerHealth;
		}
	}
	
	public int strengthChange(int int1){
		if(playerStrength+int1 < 0){
			return playerStrength;
		}else if(playerStrength+int1 >= maxPlayerStrength){
			playerStrength = maxPlayerStrength;
			return playerStrength;
		}else{
			playerStrength = playerStrength + int1;
			return playerStrength;
		}
	}
	
	public int speedChange(int int1){
		if(playerSpeed+int1 < 0){
			return playerSpeed;
		}else if(playerSpeed+int1 >= maxPlayerSpeed){
			playerSpeed = maxPlayerSpeed;
			return playerSpeed;
		}else{
			playerSpeed = playerSpeed + int1;
			return playerSpeed;
		}
	}
	
	public int defenceChange(int int1){
		if(playerDefence+int1 < 0){
			return playerDefence;
		}else if(playerDefence+int1 >= maxPlayerDefence){
			playerDefence = maxPlayerDefence;
			return playerDefence;
		}else{
			playerStrength = playerDefence + int1;
			return playerStrength;
		}
	}
	
	public int coinChange(int int1){
		if(playerCoins+int1 < 0){
			System.out.println("You do not have enough coins for this purchase");
			return playerCoins;
		} else {
			playerCoins = playerCoins + int1;
			return playerCoins;
		}
	}
	
	public int intelligenceChange(int int1){
		if(playerIntelligence+int1 < 0){
			playerIntelligence = 0;
			return playerIntelligence;
		}else if(playerIntelligence+int1 >= maxPlayerIntelligence){
			playerIntelligence = 100;
			return playerIntelligence;
		}else{
			playerIntelligence = playerIntelligence + int1;
			return playerIntelligence;
		}
	}
	
	public int sanityChange(int int1){
		if(playerSanity >= 0 & playerSanity-int1 <= -100){
			playerSanity = -100;
			return playerSanity;
		}else if(playerSanity < 0 & playerSanity+int1 <= -100){
			playerSanity = -100;
			return playerSanity;
		}else if(playerSanity+int1 >= 100){
			playerSanity = 100;
			return playerSanity;
		}else{
			playerSanity = playerSanity + int1;
			return playerSanity;
		}
	}
	
	public int karmaChange(int int1){
		if(playerKarma + int1 < -100){
			playerKarma = -100;
			return playerKarma;
		}else if(playerKarma+int1 > 100){
			playerKarma = 100;
			return playerKarma;
		}else{
			playerKarma += int1;
			return playerKarma;
		}
	}
	
	public int getMeleeAttackDamage(){
		int attackDamage = 0;
		if(PlayerInv.getEquippedMelee() != null){
			attackDamage = getStrength() + PlayerInv.getEquippedMelee().getMeleeBoost();
		}else{
			attackDamage = getStrength();
		}
		return attackDamage;
	}
	
	public int getRangedAttackDamage(){
		int attackDamage = 0;
		if(PlayerInv.getEquippedRanged() != null){
			attackDamage = getStrength() + PlayerInv.getEquippedRanged().getRangedBoost() + PlayerInv.getEquippedRanged().getAmmoType().getRangedBoost();
		}else{
			attackDamage = getStrength();
		}
		return attackDamage;
	}
	
}
