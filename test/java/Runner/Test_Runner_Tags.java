package Runner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature",
        glue= {"stepDefinition","Utilities"},
        plugin = { "pretty","html:target/cucumber.html","junit:target/JUnit_Report.xml","json:target/cucumber-reports/Cucumber.json"},
        monochrome = true,
        //tags = "@smoke"
        //tags = "@regression"
        //tags = "@sanity"
        //tags = "@regression or @sanity"
        //tags = "@regression and @sanity"
        tags = "@regression and not @sanity"

)
public class Test_Runner_Tags {

}
