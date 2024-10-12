package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest  extends BaseTest {

    @Test
    public void sortTheProducts() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.loginToTheSite("standard_user", "secret_sauce");
        homePage.sortTheProducts("Price (low to high)");
        boolean areTheProductSorted= driver.findElement(homePage.areProductsSortedByPriceLowToHigh()).isDisplayed();
        if (areTheProductSorted){
            System.out.println("The products are re_odered as your request");
            }
        else System.out.println("revise your code");
    }


    @Test
    public void choseOneProduct_ByHyperlink() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.loginToTheSite("standard_user", "secret_sauce");
        homePage.choseYourFirstProduct();
        boolean isThePriceIsVisbleInTheProductPage = driver.findElement(productPage.getAssertPrice()).isDisplayed();
        if (isThePriceIsVisbleInTheProductPage){
            System.out.println("The price is visible and now you are in the product Page");
        }
        else System.out.println("revise your code ");

    }

    @Test
    public void choseTwoProductFrom_HomePage() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.loginToTheSite("standard_user", "secret_sauce");
        homePage.clickOneTowProdctsFormTheHomePage();
        boolean isTwoProductsAddedToTheCart = driver.findElement(cartPage.getAssertThatTwoItemInTheCart()).isDisplayed();
        if (isTwoProductsAddedToTheCart) {
            System.out.println("There are two products added sucessfully to your cart ");
        } else {
            System.out.println("Revise your code");
        }


    }
}