package Features_Test.T2_ProductsTest;

import Features_Pages.f3_Cart.CartPage;
import Features_Pages.f2_Products.HomePage;
import Features_Pages.f1_Auth.LoginPage;
import Features_Pages.f2_Products.ProductPage;
import Features_Test.BaseTest;
import ExcelDataReader.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class T2_1_HomeTest extends BaseTest {

   @DataProvider (name = "ExcelData")
   public  Object[][] userRegisterData () throws IOException {
       ExcelReader excelReader = new ExcelReader();
       return excelReader.getExcelSpecificRow(1,0);

   }

    @Test (dataProvider = "ExcelData")

    public void sortTheProducts (String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.loginToTheSite(userName, password);
        homePage.sortTheProducts("Price (low to high)");
        boolean areTheProductSorted= driver.findElement(homePage.areProductsSortedByPriceLowToHigh()).isDisplayed();
        if (areTheProductSorted){
            System.out.println("The products are re_odered as your request");
            }
        else System.out.println("revise your code");
    }


    @Test (dataProvider = "ExcelData")
    public void choseOneProduct_ByHyperlink(String userName, String password) {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.loginToTheSite(userName, password);
        homePage.choseYourFirstProduct();
        boolean isThePriceIsVisbileInTheProductPage = driver.findElement(productPage.getAssertPrice()).isDisplayed();
        if (isThePriceIsVisbileInTheProductPage){
            System.out.println("The price is visible and now you are in the product Page");
        }
        else System.out.println("revise your code ");

    }

    @Test (dataProvider = "ExcelData")
    public void choseTwoProductFrom_HomePage(String userName, String password) {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.loginToTheSite(userName, password);
        homePage.clickOneTowProdctsFormTheHomePage();
        boolean isTwoProductsAddedToTheCart = driver.findElement(cartPage.getAssertThatTwoItemInTheCart()).isDisplayed();
        if (isTwoProductsAddedToTheCart) {
            System.out.println("There are two products added sucessfully to your cart ");
        } else {
            System.out.println("Revise your code");
        }


    }
}