package tech_test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static tech_test.utils.Util.*;

public class CheckoutPage {


    @FindBy(xpath = "//*[@id='header_container']//span[contains(.,'Checkout: Your Information')]")
    public static WebElement checkoutHeading;

    @FindBy(id = "first-name")
    public static WebElement firstNameInput;

    @FindBy(id = "last-name")
    public static WebElement lastNameInput;

    @FindBy(id = "postal-code")
    public static WebElement addressInput;

    @FindBy(id = "continue")
    public static WebElement continueButton;

    @FindBy(xpath = "//*[@id='checkout_info_container']//form//h3")
    public static WebElement addressError;


    public static boolean isCheckoutPageOpen(){

        try {
            checkoutHeading.isDisplayed();
            return true;
        } catch (Exception e ){
            System.out.println(e);
            return  false;
        }
    }


    public static void checkoutDetails(String input,String field){

        switch (field) {
            case "first name":
                waitForElementToBeClickable(firstNameInput);
                firstNameInput.sendKeys(input);
                break;
            case "last name":
                waitForElementToBeClickable(lastNameInput);
                lastNameInput.sendKeys(input);
                break;
            case "address":
                waitForElementToBeClickable(addressInput);
                addressInput.sendKeys(input);
                break;

        }
    }

    public static void selectContinueButton(){

        continueButton.click();

    }


    public static String addressErrorText(){
        sleepForTime(2000);
        waitForElementToBeVisible(addressError);
        System.out.println(addressError.getText());
        return addressError.getText();
    }


}
