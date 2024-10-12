package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage   {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
        protected final By userName = By.id("user-name");
        protected final By passWord = By.id("password");

        protected final By loginBtn = By.className("btn_action");
        protected  final  By assertErrorSMS = By.xpath("//button[@class=\"error-button\"]");
        protected  final By assertThatTheUserInLoginPgae = By.xpath("//div[@class='login_logo']");

        public By getAssertErrorSMS(){
            return assertErrorSMS;
        }
    public By getAssertThatTheUserInLoginPgae(){
        return assertThatTheUserInLoginPgae;
    }
    public HomePage  loginToTheSite (String username, String password)
    {
        driver.findElement(userName).sendKeys(username);
        driver.findElement(passWord).sendKeys (password);
        driver.findElement(loginBtn).click();
        return new HomePage(driver);
    }

    }





