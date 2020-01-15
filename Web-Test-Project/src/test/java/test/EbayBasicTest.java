package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class EbayBasicTest extends BaseTest {
    @Test
    public void testEbaySearch() {
        browser.get(PropertyManager.url);
        WebElement input = browser.findElement(By.id("gh-ac"));
        input.sendKeys("jbl");
        input.submit();
    }
}
