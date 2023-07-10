package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;

public class SpeechTherapist extends Employee {

	private String workingMethods;
	private static PriorityQueue<Child> allChildrenAtSpeechLessons = new PriorityQueue<>();
	
	// get funkcijas 
	
	public String getWorkingMethods() {
		return workingMethods;
	}
	
	public PriorityQueue<Child> getAllChildrenAtSpeechLessons() {
		return allChildrenAtSpeechLessons;
	}
	
	// set funkcijas
	
	public void setWorkingMethods(String workingMethods) {
		if (workingMethods != null && workingMethods.matches("[a-zзыоврмнптию]+")) 
		{
			this.workingMethods = workingMethods;
		}
		else
		{
			this.workingMethods = "unknown";
		}
	}
	
	public static void setAllChildrenAtSpeechLessons(PriorityQueue<Child> queue) {
		
		if(allChildrenAtSpeechLessons != null)
		{
			queue = allChildrenAtSpeechLessons;
		}
		else
		{
			queue = null;
		}
		
	}
	
	
	public SpeechTherapist()
	{
		super();
		setAllChildrenAtSpeechLessons(null);
		setWorkingMethods("test metodes");
	}
	
	public SpeechTherapist(String name, String surname, String personalCode, LocalDate contractDate, String workingMethods)
	{
		super(name, surname, personalCode, contractDate);
		SpeechTherapist.allChildrenAtSpeechLessons = new PriorityQueue<Child>();
		setWorkingMethods(workingMethods);
	}
	
	public String toString() {
		return "Speech Therapist- " + super.toString() + " working methods " +  workingMethods;
	}
	
	public boolean addChildByPriority(Child child) 
	{
		if (child.getPriorityForSpeechLessons() >= 1 && child.getPriorityForSpeechLessons() <= 4)
		{
			allChildrenAtSpeechLessons.add(child);
			return true;
		}	
		return false;
	}
	
	
	
}
