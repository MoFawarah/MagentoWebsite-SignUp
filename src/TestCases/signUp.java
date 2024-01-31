package TestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class signUp extends parameters {

	@BeforeTest()
	public void Setup() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1, enabled = true)
	public void Sign_Up() {
		driver.get(URL);
		WebElement Sign_Up_Link = driver.findElement(By.linkText("Create an Account"));
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

		WebElement Welcome_Msg = driver.findElement(By.className("message-success"));
		String Actual_Result = Welcome_Msg.getText();

		assertEquals(Actual_Result, "Thank you for registering with Main Website Store.");

	}

	@Test(priority = 2, enabled = true)
	public void Logout_Process() {

		driver.get(Logout_Link);

		String current_Url = driver.getCurrentUrl();
		Boolean Actual_Result = current_Url.contains("logoutSuccess");

		Boolean Expected_Result = true;

		assertEquals(Actual_Result, Expected_Result);

	}

	@Test(priority = 3, enabled = true)
	public void Login_Process() throws InterruptedException {

		WebElement SignIn_Link = driver.findElement(By.linkText("Sign In"));
		SignIn_Link.click();

		Sign_In_Email = driver.findElement(By.id("email"));
		Sign_In_Password = driver.findElement(By.id("pass"));
		Sign_In_Button = driver.findElement(By.id("send2"));

		Sign_In_Email.sendKeys(Email_Account);
		Sign_In_Password.sendKeys(Common_Password);
		Sign_In_Button.click();

		Thread.sleep(3000);
		String Greeting_Msg = driver.findElement(By.cssSelector(".greet.welcome")).getText();

		boolean Actual_Result = Greeting_Msg.contains("Welcome");

		assertEquals(Actual_Result, true);

	}

	@Test(priority = 5, enabled = true)
	public void Adding_One_Item_To_Cart() throws InterruptedException {
		driver.get(Back_To_Home_Page_Link);
		WebElement Items_Container = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));

		List<WebElement> Items_In_Ol = Items_Container.findElements(By.tagName("li"));

		int Random_Item = rand.nextInt(4);
		Items_In_Ol.get(Random_Item).click();

		// Selecting a random size:
		WebElement Size_Container = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		List<WebElement> Sizes_Buttons = Size_Container.findElements(By.className("swatch-option"));

		int Num_Of_Sizes_Buttons = Sizes_Buttons.size();

		int Random_Size_Selection = rand.nextInt(Num_Of_Sizes_Buttons);

		Sizes_Buttons.get(Random_Size_Selection).click();

		// Selecting a random color:
		WebElement Color_Container = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		List<WebElement> Colors_Buttons = Color_Container.findElements(By.className("swatch-option"));

		int Num_Of_Color_Buttons = Colors_Buttons.size();

		int Random_Color_Selection = rand.nextInt(Num_Of_Color_Buttons);

		Colors_Buttons.get(Random_Color_Selection).click();

		// Adding a Random Quantity
		WebElement Quantity_Container = driver.findElement(By.cssSelector(".field.qty"));
		WebElement Quantity_Input_Field = Quantity_Container.findElement(By.cssSelector(".input-text.qty"));
		Quantity_Input_Field.clear();

		int Random_Quantity = rand.nextInt(10001);
		String Random_Quantity_String = Integer.toString(Random_Quantity);
		Quantity_Input_Field.sendKeys(Random_Quantity_String);

		WebElement Checkout = driver.findElement(By.id("product-addtocart-button"));
		Checkout.click();
		
		Thread.sleep(4000);
		String Adding_To_Cart_Msg = driver.findElement(By.className("message-success")).getText();
		
		
		Boolean Actual_Result = Adding_To_Cart_Msg.contains("You added");
		Boolean Expected_Result = true;

		assertEquals(Actual_Result, Expected_Result);
	}

	@Test(priority = 6, enabled = true)
	public void Checking_Reviews_From_Checkout_Page() {

		WebElement Add_Your_Review_Link = driver.findElement(By.cssSelector(".action.add"));
		Add_Your_Review_Link.click();

		
		Boolean Actual_Result = Add_Your_Review_Link.getText().toLowerCase().contains("review");

		Boolean Expected_Result = true;

		assertEquals(Actual_Result, Expected_Result);

	}

}
