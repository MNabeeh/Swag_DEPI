package Tests;

import Pages.*;
import org.testng.annotations.Test;

public class CheckOutTest extends  BaseTest{


    @Test

    public  void doCheckOut () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        OverviewPage overviewPage =new OverviewPage(driver);

        loginPage.loginToTheSite("standard_user", "secret_sauce");
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnContinueShoopingBtn();
        homePage.choseYourSecondProduct();
        productPage.clickOnAddToCartBtn();
        productPage.clickOnCartLogo();
        cartPage.clickOnCheckoutBtn();
        checkOutPage.fillCheckOutDate("Maha", "Ali", "12345");
        boolean IsTheUserInheckOutPage = driver.findElement(overviewPage.getAssertThatYouAreInCheckOutPage()).isDisplayed();
        if (IsTheUserInheckOutPage) {
            System.out.println("your are in the checkOut-Review Page");
        } else {
            System.out.println("Revise your code");
        }

    }



    @Test

    public  void cancelCheckOut () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);

        loginPage.loginToTheSite("standard_user", "secret_sauce");
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

