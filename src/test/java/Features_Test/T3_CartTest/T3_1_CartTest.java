package Features_Test.T3_CartTest;

import Features_Pages.f2_Products.P2_1_HomePage;
import Features_Pages.f2_Products.P2_2_ProductPage;
import Features_Pages.f3_Cart.P3_CartPage;
import Features_Pages.f4_CheckOut.P4_1_CheckOutPage;
import Features_Pages.f1_Auth.P1_1_LoginPage;
import Features_Test.BaseTest;
import ExcelDataReader.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class T3_1_CartTest extends BaseTest {


    @DataProvider(name = "ExcelData")
    public  Object[][] userRegisterData () throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelSpecificRow(1,0);

    }

    @Test(dataProvider = "ExcelData")
    public void testOneITemAddToTheCart( String user,String password) {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        P2_2_ProductPage productPage = new P2_2_ProductPage(driver);
        P3_CartPage cartPage = new P3_CartPage(driver);

        loginPage.loginToTheSite(user, password);
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();

        boolean IsOneProdcutAddToTheCart = driver.findElement(cartPage.getassertOneItemInTheCart()).isDisplayed();
        if (IsOneProdcutAddToTheCart) {
            System.out.println("your first product is added and now  can continue your shopping or can checkOut");
        } else {
            System.out.println("Revise your code");
        }
        cartPage.clickOnContinueShoopingBtn();
        boolean isTheProductPageIsVisible = driver.findElement(homePage.getAssertTheProdcutsWord()).isDisplayed();
        if (isTheProductPageIsVisible) {
            System.out.println(" now you select continue your shopping and now you are in the home Page");
        } else
            System.out.println("Revise your code");

    }


    @Test (dataProvider = "ExcelData")

    public void addTwoIemInTheCart_and_testIT(String userName, String password) {
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
        boolean isTwoProductsAddedToTheCart = driver.findElement(cartPage.getAssertThatTwoItemInTheCart()).isDisplayed();
        if (isTwoProductsAddedToTheCart) {
            System.out.println("There are two products added sucessfully to your cart ");
        } else {
            System.out.println("Revise your code");
        }
        cartPage.clickOnCheckoutBtn();
        boolean isCheckOutPageIsVisble =driver.findElement(checkOutPage.getAssertThatYouAreInCheckOutPage()).isDisplayed();
        if (isCheckOutPageIsVisble)
        {
            System.out.println("You are now in CheckOut page");
        }
        else System.out.println("Revise your code ");
    }


    @Test (dataProvider = "ExcelData")

    public void deleteOneItemFormTheCart(String userName, String password) {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        P2_2_ProductPage productPage = new P2_2_ProductPage(driver);
        P3_CartPage cartPage = new P3_CartPage(driver);

        loginPage.loginToTheSite(userName, password);
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnContinueShoopingBtn();
        homePage.choseYourSecondProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnRemoveBtn();

        boolean isTheProductsRemovedFromTheCart = driver.findElement(cartPage.getassertOneItemInTheCart()).isDisplayed();
        if (isTheProductsRemovedFromTheCart) {
            System.out.println("One Prodcut is Removed form the cart and there is only One Item");
        } else {
            System.out.println("Revise your code");
        }

    }



}
