package tech_test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import static tech_test.hooks.Hooks.driver;

import static tech_test.utils.Util.sleepForTime;
import static tech_test.utils.Util.waitImplicit;

public class CartPage {

    @FindBy(xpath = "//*[@id='header_container']//span[contains(.,'Your Cart')]")
    public static WebElement productHeading;

    @FindBy(xpath = "//*[@id='cart_contents_container']//div[2]/div[2]/button")
    public static List<WebElement> removeItemButtons;

    @FindBy(xpath = "//*[@id='cart_contents_container']//div[3]/div[2]/div[2]/button")
    public static WebElement firstRemoveItemButton;

    @FindBy(xpath = "//button[contains(.,'Checkout')]")
    public static WebElement checkoutButton;

    @FindBy(xpath = "//button[contains(.,'Continue Shopping')]")
    public static WebElement continueShoppingButton;


    public static void emptyCart() {

        //count the number of remove buttons
        int xpathCount = removeItemButtons.size();

        //As the user deletes the count drops
        for (int i = xpathCount; i > 0; --i) {

            try {
                sleepForTime(1000);
                selectFirstRemoveButton();
                xpathCount--;
            } catch (Exception e) {

                System.out.println("No products present");
            }


        }


    }

    public static void selectFirstRemoveButton(){

        firstRemoveItemButton.click();
        waitImplicit(driver,2);
    }
    public static void selectContinueShopping(){

        continueShoppingButton.click();
        waitImplicit(driver,2);
    }
    public static void selectCheckout(){

        checkoutButton.click();
        waitImplicit(driver,10);
    }

}
