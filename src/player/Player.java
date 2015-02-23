package player;


public class Player {
	
	public Stats stats = new Stats();
	
	public Player(){
		stats.initiaizeStats();
		PlayerInv.initilizeArmour();
	}
	
	public void unlockMagic(){
		stats.magic.unlockMagic();
	}
	
	public boolean isMagicUnlocked(){
		return stats.magic.isMagicUnlocked();
	}
	
}
