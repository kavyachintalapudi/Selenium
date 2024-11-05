package testNG_Programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingFrames {
	WebDriver driver;
	@Test
	public void verifyFrames()
	{
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		driver.switchTo().frame(0);
		String text = driver.findElement(By.xpath("//div[@id='draggable']/p")).getText();
		System.out.println("TEXT:"+text);
		driver.switchTo().parentFrame();
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		text = driver.findElement(By.xpath("//div[@id='draggable']/p")).getText();
		System.out.println("TEXT:"+text);
		driver.switchTo().parentFrame();

	
	}
	@BeforeTest
	public void beforeTest()
	{
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	@AfterTest
	public void afterTest()
	{
		
	}

}
