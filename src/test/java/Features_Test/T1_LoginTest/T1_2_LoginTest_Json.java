package Features_Test.T1_LoginTest;

import Features_Pages.f1_Auth.P1_1_LoginPage;
import Features_Pages.f1_Auth.P1_2_LogoutPage;
import Features_Pages.f2_Products.P2_1_HomePage;
import Features_Test.BaseTest;
import json_dataReader.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class T1_2_LoginTest_Json extends BaseTest {
    @Test

    public void checkValidLogin() throws IOException, ParseException {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        P1_2_LogoutPage logoutPage = new P1_2_LogoutPage(driver);


        JsonDataReader jsonReader = new JsonDataReader();
        List<String[]> usersList = jsonReader.JsonReader();
        for (String[] user : usersList) {
            String username = user[0];
            String password = user[1];

            loginPage.loginToTheSite(username, password);
            boolean isTheBagPhotoIsVisible = driver.findElement(homePage.getAsssertTheBagPhoto()).isDisplayed();
            if (isTheBagPhotoIsVisible) {
                System.out.println("passed");
            } else System.out.println("failed ");
            logoutPage.logout();

        }

        loginPage.loginToTheSite("locked_out_user", "secret_sauce");

        boolean isTheBagPhotoIsVisible = driver.findElement(loginPage.getAssertErrorSMS()).isDisplayed();
        if (isTheBagPhotoIsVisible) {
            System.out.println("login is failed ");
        } else System.out.println(" you are login now  ");
        logoutPage.logout();

    }


}

