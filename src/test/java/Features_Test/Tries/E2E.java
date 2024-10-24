package Features_Test.Tries;

import Features_Test.BaseTest;
import Features_Pages.f1_Auth.P1_1_LoginPage;
import org.testng.annotations.Test;

public class E2E extends BaseTest {
    @Test

    public void fromLoginToLastStep_OneProduct() {
        new P1_1_LoginPage(driver)
                .loginToTheSite("standard_user", "secret_sauce")
                .choseYourFirstProduct()
                .clickOnAddToCartBtn()
                .clickOnCartLogo()
                .clickOnCheckoutBtn()
                .fillCheckOutDate("Maha", "Ali", "12345")
                .clickOnFinishBtn()
                .clickOnOpenMenuBtnToLogOut();
        //Test is done
    }
//    public void fromt() {
//        new LoginPage(driver)
//                .loginToTheSite("")
//                .choseYourSecondProduct()
//                .clickOnCartLogo()
//                .clickOnCheckoutBtn()
//                .fillCheckOutDate()
//                .clickOnFinishBtn()
//                .clickOnOpenMenuBtnToLogOut();
//    }


    @Test
    public void fromLoginToLastStep_TwoProducts() {
        new P1_1_LoginPage(driver)
                .loginToTheSite("standard_user", "secret_sauce")
                .choseYourFirstProduct()
                .clickOnAddToCartBtn()
                .clickOnCartLogo()
                .clickOnContinueShoopingBtn()
                .choseYourSecondProduct()
                .clickOnCartLogo()
                .clickOnCheckoutBtn()
                .fillCheckOutDate("Maha", "Ali", "12345")
                .clickOnFinishBtn();
    }


    }

