package Features_Test.T3_CartTest;

import Features_Pages.f2_Products.HomePage;
import Features_Pages.f2_Products.ProductPage;
import Features_Pages.f3_Cart.CartPage;
import Features_Pages.f4_CheckOut.CheckOutPage;
import Features_Pages.f4_CheckOut.OverviewPage;
import Features_Pages.f1_Auth.LoginPage;
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
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        OverviewPage overviewPage =new OverviewPage(driver);

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
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);

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

