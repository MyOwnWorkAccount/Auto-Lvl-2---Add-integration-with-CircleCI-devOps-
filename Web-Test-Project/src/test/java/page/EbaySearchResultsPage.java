package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EbaySearchResultsPage extends AbstractPage {
    public EbaySearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private final String appropriatePhonesXPath =
            "//a[contains(@class, 's-item__link')]" +
                "[.//*[contains(@class, '--tagblock')][not(.//span[text()='S'] " +
                 "and .//span[text()='P'] and .//span[text()='O'] " +
                 "and .//span[text()='N'] and .//span[text()='R'] " +
                 "and .//span[text()='E'] and .//span[text()='D'])]]" +
                     "[..//*[contains(@class, 'mskuInfo')]]";

    @FindBy(className = "s-item__wrapper")
    private List<WebElement> productItems;
    @FindBy(xpath = "//*[contains(@class, 'fake-tabs__items')]//a[.//*[normalize-space()='Buy It Now']]")
    private WebElement BuyItNowButton;
    @FindBy(xpath = appropriatePhonesXPath)
    private List<WebElement> phonesLinks;
    @FindBy(className = "srp-controls__count-heading")
    private WebElement ResultsField;
    @FindBy(className = "srp-save-null-search__heading")
    private WebElement nullSearchHeading;

    private int randomItem;

    public int getProductItemsCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(productItems)).size();
    }

    public EbaySearchResultsPage clickBuyItNowButton() {
        wait.until(ExpectedConditions.visibilityOf(BuyItNowButton)).click();
        return this;
    }

    public String chooseRandomItem() {
        randomItem = (int) Math.round(Math.random() * (phonesLinks.size() - 1));
        String phoneNameInResultsList = (String) ((JavascriptExecutor) driver).executeScript(
                "return document.evaluate(arguments[0], " +
                        "document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null).snapshotItem(arguments[1]).textContent",
                appropriatePhonesXPath + "//h3/text()", randomItem);
        return phoneNameInResultsList;
    }

    public EbayProductDetailsPage clickRandomItem() {
        wait.until(ExpectedConditions.visibilityOfAllElements(phonesLinks)).get(randomItem).click();
        return new EbayProductDetailsPage(driver);
    }

    public String getResultsFieldText() {
        return wait.until(ExpectedConditions.visibilityOf(ResultsField)).getText();
    }

    public String getNullSearchHeadingText() {
        return wait.until(ExpectedConditions.visibilityOf(nullSearchHeading)).getText();
    }

    public EbaySearchResultsPage getPageSource() {
        System.out.println(driver.getPageSource());
        return this;
    }
}
