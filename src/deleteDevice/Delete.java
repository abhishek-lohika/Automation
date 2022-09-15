package deleteDevice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Delete {

    public static void main(String[] args) throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\4016286\\Documents\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
    	
        String baseUrl = "https://hackathon.smartaedev.ifxurl.io/";
        String userName = "prbStmnt";
        String password = "PrbStmntTest@1234";
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
      
        driver.findElement(By.xpath("//*[text()='Accept']")).click();
        
        driver.findElement(By.xpath("//*[text()=' Sign In ']")).click();
        
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(userName);
        
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        
        driver.findElement(By.xpath("//*[text()='Sign In']")).click();
        
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Devices']")));
       
        driver.findElement(By.xpath("//*[text()='Devices']")).click();
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-progress-circular__overlay']")));
        driver.findElement(By.xpath("//a[@class='sub-item']//div[text()='Configuration']")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='delete']")));
        driver.findElement(By.xpath("//button[text()='delete']")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Delete ']")));
        
        driver.findElement(By.xpath("//span[text()=' Delete ']")).click();

        
      //verify device is deleted
        if(driver.findElements(By.xpath("//td[text()='applicationName: Smart Actuator']//following::td")).size()==0)
        {
            System.out.println("Test Passed!");
        } 
        else {
            System.out.println("Test Failed");
        }
        
        driver.close();
       
    }

}