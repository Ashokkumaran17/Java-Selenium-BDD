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

public class Ecom_Login_test {
    WebDriver driver;
    public static final String email_id = "selenium_java_2023@yopmail.com";
    public static final String pwd = "Java2023";

    @Given("open the browser")
    public void open_the_browser() {
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

    }

    @When("verify home page title")
    public void verify_home_page_title() {
        //Get the Title of the page
        String page_title = driver.getTitle();
        System.out.println("Title is :" + page_title);
        if (page_title.equals("My Shop")) {
            System.out.println("Home page Title Verification passed");
        } else {
            System.out.println("Home page Title Verification Failed!!!");
        }

    }

    @And("clicks the sign_in button")
    public void clicks_the_sign_in_button() {
        // explicit wait - to wait for the Sign In button to be click-able
        WebDriverWait wait_sign_in_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_sign_in_btn.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
        //Wait for 30 sec
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement sign_in_btn = driver.findElement(By.className("login"));
        sign_in_btn.click();

    }

    @Then("verify the login page title")
    public void verify_the_login_page_title() {
        // explicit wait - to wait for the create Account button to be click-able
        WebDriverWait wait_account_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_account_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='create-account_form']")));
        //display the title of the page
        String auth_page_title = driver.getTitle();
        System.out.println("Title is :" + auth_page_title);
        if (auth_page_title.equals("Login - My Shop")) {
            System.out.println("Auth Title page verification Passed!!!");
        } else {
            System.out.println("Auth Title page verification failed!!!");
        }

    }

    @Then("login to the e_com web page")
    public void login_to_the_e_com_web_page() {
        WebDriverWait wait_account_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_account_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        //Enter the Email Id
        WebElement usr_email_id = driver.findElement(By.id("email"));
        usr_email_id.click();
        usr_email_id.sendKeys(email_id);
        //Enter the Password
        WebElement usr_pwd = driver.findElement(By.id("passwd"));
        usr_pwd.click();
        usr_pwd.sendKeys(pwd);
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
    @Then("^user enters (.*) and (.*)$")
    public void user_enters_and(String string, String string2) {
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

    @Then("click the the logout button")
    public void click_the_logout_button() {
        WebDriverWait wait_logout_btn = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait_logout_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='logout']")));

        //Click Logout btn
        WebElement logout_btn = driver.findElement(By.xpath("//a[@class='logout']"));
        logout_btn.click();

    }
    @Then("verify home page title after logout")
    public void verify_home_page_title_after_logout() {
        //Get the Title of the page
        String home_page_title = driver.getTitle();
        System.out.println("*******************************************************");
        System.out.println("Home Page Title is :" + home_page_title);
        if (home_page_title.equals("Login - My Shop")) {
            System.out.println("Logout Successful");
        } else {
            System.out.println("Failed to do Logout!!!");
        }
        System.out.println("*******************************************************");

    }

    @Then("close the browser")
    public void close_the_browser() {
        driver.quit();

    }

}
