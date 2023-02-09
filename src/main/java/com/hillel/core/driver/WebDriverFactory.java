package com.hillel.core.driver;
import com.hillel.core.Browsers;
import com.hillel.util.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private static final String BROWSER = System.getProperty("browser");

    public static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.BROWSER;
        return getDriver(Browsers.valueOf(browserType.toUpperCase()));
    }

    public static WebDriver getDriver(Browsers browsers) {
        return switch (browsers) {
            case CHROME -> getChromeDriver();
            case FIREFOX -> getFirefoxDriver();
            case SAFARI -> getSafariDriver();
            case OPERA -> getOperaDriver();
            default -> throw new IllegalArgumentException("The wrong browser was selected");
        };
    }

    private static WebDriver getChromeDriver() {
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        if (driver==null){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    private static WebDriver getSafariDriver(){
        if (driver==null){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        return driver;
    }

    private static WebDriver getOperaDriver(){
        if (driver==null){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        return driver;
    }

}