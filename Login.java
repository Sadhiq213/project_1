
package testing_saucedemo_website;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	 
	 public WebDriver getDriver() {
	        return driver.get();
	    }
	 

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver localDriver = new ChromeDriver();
        driver.set(localDriver);
        getDriver().get("https://www.saucedemo.com/v1/");
    }
    
 // Assertion: Check if login was successful by verifying the presence of products page
    
    public void verifyloginsuccess() {
    	boolean isProductsDisplayed = getDriver().getPageSource().contains("Products");
    	assertTrue(isProductsDisplayed, "Login failed or Products page not loaded");
    	
    }

    
    //test cases 1 for valid input
    @Test
    public void testValidLogin() {
    	getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
    	getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
    	getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
        
    }
    
  //test cases 2 for valid input this test case is failed but actually have to pass
    @Test
    public void testValidLogin1() {
    	getDriver().findElement(By.id("user-name")).sendKeys("locked_out_user");
    	getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
    	getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
    }
    
    
    
  //test cases 3 for valid input
    @Test
    public void testValidLogin2() {
        getDriver().findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
            }
    
  //test cases 4. From one to four test cases checking the login 
    @Test
    public void testValidLogin3() {
        getDriver().findElement(By.id("user-name")).sendKeys("problem_user");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
           }
    
    //test cases 5 leave username field and click on login
    @Test
    public void testValidLogin4() {
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
        
    }  
    
  //test cases 6 leave password field and click on login
    @Test
    public void testValidLogin5() {
        getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
        
    }  
    
    
    //test cases 6 leave both the fields and click on login
    @Test
    public void testValidLogin6() {
        getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
        
    } 
    
    //Test cases 7 for invalid input for password
    @Test
    public void testValidLogin7() {
        getDriver().findElement(By.id("user-name")).sendKeys("locked_out_user");
        getDriver().findElement(By.id("password")).sendKeys("1234567");
        getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
        
    }
    
    
    //Test cases 7 for invalid input for username
    @Test
    public void testValidLogin8() {
        getDriver().findElement(By.id("user-name")).sendKeys("Sadhiq");
        getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getDriver().findElement(By.id("login-button")).click();
        verifyloginsuccess();
        
    }
    

    @AfterMethod
    public void tearDown() {
    	getDriver().quit();
    }
}
