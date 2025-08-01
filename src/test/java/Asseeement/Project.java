package Asseeement;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Project {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        
        String TRELLO_EMAIL="danish.syed.husain@gmail.com";
        String TRELLO_PASSWORD="Zxcv@1234";
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
        driver.get("https://trello.com");
        
        driver.findElement(By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']")).click();
        
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//input[@id=\"username-uid1\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"username-uid1\"]")).sendKeys(TRELLO_EMAIL);
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(TRELLO_PASSWORD);
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//span[text()='Log in']")).click();
        
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//p[text()='Create']")).click();
        
        driver.findElement(By.xpath("//span[text()='Create board']")).click();
	
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("QA Scrum Board - UI - 08/01/2025");
        Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@type='button'  and text()='Create']")).click();
	    Thread.sleep(2000);
	    
	    WebElement entertxtelement=driver.findElement(By.xpath("//textarea[@placeholder=\"Enter list name…\"]"));
	    WebElement clickelement=driver.findElement(By.xpath("//button[text()='Add list']"));
	    entertxtelement.sendKeys("To Do");
	    driver.findElement(By.xpath("//button[text()='Add list']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//textarea[@placeholder=\"Enter list name…\"]")).sendKeys("In Progress");
	    driver.findElement(By.xpath("//button[text()='Add list']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//textarea[@placeholder=\"Enter list name…\"]")).sendKeys("Done");
	    driver.findElement(By.xpath("//button[text()='Add list']")).click();
	    Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
        Thread.sleep(2000);
        
        
	    driver.findElement(By.xpath("//button[@aria-label='Add a card in To Do']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//textarea[@placeholder=\"Enter a title or paste a link\"]")).sendKeys("Test Plan");
	    
	    WebElement linkAddtocart=driver.findElement(By.xpath("//button[text()='Add card']"));
	    linkAddtocart.click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
	    
	    Actions ac=new Actions(driver);
	    ac.moveToElement(driver.findElement(By.xpath("//a[@data-testid=\"card-name\"]"))).perform();
	 
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[@aria-label=\"Edit card\"]")).click();
	    driver.findElement(By.xpath("//button[normalize-space()='Change cover']")).click();
	    driver.findElement(By.xpath("//button[@aria-label=\"red\"]")).click();
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	    
	    driver.findElement(By.xpath("//a[@data-testid=\"card-name\"]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[normalize-space()='Labels']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[@aria-label='Color: orange, title: none']")).click();
	    driver.findElement(By.xpath("//button[@aria-label=\"Close popover\"]//span")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[normalize-space()='Attachment']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//label[text()='Choose a file']")).click();  // sendKeys("file:///C:/Movie/MyImage.jpg");
	   
	    StringSelection selection = new StringSelection("file:///C:/Movie/MyImage.jpg");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	    Robot robot = new Robot();
	    robot.delay(2000);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    
	    
	    Thread.sleep(5000);
	    String actualmsg=driver.findElement(By.xpath("//span[@class='VmbXKMJLSqfD0U']")).getText();
	
	    if(actualmsg.equalsIgnoreCase("success"))
	    {  Thread.sleep(2000);
	    	System.out.println("Uploaded Successfully............");
	    }
	    
	   driver.findElement(By.xpath("//span[@data-testid='CloseIcon']")).click();
	   Thread.sleep(2000);
	  WebElement source= driver.findElement(By.xpath("//a[@data-testid='card-name']"));
	  WebElement target= driver.findElement(By.xpath("//button[@aria-label='Add a card in In Progress']"));
	  Thread.sleep(2000);
	  ac.dragAndDrop(source, target).perform();
	  WebElement source2=driver.findElement(By.xpath("//a[@data-testid='card-name']"));
	  WebElement target2=driver.findElement(By.xpath("//button[@aria-label='Add a card in Done']"));
	  Thread.sleep(2000);
	  ac.dragAndDrop(source2, target2).perform();
	  
	  driver.quit();
	}

}
