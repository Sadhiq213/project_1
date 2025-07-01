package testing_saucedemo_website;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Invertory {
	
 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	 
	 public WebDriver getDriver() {
	        return driver.get();
	    }
	
	
	
	 
	 WebDriverWait wait; 
	 @BeforeMethod
	public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	        WebDriver localDriver = new ChromeDriver();
	        driver.set(localDriver);	     
	        getDriver().get("https://www.saucedemo.com/v1/inventory.html");
	    }
	 
	
	 
	 
	 //click on twitter icon
	 @Test
	 public void socialmedia_twitter() {
		 getDriver().findElement(By.className("social_twitter")).click();
		 String str = "https://x.com/saucelabs/status/1727284310397653081";
		 String currenturl = getDriver().getCurrentUrl();
		 if(str.equals(currenturl)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
		 
	 }
	 
	//click on facebook icon
	 @Test
	 public void socialmedia_facebook() {
		  getDriver().findElement(By.className("social_facebook")).click();
		 String str = "https://www.facebook.com/saucelabs/";
		 String currenturl = getDriver().getCurrentUrl();
		 if(str.equals(currenturl)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
		 
	 }
	 
	//click on linkedin icon
	 @Test
	 public void socialmedia_linkedin() {
		  getDriver().findElement(By.className("social_linkedin")).click();
		 String str = "https://www.linkedin.com/company/sauce-labs/";
		 String currenturl = getDriver().getCurrentUrl();
		 if(str.equals(currenturl)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
		 
	 }
	 
	 //click on reset app state
	 @Test
	 public void menu4() {
		  getDriver().findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
		  getDriver().findElement(By.id("reset_sidebar_link")).click();
		 String str1 = "https://www.saucedemo.com/v1/index.html";
		 String current = getDriver().getCurrentUrl();
		 if(str1.equals(current)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
	 }
		 
		//click on Logout
		 @Test
		 public void menu3() {
			  getDriver().findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
			  getDriver().findElement(By.id("logout_sidebar_link")).click();
			 String str1 = "https://www.saucedemo.com/v1/";
			 String current = getDriver().getCurrentUrl();
			 if(str1.equals(current)) {
				 System.out.println("Test case passed");
			 }else {
				 System.out.println("Test case failed");
			 }
		 
	 }
		 
		 
			//click on all items
		 @Test
		 public void menu1() {
			  getDriver().findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
			  getDriver().findElement(By.id("inventory_sidebar_link")).click();
			 String str1 = "https://www.saucedemo.com/v1/inventory.html";
			 String current = getDriver().getCurrentUrl();
			 if(str1.equals(current)) {
				 System.out.println("Test case passed");
			 }else {
				 System.out.println("Test case failed");
			 }
		 
	 }
	 
		 
		 
		//click on about
		 @Test
		 public void menu2() {
			  getDriver().findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
			  getDriver().findElement(By.id("about_sidebar_link")).click();
			 String str1 = "https://saucelabs.com/";
			 String current = getDriver().getCurrentUrl();
			 if(str1.equals(current)) {
				 System.out.println("Test case passed");
			 }else {
				 System.out.println("Test case failed");
			 }
		 
	 }
	 
	 //Selecting Z to A in the filter
		 @Test
		 public void filter() {
			 WebElement ele =  getDriver().findElement(By.className("product_sort_container"));
			 Select box = new Select(ele);
			 box.selectByVisibleText("Name (A to Z)");
			 box.selectByVisibleText("Name (Z to A)");
			 WebElement selected = box.getFirstSelectedOption();
			 System.out.println(selected.getText());
			
			 
		 }
		 
		//Selecting low to high in the filter
		 @Test
		 public void filter2() {
			 WebElement ele =  getDriver().findElement(By.className("product_sort_container"));
			 Select box = new Select(ele);
			 box.selectByVisibleText("Price (low to high)");
			 WebElement selected = box.getFirstSelectedOption();
			 System.out.println(selected.getText());
			
			 
		 }
		 
		 
		//Selecting high to low in the filter
		 @Test
		 public void filter3() {
			 WebElement ele =  getDriver().findElement(By.className("product_sort_container"));
			 Select box = new Select(ele);
			 box.selectByVisibleText("Price (high to low)");
			 WebElement selected = box.getFirstSelectedOption();
			 System.out.println(selected.getText());
			
			 
		 }
	
		 
	// checking that cart is getting added the products	 
	 @Test
	 public void add_product_to_cart() {
	      getDriver().findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]")).click();
	      getDriver().findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[2]")).click();
	      getDriver().findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[3]")).click();

	      
	      WebDriverWait wait = new WebDriverWait(getDriver(), 10);
	      
	     WebElement cartBadge = wait.until(
	         ExpectedConditions.visibilityOfElementLocated(
	             By.xpath("//a[contains(@class,'shopping_cart_link fa-layers')]")
	         )
	     );

	     int cartCount = Integer.parseInt(cartBadge.getText().trim());

	     if (cartCount == 3) {
	         System.out.println("SUCCESS: Cart badge shows '3'.");
	     } else {
	         System.out.println("FAILURE: Cart badge count is: " + cartCount);
	     }
	 }

	 
	 @AfterMethod
	public void tearDown() {
		 getDriver().quit();
	    }
}
