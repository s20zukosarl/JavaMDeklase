package models;

import java.util.ArrayList;

public class Group {

	private static ArrayList<Child> allChildrenInGroup = new ArrayList<>();
	private short groupStartYear;
	private String title;
	private Teacher teacher;
	
	// get funkcijas
	
	public static ArrayList<Child> getAllChildrenInGroup()
	{
		return  allChildrenInGroup;
	}
	
	public short getGroupStartYear() {
		return groupStartYear;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	// set funkcijas
	
	public void setAllChildrenInGroup(ArrayList<Child> list) {// !!
		
		if(allChildrenInGroup != null)
		{
			list = allChildrenInGroup;
		}
		else
		{
			list = null;
		}
		
	}

	public void setGroupStartYear(short groupStartYear) { //!!
		
		if (groupStartYear >= 2019 && groupStartYear <= 2022)
		{
			this.groupStartYear = groupStartYear;
		}
		else 
		{
			this.groupStartYear = 0;
		}
	}

	public void setTitle(String title) {
		if (title != null && title.matches("[A-ZÂÇÛÎÏÍÌÐÞÈÒ]{1}[a-zçûîâðìíïòèþ]+")) 
		{
			this.title = title;
		}
		else
		{
			this.title = "unknown";
		}
	}

	public void setTeacher(Teacher teacher) {
		if(teacher != null)
		{
			this.teacher = teacher;
		}
		else
		{
			this.teacher = new Teacher();
		}
		
	}
	
	public Group()
	{
		setAllChildrenInGroup(null);
		setGroupStartYear((short)2000); 
		setTitle("test title");
		setTeacher(new Teacher());
	}
	
	public Group(short groupStartYear, String title, Teacher teacher)
	{
		this.allChildrenInGroup = new ArrayList<Child>();
		setGroupStartYear(groupStartYear);
		setTitle(title);
		setTeacher(teacher);
	}
	
	public boolean addChildInGroup(Child child)   
	{
		allChildrenInGroup.add(child);
		return true;
	}
	
	public boolean removeChildFromGroup(Child child)
	{
		allChildrenInGroup.remove(child);
		return true;
    	
	}

	@Override
	public String toString() {
		return "Group- " + title + " group start year: " + groupStartYear + " teacher: " + teacher.getName() +  teacher.getSurname();
	}
	
	
	
	
}
