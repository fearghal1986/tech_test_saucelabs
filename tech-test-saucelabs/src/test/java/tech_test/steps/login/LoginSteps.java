package tech_test.steps.login;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static tech_test.pages.InitPages.startBrowserAndLaunch;
import static tech_test.pages.LoginPage.*;
import static tech_test.pages.ProductPage.*;
import static tech_test.pages.CartPage.*;


import static org.junit.Assert.*;

public class LoginSteps {

    @Given("I am on login page")
    public void iAmOnLoginPage() {

        startBrowserAndLaunch();
        loginButtonIsDisplayed();
    }

    @When("login with {string}")
    public void loginWithValidUsername(String username) {

        loginDifferentUsers(username);
    }

    @Then("login error is displayed as {string}")
    public void loginErrorIsDisplayedAs(String error) {

        assertTrue(loginErrorText().contains(error));
    }


    @When("login without username")
    public void loginWithoutUsername() {

        attemptLogin("","secret_sauce");
    }

    @When("login without password")
    public void loginWithoutPassword() {

        attemptLogin("standard_user","");

    }

    @When("login with {string}and empty cart")
    public void loginWithValidUsernameAndEmptyCart(String username) {
        startBrowserAndLaunch();
        loginButtonIsDisplayed();
        loginDifferentUsers(username);
        selectShoppingCart();
        emptyCart();
        selectContinueShopping();



    }
}