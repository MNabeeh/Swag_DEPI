package Features_Test.T3_CartTest;

import Features_Pages.f2_Products.P2_1_HomePage;
import Features_Pages.f2_Products.P2_2_ProductPage;
import Features_Pages.f3_Cart.P3_CartPage;
import Features_Pages.f4_CheckOut.P4_1_CheckOutPage;
import Features_Pages.f4_CheckOut.P4_2_OverviewPage;
import Features_Pages.f1_Auth.P1_1_LoginPage;
import Features_Test.BaseTest;
import ExcelDataReader.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class T3_2_CheckOutTest extends BaseTest {

    @DataProvider(name = "ExcelData")
    public  Object[][] userRegisterData () throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelSpecificRow(2,1);

    }


    @Test (dataProvider = "ExcelData")
// String FirstName, String LastName, String PostalCode
    public  void doCheckOut (String userName, String password, String FirstName, String LastName, String PostalCode) {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        P2_2_ProductPage productPage = new P2_2_ProductPage(driver);
        P3_CartPage cartPage = new P3_CartPage(driver);
        P4_1_CheckOutPage checkOutPage = new P4_1_CheckOutPage(driver);
        P4_2_OverviewPage overviewPage =new P4_2_OverviewPage(driver);

        loginPage.loginToTheSite(userName, password);
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnContinueShoopingBtn();
        homePage.choseYourSecondProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnCheckoutBtn();
        checkOutPage.fillCheckOutDate(FirstName, LastName, PostalCode);
        boolean IsTheUserInCheckOutPage = driver.findElement(overviewPage.getAssertThatYouAreInCheckOutPage()).isDisplayed();
        if (IsTheUserInCheckOutPage) {
            System.out.println("your are in the checkOut-Review Page");
        } else {
            System.out.println("Revise your code");
        }

    }


    @DataProvider(name = "Data")
    public  Object[][] userData () throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelSpecificRow(2,1);

    }

    @Test (dataProvider = "ExcelData")

    public  void cancelCheckOut (String userName, String password, String FirstName, String LastName, String PostalCode) {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        P2_2_ProductPage productPage = new P2_2_ProductPage(driver);
        P3_CartPage cartPage = new P3_CartPage(driver);
        P4_1_CheckOutPage checkOutPage = new P4_1_CheckOutPage(driver);

        loginPage.loginToTheSite(userName, password);
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnContinueShoopingBtn();
        homePage.choseYourSecondProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnCheckoutBtn();
        checkOutPage.cancelCheckOut();
        boolean IsTheUserCancelCheckOut = driver.findElement(cartPage.getAssertCartWord()).isDisplayed();
        if (IsTheUserCancelCheckOut) {
            System.out.println("you cancelled the checkOut and now you are in the cart Page");
        } else {
            System.out.println("Revise your code");
        }

    }
    }

