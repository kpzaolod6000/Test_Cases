# Pruebas Funcionales y xUnit

Trabajo de automatizar pruebas funcionales de aplicaciones web utilizando Selenium Web Driver y JUnit, usando Eclipse IDE 2020-09 en Linux Ubuntu 18.04.5 LTS

## Pre-requisitos:
+ Java 8+
+ Eclipse IDE, Se instalo siguiendo la guia del siguiente link https://www.eclipse.org/downloads/packages/release/mars/r/eclipse-ide-java-ee-developers
+ Selenium Web Driver,Para crear scripts que interactúen con Selenium Server o crear scripts locales de Selenium WebDriver, necesita utilizar controladores de cliente específicos de un lenguaje. En este caso se uso el lenguaje java y se descargo del siguiente link: https://www.selenium.dev/downloads/
![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/unit.png)
+ Geckodriver,El ejecutador se descargo del siguiente link: https://github.com/mozilla/geckodriver/releases
![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/unit1.png)
+ Configurar GeckoDriver: Se utilzo http://toolsqa.com/selenium-webdriver/how-to-use-geckodriver/

## Actividades:

Se implemento Casos de prueba en base a https://www.tutorialspoint.com/selenium/selenium_webdriver.htm: 

+ Primero se procedio a crear un Proyecto de tipo java
![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java5.png)
+ Se procede a referenciar las librerias necesarias:
  __Librerias de Selenium Web Driver
    ![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java3.png)
  
  __Librerias de Junit
    ![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java4.png)
+ Librerias referenciadas	
![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java2.png)
    
+ Se crea la clase WebDriverDemo.java
  ![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java5.png)

+Se implementa el scripts del tutorial seguido con algunas variaciones como por ejemplo agregar una sola línea de código para configurar las propiedades del sistema para GeckoDriver para enlazar las pruebas de Selenium con el navegador Firefox.
```java
  public class WebDriverDemo{
	public void TestSelenium(){
		
    //link
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
	      
	      driver.close();
	}
	

	public static void main(String[] args){
		WebDriverDemo demo = new WebDriverDemo();
		demo.TestSelenium();
	
	}
```
+ Integrar xUnit: 
La integracion ya se realizo anteriormente agreagando las librerias referenciadas al proyecto
En este caso se procedio a modificar el scripts de la siguiente manera

```java
public class WebDriverDemo{
	public int rpta;
	@Before
	public void TestSelenium(){
		
		//link
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

	}
	
	@Test
	public void Testing() {
		assertEquals(50,rpta);
		
	}
}

```

## Resultados
+ Figura de la ejecucion del proyecto en modo JUnit Test
  ![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java8.png)
+ Ventana del navegador firefox
  ![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java9.png)
+ Finalmente los resultados en la izquierda se verifica que la prueba realizada del valor esperado con el resultado son iguales por lo tanto no registra ningun error
  ![HI](https://github.com/kpzaolod6000/Test_Cases/blob/master/image/java10.png)
