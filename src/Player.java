// File: Player.java
// Name: Jason Harkness
// Purpose: Create player class to store dealer info
public class Player implements Person{
	
	private String name;

	public Player(String n) {
		this.setName(n);
		
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
