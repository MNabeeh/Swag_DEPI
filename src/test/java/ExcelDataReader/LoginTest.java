package ExcelDataReader;

import Features_Pages.f1_Auth.P1_1_LoginPage;
import Features_Pages.f2_Products.P2_1_HomePage;
import Features_Pages.f3_Cart.P3_CartPage;
import Features_Test.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

 @Test
     //(priority = 0, enabled="false")
     //check Valid user , Invalid user and locked_out_user secenarios

 public void loginTest () {
     P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
     P2_1_HomePage homePage = new P2_1_HomePage(driver);

     loginPage.loginToTheSite("", "");
     try {
         boolean isTheBagPhotoIsVisible = driver.findElement(homePage.getAsssertTheBagPhoto()).isDisplayed();
         if (isTheBagPhotoIsVisible) {
             System.out.println("Welcome! You are in the home page, you can select any product");
         }
     } catch (Exception errorSMS) {
         System.out.println("Please check your Username or your Password or You use locked_out_user");
     }
 }

     @Test
     // Test "login with the Problem User "
    // Test_ProblemUser_And_visualUser
     public void Test_ProblemUser_And_visualUser  () {
         P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
         P2_1_HomePage homePage = new P2_1_HomePage(driver);

         loginPage.loginToTheSite("problem_user", "secret_sauce");
         boolean isTheInCorrectImageVisibe = driver.findElement(homePage.getAssertThePhotoOfThePage()).isDisplayed();
         if (isTheInCorrectImageVisibe) {
             System.out.println("You are in the home page, but the image doesn't match  the description as there is Dog Photo");
         } else
             System.out.println("check again you code");
     }
     @Test
     //Test the time with performance_glitch_user
     public void test_Performance_glitch () {
         P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
         P2_1_HomePage homePage = new P2_1_HomePage(driver);

         loginPage.loginToTheSite("performance_glitch_user", "secret_sauce");
         long loginTime = System.nanoTime();

         boolean isThebagPhotoIsVisible = driver.findElement(homePage.getAsssertTheBagPhoto()).isDisplayed();
         if (isThebagPhotoIsVisible) {
             System.out.println("You are in the home page, you can select any product");
         } else System.out.println("Please check your Username or your Password");

         long endTime = System.nanoTime();
         long totalTime = endTime - loginTime;
         System.out.println("Total time taken for login and verification: " + totalTime / 1_000_000 + " ms");


     }
     @Test
// There are porducts clickable
     public void Test_ErrorsUser () {
         P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
         P2_1_HomePage homePage = new P2_1_HomePage(driver);
         P3_CartPage cartPage = new P3_CartPage(driver);

         loginPage.loginToTheSite("error_user", "secret_sauce");
         homePage.clickOneThreeProdctsFormTheHomePage();
         try {
             boolean isTheThereeITemsAddedToCart = driver.findElement(cartPage.getAssertThatThreeItemInTheCart()).isDisplayed();
             if (isTheThereeITemsAddedToCart) {
                 System.out.println("All Elements are now in the Cart ");
             }
         } catch (Exception e) {
             System.out.println("There is one Product not clickable ");

         }
     }
 }
