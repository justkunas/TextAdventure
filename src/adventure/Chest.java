package adventure;

import player.PlayerInv;

public class Chest {

	private boolean unlocked;
	private String chestKey;
	private String[] contents;
	
	public Chest(String lock, int size){
		unlocked = false;
		chestKey = lock;
		contents = new String[size];
	}
	
	public Chest(int size){
		unlocked = true;
		contents = new String[size];
	}
	
	public boolean isChestUnlocked(){
		return unlocked;
	}
		
	public String getChestKey(){
		return chestKey;
	}
	
	public boolean unlockChest(boolean keyUsed){
		for(int i = 0; i < PlayerInv.getInvSize();i++){	
			if(chestKey == player.PlayerInv.getItemAt(i).getName()){
				unlocked = true;
				if (keyUsed){
					PlayerInv.setItemNull(i);
				}
				return true;
			}else{
				unlocked = false;
			}
			
		}
		
		return false;
	}
	
	public void systemAddsItem(String item){
		for(int i = 0; i < contents.length; i++){
			if(contents[i] == null){
				contents[i] = item;
				return;
			}else if(i == contents.length-1){
				System.out.println("Unable to add item \nChest is full");
				return;
			}
		}
	}
	
	public void systemRemovesItem(String item){
		for(int i = 0; i < contents.length; i++){
			if(contents[i].equalsIgnoreCase(item)){
				contents[i] = null;
				return;
			}else if(i == contents.length-1){
				System.out.println("Unable to locate item");
				return;
			}
		}
	}
	
	public String[] getChestContents(){
		return contents;
	}
	
}