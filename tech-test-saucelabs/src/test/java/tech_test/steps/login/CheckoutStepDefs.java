package tech_test.steps.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static tech_test.pages.CartPage.*;
import static tech_test.pages.InitPages.startBrowserAndLaunch;
import static tech_test.pages.LoginPage.loginButtonIsDisplayed;
import static tech_test.pages.LoginPage.loginDifferentUsers;
import static tech_test.pages.ProductPage.*;
import static tech_test.pages.CheckoutPage.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CheckoutStepDefs {

    @When("item is added and checkout page is opened")
    public void itemIsAddedAndCheckoutPageIsOpened() {

        startBrowserAndLaunch();
        loginButtonIsDisplayed();
        loginDifferentUsers("valid username");
        selectShoppingCart();
        emptyCart();
        selectContinueShopping();
        selectProduct("Sauce Labs Backpack");
        selectAddToCart();
        selectShoppingCart();
        selectCheckout();
        assertTrue(isCheckoutPageOpen());

    }

    @When("item is added and checkout page is opened with problem user")
    public void itemIsAddedAndCheckoutPageIsOpenedProblem() {

        startBrowserAndLaunch();
        loginButtonIsDisplayed();
        loginDifferentUsers("problem username");
        selectShoppingCart();
        emptyCart();
        selectContinueShopping();
        selectProduct("Sauce Labs Backpack");
        selectAddToCart();
        selectShoppingCart();
        selectCheckout();
        assertTrue(isCheckoutPageOpen());

    }


    @And("text {string} is added to {string} input")
    public void textIsAddedToInput(String input, String field) {

        checkoutDetails(input,field);
    }

    @And("continue button is selected")
    public void continueButtonIsSelected() {

        selectContinueButton();

    }

    @Then("address error is displayed as {string}")
    public void addressErrorIsDisplayedAs(String text) {
        assertTrue(addressErrorText().contains(text));

    }

    @And("valid name and address details are entered")
    public void validNameAndAddressDetailsAreEntered() {

        checkoutDetails("Joe","first name");
        checkoutDetails("bloggs","last name");
        checkoutDetails("ireland","address");
        selectContinueButton();


    }
}
