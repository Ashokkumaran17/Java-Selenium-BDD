package stepDefinition;
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

public class Login_Test_Step_Def {
    WebDriver driver;
    @Given("start to open the web browser")
    public void start_to_open_the_web_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("navigate to the web page")
    public void navigate_to_the_web_page() {
        // Launch Website
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String page_title = driver.getTitle();
        System.out.println("Title is :" + page_title);
        if (page_title.equals("My Shop")) {
            System.out.println("Home page Title Verification passed");
        } else {
            System.out.println("Home page Title Verification Failed!!!");
        }
        // explicit wait - to wait for the Sign In button to be click-able
        WebDriverWait wait_sign_in_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_sign_in_btn.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
        //Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement sign_in_btn = driver.findElement(By.className("login"));
        sign_in_btn.click();

    }
    @When("^user enter (string) and (string2)$")
    public void user_enter_email_id_and_password(String string, String string2) {
        WebDriverWait wait_account_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_account_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        //Enter the Email Id
        WebElement usr_email_id = driver.findElement(By.id("email"));
        usr_email_id.click();
        usr_email_id.sendKeys(string);
        //Enter the Password
        WebElement usr_pwd = driver.findElement(By.id("passwd"));
        usr_pwd.click();
        usr_pwd.sendKeys(string2);
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
    @Then("verify the dashboard page title")
    public void verify_the_dashboard_page_title() {
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

    @Then("logout the application")
    public void logoutTheApplication() {
        WebDriverWait wait_logout_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_logout_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));

        //Click Logout btn
        WebElement logout_btn = driver.findElement(By.xpath("//a[@class='logout']"));
        logout_btn.click();

    }

    @Then("close the application")
    public void closeTheApplication() {

        driver.quit();
    }


}
