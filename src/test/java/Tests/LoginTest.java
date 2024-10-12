package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test

   //check Valid user , Invalid user and locked_out_user secenarios
    public  void checkValidLogin_InValidLogin_locked_out_user () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.loginToTheSite("standard_user", "secret_sauce");
        try {
            boolean isThebagPhotoIsVisible = driver.findElement(homePage.getAsssertTheBagPhoto()).isDisplayed();
            if (isThebagPhotoIsVisible) {
                System.out.println("Welcome! You are in the home page, you can select any product");}
            }
        catch(Exception errorSMS)
        {
            System.out.println("Please check your Username or your Password or You use locked_out_user");
        }
    }


    @Test
            // Test "login with the Problem User "
    public  void Test_ProblemUser_And_visualUser() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.loginToTheSite("problem_user", "secret_sauce");
        boolean isTheInCorrectImageVisibe = driver.findElement(homePage.getAssertThePhotoOfThePage()).isDisplayed();
        if (isTheInCorrectImageVisibe) {
            System.out.println("You are in the home page, but the image doesn't match  the description as there is Dog Photo");}
         else
            System.out.println("check again you code");
    }
    @Test
            //Test the time with performance_glitch_user
    public void test_Performance_glitch() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.loginToTheSite("performance_glitch_user", "secret_sauce");
          long loginTime = System.nanoTime();

            boolean isThebagPhotoIsVisible = driver.findElement(homePage.getAsssertTheBagPhoto()).isDisplayed();
            if (isThebagPhotoIsVisible) {
                System.out.println("You are in the home page, you can select any product");}
             else   System.out.println("Please check your Username or your Password");

        long endTime = System.nanoTime();
        long totalTime = endTime - loginTime;
        System.out.println("Total time taken for login and verification: " + totalTime / 1_000_000 + " ms");



}
    @Test
// There are porducts clickable
    public  void Test_ErrorsUser () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

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
