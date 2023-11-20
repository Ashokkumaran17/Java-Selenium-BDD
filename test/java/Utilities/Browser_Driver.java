package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Browser_Driver {
    public static WebDriver driver;
    public void BrowserDriver(){
        this.driver = driver;
        System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        this.driver = new ChromeDriver();
        // Maximize the browser
        this.driver.manage().window().maximize();
        //Wait for 30 sec
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // Launch Website
        this.driver.get("http://www.automationpractice.pl/index.php");
    }
    public void close_Browser(){
        this.driver.close();
    }
}
