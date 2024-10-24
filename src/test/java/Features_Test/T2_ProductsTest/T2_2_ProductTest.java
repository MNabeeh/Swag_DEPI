package Features_Test.T2_ProductsTest;

import Features_Pages.f2_Products.P2_1_HomePage;
import Features_Pages.f1_Auth.P1_1_LoginPage;
import Features_Pages.f2_Products.P2_2_ProductPage;
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
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage= new P2_1_HomePage(driver);
        P2_2_ProductPage productPage = new P2_2_ProductPage(driver);

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
