package Features_Test.T2_ProductsTest;

import Features_Pages.f2_Products.HomePage;
import Features_Pages.f1_Auth.LoginPage;
import Features_Pages.f2_Products.ProductPage;
import Features_Test.BaseTest;
import ExcelDataReader.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class T2_2_ProductTest extends BaseTest {

    @DataProvider(name = "ExcelData")
    public  Object[][] userRegisterData () throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getExcelSpecificRow(1,0);

    }


    @Test (dataProvider="ExcelData")
    public void addProductToTheCart (String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage= new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.loginToTheSite(userName,password);
        homePage.choseYourFirstProduct();
        productPage.clickOnAddToCartBtn();
        boolean isTheProductIsAddedToTheCart = driver.findElement(productPage.getAssertThatTheProductIsAdded()).isDisplayed();
        if (isTheProductIsAddedToTheCart)
        {
            System.out.println(" Great ! The product is added successfully to the cart");
        }
        else {
            System.out.println("Revise your code");
        }

    }




}
