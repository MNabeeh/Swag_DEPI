package Features_Test.Tries;


import Features_Pages.f2_Products.P2_1_HomePage;
import Features_Pages.f1_Auth.P1_1_LoginPage;
import Features_Test.BaseTest;
import org.testng.annotations.Test;

public class TryTest extends BaseTest {
    @Test
    public void login() {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);

        loginPage.loginToTheSite("locked_out_user", "secret_sauce");
        try {
            boolean isTheLabelOFHomePageIsVisible = driver.findElement(homePage.getAsssertTheBagPhoto()).isDisplayed();

            if (isTheLabelOFHomePageIsVisible) {
                System.out.println("Welcome to the Home Page");
            }
        } catch (Exception e) {
            try {
                boolean isgetCheckThePhotoOfTheProdcut = driver.findElement(homePage.getAssertThePhotoOfThePage()).isDisplayed();

                if (isgetCheckThePhotoOfTheProdcut) {
                    System.out.println("The existing photo not matched the discription");
                }
            } catch (Exception error) {
                System.out.println("revise your code as there is an error SMS  ");
            }
        }


    }

    @Test
    public void problem_user_Login() {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        loginPage.loginToTheSite("problem_user", "secret_sauce");
        boolean isTheWrongPhotoDisplayed = driver.findElement(homePage.getAssertThePhotoOfThePage()).isDisplayed();
        if (isTheWrongPhotoDisplayed) {
            System.out.println("The photo is dog not a matched the discription.");
        } else
            System.out.println("Revise your code");
    }

    @Test
    public void prueba() {
        P1_1_LoginPage loginPage = new P1_1_LoginPage(driver);
        P2_1_HomePage homePage = new P2_1_HomePage(driver);
        loginPage.loginToTheSite("standard_user", "secrets_sauce");
        try {
            boolean isTheCorrectPhotoDisplayed = driver.findElement(homePage.getAssertThePhotoOfThePage()).isDisplayed();
            if (isTheCorrectPhotoDisplayed) {
                System.out.println("The photo is a bag and matched to the discription.");
            }
        } catch (Exception ofTheIvalidLogin) {
            System.out.println("revise your code as there is an error SMS  ");
        }
    }



}