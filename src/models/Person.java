package models;

public class Person {

	private String name;
	private String surname;
	private String personalCode;
	
	// get funkcijas
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPersonalCode() {
		return personalCode;
	}
	
	// set funkcijas
	
	public void setName(String name) {
		
		if (name != null && name.matches("[A-ZÂÇÛÎÏÍÌĞŞÈÒ]{1}[a-zçûîâğìíïòèş]+")) //\p{L}+
		{
			this.name = name;
		}
		else
		{
			this.name = "unknown";
		}
	}
	
	public void setSurname(String surname) {
		
		if (surname != null && surname.matches("[A-ZÂÇÛÎÏÍÌĞŞÈÒ]{1}[a-zçûîâğìíïòèş]+")) //\p{L}+
		{
			this.surname = surname;
		}
		else
		{
			this.surname = "unknown";
		}
	}
	
	public void setPersonalCode(String personalCode) {
		if (personalCode != null && personalCode.matches("[0-9]{6}-[0-9]{5}"))
		{
			this.personalCode = personalCode;
		}
		else 
		{
			this.personalCode = "unknown";
		}
	}
	
	
	public Person()
	{
		setName("TestName");
		setSurname("TestSurname");
		setPersonalCode("TestCode");
	}
	
	public Person(String name, String surname, String personalCode)
	{
		setName(name);
		setSurname(surname);
		setPersonalCode(personalCode);
	}
	
	
	@Override
	public String toString() {
		return "Name- " + name + ", surname= " + surname + ", personal code " + personalCode;
	}
	
	
	
	
}
