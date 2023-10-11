import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/org/example/features",
        glue = "com.example.java.steps",
        tags = "@smoke")
public class CucumberTests {

}
