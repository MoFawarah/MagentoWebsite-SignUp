package TestCases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {

	// Variables:
	String URL = "https://magento.softwaretestingboard.com/";
	WebElement First_Name;
	WebElement Last_Name;
	WebElement Email;
	WebElement Password;
	WebElement Confirm_Password;
	WebElement Create_Account_Button;

	WebDriver driver = new ChromeDriver();

	Random rand = new Random();

	String[] First_Names = { "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack" };
	String[] Last_Names = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore",
			"Taylor" };

	String Common_Password = "Test@#123";

	int Random_Index = rand.nextInt(First_Names.length);
	int Random_Email_Id = rand.nextInt(9999);

	String Email_Account = First_Names[Random_Index] + Last_Names[Random_Index] + Random_Email_Id + "@gmail.com";

	String Logout_Link = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String SignIn_Link = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";

	WebElement Sign_In_Email;
	WebElement Sign_In_Password;
	WebElement Sign_In_Button;
	String Back_To_Home_Page_Link = "https://magento.softwaretestingboard.com/";

}
