package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Firsttest {
	public WebDriver driver;
  
	
	@Test(priority=1)
  public void openApp() {
		driver.get("https://www.amazon.ca/");
	   }
	
	@Test(priority=2)
	public void hoverEffect() throws InterruptedException {
		WebElement hover=driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"));
		Actions builder=new Actions(driver); 
		builder.moveToElement(hover).build().perform();
		
		Thread.sleep(1000);
		}
	
	@Test(priority=3)
	public void signClick() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]"))).click();
		//WebElement signInbutton=driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]"));
		
	}
	
	@Test(priority=4)
	public void signInPage() {
		driver.navigate().to("https://www.amazon.ca/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=caflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3Fref_%3Dnav_signin&switch_account=");
	}
	
	@Test(priority=5)
	public void signIn() throws InterruptedException {
		WebElement username=driver.findElement(By.cssSelector("#ap_email"));
		username.sendKeys("patelmira2411@gmail.com");
		
		WebElement password=driver.findElement(By.cssSelector("#ap_password"));
		password.sendKeys("Mira@231665");
		
		
		WebElement signInbutton2=driver.findElement(By.cssSelector("#signInSubmit"));
		signInbutton2.submit();
		Thread.sleep(1000);
		}
	
	@Test(priority=6)
	public void title(){
		driver.navigate().to("https://www.amazon.ca/gp/yourstore/home?ie=UTF8&action=sign-out&path=%2Fgp%2Fyourstore%2Fhome&ref_=nav_youraccount_signout&signIn=1&useRedirectOnSuccess=1&");
		
		String actualtitle=driver.getTitle();
		String Expectedtitle="Your Amazon.ca";
		
		Assert.assertEquals(actualtitle, Expectedtitle);
		System.out.println("login Successfullt");
		
		
		
		}
	
	@Test(priority=7)
	public void selectGiftcard() {
	
		WebElement giftcard=driver.findElement(By.xpath("//a[@class='nav-a'][contains(text(),'Gift Cards')]"));
		giftcard.click();
	}
	
	@Test(priority=8)
	public void checkBoxlist() {
		List<WebElement> options=driver.findElements(By.xpath("//div[@id='leftNav']//ul[3]//div[1]"));
		System.out.println(options.size());
		
		for(WebElement a:options) {
			System.out.println(a.getText());
			/*String text="Father's Day";
			Assert.assertEquals(a.getText(), text);
			a.click();*/
			
			WebElement Fathersday=driver.findElement(By.xpath("//span[contains(text(),\"Father's Day\")]"));
			Fathersday.click();
			
		}
		
	}


@BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\Ronak Patel\\Desktop\\Mira\\SeleniumJars\\geckodriver.exe");
	  driver=new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
