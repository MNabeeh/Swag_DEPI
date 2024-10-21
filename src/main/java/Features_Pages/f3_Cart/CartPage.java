package Features_Pages.f3_Cart;

import Features_Pages.f4_CheckOut.CheckOutPage;
import Features_Pages.f2_Products.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    public CartPage (WebDriver driver){
        this .driver= driver;
    }


    protected  final  By assertCartWord= By.xpath("//span[text()='Your Cart']");
    protected final By continueShoppingBtn= By.xpath("//button[(text() = 'Continue Shopping')]");
    protected  final By checkoutBtn= By.xpath("//button[@id='checkout']");
    protected  final By assertThatOneItemInTheCart = By.xpath("//span[text()='1']");
    public   final By assertThatTwoItemInTheCart = By.xpath("//span[text()='2']");
    public   final By assertThatThereeItemInTheCart = By.xpath("//span[text()='3']");
    protected final By removeBtn= By.xpath("(//button[text()='Remove'])[2]");




    public By getAssertCartWord (){
        return assertCartWord;
    }
   public By getassertOneItemInTheCart (){
       return assertThatOneItemInTheCart;
   }
    public By getAssertThatTwoItemInTheCart(){
        return assertThatTwoItemInTheCart;
    }
    public By getAssertThatThreeItemInTheCart(){
        return assertThatTwoItemInTheCart;
    }

    public HomePage clickOnContinueShoopingBtn(){
       driver.findElement(continueShoppingBtn).click();
       return new HomePage(driver);
    }
    public CheckOutPage clickOnCheckoutBtn(){
        driver.findElement(checkoutBtn).click();
        return new CheckOutPage(driver);
    }

    public void clickOnRemoveBtn(){
        driver.findElement(removeBtn).click();



    }
}
