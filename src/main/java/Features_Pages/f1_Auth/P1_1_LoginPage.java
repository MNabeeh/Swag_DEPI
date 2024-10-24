package Features_Pages.f1_Auth;

import Features_Pages.f2_Products.P2_1_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P1_1_LoginPage {
    private WebDriver driver;
    public P1_1_LoginPage(WebDriver driver) {
        this.driver = driver;
    }
        protected final By userName = By.id("user-name");
        protected final By passWord = By.id("password");
        protected final By loginBtn = By.className("btn_action");
        protected  final  By assertErrorSMS = By.xpath("//button[@class= 'error-button']");
        protected  final By assertThatTheUserInLoginPage = By.xpath("//div[@class='login_logo']");


     public By getAssertErrorSMS(){
            return assertErrorSMS;
        }
    public By getAssertThatTheUserInLoginPage(){
      return assertThatTheUserInLoginPage;
    }


    public P2_1_HomePage loginToTheSite (String username, String password)
    {
        driver.findElement(userName).sendKeys(username);
        driver.findElement(passWord).sendKeys (password);
        driver.findElement(loginBtn).click();
        return new P2_1_HomePage(driver);
    }

    }





