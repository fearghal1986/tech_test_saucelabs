package tech_test.hooks;

import tech_test.DriverFactory;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


public class Hooks {


    public static WebDriver driver;

    @Before
    public void initializeTest() {
        System.out.println("Before Driver");

        driver = DriverFactory.startDriver();
        System.out.println("After Driver");
    }


    @After()
    public void tearDown(Scenario scenario) {

        driver.close();
        driver.quit();

    }




}
