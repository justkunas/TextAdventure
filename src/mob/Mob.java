package mob;

import items.Item;
import items.MeleeWeapon;

import java.util.Random;

//import player.PlayerStats;
import combatSystem.AttackTypes;
import combatSystem.CombatSystem;


public abstract class Mob {
	
	private static Random rand = new Random();
	private int maxHealth;
	private int maxMana;
	
	private int mobStrength;
	private int mobSpeed;
	private int mobDefence;
	
	private int mobHealth;
	private int mobMana;
	
	private Item equippedMeleeItem = Item.getMeleeEquipped();
	
	private String mobType;
	
	public Mob(int maxHealth, int maxMana, int maxStrength, int maxSpeed, int maxDefence, String mobType){
		this.maxHealth = maxHealth;
		this.setMaxMana(maxMana);
		mobStrength = maxStrength;
		mobSpeed = maxSpeed;
		mobDefence = maxDefence;
		
		mobHealth = maxHealth;
		setMobMana(maxMana);
		
		this.mobType = mobType;
	}
	
	public abstract AttackTypes[] getMobImmunities();
	
	public abstract boolean isMobImmune(AttackTypes attack);
	
	public abstract AttackTypes[] getMobAttackTypes();
	
	public int getMobHealth(){
		return mobHealth;
	}
	
	public int getMaxHealth(){
		return maxHealth;
	}
	
	public int getStrength(){
		return mobStrength;
	}
	
	public int getDefence(){
		return mobDefence;
	}
	
	public int getSpeed(){
		return mobSpeed;
	}
	
	public String getType(){
		return mobType;
	}
	
	public void changeMobHealth(int i){
		if(mobHealth + i < 0){
			mobHealth = 0;
		}else if(mobHealth + i > maxHealth){
			mobHealth = maxHealth;
		}else{
			mobHealth += i;
		}
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getMobMana() {
		return mobMana;
	}

	public void setMobMana(int mobMana) {
		this.mobMana = mobMana;
	}
	
}
