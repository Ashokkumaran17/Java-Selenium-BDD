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
public class E_Com_Login_Page_Test {
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

    @Given("navigate to the home page and click the Signin btn")
    public void navigate_to_the_home_page_and_click_the_Signin_btn() {
        // explicit wait - to wait for the Sign In button to be click-able
        WebDriverWait wait_sign_in_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_sign_in_btn.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
        //Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement sign_in_btn = driver.findElement(By.className("login"));
        sign_in_btn.click();

    }
    @When("user enters valid email_id with password")
    public void user_enters_valid_email_id_with_password() {
        WebDriverWait wait_account_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_account_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        //Enter the Email Id
        WebElement usr_email_id = driver.findElement(By.id("email"));
        usr_email_id.click();
        usr_email_id.sendKeys("selenium_java_2023@yopmail.com");
        //Enter the Password
        WebElement usr_pwd = driver.findElement(By.id("passwd"));
        usr_pwd.click();
        usr_pwd.sendKeys("Java2023");
        //Click Submit button
        WebElement submit_btn = driver.findElement(By.id("SubmitLogin"));
        submit_btn.click();
        //div[@id="center_column"]/p[@class="alert alert-success"]
        //WebElement create_account_msg = driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']"));
        WebElement login_success = driver.findElement(By.xpath("//a[@class='logout']"));
        String text_msg = login_success.getText();
        if (text_msg.equalsIgnoreCase("Sign out")) {
            System.out.println("Login successful");

        } else {
            System.out.println("Failed to login the Account!!!");

        }

    }
    @And("verify the dash board page title")
    public void verify_the_dash_board_page_title() {
        WebDriverWait wait_logout_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_logout_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));
        //Get the Title of the page
        String Account_page_title = driver.getTitle();
        System.out.println("*******************************************************");
        System.out.println("Home Page Title is :" + Account_page_title);
        if (Account_page_title.equals("My account - My Shop")) {
            System.out.println("Account page title verified Successfully");
        } else {
            System.out.println("Failed to verify the Account page title!!!");
        }
        System.out.println("*******************************************************");


    }
    @Then("logout the e_com application")
    public void logout_the_e_com_application() {
        WebDriverWait wait_logout_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_logout_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));

        //Click Logout btn
        WebElement logout_btn = driver.findElement(By.xpath("//a[@class='logout']"));
        logout_btn.click();

    }
}
