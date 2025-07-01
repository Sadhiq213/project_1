package testing_saucedemo_website;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class cart {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	 
	 public WebDriver getDriver() {
		 return driver.get();
	    }

	
	@BeforeMethod
	public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        WebDriver localDriver = new ChromeDriver();
        driver.set(localDriver);
        getDriver().get("https://www.saucedemo.com/v1/cart.html");
    }
	
	//click on checkout button without any product in the cart
	@Test
	public void click_checkout() {
		getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
		String currenturl = getDriver().getCurrentUrl();
		System.out.println(currenturl);
		String expectedurl = "https://www.saucedemo.com/v1/checkout-step-one.html";
		
		if(currenturl.equals(expectedurl)) {
			System.out.println("Success match with current and expected url");
		}else {
			System.out.println("Failed does not match with current and expected url");
		}
	}
		
	//click on continue shopping button
	@Test	
	public void click_continue_shopping() {
		getDriver().findElement(By.xpath("//a[normalize-space(text())='Continue Shopping']")).click();
		String currenturl = getDriver().getCurrentUrl();
		System.out.println(currenturl);
		String expectedurl = "https://www.saucedemo.com/v1/inventory.html";
		
		if(currenturl.equals(expectedurl)) {
			System.out.println("Success match with current and expected url");
		}else {
			System.out.println("Failed does not match with current and expected url");
		}
			
		}
		
	//click on cancel button
	@Test
	public void click_cancel() {
		getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
		getDriver().findElement(By.xpath("//a[@class='cart_cancel_link btn_secondary']")).click();
		String currenturl = getDriver().getCurrentUrl();
		System.out.println(currenturl);
		String expectedurl = "https://www.saucedemo.com/v1/cart.html";
		
		if(currenturl.equals(expectedurl)) {
			System.out.println("Success match with current and expected url");
		}else {
			System.out.println("Failed does not match with current and expected url");
		}
		
	}
	
	//click on continue after checkout 
	@Test
	public void click_continue() {
		getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
		getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
		String currenturl = getDriver().getCurrentUrl();
		System.out.println(currenturl);
		String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
		
		if(currenturl.equals(expectedurl)) {
			System.out.println("Success match with current and expected url");
		}else {
			System.out.println("Failed does not match with current and expected url");
		}
	}
	
	
	//Enter only first name in the field and leave other two fields
		@Test
		public void Enter_firstname() {
			getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
			getDriver().findElement(By.id("first-name")).sendKeys("a");
			getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
			String currenturl = getDriver().getCurrentUrl();
			System.out.println(currenturl);
			String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
			
			if(currenturl.equals(expectedurl)) {
				System.out.println("Success match with current and expected url");
			}else {
				System.out.println("Failed does not match with current and expected url");
			}
		}
		
	
		//Enter only last name in the field and leave other two fields
				@Test
				public void Enter_lastname() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("last-name")).sendKeys("a");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}
			
				//Enter only zip code in the field and leave other two fields. Acctually this test caes should not
			    //work zip code field only accept int values but it is working
				@Test
				public void Enter_Zipcode() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("postal-code")).sendKeys("a");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}
				
				//Enter all the vaild details in the field 
				@Test
				public void Enter_details() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("Sadhiq");
					getDriver().findElement(By.id("last-name")).sendKeys("Sadhiq");
					getDriver().findElement(By.id("postal-code")).sendKeys("123546");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}
				
		
				//Enter no. in all the field 
				@Test
				public void Enter_details2() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("2");
					getDriver().findElement(By.id("last-name")).sendKeys("3");
					getDriver().findElement(By.id("postal-code")).sendKeys("123546");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}		
				
				
				//Enter spl. char. in all the field 
				@Test
				public void Enter_details3() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("%");
					getDriver().findElement(By.id("last-name")).sendKeys("@");
					getDriver().findElement(By.id("postal-code")).sendKeys("&");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}		
				
				
				//Enter Emoji in all the field 
				@Test
				public void Enter_details4() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("%");//in sendkeys enter emoji
					getDriver().findElement(By.id("last-name")).sendKeys("@");//in sendkeys enter emoji
					getDriver().findElement(By.id("postal-code")).sendKeys("&");//in sendkeys enter emoji
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}	
				

				//Enter only bracket in all the field 
				@Test
				public void Enter_details5() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("[");
					getDriver().findElement(By.id("last-name")).sendKeys("]");
					getDriver().findElement(By.id("postal-code")).sendKeys("{}");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}	
				
				
				
				
				//Enter long char. in all the field 
				@Test
				public void Enter_details6() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("dguisdbuiwfguidv");
					getDriver().findElement(By.id("last-name")).sendKeys("sdjguisddsuhdjdvn");
					getDriver().findElement(By.id("postal-code")).sendKeys("ugwuibwuidhwoeeoegh");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}	
				
				//Enter only letter in all the field 
				@Test
				public void Enter_details7() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("d");
					getDriver().findElement(By.id("last-name")).sendKeys("s");
					getDriver().findElement(By.id("postal-code")).sendKeys("u");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}
				
				//Enter only superheros name in all the field 
				@Test
				public void Enter_details8() {
					getDriver().findElement(By.xpath("//a[normalize-space(text())='CHECKOUT']")).click();
					getDriver().findElement(By.id("first-name")).sendKeys("Hulk");
					getDriver().findElement(By.id("last-name")).sendKeys("Ironman");
					getDriver().findElement(By.id("postal-code")).sendKeys("Spider-man");
					getDriver().findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-step-two.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
				}
				
				
				//click on second step continue button
				@Test
				public void click_secondcontinue() {
					getDriver().get("https://www.saucedemo.com/v1/checkout-step-two.html");
					getDriver().findElement(By.xpath("//a[@class='cart_cancel_link btn_secondary']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/inventory.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
					
					
				}
				
				//click on second step finish button
				@Test
				public void click_finish() {
					getDriver().get("https://www.saucedemo.com/v1/checkout-step-two.html");
					getDriver().findElement(By.xpath("//a[@class='btn_action cart_button']")).click();
					String currenturl = getDriver().getCurrentUrl();
					System.out.println(currenturl);
					String expectedurl = "https://www.saucedemo.com/v1/checkout-complete.html";
					
					if(currenturl.equals(expectedurl)) {
						System.out.println("Success match with current and expected url");
					}else {
						System.out.println("Failed does not match with current and expected url");
					}
					
					
				}
				
				
				
				
	
	 @AfterMethod
		public void tearDown() {
		 getDriver().quit();
		    }
}
