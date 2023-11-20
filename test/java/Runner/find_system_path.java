package Runner;

import org.openqa.selenium.WebDriver;

public class find_system_path {
    WebDriver driver = null;
    public static void main(String[] args){
        String system_path = System.getProperty("user.dir");
        System.out.println("System path is "+system_path);
    }
}
