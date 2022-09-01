package tech_test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import tech_test.utils.OSValidator;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver startDriver() {

        String projectLocation = System.getProperty("user.dir" );

        // add in elements for logging into the mobile application also - Android and
        // iOS.
        if (OSValidator.isMac()) {
            System.setProperty("webdriver.chrome.driver", projectLocation + "/chromedriver_mac" );
        } else if (OSValidator.isWindows()) {
            System.setProperty("webdriver.chrome.driver", projectLocation + "/chromedriver.exe" );
        } else {
            System.setProperty("webdriver.chrome.driver", projectLocation + "/chromedriver_linux" );
        }

//        -------------------- As per https://stackoverflow.com/questions/50642308/webdriverexception-unknown-error-devtoolsactiveport-file-doesnt-exist-while-t
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized" );
        options.addArguments("disable-infobars" );
        options.addArguments("--disable-extensions" );
        options.addArguments("--window-size=1024x768" );
        options.addArguments("--disable-cache" );
        options.addArguments("--disable-application-cache" );
        options.addArguments("--disk-cache-size=0" );
        options.addArguments("--disable-gpu" ); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage" ); // overcome limited resource problems
        options.addArguments("--dns-prefetch-disable" );
        options.addArguments("--no-sandbox" ); // Bypass OS security model
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        //--------------------

//        driver.manage().window().maximize();

        return driver;
    }

}
