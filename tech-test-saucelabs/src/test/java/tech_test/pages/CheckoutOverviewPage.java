package tech_test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage {

    @FindBy(xpath = "//*[@id='header_container']//span[contains(.,'Checkout: Overview')]")
    public static WebElement checkoutOverviewHeading;

    @FindBy(id = "finish")
    public static WebElement finishButton;

    @FindBy(id = "cancel")
    public static WebElement cancelButton;

    public static boolean isCheckoutOverviewPageOpen(){

        try {
            checkoutOverviewHeading.isDisplayed();
            return true;
        } catch (Exception e ){
            System.out.println(e);
            return  false;
        }
    }

    public static void selectCancelButton(){

        cancelButton.click();

    }


    public static void selectFinishButton(){

        finishButton.click();

    }

}
