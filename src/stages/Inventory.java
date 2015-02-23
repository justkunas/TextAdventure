package stages;

import items.ArmourPiece;
import items.Item;
import items.Item.itemType;
import items.MeleeWeapon;
import items.MundaneItem;
import items.RangedWeapon;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import player.PlayerInv;
import reference.Core;
import reference.Potions;
import reference.Stages;

public class Inventory extends BasicGameState {

	Image background;

	int xPos;
	int yPos;
	int page = 1;
	int menuX = 150;
	int menuY = 500;
	int item = 0;

	String mouse;
	String thing = "null";
	String iMenu  = "Select an Item";
	String eqpdWpn = "";

	boolean drawMenu = false;
	boolean itemSelected = false;
	boolean toggle = false;
	boolean success = false;
	
	Item selectedItem;

	public Inventory(int state) {

	}

	@Override
	public void init(GameContainer gameCont, StateBasedGame sbg)
			throws SlickException {
		background = new Image("res/Background/Inventory.png");
		thing += "Item Selected? " + itemSelected;
	}

	@Override
	public void render(GameContainer gameCont, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setBackground(Color.gray);
		g.setColor(Color.yellow);
		background.draw(75, 75);
		g.drawString(mouse, 50, 100);
		g.drawString(thing, 50, 115);
		g.drawString(eqpdWpn, 50, 130);
		drawItemNames(g);
		if (drawMenu) {
			g.drawString(iMenu, menuX, menuY);
		}
	}

	@Override
	public void update(GameContainer gameCont, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gameCont.getInput();
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(Stages.PLAY);
		}
		
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			if(toggle){
				eqpdWpn = "Equipped Melee: "+PlayerInv.getEquippedMelee().getName()+" | itemSelected?" + itemSelected;
				toggle = false;
			}else{
				eqpdWpn = "";
				toggle = true;
			}
		}

		if (input.isKeyPressed(Input.KEY_E)) {
			sbg.enterState(Stages.PLAY);
		}

		if (input.isMousePressed(1)) {
			if ((xPos < 1275 && xPos > 346) && (yPos < 724 && yPos > 83)) {
				if (yPos > 644) {
					drawItemMenu(1);
					drawMenu = true;
					itemSelected = true;
					item = 0;
				} else if (yPos < 644 && yPos > 564) {
					drawItemMenu(2);
					drawMenu = true;
					item = 1;
					itemSelected = true;
				} else if (yPos < 564 && yPos > 484) {
					drawItemMenu(3);
					drawMenu = true;
					itemSelected = true;
					item = 2;
				} else if (yPos < 484 && yPos > 404) {
					drawItemMenu(4);
					drawMenu = true;
					itemSelected = true;
					item = 3;
				} else if (yPos < 404 && yPos > 324) {
					drawItemMenu(5);
					drawMenu = true;
					itemSelected = true;
					item = 4;
				} else if (yPos < 324 && yPos > 244) {
					drawItemMenu(6);
					drawMenu = true;
					itemSelected = true;
					item = 5;
				} else if (yPos < 244 && yPos > 164) {
					drawItemMenu(7);
					drawMenu = true;
					itemSelected = true;
					item = 6;
				} else if (yPos < 164) {
					drawItemMenu(8);
					drawMenu = true;
					itemSelected = true;
					item = 7;
				}else{
					itemSelected = false;
				}
			}
			
		}
		
		if(input.isMousePressed(0)){
			
			if((xPos > 150 && xPos < 235)&&(yPos > 280 && yPos < 295)&&itemSelected){
				PlayerInv.setItemNull(item);
				System.out.println("Why am I firing?");
				iMenu = "";
			}else if((xPos > 150 && xPos < 295)&&(yPos > 260 && yPos < 280)&&itemSelected){
				if(PlayerInv.getItemAt(page * 8 - (9 - item)).getItemType() == itemType.POTION){
					PlayerInv.playerUsesItem(PlayerInv.getItemAt(item));
					PlayerInv.setItemNull(item);
					iMenu = "";
					drawItemMenu(item+1);
					itemSelected = false;
					
				}else if(PlayerInv.getItemAt(item).getItemType() == itemType.HELM){
					PlayerInv.equipHelmet((ArmourPiece) PlayerInv.getItemAt(item));
					drawItemMenu(item+1);
					itemSelected = false;
					
				}else if(PlayerInv.getItemAt(item).getItemType() == itemType.CHEST){
					PlayerInv.equipChestplate((ArmourPiece) PlayerInv.getItemAt(item));
					drawItemMenu(item+1);
					itemSelected = false;
					
				}else if(PlayerInv.getItemAt(item).getItemType() == itemType.LEGS){
					PlayerInv.equipLeggings((ArmourPiece) PlayerInv.getItemAt(item));
					drawItemMenu(item+1);
					itemSelected = false;
					
				}else if(PlayerInv.getItemAt(item).getItemType() == itemType.BOOTS){
					PlayerInv.equipBoots((ArmourPiece) PlayerInv.getItemAt(item));
					drawItemMenu(item+1);
					itemSelected = false;
					
				}else if(PlayerInv.getItemAt(item).getItemType() == itemType.MELEE_WEAPON){
					success = PlayerInv.equipMeleeItem((MeleeWeapon) PlayerInv.getItemAt(item));
					drawItemMenu(item+1);
					
				}else if(PlayerInv.getItemAt(item).getItemType() == itemType.RANGED_WEAPON){
					PlayerInv.equipRangedItem((RangedWeapon) PlayerInv.getItemAt(item));
					drawItemMenu(item+1);
					itemSelected = false;
				}
			}else{
				itemSelected = false;
				System.out.println("Why am I not firing?");
			}
		}

		mouse = ("Mouse Location - x: " + xPos + ", y: " + yPos);

		xPos = Mouse.getX();
		yPos = Mouse.getY();
	}

	private void drawItemNames(Graphics g) {
		for (int i = 0; i < page * 8; i++) {
			if (PlayerInv.getItemAt(i * page) != null) {
				g.drawString(PlayerInv.getItemAt(i * page).getName(), 350,800 - (694 - i * 80));
			}
		}
	}

	private Item itemAt() {
		Item item = new MundaneItem("Null");
		if ((xPos < 346 && xPos > 83) && (yPos < 1275 && yPos > 724)) {
			if (yPos > 644) {
				item = PlayerInv.getItemAt(page * 8 - 8);
			} else if (yPos < 644) {
				item = PlayerInv.getItemAt(page * 8 - 7);
			} else if (yPos < 564) {
				item = PlayerInv.getItemAt(page * 8 - 6);
			} else if (yPos < 484) {
				item = PlayerInv.getItemAt(page * 8 - 5);
			} else if (yPos < 404) {
				item = PlayerInv.getItemAt(page * 8 - 4);
			} else if (yPos < 324) {
				item = PlayerInv.getItemAt(page * 8 - 3);
			} else if (yPos < 244) {
				item = PlayerInv.getItemAt(page * 8 - 2);
			} else if (yPos < 1644) {
				item = PlayerInv.getItemAt(page * 8 - 1);
			}
		}
		thing = item.getName();
		return item;
	}

	private void drawItemMenu(int i) {
		if (PlayerInv.getItemAt(page * 8 - (9 - i)) != null) {
			if (PlayerInv.getItemAt(page * 8 - (9 - i)).isQuestItem()) {
			} else {
				iMenu = "Drop Item";
				switch (PlayerInv.getItemAt(page * 8 - (9 - i)).getItemType()) {
				case ARROW:
					break;
				case BOOTS:
					if(PlayerInv.getEquippedBoots() != null){
						if(PlayerInv.getEquippedBoots().equals(PlayerInv.getItemAt(page * 8 - (9 - i)))){
							iMenu = iMenu + "\nUnequip Boots";
						}else{
							iMenu = iMenu + "\nEquip Boots";
						}
					}else{
						iMenu = iMenu + "\nEquip Boots";
					}
					break;
				case CHEST:
					if(PlayerInv.getEquippedChestplate() != null){
						if(PlayerInv.getEquippedChestplate().equals(PlayerInv.getItemAt(page * 8 - (9 - i)))){
							iMenu = iMenu + "\nUnequip Chestplate";
						}else{
							iMenu = iMenu + "\nEquip Chestplate";
						}
					}else{
						iMenu = iMenu + "\nEquip Chestplate";
					}
					break;
				case HELM:
					if(PlayerInv.getEquippedHelmet() != null){
						if(PlayerInv.getEquippedHelmet().equals(PlayerInv.getItemAt(page * 8 - (9 - i)))){
							iMenu = iMenu + "\nUnequip Helmet";
						}else{
							iMenu = iMenu + "\nEquip Helmet";
						}
					}else{
						iMenu = iMenu + "\nEquip Helmet";
					}
					break;
				case LEGS:
					if(PlayerInv.getEquippedLeggings() != null){
						if(PlayerInv.getEquippedLeggings().equals(PlayerInv.getItemAt(page * 8 - (9 - i)))){
							iMenu = iMenu + "\nUnequip Leggings";
						}else{
							iMenu = iMenu + "\nEquip Leggings";
						}
					}else{
						iMenu = iMenu + "\nEquip Leggings";
					}
					break;
				case MELEE_WEAPON:
					if(success){
						iMenu = iMenu + "\nUnEquip Weapon";
					}else{
						iMenu = iMenu + "\nEquip Weapon";
					}
					break;
				case MUNDANE:
					break;
				case POTION:
					iMenu = iMenu + "\nUse Potion";
					break;
				case RANGED_WEAPON:
					if(PlayerInv.getEquippedRanged() != null){
						if(PlayerInv.getEquippedRanged().equals(PlayerInv.getItemAt(page * 8 - (9 - i)))){
							iMenu = iMenu + "\nUnequip Weapon";
						}else{
							iMenu = iMenu + "\nEquip Weapon";
						}
					}else{
						iMenu = iMenu + "\nEquip Weapon";
					}
				default:
					iMenu = "No item found";
					break;
				}
			}
		}
	}

	@Override
	public int getID() {
		return Stages.INV;
	}

}
