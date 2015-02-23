package adventure;

import player.PlayerInv;

public class Door {
	
		
	private boolean unlocked;
	private boolean open;
	private String doorKey;
	
	public Door(TravelDirection.direction direction, String lock, boolean open){
		unlocked = false;
		this.open = open;
		doorKey = lock;
	}
	
	public Door(TravelDirection.direction direction, boolean open){
		unlocked = true;
		this.open = open;
	}
	
	public boolean isDoorUnlocked(){
		return unlocked;
	}
	
	public boolean isDoorOpen(){
		return open;
	}
	
	public String getDoorKey(){
		return doorKey;
	}
	
	public boolean unlockDoor(boolean keyUsed){
		for(int i = 0; i < PlayerInv.getInvSize();i++){	
			if(doorKey == PlayerInv.getItemAt(i).getName()){
				unlocked = true;
				if (keyUsed){
					player.PlayerInv.setItemNull(i);
				}
				return true;
			}else{
				System.out.println("Reached stage 3b");
				unlocked = false;
			}
			
		}
		
		return false;
	}
	
}
