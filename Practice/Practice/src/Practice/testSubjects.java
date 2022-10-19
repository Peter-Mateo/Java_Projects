package Practice;

public class testSubjects {
	// Declaring Variables 
	protected int ID;
	protected String name;

	testSubjects(){
	}

	testSubjects(int ID, String name){
		this.ID = ID;
		this.name = name;
		System.out.println("Confirmed");
	}
	// Setters
	public boolean setID(int ID) {
		this.ID = ID;
		return true;
	}
	public void setName(String name) {
		this.name = name;
	}
	// Getters
	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

}
