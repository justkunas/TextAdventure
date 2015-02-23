package main;

import reference.Potions;
import mob.Mob;

public class GameDisplay {

	private static int mobNameLength;
	private static int totalSpaces;
	private static int spaces;
	private static String encStart = "# A wild ";
	private static String encEnd = " has apperead!#";
	
	public static void encounter(Mob mob){
		mobNameLength = mob.getType().length();
		totalSpaces = encStart.length() + mobNameLength + encEnd.length();
		for(spaces = 0; spaces < totalSpaces; spaces++){
			System.out.print("#");
		}
		spaces = 0;
		System.out.println("\n" + encStart + mob.getType() + encEnd);
		for(spaces = 0; spaces < totalSpaces; spaces++){
			System.out.print("#");
		}
		spaces = 0;
		totalSpaces = 0;
		mobNameLength = 0;
	}
	
	public static void startGame(){
		System.out.println("");
		System.out.println("");
		System.out.println("###############################################");
		System.out.println("#                                             #");
		System.out.println("#          Welcome to Text Adventure          #");
		System.out.println("#              by:Justin Jankunas             #");
		System.out.println("#      When ready please input start game     #");
		System.out.println("#                                             #");
		System.out.println("###############################################");
		
	}
	
	public static void mobDeath(Mob mob){
		//make mob 20 Characters long using spaces
		mobNameLength = mob.getType().length();
		totalSpaces = 20-mobNameLength;
		spaces = totalSpaces/2;
		System.out.print(spaces);
		System.out.println("");
		System.out.println("");
		System.out.println("###############################################");
		System.out.println("#                                             #");
		System.out.print("#  ");
		for(; spaces > 0; spaces--){
			System.out.print(" ");
		}
		spaces = totalSpaces/2;
		System.out.print  (" You have been slain by " + mob.getType());
		for(; spaces > 0; spaces--){
			System.out.print(" ");
		}
		System.out.print("#");
		System.out.println("\n#                  GAME OVER                  #");
		System.out.println("#                                             #");
		System.out.println("###############################################");
		spaces = 0;
		totalSpaces = 0;
		mobNameLength = 0;
	}
	
	public static void stupidDeath(){
		System.out.println("");
		System.out.println("");
		System.out.println("###############################################");
		System.out.println("#                                             #");
		System.out.println("#       Your plan has majorly back fired      #");
		System.out.println("#                  GAME OVER                  #");
		System.out.println("#                                             #");
		System.out.println("###############################################");
	}
}
