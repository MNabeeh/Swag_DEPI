package Parallel_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Base_parallelTest {

    //protected WebDriver driver;
    public static String BaseUrl = "https://www.saucedemo.com/";
    protected ThreadLocal<RemoteWebDriver> driver = null;
    //thread local: da  3lasan aft7 aktr mn http at the same time w 3lashan keda f kelmt thread f xml
    //allows multiple tests to run concurrently without affecting each other by ensuring each test thread interacts with its own browser instance.
    // RemoteWebDriver
//have its own instance of RemoteWebDriver. This is important because:Isolation:
// Each thread can interact with its own browser instance without interference from other threads.
// This prevents issues like one test affecting the state of another test.


    @BeforeClass
    @Parameters(value = {"browser"})

    public void start(String browserName) {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browserName);
        try {
            driver.set(new RemoteWebDriver(new URL("browser"), caps));

        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for RemoteWebDriver", e);
        }
    }
}