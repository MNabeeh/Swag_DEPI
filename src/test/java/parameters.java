import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class parameters {
 WebDriver driver;


 @BeforeClass

    @Parameters({"browser", "url"})
    void setup (String browser, String app)
    {
        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");

            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Desktop\\msedgedriver.exe");
            driver = new EdgeDriver();

        }
        //    driver.manage().window().maximize();
        driver.navigate().to(app);
    }


}
