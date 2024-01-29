package TestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class signUp extends parameters {

	// Variables:
	String URL = "https://magento.softwaretestingboard.com/";
	WebElement First_Name;
	WebElement Last_Name;
	WebElement Email;
	WebElement Password;
	WebElement Confirm_Password;
	WebElement Create_Account_Button;

	WebDriver driver = new ChromeDriver();

	@BeforeTest()
	public void Setup() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test
	public void Sign_Up () {
		driver.get(URL);
		WebElement Sign_Up_Link = driver
				.findElement(By.linkText("Create an Account"));
		Sign_Up_Link.click();
		
		First_Name = driver.findElement(By.id("firstname"));
		Last_Name = driver.findElement(By.id("lastname"));
		Email = driver.findElement(By.id("email_address"));
		Password = driver.findElement(By.id("password"));
		Confirm_Password = driver.findElement(By.id("password-confirmation"));
		Create_Account_Button = driver.findElement(By.cssSelector("button[title='Create an Account']"));
		
		First_Name.sendKeys(First_Names[Random_Index]);
		Last_Name.sendKeys(Last_Names[Random_Index]);
		Email.sendKeys(Email_Account);
		Password.sendKeys(Common_Password);
		Confirm_Password.sendKeys(Common_Password);
		
		Create_Account_Button.click();
		
		//Now let's test:
		
		WebElement Welcome_Msg = driver.findElement(By.className("message-success"));
		String Actual_Result = Welcome_Msg.getText();
		
		assertEquals(Actual_Result,"Thank you for registering with Main Website Store.");



	}

}
