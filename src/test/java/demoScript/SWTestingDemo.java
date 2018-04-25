package demoScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SWTestingDemo {
   public static WebDriver driver;
   
   @Test  
   public static void main(String[] args) throws Exception {
   System.setProperty("webdriver.gecko.driver","C:/Users/Me/Downloads/geckodriver-v0.20.1-win64/geckodriver.exe");
   DesiredCapabilities capabilities = DesiredCapabilities.firefox();
   capabilities.setCapability("marionette", true);
   driver=new FirefoxDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
   driver.navigate().refresh();      
   //Once you got the select object initialized then you can access all the methods of select class. 
   //Identify the select HTML element:
   Thread.sleep(5000);   
           
   //Selecting a value from Multi-Select box
   WebElement multiSelectElement = driver.findElement(By.name("multipleselect[]"));
   //WebElement multiSelectElement = driver.findElement(By.cssSelector("select.spTextField"));
   
   Select multiselect= new Select(multiSelectElement);
   multiselect.selectByVisibleText("Selenium");
   /*java.util.List<WebElement> options = multiselect.getOptions();
   for (WebElement option : options) {
   System.out.println(option.getText()); 
   if (option.getText()=="Selenium") {	   
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
	   executor.executeScript("arguments[0].click();", option);	      
	   }
   }*/
   
   Thread.sleep(5000);
   /*WebElement option = multiselect.getFirstSelectedOption();
   System.out.println(option.getText());*/
   
   WebElement mySelectElement = driver.findElement(By.name("dropdown"));
   JavascriptExecutor executor = (JavascriptExecutor)driver;
   executor.executeScript("arguments[0].click();", mySelectElement);
   mySelectElement.sendKeys(Keys.ESCAPE);
   Select dropdown= new Select(mySelectElement);
   //To select an option - selectByVisibleText, selectByIndex, selectByValue
   //selectByVisibleText
   dropdown.selectByVisibleText("Automation Testing");
   
   executor.executeScript("window.scrollBy(0,200)");
      
   Thread.sleep(5000);
   driver.quit();
   }
   
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
