package stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class E_Com_Login_Hooks {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Launch Website
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }
    @After
    public void teardown(){
        driver.quit();

    }
    @BeforeStep
    public void beforeStep() {
        System.out.println("======>  This is before step  <======");
        //Do something before executing the step
    }

    @AfterStep
    public void afterStep() {
        System.out.println("======>  This is after step  <======");
        //Do something after executing the step
    }

}
