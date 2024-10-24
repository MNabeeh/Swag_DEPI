package Features_Test.T3_CartTest;

import Features_Pages.f2_Products.P2_1_HomePage;
import Features_Pages.f2_Products.P2_2_ProductPage;
import Features_Pages.f3_Cart.P3_CartPage;
import Features_Pages.f4_CheckOut.P4_1_CheckOutPage;
import Features_Pages.f4_CheckOut.P4_3_CompleteCheckOutPage;
import Features_Pages.f4_CheckOut.P4_2_OverviewPage;
import Features_Pages.f1_Auth.P1_1_LoginPage;
import Features_Test.BaseTest;
import ExcelDataReader.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class T3_3_OverViewTest extends BaseTest {

    @DataProvider(name = "ExcelData")
    public  Object[][] userRegisterData () throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelSpecificRow(2,1);

    }


    // Flaky test
    @Test (dataProvider = "ExcelData")

    public void finishPayingTheProduct_ThenLogOut(String  username, String password, String firstname,String Lastname, String postelcode ) {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        P2_2_ProductPage productPage = new P2_2_ProductPage(driver);
        P3_CartPage cartPage = new P3_CartPage(driver);
        P4_1_CheckOutPage checkOutPage = new P4_1_CheckOutPage(driver);
        P4_2_OverviewPage overviewPage = new P4_2_OverviewPage(driver);
        P4_3_CompleteCheckOutPage completeCheckOutPage= new P4_3_CompleteCheckOutPage(driver);

        loginPage.loginToTheSite(username, password);
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnContinueShoopingBtn();
        homePage.choseYourSecondProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnCheckoutBtn();
        checkOutPage.fillCheckOutDate(firstname, Lastname, postelcode);
        overviewPage.clickOnFinishBtn();
        boolean IsTheCheckOutIsCompleted = driver.findElement(completeCheckOutPage.getAssertThatYouAreInCheckOutCompletePage()).isDisplayed();
        if(IsTheCheckOutIsCompleted){
            System.out.println();
            System.out.println("Thank you for your order");
        }
        else System.out.println("Revise your code ");

        Wait<WebDriver> fluentWait =new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30));

        completeCheckOutPage.clickOnOpenMenuBtnToLogOut();

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30));

        boolean IsTheUSerCanLogOutAfterFinishTheCheckOut = driver.findElement(loginPage.getAssertThatTheUserInLoginPage()).isDisplayed();
        if(IsTheUSerCanLogOutAfterFinishTheCheckOut){
            System.out.println("You logout now and you can login any time");
        }
        else System.out.println("Revise your code ");
    }



    @Test (dataProvider = "ExcelData")

    public void cancelCheckOut_ThenBackToHome(String  username, String password, String firstname,String Lastname, String postelcode) {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        P2_2_ProductPage productPage = new P2_2_ProductPage(driver);
        P3_CartPage cartPage = new P3_CartPage(driver);
        P4_1_CheckOutPage checkOutPage = new P4_1_CheckOutPage(driver);
        P4_2_OverviewPage overviewPage = new P4_2_OverviewPage(driver);
        P4_3_CompleteCheckOutPage completeCheckOutPage= new P4_3_CompleteCheckOutPage(driver);

        loginPage.loginToTheSite(username, password);
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnContinueShoopingBtn();
        homePage.choseYourSecondProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnCheckoutBtn();
        checkOutPage.fillCheckOutDate(firstname, Lastname, postelcode);
        overviewPage.clickOnFinishBtn();
        completeCheckOutPage.clickOnBackHomeBtn();
        boolean IsTheCustomerClickOnBackHomeBtn = driver.findElement(homePage.getAssertTheProdcutsWord()).isDisplayed();
        if(IsTheCustomerClickOnBackHomeBtn){
            System.out.println("You are now in the Home page");
        }
        else System.out.println("Revise your code ");


    }
}
