package items;

public class Armour{
	
	public enum ArmourSection {
		
		NULL(0),
		HELMET(2),
		CHESTPLATE(3),
		LEGGINGS(2),
		BOOTS(1);
		
		private int protectionFactor = 0;
	
		ArmourSection(int protection){
			protectionFactor = protection;
		}
		
		public int getProtectionFactor(){
			return protectionFactor;
		}
	
	}
	
}
