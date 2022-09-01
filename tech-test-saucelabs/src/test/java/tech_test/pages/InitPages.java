package tech_test.pages;

import org.openqa.selenium.support.PageFactory;

import static tech_test.hooks.Hooks.driver;


public class InitPages {

    public static String currentUrl = "";

    public static void startBrowserAndLaunch() {

        initAllPages();
        selectAndLaunchUrl();

    }


    private static void selectAndLaunchUrl() {

        driver.get("https://www.saucedemo.com/");
    }


    private static void initAllPages() { // Add EACH ONE of the pages to be initiated here, regardless of which section they may be coming from, otherwise a Null Pointer Exception may occur
        PageFactory.initElements(driver, InitPages.class);
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, ProductPage.class);
        PageFactory.initElements(driver, CartPage.class);
        PageFactory.initElements(driver, CheckoutPage.class);
        PageFactory.initElements(driver, CheckoutOverviewPage.class);
        PageFactory.initElements(driver, CheckoutCompletePage.class);

    }

}
