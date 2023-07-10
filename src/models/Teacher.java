package models;

import java.time.LocalDate;
import java.util.Calendar;


public class Teacher extends Employee {

	private TeachingLevel level;

	// get funkcijas
	
	public TeachingLevel getLevel() {
		return level;
	}

	//set funkcijas
	
	public void setLevel(TeachingLevel level) {
		
		if (level != null)
		{
			this.level = level;
		}
		else
		{
			this.level = TeachingLevel.YOUNGCHILD;
		}
	}
	
	public Teacher()
	{
		super();
		setLevel(TeachingLevel.YOUNGCHILD);
	}
	
	public Teacher(String name, String surname, String personalCode, LocalDate contractDate, TeachingLevel level)
	{
		super(name, surname, personalCode, contractDate);
		setLevel(level);
	}

	@Override
	public String toString() {
		return "Teacher - " + super.toString() + " teaching level: " + level;
	}
	
	
	
}
