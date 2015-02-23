package player;

import java.util.Random;

public class Magic {
	
	private boolean isMagicUnlocked = false;
	private static int playerMana = 0;
	private static int maxPlayerMana = playerMana;
	private static Random maxStat = new Random();
	
	public int getMana(){
		return playerMana;
	}
	
	public int getMaxMana(){
		return maxPlayerMana;
	}
	
	protected static void initialize(){
		maxPlayerMana = playerMana;
	}
	
	public void unlockMagic(){
		isMagicUnlocked = true;
		maxPlayerMana += maxStat.nextInt(6);
	}
	
	public boolean isMagicUnlocked(){
		return isMagicUnlocked;
	}
	
	
	public int manaChange(int int1){
		if(playerMana+int1 < 0){
			playerMana = 0;
			return playerMana;
		}else if(playerMana+int1 >= maxPlayerMana){
			playerMana = maxPlayerMana;
			return playerMana;
		}else{
			playerMana = playerMana + int1;
			return playerMana;
		}
	}
}
