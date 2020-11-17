package testSelenium;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

//import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WebDriverDemo /*extends TestCase*/{
	public int rpta;
	@Before
	public void TestSelenium(){
		
		System.setProperty("webdriver.gecko.driver", "/home/judal/Escritorio/COMPUTACION/Cursos_2020_II/IS_II/Tasks_Selenium/geckodriver-v0.28.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch website
	      driver.navigate().to("http://www.calculator.net/");
	      
	      //Maximize the browser
	      driver.manage().window().maximize();
	      
	      // Click on Math Calculators
	      driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td[3]/div[2]/a")).click();
	      
	    //*[@id="sciOutPut"]
	      // Click on Percent Calculators
	      driver.findElement(By.xpath("/html/body/div[3]/div[1]/table[2]/tbody/tr/td/div[3]/a")).click();
	      
	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("100");
	      
	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("50");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();

	      // Get the Result Text based on its xpath
	      String result = driver.findElement(By.xpath("/html/body/div[3]/div[1]/p[2]/font/b")).getText();
	      //String result = driver.findElement(By.id("cpar3")).getText();

	      
	      // Print a Log In message to the screen
	      System.out.println(" The Result is " + result);
	      //Close the Browser.	
	     
	      rpta = Integer.parseInt(result);
	      
	      driver.close();
	      
		//return 0;
	}
	
	@Test
	public void Testing() {
		//WebDriverDemo demo = new WebDriverDemo();
		assertEquals(50,rpta);
		
	}

}
