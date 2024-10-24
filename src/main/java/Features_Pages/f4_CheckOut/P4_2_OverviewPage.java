package Features_Pages.f4_CheckOut;

import Features_Pages.f2_Products.P2_1_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P4_2_OverviewPage {

    private WebDriver driver;

     public P4_2_OverviewPage(WebDriver driver){
          this.driver= driver;
     }


     protected final By assertThatYouAreInCheckOutPage = By.xpath("//span[text()='Checkout: Overview']");
     protected  final By finishBtn =By.xpath("//button[text()='Finish']");
     protected final By cancelBtn = By.xpath("//button[@id='cancel']");

      protected final By  firstITemPrice= By.xpath("//div[text()='7.99']");
      protected  final  By secondITemPrice = By.xpath("//div[text()='29.99']");
      protected  final By totalPrice= By.xpath("//div[text()='29.99']");


    public  By getAssertThatYouAreInCheckOutPage()
    {
        return assertThatYouAreInCheckOutPage;
    }


    public P4_3_CompleteCheckOutPage clickOnFinishBtn(){
        driver.findElement(finishBtn).click();
        return new P4_3_CompleteCheckOutPage(driver);
    }


    public P2_1_HomePage clickOnCancelBtn(){
        driver.findElement(cancelBtn).click();
        return new P2_1_HomePage(driver);
    }
}
