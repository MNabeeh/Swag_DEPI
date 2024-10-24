package Features_Pages.f4_CheckOut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P4_3_CompleteCheckOutPage {

    private WebDriver driver;

    public P4_3_CompleteCheckOutPage(WebDriver driver){
         this.driver=driver;
    }
    private String OpenMenu= "Logout";

    protected final By assertThatYouAreInCheckOutCompletePage = By.xpath("//span[text()='Checkout: Complete!']");
    protected  final  By  clickOnBackHomeBtn= By.xpath("//button[text()='Back Home']");
    protected  final By clickOnOpenMenuBtnToLogOut =By.xpath("//button[text()='Open Menu']");
    protected  final By clickOnLogOut = By.xpath("//nav[@class='bm-item-list']//a[@id='logout_sidebar_link']");
            //By.cssSelector("#logout_sidebar_link");
            //By.xpath("//a[text()= '"+ OpenMenu + "']");

    public By getAssertThatYouAreInCheckOutCompletePage(){
        return assertThatYouAreInCheckOutCompletePage;
    }

   public void clickOnBackHomeBtn (){
         driver.findElement(clickOnBackHomeBtn).click();

   }
    public void clickOnOpenMenuBtnToLogOut (){
        driver.findElement(clickOnOpenMenuBtnToLogOut).click();
        driver.findElement(clickOnLogOut).click();
    }
}
