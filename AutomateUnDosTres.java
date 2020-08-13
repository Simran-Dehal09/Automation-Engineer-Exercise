package website_Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomateUnDosTres {
	
	WebDriver driver;

	// Invoke the browser
	public void invokeBrowser() {
		System.out.println("Invoking browser");

		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\admin\\Desktop\\Python\\Selenium\\selenium-java-3.141.59\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			// navigating to UnDrosTres website
			driver.get("http://prueba.undostres.com.mx");
			PopulateFieldsOnTheFirstPage();			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    // Popultate the values on the first page of website
	private void PopulateFieldsOnTheFirstPage() {
		
		try {		
		
		Thread.sleep(5000);
		
		//Check if 'Recarga Celular' is visible
		boolean visibilityOfElement = driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/h1")).isDisplayed();
		
		if(visibilityOfElement) {
			
			Thread.sleep(3000);
		
			//Finding and then clicking on operador
			WebElement operador = driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/label"));
			Actions actions = new Actions(driver);
			actions.moveToElement(operador).click().perform();
		
			Thread.sleep(3000);
			
			//Selecting TelCel from the list of operador
			driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/div/ul/li[1]/a/div/b")).click();
		
			Thread.sleep(3000);
			
			//Finding and inserting value under numero de celluar field
			
			WebElement numeroDeCellular = driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[2]/div/div/input"));
		    numeroDeCellular.sendKeys("5523261151");
		    
		    Thread.sleep(3000);
		    
		    //Finding and then clicking on monte de recharga
		    
		    WebElement montaDeRecarga = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/form/div/div[1]/div[1]/div[2]/ul/li[3]/div/div/input"));
		    actions.moveToElement(montaDeRecarga).click().perform();
		    
		    Thread.sleep(3000);
		    
		    //select 10 dollar under  monte de recharga
		    
		    driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[3]/div/div/div/ul[1]/li[1]/a/div[2]")).click();
		    
		    Thread.sleep(3000);
		    
		    //click on siguiente
		    
		    driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[3]/div/button")).click();
		    
		    PopulateFieldsOnTheSecondPage();
		    
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

   //Populate the fields on the second page of the website
	
	private void PopulateFieldsOnTheSecondPage() {
		
		//getting the title of the current page
		String currentPageTitle= driver.getTitle();
		
		//Closing the browser if 'payments' page is not getting opened
		if(!currentPageTitle.equalsIgnoreCase("Payment")) {
			
			System.out.println("Not getting redirected to payments page");
			driver.close();
		}
		
	}

	public static void main(String[] args) {

		AutomateUnDosTres automateUndrosTres = new AutomateUnDosTres();
		automateUndrosTres.invokeBrowser();

	}

}



