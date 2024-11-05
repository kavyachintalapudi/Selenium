package testNG_Programs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Handling_Alerts_Or_Popups {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
  @Test
  public void verifyAlerts() {
	  action.sendKeys(Keys.PAGE_DOWN).build().perform();
	  driver.findElement(By.id("alertButton")).click();
	  String text = driver.switchTo().alert().getText();
	  System.out.println("TEXT1:"+text);
	  driver.switchTo().alert().accept();
	  driver.findElement(By.id("timerAlertButton")).click();
	  text = driver.switchTo().alert().getText();
	  System.out.println("TEXT2:"+text);
	  driver.switchTo().alert().accept();
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.get("https://demoqa.com/alerts");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	  action = new Actions(driver);
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
