package TutorialNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	
	@Test
	public void verifyRegisterAccountWithAllFields() throws InterruptedException{

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Hammeer");
		driver.findElement(By.id("input-lastname")).sendKeys("Yami");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.name("telephone")).sendKeys("67543356");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		String expectedProperDetailsSix = "contact us";

		String actualProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne)); 
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo)); 
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree)); 
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour)); 
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive)); 
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix)); 

		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

		driver.quit();
	}	
	
	public static String generateNewEmail() {
	
			return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	    	
		}

}
