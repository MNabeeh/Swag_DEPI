package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

    private WebDriver driver;

     public  OverviewPage (WebDriver driver){
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


    public CompleteCheckOutPage clickOnFinishBtn(){
        driver.findElement(finishBtn).click();
        return new CompleteCheckOutPage(driver);
    }


    public HomePage clickOnCancelBtn(){
        driver.findElement(cancelBtn).click();
        return new HomePage(driver);
    }
}
