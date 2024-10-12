package Tests;

import Pages.*;
import org.testng.annotations.Test;

public class OverViewPage extends BaseTest {

    @Test

    public void finishPayingTheProduct_ThenLogOut() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        CompleteCheckOutPage completeCheckOutPage= new CompleteCheckOutPage(driver);

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
        overviewPage.clickOnFinishBtn();
        boolean IsTheCheckOutIsCompleted = driver.findElement(completeCheckOutPage.getAssertThatYouAreInCheckOutCompletePage()).isDisplayed();
        if(IsTheCheckOutIsCompleted){
            System.out.println("Thank you for your order");
        }
        else System.out.println("Revise your code ");
        completeCheckOutPage.clickOnOpenMenuBtnToLogOut();

        boolean IsTheUSerCanLogOutAferFinshTheCheckOut = driver.findElement(loginPage.getAssertThatTheUserInLoginPgae()).isDisplayed();
        if(IsTheUSerCanLogOutAferFinshTheCheckOut){
            System.out.println("You logout now and you can login any time");
        }
        else System.out.println("Revise your code ");
    }



    @Test

    public void cancelCheckOut_ThenbackToHome() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        CompleteCheckOutPage completeCheckOutPage= new CompleteCheckOutPage(driver);

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
        overviewPage.clickOnFinishBtn();
        completeCheckOutPage.clickOnBackHomeBtn();
        boolean IsTheCustomerClickOnBackHomeBtn = driver.findElement(homePage.getAssertTheProdcutsWord()).isDisplayed();
        if(IsTheCustomerClickOnBackHomeBtn){
            System.out.println("You are now in the Home page");
        }
        else System.out.println("Revise your code ");


    }
}
