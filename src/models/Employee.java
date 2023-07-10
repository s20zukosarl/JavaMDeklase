package models;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {

	private int employeeId;
	private static int idCounter = 0;
	
	private LocalDate contractDate = LocalDate.of(2021, 3, 24);
	
	private String contractNumber;
	
	// get funkcijas
	
	public int getEmployeeId() {
		return employeeId;
	}
	public LocalDate getContractDate() {
		return contractDate;
	}
	
	public int getYear()
	{
		return contractDate.getYear();
	}
	
	public String getContractNumber() {
		return contractNumber;
	}
	
	// set funkcijas
	
	public void setEmployeeId() {
	
		this.employeeId = idCounter;
		idCounter++;
	}
	
	public void setContractDate(LocalDate date) { 
		
		
	
		if (date != null && date.isAfter(contractDate))
		{
			this.contractDate = date;
		}
		else
		{
			contractDate = LocalDate.of(2022, 3, 24);
		}
	}
	
	public void setContractNumber(String contractNumber) { 
		
		int i = getEmployeeId();
		char str = getName().charAt(0);
		char str1 = getSurname().charAt(0);
		String contrNumber = getYear() + "_" + i + "_" + str + "_" + str1;
		
		this.contractNumber = contrNumber;
		
	}
	
	public Employee()
	{
		super();
		setEmployeeId();
		setContractDate(null); 
		setContractNumber("test");
	}
	
	public Employee(String name, String surname, String personalCode, LocalDate contractDate)
	{
		super(name, surname, personalCode);
		setEmployeeId();
		setContractDate(contractDate);
		setContractNumber(contractNumber);
	}
	
	public String toString() {
		return " " + employeeId + " " + super.toString() + " " + "contract date " + contractDate + " contract number " + contractNumber ;
	}
	
	
	
	
}
