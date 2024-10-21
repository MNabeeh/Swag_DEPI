package Features_Pages.f2_Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    protected final By assertThebagPhoto = By.xpath("//img [contains(@src, '/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg')]");
    protected final By assertTheProdcutsWord= By.xpath("//span[(text() = 'Products')]");
            //By.xpath("//div[@class='header_label'] / div[@class='app_logo']");

    protected  final By dropDwonList = By.xpath("//select[@class='product_sort_container']");

    private String  addFirstProduct= "Sauce Labs Backpack";
    private String addSecondProduct= "Sauce Labs Bike Light";
    private String addThridProduct= "Sauce Labs Bolt T-Shirt";

    By clickOnProduct1 = By.xpath("//div[text() = '"+addFirstProduct+"']");
    By clickOnProduct2 = By.xpath("//div[text() = '"+addSecondProduct+"']");
    By clickOnProduct3 = By.xpath("//div[text() = '"+addThridProduct+"']");
    //div[text() = 'Sauce Labs Backpack']


    protected final By assertThePhotoOfThePage = By.xpath("(//img[contains(@src ,'static/media/sl-404.168b1cce.jpg' )])[1]");
    protected  final By removeBtn = By.xpath("(//button[text()='Remove'])[1]");
    protected final By addToCartBtn_firstProduct= By.xpath("(//button[text()='Add to cart'])[1]");
    protected final By addToCartBtn_secondProduct= By.xpath("(//button[text()='Add to cart'])[2]");
    protected final By addToCartBtn_ThirdProduct= By.xpath("(//button[text()='Add to cart'])[3]");


    public By getAsssertTheBagPhoto() {return assertThebagPhoto;}
    public By getAssertTheProdcutsWord (){
        return  assertTheProdcutsWord;
    }

    public By getAssertThePhotoOfThePage() {
        return assertThePhotoOfThePage;
    }

    public By getRemoveBtn(){
        return removeBtn;
    }
        public ProductPage choseYourFirstProduct() {
            driver.findElement(clickOnProduct1).click();
            return new ProductPage(driver);
        }

    public ProductPage choseYourSecondProduct () {
        driver.findElement(clickOnProduct2).click();
        return new ProductPage(driver);
    }


    public void clickOneTowProdctsFormTheHomePage(){
        driver.findElement(addToCartBtn_firstProduct).click();
        driver.findElement(addToCartBtn_secondProduct).click();

    }
    public void clickOneThreeProdctsFormTheHomePage(){
        driver.findElement(addToCartBtn_firstProduct).click();
        driver.findElement(addToCartBtn_secondProduct).click();
        driver.findElement(addToCartBtn_ThirdProduct ).click();
    }

    public void sortTheProducts(String text) {
        Select select = new Select(driver.findElement(dropDwonList));
        select.selectByVisibleText(text);

    }
    public  void clickOnRemoveBtn(){
        driver.findElement(removeBtn).click();

    }

    public By areProductsSortedByPriceLowToHigh() {
//        List<WebElement> productList = driver.findElements(dropDwonList);
//        List<Double> prices = new ArrayList<>();
        return dropDwonList;
    }

    public By assertThatAddToButtonISclickable (){
        return addToCartBtn_firstProduct;
    }
    public By getAddToCartBtn_secondProduct(){
        return addToCartBtn_secondProduct;
    }




}