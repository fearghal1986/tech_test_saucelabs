package tech_test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage {

    @FindBy(xpath = "//*[@id='header_container']//span[contains(.,'Checkout: Complete!')]")
    public static WebElement checkoutCompleteHeading;


    public static boolean isCheckoutOverviewPageOpen(){

        try {
            checkoutCompleteHeading.isDisplayed();
            return true;
        } catch (Exception e ){
            System.out.println(e);
            return  false;
        }
    }

}
