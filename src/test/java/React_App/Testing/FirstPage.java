package React_App.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstPage 
{
	public static void main(String arg[])
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.get("http://localhost:5173/");
		
		driver.findElement(By.xpath("//button[contains(text(),'count is ')]")).click();		
		System.out.println("Button Clicked Successful....");
		
		driver.findElement(By.xpath("//button[contains(text(),'count is ')]")).click();
		System.out.println("Button Clicked Successful....");
		
		WebElement buttonValue=driver.findElement(By.xpath("//button[contains(text(),'count is ')]"));
		String valueText=buttonValue.getText();
		 String countText = valueText.split("= ")[0].trim();
		System.out.println("Button Count Value:"+countText);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
