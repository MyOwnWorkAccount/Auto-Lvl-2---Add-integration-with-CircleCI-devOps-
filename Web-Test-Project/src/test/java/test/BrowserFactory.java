package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) throws Exception {
        WebDriver driver;
        switch (browser) {
            case "edge":
                WebDriverManager.getInstance(EDGE).setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.getInstance(CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                //chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "ff":
                WebDriverManager.getInstance(FIREFOX).setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--headless");
                //ffOptions.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(ffOptions);
                break;
            default:
                throw new Exception("Browser with name '" + browser + "' is not supported");
        }
        return driver;
    }
}
