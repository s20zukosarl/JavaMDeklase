package models;

public class Child extends Person implements Comparable  <Child> { 

	private String allergies;
	private int priorityForSpeechLessons;
	private Nationality nationality;
	
	// get funkcijas
	
	public String getAllergies() {
		return allergies;
	}
	public int getPriorityForSpeechLessons() {
		return priorityForSpeechLessons;
	}
	public Nationality getNationality() {
		return nationality;
	}
	
	// set funkcijas
	
	public void setAllergies(String allergies) {
		if (allergies != null && allergies.matches("[a-zçûîâðìíïòèþ]+")) 
		{
			this.allergies = allergies;
		}
		else
		{
			this.allergies = "unknown";
		}
	}
	
	public void setPriorityForSpeechLessons(int priorityForSpeechLessons) {
		
		int min = 1;
		int max = 6;
		
		int priority = (int)Math.floor(Math.random() * (max - min + 1) + min);
		this.priorityForSpeechLessons = priority;
	}
	
	public void setNationality(Nationality nationality) {
		
		if (nationality != null)
		{
			this.nationality = nationality;
		}
		else
		{
			this.nationality = nationality.OTHER;
		}
	}
	
	public Child()
	{
		super();
		setAllergies("Test allergies");
		setPriorityForSpeechLessons(0);
		setNationality(Nationality.OTHER);
	}
	
	public Child(String name, String surname, String personalCode, String allergies, Nationality nationality)
	{
		super(name, surname, personalCode);
		setAllergies(allergies);
		setPriorityForSpeechLessons(priorityForSpeechLessons);
		setNationality(nationality);
	}
	
	
	public String toString() {
		return "Child - " + super.toString() + " allergies: "+ allergies  + " priority for speech lessons: " + priorityForSpeechLessons
				+ " nationality: " + nationality;
	}
	
	
	public int compareTo(Child child) {
		
		if(this.getPriorityForSpeechLessons() > child.getPriorityForSpeechLessons())
		{
			return 1;
		}
		else if (this.getPriorityForSpeechLessons() < child.getPriorityForSpeechLessons())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	
}
