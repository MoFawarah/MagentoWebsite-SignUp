package TestCases;

import java.util.Random;

public class parameters {
	
	Random rand = new Random();

	String [] First_Names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};
	String [] Last_Names = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	
	String Common_Password = "Test@#123";
	
	int Random_Index = rand.nextInt(First_Names.length);
	int Random_Email_Id = rand.nextInt(9999);
	
	String Email_Account = First_Names[Random_Index] + Last_Names[Random_Index] + Random_Email_Id + "@gmail.com";
	
}
