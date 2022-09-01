package tech_test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static tech_test.hooks.Hooks.driver;
import static tech_test.utils.Util.*;


public class ProductPage {

    @FindBy(xpath = "//*[@id='header_container']//span[contains(.,'Products')]")
    public static WebElement productHeading;

    @FindBy(xpath = "react-burger-menu-btn")
    public static WebElement burgerButton;


    @FindBy(xpath = "//*[@id='shopping_cart_container']//span")
    public static WebElement cartContainer;

    @FindBy(id = "shopping_cart_container")
    public static WebElement shoppingCartElement;

    @FindBy(xpath = "//button[contains(.,'Add to cart')]")
    public static WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(.,'Back to products')]")
    public static WebElement backToProductsButton;

    @FindBy(xpath = "//button[contains(.,'Remove')]")
    public static WebElement removeButton;


    public static boolean isProductPageOpen(){

        try{
            return globalExplicitWait.until(ExpectedConditions.visibilityOf(productHeading)).isDisplayed();
        }catch (NoSuchElementException e){ return false; }

    }



    public static String cartContainer() {

        return cartContainer.getText();
    }

    public static boolean cartContainerDisplayed() {

        try{
            return cartContainer.isDisplayed();
        }catch (NoSuchElementException e){ return false; }
    }

    //enable user to selects specific products, helpful if comparing prices etc
    public static WebElement product(String elementName) {
        WebElement ele = driver.findElement(By.xpath("//*[@class=\"inventory_item\"]//div//a[contains(.,'"+elementName+"')]"));
        return ele;
    }


    public static void selectProduct(String prod){

        product(prod).click();

    }

    public static void selectShoppingCart(){

        shoppingCartElement.click();

    }

    public static void selectAddToCart(){

        addToCartButton.click();

    }

    public static void selectBackToProducts(){

        backToProductsButton.click();

    }


    public static boolean isRemoveButtonDisplayed(){

        try{
            return removeButton.isDisplayed();
        }catch (NoSuchElementException e){ return false; }
    }


}
