package Features_Pages.f4_CheckOut;

import Features_Pages.f3_Cart.P3_CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P4_1_CheckOutPage {
    private WebDriver driver;
      public P4_1_CheckOutPage(WebDriver driver){
           this.driver= driver;
      }

    protected  final By assertThatYouAreInCheckOutPage =By.xpath("//span[text()='Checkout: Your Information']");
    protected  final By firstNameBtn = By.xpath("//input[@id='first-name']");
    protected  final By lasttNameBtn = By.xpath("//input[@id='last-name']");
    protected  final By postalCodeBtn= By.xpath("//input[@id='postal-code']");
    protected  final By cancelBtn = By.xpath("//button[@id='cancel']");
    protected  final By continueBtn = By.xpath("//input[@id='continue']");

    public  By getAssertThatYouAreInCheckOutPage (){
        return assertThatYouAreInCheckOutPage;
    }

    public P4_2_OverviewPage fillCheckOutDate(String  FirstName, String LastName, String PostalCode){
         driver.findElement(firstNameBtn).sendKeys(FirstName);
         driver.findElement(lasttNameBtn).sendKeys(LastName);
         driver.findElement(postalCodeBtn).sendKeys(PostalCode);
         driver.findElement(continueBtn).click();
         return new P4_2_OverviewPage(driver);
    }

    public P3_CartPage cancelCheckOut() {
        driver.findElement(cancelBtn).click();
        return new P3_CartPage(driver);
    }














}
