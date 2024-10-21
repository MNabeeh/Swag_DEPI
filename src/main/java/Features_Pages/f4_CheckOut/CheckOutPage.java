package Features_Pages.f4_CheckOut;

import Features_Pages.f3_Cart.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    private WebDriver driver;
      public  CheckOutPage (WebDriver driver){
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

    public OverviewPage fillCheckOutDate(String  FirstName, String LastName, String PostalCode){
         driver.findElement(firstNameBtn).sendKeys(FirstName);
         driver.findElement(lasttNameBtn).sendKeys(LastName);
         driver.findElement(postalCodeBtn).sendKeys(PostalCode);
         driver.findElement(continueBtn).click();
         return new OverviewPage(driver);
    }

    public CartPage cancelCheckOut() {
        driver.findElement(cancelBtn).click();
        return new CartPage(driver);
    }














}
