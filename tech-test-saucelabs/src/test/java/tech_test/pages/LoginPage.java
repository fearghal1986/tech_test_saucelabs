package tech_test.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static tech_test.utils.Util.*;

public class LoginPage {


    public static String validUsername = "standard_user";
    public static String lockedUsername = "locked_out_user";
    public static String problemUsername = "problem_user";
    public static String performanceUsername = "performance_glitch_user";
    public static String validPassword = "secret_sauce";


    @FindBy(id = "user-name")
    public static WebElement usernameEl;
    @FindBy(id = "password")
    public static WebElement passwordEl;
    @FindBy(id = "login-button")
    public static WebElement loginButtonEl;
    @FindBy(xpath = "//*[@id='login_button_container']//h3")
    public static WebElement loginErrorText;


    public static void validCredentials() {


        attemptLogin(validUsername, validPassword); }

    public static void validInputCredentials(String username, String password) {

        attemptLogin(username, password);
    }


    private static void inputLoginDetails(String username, String password) {
        waitForElementToBeClickable(usernameEl);
        usernameEl.clear();
        System.out.println(username);
        usernameEl.sendKeys(username);
        waitForElementToBeClickable(passwordEl);
        passwordEl.clear();
        System.out.println(password);
        passwordEl.sendKeys(password);
    }


    public static void attemptLogin(String username, String password) {
        inputLoginDetails(username, password);
        clickLoginButton();
    }

    public static void clickLoginButton() {
        loginButtonEl.click();
    }


    public static void typeUsername() {
        usernameEl.sendKeys(validUsername); }


    public static void typePassword() {
        passwordEl.sendKeys(validPassword);
    }


    public static void clickLogin() {
        loginButtonEl.click();
    }

    public static boolean loginButtonIsDisplayed() {

        try {
            waitForElementToBeVisible(loginButtonEl);
            return true;
        } catch (Exception e){
            System.out.println("login button displayed");
            return false;
        }


    }
    public static void loginDifferentUsers(String username) {


        switch (username) {
            case "valid username":
                attemptLogin( validUsername, validPassword);
                break;
            case "locked username":
                attemptLogin(lockedUsername, validPassword);
                break;
            case "problem username":
                attemptLogin(problemUsername, validPassword);
                break;
            // have to use a different xpath for tasks
            case "performance username":
                attemptLogin(performanceUsername, validPassword);
                break;

        }


    }


    public static String loginErrorText(){

        waitForElementToBeVisible(loginErrorText);
        System.out.println(loginErrorText);
        return loginErrorText.getText();
    }





}
