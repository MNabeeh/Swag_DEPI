package Tests;

import Pages.*;
import org.testng.annotations.Test;

public class CartTest extends  BaseTest {

    @Test
    public void testOneITemAddToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.loginToTheSite("standard_user", "secret_sauce");
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


    @Test

    public void addTwoIemInTheCart_and_testIT() {
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


    @Test

    public void deleteOneItemFormTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.loginToTheSite("standard_user", "secret_sauce");
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
