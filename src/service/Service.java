package service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import models.Child;
import models.Employee;
import models.Group;
import models.Nationality;
import models.Person;
import models.SpeechTherapist;
import models.Teacher;
import models.TeachingLevel;

public class Service {
	
	private static ArrayList<Employee> allEmployees = new ArrayList<>();
	private static ArrayList<Group> allGroups = new ArrayList<>();
	private static ArrayList<Child> allChildren = new ArrayList <>();
	

	public static void main(String[] args)
	{
		
		Teacher t1 = new Teacher("Gunta", "Spuldze", "223344-00990", LocalDate.of(2022, 4, 25), TeachingLevel.YOUNGCHILD);
		Teacher t2 = new Teacher("Mara", "Skuja", "333333-88888", LocalDate.of(2022, 4, 24), TeachingLevel.TODDLER);
		Teacher t3 = new Teacher("Sanita", "Zîle", "399933-00088", LocalDate.of(2022, 4, 24), TeachingLevel.PRESCHOOL);
		allEmployees.add(t1);
		allEmployees.add(t2);
		allEmployees.add(t3);
		
		Child ch1 = new Child("Mârtiòð", "Liepa", "666666-77883", "tomâti", Nationality.OTHER);
		Child ch2 = new Child("Leo", "Burts", "222222-11111", "nav", Nationality.LATVIAN);
		Child ch3 = new Child("Anna", "Panna", "233322-11111", "rieksti", Nationality.LATVIAN);
		Child ch4 = new Child("Marija", "Ozola", "244322-55111", "rieksti", Nationality.LATVIAN);
		Child ch5 = new Child("Harijs", "Poters", "211322-10001", "nav",Nationality.LATVIAN);
		
		Group g1 = new Group((short)2021, "Aizkari", t1);
		Group g2 = new Group((short)2020, "Pûciòas", t2);
		Group g3 = new Group((short)2019, "Zvaniòi", t3);
		allGroups.add(g1);
		allGroups.add(g3);
		allGroups.add(g2);
		

		SpeechTherapist st1 = new SpeechTherapist("Austra", "Vçja", "111111-22112", LocalDate.of(2022, 3, 30), "metode");
		SpeechTherapist st2 = new SpeechTherapist("Olga", "Lagzdiòa", "777777-00000", LocalDate.of(2020, 4, 24), "terapija" );
		allEmployees.add(st2);
		allEmployees.add(st1);
		
		showAllTeachers();
		System.out.println("--------");
		showAllSpeechTherapists();
		System.out.println("--------");
		addChildInGroup(ch2, g2);
		addChildInGroup(ch3, g2);
		addChildInGroup(ch4, g3);
		addChildInGroup(ch5, g3);
		showAllChildrenInGroup(g2);
		System.out.println("--------");
		removeChildFromGroup(ch2, g2);
		showAllChildrenInGroup(g2);
		
		addNewTeacher("Zaiga", "Zvirbule", "111111-12129", LocalDate.of(2022, 4, 24), TeachingLevel.PRESCHOOL);
		addNewChild("Riko", "Liepiòð", "444455-99099", "soja" , Nationality.ESTONIAN);
		addNewSpeechTherapist("Janîna", "Upeniece", "112233-44556", LocalDate.of(2022, 4, 24), "baigâ metode");
		addNewGroup((short)2021, "Haizivis", t2);
		
		showAllChildrenByGroupStartYear((short)2020);
		changeGroup(ch3, g2, g3);
		System.out.println("----------");
		showAllChildrenInGroup(g2);
		addChildInGroup(ch2, g2);
		System.out.println("----------");
		subscribeChildInSpeechLessonsByChildPersonalCode("233322-11111", st1);
		subscribeChildInSpeechLessonsByChildPersonalCode("222222-11111", st1);
		subscribeChildInSpeechLessonsByChildPersonalCode("123455-56788", st1);
		subscribeChildInSpeechLessonsByChildPersonalCode("666666-77883", st1);
		subscribeChildInSpeechLessonsByChildPersonalCode("244322-55111", st1);
		showAllChildrenInSpeechLessonBySpeechTherapistPersonalCode("111111-22112");
		System.out.println("----------");
		System.out.println("Bçrni pie speech therapist: ");
		showAllChildrenInSpeechLessonBySpeechTherapistPersonalCode("777777-00000");
		
		showAllTeachers();
		removeTeacherByEmployeeId(4);
		showAllTeachers();
		System.out.println("--------");
		removeTeacherByPersonalCode("333333-88888");
		showAllTeachers();
		System.out.println("--------");
		showAllSpeechTherapists();
		removeSpeechTherapistByEmployeeId(3);
		showAllSpeechTherapists();
		System.out.println("--------");
		removeSpeechTherapistByPersonalCode("777777-00000");
		showAllSpeechTherapists();
		System.out.println("-----------");
		showAllChildrenInGroup(g3);
		removeChildByPersonalCode("233322-11111");
		showAllChildrenInGroup(g3);
		removeGroupByTitleAndYearAndTeacher("Zvaniòi",(short) 2019, t3);
		showAllChildrenByGroupStartYear((short)2019);
		
		System.out.println("-----------");
		addChildInGroup(ch5, g1);
		Child ch6 = new Child("Kaija", "Aukla", "123455-56788", "nav", Nationality.ESTONIAN);
		allChildren.add(ch6);
		addChildInGroup(ch6, g1);
		showAllChildrenInGroup(g1);
		System.out.println("-----------");
		
		

	}
	
	private static boolean addNewTeacher(String name, String surname, String personalCode, LocalDate contractDate, TeachingLevel level)
	{
		Teacher teacher = new Teacher(name, surname, personalCode, contractDate, level);
		if(allEmployees.contains(teacher))
		{
			return false;
		}
		else
		{
			allEmployees.add(teacher);
			return true;
		}
    	
	};
	
	private static boolean addNewSpeechTherapist(String name, String surname, String personalCode, LocalDate contractDate, String workingMethods)
    {
    	SpeechTherapist speechTh = new  SpeechTherapist(name, surname, personalCode, contractDate, workingMethods);
    	if(allEmployees.contains(speechTh))
    	{
    		return false;
    	}
    	else
    	{
    		allEmployees.add(speechTh);
    		return true;
    	}
    	
    };
	
	private static boolean addNewChild(String name, String surname, String personalCode, String allergies, Nationality nationality)
	{
		Child child = new Child (name, surname, personalCode, allergies, nationality);
		if (allChildren.contains(child))
		{
			return false;
		}
		else
		{
			allChildren.add(child);
			return true;
		}
		
	};
	
	private static boolean addNewGroup(short groupStartYear, String title, Teacher teacher)
	{
		Group gr = new Group (groupStartYear, title, teacher);
		if (allGroups.contains(gr))
		{
			return false;
		}
		else
		{
			allGroups.add(gr);
			return true;
			
		}
	};
	
	 private static boolean removeTeacherByPersonalCode(String personalCode)
     {
     	
     	for (Employee teacher : allEmployees)
     	{
     		if (teacher.getPersonalCode() == personalCode)
     		{
     			allEmployees.remove(teacher);
     			return true;
     		}
     	}
     	return false;
     	
     }
	 
	 private static boolean removeTeacherByEmployeeId(int employeeId)
     {
     	
     	for (Employee teacher : allEmployees)
     	{
     		if (teacher.getEmployeeId() == employeeId)
     		{
     			allEmployees.remove(teacher);
     			return true;
     		}
     	}
     	return false;
     	
     }
	 
	 private static boolean removeSpeechTherapistByEmployeeId(int employeeId)
     {
     	
     	for (Employee speechTherapist : allEmployees)
     	{
     		if (speechTherapist.getEmployeeId() == employeeId)
     		{
     			allEmployees.remove(speechTherapist);
     			return true;
     		}
     	}
     	return false;
     	
     }
	 
	 private static boolean removeSpeechTherapistByPersonalCode(String personalCode)
     {
     	
     	for (Employee speechTh : allEmployees)
     	{
     		if (speechTh.getPersonalCode() == personalCode)
     		{
     			allEmployees.remove(speechTh);
     			return true;
     		}
     	}
     	return false;
     	
     }
	 
	 private static boolean removeChildByPersonalCode(String personalCode) 
		{
		 
		 for(Child child : Group.getAllChildrenInGroup())
		 {
			 if (child.getPersonalCode() == personalCode)
			 {
				 Group.getAllChildrenInGroup().remove(child);
				 return true;
			 }
		 }
			
		return false;
	    	
		}
	 
	 private static boolean removeGroupByTitleAndYearAndTeacher(String title, short year, Teacher teacher)
     {
     	
     	for (Group group : allGroups)
     	{
     		if (group.getTitle() == title && group.getGroupStartYear() == year && group.getTeacher() == teacher)
     		{
     			allGroups.remove(group);
     			return true;
     		}
     	}
     	return false;
     	
     }
	 
	 private static boolean addChildInGroup(Child child, Group group)
	 {
		
			 if (group.getAllChildrenInGroup().contains(child))
			 {
				 return false;
			 }
			 else
			 {
				group.addChildInGroup(child);
				return true;
			 }	 		
	 }
	 
	 private static boolean removeChildFromGroup(Child child, Group group)
	 {
		 if(group.getAllChildrenInGroup().contains(child))
		 {
			 group.removeChildFromGroup(child);
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 private static boolean changeGroup(Child child, Group groupNo, Group groupUz)
	 {
		 if(groupUz.getAllChildrenInGroup().contains(child))
		 {
			 return false;
		 }
		 else
		 {
			 removeChildFromGroup(child, groupNo);
			 addChildInGroup(child, groupUz);
			 return true;
		 }
	 }
	 
	 
	 private static boolean subscribeChildInSpeechLessonsByChildPersonalCode(String personalCode, SpeechTherapist speechTh)
	 {

		 
		 for (Child t : allChildren)
		 {
			 if (t.getPersonalCode() == personalCode && t.getPriorityForSpeechLessons() >= 1 && t.getPriorityForSpeechLessons() <= 4)
			 {
				 speechTh.getAllChildrenAtSpeechLessons().add(t);
				 //speechTh.addChildByPriority(t);
				 return true;
			 }
		 }
		 return false;
		
	 }
	 
	 

	private static void showAllTeachers()
	 {
		 for (Employee temp : allEmployees)		 
		 {
			 if (temp instanceof Teacher)
			 {
				 System.out.println(temp);
			 } 
		 }
	 }
	 
	 private static void showAllSpeechTherapists()
	 {
		 for (Employee temp : allEmployees)
		 {
			 if (temp instanceof SpeechTherapist) {
				 System.out.println(temp);
			 }	 
		 }
	 }
	 
	 private static void showAllChildrenInGroup(Group group)
	 {
		
		 System.out.println(group.getAllChildrenInGroup());
	 }
	 
	 private static void showAllChildrenInSpeechLessonBySpeechTherapistPersonalCode(String personalCode)
	 {
		 
		 for (Employee temp : allEmployees)
		 {
			 
			 if(temp instanceof SpeechTherapist)
			 {
				 //ja ir String, tad == vietâ ir jâliek funkcija .equals; tâ tev ir vairâkâs vietâs!
				 
				SpeechTherapist therapist = (SpeechTherapist) temp;
				if (therapist.getPersonalCode() == personalCode)
				{

					System.out.println(therapist.getAllChildrenAtSpeechLessons());
				}
				 
			 }
			
		 }
	 }
	 
	 
	 private static void showAllChildrenByGroupStartYear(short startYear)
	 {
		 for (Group temp : allGroups)
		 {
			 if(temp.getGroupStartYear() == startYear)
			 {
				 System.out.println(temp.getAllChildrenInGroup());
			 }
		 }
	 }
	 
	 private static String generateLunch()
	 {
		 String edieni[] = {"rieksti", "tomâti", "maize", "soja", "makaroni", "spinâti", "zupa"};
		 String alergijas[] = {"rieksti", "tomâti", "soja"};
		 ArrayList<String> lunch = new ArrayList<>();
		 
		 
		 int min = 1;
		 int max = edieni.length;
			
		 int randSkaitlis = (int)Math.floor(Math.random() * (max - min + 1) + min);
		 
		 for (int i=0; i <= alergijas.length-1; i++)
		 {
			 String food = edieni[randSkaitlis];
			 if (food != alergijas[i])
			 {
				 lunch.add(food);
			 }
		 }
		 String list = String.join(" ", lunch);
		 
		 return list;	
			
		 
	 }
}
