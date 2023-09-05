import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fb_Login 
{
	
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	@Test(priority=1)
	public void TC_FB()
	{
		WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));
		Email.sendKeys("rajputvinay99@gmail.com");
		
		
		WebElement PassWord = driver.findElement(By.xpath("//input[@id='pass']"));
		PassWord.sendKeys("@1nothing");
		
		WebElement Login = driver.findElement(By.xpath("//button[@id='loginbutton']"));
		Login.click();
	}
	@Test(priority=2)
	public void VerifiedTitle()
	{
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="(3) Facebook";
		if(ActualTitle.equals(ExpectedTitle))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
	}
	
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
