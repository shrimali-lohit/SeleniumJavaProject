package TutorialNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_RF_001 {
    
	@Test
	public void verifyRegisteringWithMandatoryFields(){
		
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

		String ExpectedConfirmationMessage = "Your Account Has Been Created!";
		String ExpectectedSecondConfirmationMesage = "Congratulations! Your new account has been successfully created!";
        String ExpectedThirdConfirmationMessage = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String ExpectedFourthConfirmationMessage = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String ExpectedFifthConfirmationMessage = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		
        String ActualConfirmationMessage = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        String ActualSecondConfirmationMessage = driver.findElement(By.xpath("//div[@id='content']/p[text()='Congratulations! Your new account has been successfully created!']")).getText();
        String ActualThirdConfirmationMessage = driver.findElement(By.xpath("//div[@id='content']/p[text()='You can now take advantage of member privileges to enhance your online shopping experience with us.']")).getText();
        String ActualFourthConfirmationMessage = driver.findElement(By.xpath("//div[@id='content']/p[text()='If you have ANY questions about the operation of this online shop, please e-mail the store owner.']")).getText();
        String ActualFifthConfirmationMessage = driver.findElement(By.xpath("//div[@id='content']/p[text()='A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ']")).getText();

        Assert.assertTrue(ExpectedConfirmationMessage.contains(ActualConfirmationMessage));
        Assert.assertTrue(ExpectectedSecondConfirmationMesage.contains(ActualSecondConfirmationMessage));
        Assert.assertTrue(ExpectedThirdConfirmationMessage.contains(ActualThirdConfirmationMessage));
        Assert.assertTrue(ExpectedFourthConfirmationMessage.contains(ActualFourthConfirmationMessage));
        Assert.assertTrue(ExpectedFifthConfirmationMessage.contains(ActualFifthConfirmationMessage));	
		
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        
        driver.quit();
	}
	
	public static String generateNewEmail() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	}

}
