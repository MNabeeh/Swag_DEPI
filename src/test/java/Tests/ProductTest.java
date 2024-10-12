package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{
    @Test
    public void addProductToTheCart (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage= new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.loginToTheSite("standard_user","secret_sauce");
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        boolean isTheProductIsAddedToTheCart = driver.findElement(productPage.getAssertThatTheProductIsAdded()).isDisplayed();
        if (isTheProductIsAddedToTheCart)
        {
            System.out.println(" Great ! The producte is added successfully to the cart");
        }
        else {
            System.out.println("Revise your code");
        }

    }




}
