/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tatoc_basic;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Tatoc_basic {

	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.cssSelector("a")).click();
		driver.findElement(By.className("greenbox")).click();
		driver.switchTo().frame("main");
		WebElement we=driver.findElement(By.id("answer"));
		String box1= we.getAttribute("class");
		while(true)
		{
		WebElement child= driver.findElement(By.id("child"));
		driver.switchTo().frame(child);
		WebElement we1=driver.findElement(By.id("answer"));
		String box2=we1.getAttribute("class");
	    driver.switchTo().parentFrame();
	    if(!box1.equals(box2))
	    	driver.findElement(By.linkText("Repaint Box 2")).click();
	    driver.findElement(By.linkText("Proceed")).click();	
		WebElement To=driver.findElement(By.cssSelector("#dropbox"));
	    WebElement From =driver.findElement(By.cssSelector("#dragbox"));
	    WebElement To1=driver.findElement(By.cssSelector("#dropbox"));
	    WebElement From1 =driver.findElement(By.cssSelector("#dragbox"));
	    
		Actions act=new Actions(driver);					
		act.dragAndDrop(From1, To1).build().perform();
		
		
		driver.findElement(By.cssSelector("a")).click();
		driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(4)")).click();
		String MainWindow=driver.getWindowHandle();			
	    Set<String> s1=driver.getWindowHandles();		
	    Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                    driver.switchTo().window(ChildWindow);	                                                                                                           
	                    driver.findElement(By.id("name"))
	                    .sendKeys("Neha");                			
	                    
	                    driver.findElement(By.id("submit")).click();			
	                    Thread.sleep(1000);
	            }		
	        }	
	        driver.switchTo().window(MainWindow);
	        driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(6)")).click(); 
	        driver.findElement(By.cssSelector("a")).click();
	        String value=driver.findElement(By.cssSelector("#token")).getText();
	        String [] splt=value.split("\\s"); 
	  		Cookie name = new Cookie("Token", splt[1]);
	  		driver.manage().addCookie(name);
	  		driver.findElement(By.linkText("Proceed")).click();
	  	
			
	    }
		}
	}






