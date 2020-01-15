package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {
    WebDriver browser;
    Logger logger = LoggerFactory.getLogger(EbayTestCase3.class);

    @Before
    public void initializeDriver() throws Exception {
        String browserName = System.getProperty("browser");
        logger.info(this.getClass() + " started in browser: " + browserName);
        browser = BrowserFactory.getDriver(browserName);
        browser.manage().window().maximize();
    }

    @After
    public void releaseDriver() {
        if (browser != null) {
            browser.quit();
            browser = null;
        }
    }
}
