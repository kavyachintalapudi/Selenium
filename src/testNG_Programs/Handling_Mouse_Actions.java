package testNG_Programs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Handling_Mouse_Actions {
	WebDriver driver;
	Actions action;
  @Test(priority = 1)
  public void verifyDraggable() {
	  driver.findElement(By.linkText("Draggable")).click();
	  driver.switchTo().frame(0);
	  action.clickAndHold(driver.findElement(By.id("draggable"))).build().perform();
	  action.release().build().perform();
	  driver.switchTo().defaultContent();
  }
  @Test(priority = 2)
  public void verifyDroppable()
  {
	  driver.findElement(By.linkText("Droppable")).click();
	  driver.switchTo().frame(0);
	  action.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
	  action.release().build().perform();
	  driver.switchTo().defaultContent();
  }
  @Test(priority = 3)
  public void verifySortable() throws Exception {
	  driver.findElement(By.linkText("Sortable")).click();
	  driver.switchTo().frame(0);
	  action.clickAndHold(driver.findElement(By.xpath("//li[text()='Item 2']"))).build().perform();
	  Thread.sleep(500);
	  action.moveToElement(driver.findElement(By.xpath("//li[text()='Item 7']"))).build().perform();
	  action.release().build().perform();
	  driver.switchTo().defaultContent();
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.get("https://jqueryui.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  action = new Actions(driver);
	  System.out.println(driver.getCurrentUrl());
  }
  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  driver.findElement(By.xpath("//li[@class=\"ui-state-default ui-sortable-handle\"]")).click();
	  driver.findElement(By.xpath("//li[@class=\"ui-state-default ui-sortable-handle\"]")).click();
	  driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-arrowthick-2-n-s\"]")).click();
	  action.dragAndDrop(driver.findElement(By.xpath("//li[@class=\\\"ui-state-default ui-sortable-handle\\\"]")),driver.findElement(By.xpath("\"//span[@class=\\\"ui-icon ui-icon-arrowthick-2-n-s\\\"]\""))).build().perform();

	  driver.navigate();
	  driver.navigate().back();
	  driver.navigate().refresh();
	  driver.navigate().forward();
	  driver.close();
	  
	  
	  
  }
  

}
