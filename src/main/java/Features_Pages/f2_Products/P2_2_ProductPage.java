package Features_Pages.f2_Products;

import Features_Pages.f3_Cart.P3_CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P2_2_ProductPage {
    private WebDriver driver;
    public P2_2_ProductPage(WebDriver driver) {this.driver= driver;};

    protected  final By assertPrice = By.xpath("//div[@class =\"inventory_details_price\"]");
    protected  final By clickOnAddToCartBtn= By.xpath("//button[@id='add-to-cart']");
    protected  final By assertThatTheProductIsAdded = By.xpath("//a[@class='shopping_cart_link']// span");

    protected  final By clickOnCartLogo= By.cssSelector("#shopping_cart_container ");




    public  By getAssertPrice(){
        return assertPrice;
    }

    public  By getAssertThatTheProductIsAdded(){
        return assertThatTheProductIsAdded;
    }
    public P2_2_ProductPage clickOnAddToCartBtn(){
        driver.findElement(clickOnAddToCartBtn).click();
        return this;
    }
    public P3_CartPage clickOnCartLogo(){
        driver.findElement(clickOnCartLogo).click();
        return new P3_CartPage(driver);
    }

}
