package addDevice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add {

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
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-progress-circular__overlay']")));
        driver.findElement(By.xpath("//*[text()=' Add Device ']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-select__selections']//input[@required='required']")));
        driver.findElement(By.xpath("//div[@class='v-select__selections']//input[@required='required']")).click();
        driver.findElement(By.xpath("//*[text()='Smart Sensor']")).click();
        
        driver.findElement(By.xpath("//*[text()='Thing Name']//preceding::input[1]")).sendKeys("testSensor");
      
        driver.findElement(By.xpath("//*[text()='Thing Name']//following::input[1]")).sendKeys("testSensor");
        
        driver.findElement(By.xpath("//*[text()='Wifi Password']//preceding::input[1]")).sendKeys("testSensor");
        driver.findElement(By.xpath("//*[text()='Wifi Password']//following::input[1]")).sendKeys("testSensor");
       
        driver.findElement(By.xpath("//span[text()='Add Device']")).click();
        
        //verify device is added
        if(driver.findElements(By.xpath("//td[text()='applicationName: Smart Actuator']//following::td")).size()>0)
        {
            System.out.println("Test Passed!");
        } 
        else {
            System.out.println("Test Failed");
        }
        
        driver.findElement(By.xpath("//*[text()=' Add Device ']")).click();
        driver.findElement(By.xpath("//div[@class='v-select__selections']//input[@required='required']")).click();
        driver.findElement(By.xpath("//*[text()='Smart Actuator']")).click();
        
        driver.findElement(By.xpath("//*[text()='Thing Name']//preceding::input[1]")).sendKeys("testActuator");
        driver.findElement(By.xpath("//*[text()='Thing Name']//following::input[1]")).sendKeys("testActuator");
        
        driver.findElement(By.xpath("//*[text()='Wifi Password']//preceding::input[1]")).sendKeys("testActuator");
        driver.findElement(By.xpath("//*[text()='Wifi Password']//following::input[1]")).sendKeys("testActuator");
       
        driver.findElement(By.xpath("//*[text()='Actuator']")).click();
        
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("testActuator");
        
        driver.findElement(By.xpath("//*[text()=' Submit ']")).click();
        
        driver.findElement(By.xpath("//span[text()='Add Device']")).click();
        
        driver.close();
       
    }

}