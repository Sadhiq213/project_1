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
	
	
	 WebDriver driver;
	 WebDriverWait wait; 
	 @BeforeMethod
	public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, 10); 
	        driver.get("https://www.saucedemo.com/v1/inventory.html");
	    }
	 
	
	 
	 
	 //click on twitter icon
	 @Test
	 public void socialmedia_twitter() {
		 driver.findElement(By.className("social_twitter")).click();
		 String str = "https://x.com/saucelabs/status/1727284310397653081";
		 String currenturl = driver.getCurrentUrl();
		 if(str.equals(currenturl)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
		 
	 }
	 
	//click on facebook icon
	 @Test
	 public void socialmedia_facebook() {
		 driver.findElement(By.className("social_facebook")).click();
		 String str = "https://www.facebook.com/saucelabs/";
		 String currenturl = driver.getCurrentUrl();
		 if(str.equals(currenturl)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
		 
	 }
	 
	//click on linkedin icon
	 @Test
	 public void socialmedia_linkedin() {
		 driver.findElement(By.className("social_linkedin")).click();
		 String str = "https://www.linkedin.com/company/sauce-labs/";
		 String currenturl = driver.getCurrentUrl();
		 if(str.equals(currenturl)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
		 
	 }
	 
	 //click on reset app state
	 @Test
	 public void menu4() {
		 driver.findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
		 driver.findElement(By.id("reset_sidebar_link")).click();
		 String str1 = "https://www.saucedemo.com/v1/index.html";
		 String current = driver.getCurrentUrl();
		 if(str1.equals(current)) {
			 System.out.println("Test case passed");
		 }else {
			 System.out.println("Test case failed");
		 }
	 }
		 
		//click on Logout
		 @Test
		 public void menu3() {
			 driver.findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
			 driver.findElement(By.id("logout_sidebar_link")).click();
			 String str1 = "https://www.saucedemo.com/v1/";
			 String current = driver.getCurrentUrl();
			 if(str1.equals(current)) {
				 System.out.println("Test case passed");
			 }else {
				 System.out.println("Test case failed");
			 }
		 
	 }
		 
		 
			//click on all items
		 @Test
		 public void menu1() {
			 driver.findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
			 driver.findElement(By.id("inventory_sidebar_link")).click();
			 String str1 = "https://www.saucedemo.com/v1/inventory.html";
			 String current = driver.getCurrentUrl();
			 if(str1.equals(current)) {
				 System.out.println("Test case passed");
			 }else {
				 System.out.println("Test case failed");
			 }
		 
	 }
	 
		 
		 
		//click on about
		 @Test
		 public void menu2() {
			 driver.findElement(By.xpath("//button[normalize-space(text())='Open Menu']")).click();
			 driver.findElement(By.id("about_sidebar_link")).click();
			 String str1 = "https://saucelabs.com/";
			 String current = driver.getCurrentUrl();
			 if(str1.equals(current)) {
				 System.out.println("Test case passed");
			 }else {
				 System.out.println("Test case failed");
			 }
		 
	 }
	 
	 //Selecting Z to A in the filter
		 @Test
		 public void filter() {
			 WebElement ele = driver.findElement(By.className("product_sort_container"));
			 Select box = new Select(ele);
			 box.selectByVisibleText("Name (A to Z)");
			 box.selectByVisibleText("Name (Z to A)");
			 WebElement selected = box.getFirstSelectedOption();
			 System.out.println(selected.getText());
			
			 
		 }
		 
		//Selecting low to high in the filter
		 @Test
		 public void filter2() {
			 WebElement ele = driver.findElement(By.className("product_sort_container"));
			 Select box = new Select(ele);
			 box.selectByVisibleText("Price (low to high)");
			 WebElement selected = box.getFirstSelectedOption();
			 System.out.println(selected.getText());
			
			 
		 }
		 
		 
		//Selecting high to low in the filter
		 @Test
		 public void filter3() {
			 WebElement ele = driver.findElement(By.className("product_sort_container"));
			 Select box = new Select(ele);
			 box.selectByVisibleText("Price (high to low)");
			 WebElement selected = box.getFirstSelectedOption();
			 System.out.println(selected.getText());
			
			 
		 }
	
		 
	// checking that cart is getting added the products	 
	 @Test
	 public void add_product_to_cart() {
	     driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]")).click();
	     driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[2]")).click();
	     driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[3]")).click();

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
	        driver.quit();
	    }
}
