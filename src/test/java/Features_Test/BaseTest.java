package Features_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public final String filePath = "C:\\Users\\V18MMohamed138\\OneDrive - Vodafone Group\\Documents\\GitHub\\DEPI_Project\\src\\test\\java\\data_Excel\\swaglap.xlsx";
   protected   WebDriver driver;


    @BeforeMethod

    public void start (){
        driver = new EdgeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void tearDown ()
    {
        driver.quit();
    }




}
