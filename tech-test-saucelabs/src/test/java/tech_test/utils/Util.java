package tech_test.utils;

import tech_test.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static tech_test.hooks.Hooks.driver;

public class Util {


    public static WebDriver init(WebDriver wd) {
        wd = DriverFactory.startDriver();
        return wd;
    }


    public static void waitImplicit(WebDriver wd, int time) {
        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    public static WebDriverWait globalExplicitWait =  new WebDriverWait(driver, 3);



    public static WebElement waitExplicitly(WebDriver wd, By by) {

        WebDriverWait wait = new WebDriverWait(wd, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForElementToBeVisible(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,3);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitForElementToBeClickable(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static boolean isElementDisplayed(WebElement e) {
        try {
            return e.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public static boolean isElementEnabled(WebElement e) {
        try {
            return e.isEnabled();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public static void checkEquals(String text1, String text2) {
        Assert.assertEquals(text1, text2);
    }


    public static JavascriptExecutor clickWithJS(WebDriver wd, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("arguments[0].click();", element);
        return js;
    }

    public static void clickWithActions(WebDriver wd, WebElement element) {
        Actions actions = new Actions(wd);
        actions.moveToElement(element).click().perform();
    }

    public static void sendKeysWithActions(WebElement e, CharSequence... keys) {
        Actions actions = new Actions(driver);
        actions.moveToElement(e).sendKeys(keys).build().perform();
    }

    public static void scrollInto(WebDriver wd, WebElement element) {

        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
    }


    public static WebElement waitExplicitely(WebDriver wd, By by) {

        WebDriverWait wait = new WebDriverWait(wd, 3);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void sleepForTime(int timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








}

