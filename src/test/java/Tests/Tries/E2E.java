package Tests.Tries;

import Pages.*;
import Tests.BaseTest;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.Test;

public class E2E extends BaseTest {
    @Test

    public void fromLoginToLastStep_OneProduct() {
        new LoginPage(driver)
                .loginToTheSite("standard_user", "secret_sauce")
                .choseYourFirstProduct()
                .clickOnAddToCartBtn()
                .clickOnCartLogo()
                .clickOnCheckoutBtn()
                .fillCheckOutDate("Maha", "Ali", "12345")
                .clickOnFinishBtn()
                .clickOnOpenMenuBtnToLogOut();
    }

    @Test
    public void fromLoginToLastStep_TwoProducts() {
        new LoginPage(driver)
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

