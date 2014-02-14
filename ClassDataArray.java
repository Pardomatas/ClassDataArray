// classdataarray.java
// data items as class objects

import java.io.*;
////////////////////////////////////////////////////////
class Person
{
	private String lastName;
	private String firstName;
	private int age;
	private double gpa;
	//-----------------------------------------------------------------
	public Person(String last, String first, int a, double b)
	{
		lastName = last;
		firstName = first;
		age = a;
		gpa = b;
	}
	//-------------------------------------------------------------------
	public void displayPerson()
	{
		System.out.print("  Last name: " + lastName);
		System.out.print(", First name: " + firstName);
		System.out.print(", Age: " + age);
		System.out.print(", GPA: " + gpa);
	}
	//---------------------------------------------------------------------
	public String getLast()
	{ return lastName; }
	
	public double getAge()
	{ return age; }
	
	public double getGPA()
	{ return gpa; }
}
///////////////////////////////////////////////////////////////////////////////
class ClassDataArray
{
	private Person[] a;
	private int nElems;
	//----------------------------------------------------------------------
	public ClassDataArray(int max)
	{
		a = new Person[max];
		nElems = 0;
	}
	//----------------------------------------------------------------------------
	public Person find(String searchName)
	{
		int j;
		for(j=0; j<nElems; j++)
			if( a[j].getLast().equals(searchName) )
				break;
		if(j == nElems)
			return null;
		else
			return a[j];
	}
	//-----------------------------------------------------------------------------------
	public void insert(String last, String first, int age, double gpa)
	{
		a[nElems] = new Person(last, first, age, gpa);
		nElems++;
	}
	//-------------------------------------------------------------------------------------
	public boolean delete(String searchName)
	{
		int j;
		for(j = 0; j<nElems; j++)
			if( a[j].getLast().equals(searchName))
				break;
		if (j == nElems)
			return false;
		else
			{
			for(int k=j; k<nElems; k++)
				a[k] = a[k+1];
			nElems--;
			return true;
			}
		}
	//-----------------------------------------------------------------------------------------
	public void displayA()
	{
		for(int j = 0; j<nElems; j++)
			a[j].displayPerson();
	}
	//----------------------------------------------------------------------------------------------
	public double average()
	{
		double sum = 0;
		int i;
		double average = 0;
		for(i = 0; i<nElems; i++)
			sum = sum + a[i].getAge();
		if (i == nElems)
			average = sum/nElems;
		System.out.println(" Average age: " + average);
		return average;
	}
	
	public void sortGPA() {
	    boolean swapped = true;
	    int j = 0;
	    Person tmp;
	    while (swapped) {
	        swapped = false;
	        j++;
	        for (int i = 0; i < nElems - j; i++) {
	            if (a[i].getGPA() < a[i+1].getGPA()) {
	                tmp = a[i];
	                a[i] = a[i+1];
	                a[i+1] = tmp;
	                swapped = true;
	            }
	        }
	    }
	    System.out.print("Sorted GPA's: ");
	    for(int i = 0; i<nElems; i++)
			System.out.print(a[i].getGPA() + ", ");
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////
class ClassDataApp
{
	public static void main(String[] args)
	{
	int maxSize = 100;
	ClassDataArray arr;
	arr = new ClassDataArray(maxSize);
	
	arr.insert("Evans", "Patty", 24, 3.21);
	arr.insert("Smith", "Lorraine", 37, 2.34);
	arr.insert("Yee", "Tom", 43, 1.34);
	arr.insert("Adams", "Henry", 63, 2.65);
	arr.insert("Hashimoto", "Sato", 21, 3.00);
	arr.insert("Stimson", "Henry", 29, 2.00);
	arr.insert("Velasquez", "Jose", 72, 1.00);
	arr.insert("Lamarque", "Henry", 54, 3.23);
	arr.insert("Vang", "Minh", 22, 3.76);
	arr.insert("Creswell", "Lucinda", 18, 1.65);
	arr.insert("Wilson", "Mychal", 21, 4.00);
	
	arr.displayA();
	
	String searchKey = "Stimson";
	Person found;
	found = arr.find(searchKey);
	if (found != null)
	{
		System.out.print("Found ");
		found.displayPerson();
	}
	else
		System.out.println("Can't find " + searchKey);
	
	System.out.println("Deleting Smith, Yee, and Careswell");
	arr.delete("Smith");
	arr.delete("Yee");
	arr.delete("Creswell");
	
	arr.displayA();
	arr.average();
	arr.sortGPA();
	}
}