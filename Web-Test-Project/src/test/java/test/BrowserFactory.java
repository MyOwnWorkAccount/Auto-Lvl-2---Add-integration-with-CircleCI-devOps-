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
                //chromeOptions.addArguments("--headless");
                //chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("--ignore-certificate-errors");
				chromeOptions.addArguments("--test-type");
				chromeOptions.addArguments("test-type");
				chromeOptions.addArguments("start-maximized");
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("--enable-precise-memory-info");
				chromeOptions.addArguments("--disable-popup-blocking");
				chromeOptions.addArguments("--disable-default-apps");
				chromeOptions.addArguments("test-type=browser");
				chromeOptions.addArgument("--incognito");
				chromeOptions.addArgument("--no-sandbox");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "ff":
                WebDriverManager.getInstance(FIREFOX).setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                //ffOptions.addArguments("--headless");
                //ffOptions.addArguments("--window-size=1920,1080");
				ffOptions.addArguments("--ignore-certificate-errors");
				ffOptions.addArguments("--test-type");
				ffOptions.addArguments("test-type");
				ffOptions.addArguments("start-maximized");
				ffOptions.addArguments("--window-size=1920,1080");
				ffOptions.addArguments("--enable-precise-memory-info");
				ffOptions.addArguments("--disable-popup-blocking");
				ffOptions.addArguments("--disable-default-apps");
				ffOptions.addArguments("test-type=browser");
				ffOptions.addArgument("--incognito");
				ffOptions.addArgument("--no-sandbox");
                driver = new FirefoxDriver(ffOptions);
                break;
            default:
                throw new Exception("Browser with name '" + browser + "' is not supported");
        }
        return driver;
    }
}
