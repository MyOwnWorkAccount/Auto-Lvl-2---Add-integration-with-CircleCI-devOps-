package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EbayMainPage extends AbstractPage {
    public EbayMainPage(WebDriver driver) {
        super(driver);
    }

    private SearchBlock searchBlock;
    @FindBy(tagName = "html")
    private WebElement htmlElement;
    @FindBy(id = "gh-eb-Geo-a-default")
    private WebElement languagePanel;
    @FindBy(id = "gh-eb-Geo-a-en")
    private WebElement languageEnItem;
    @FindBy(css = "#gh-cart .gh-eb-li-a")
    private WebElement YourCartBtn;
    @FindBy(id = "gh-as-a")
    private WebElement AdvancedBtn;

    public EbayMainPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public EbayMainPage chooseEnLangIfNotChosen() {
        wait.until(ExpectedConditions.visibilityOf(htmlElement));
        if (htmlElement.getAttribute("lang").toLowerCase().equals("ru")) {
            Actions action = new Actions(driver);
            wait.until(ExpectedConditions.visibilityOf(languagePanel)).click();
            wait.until(ExpectedConditions.visibilityOf(languageEnItem)).click();
        }
        return this;
    }

    public EbaySearchResultsPage searchForProduct(String inputValue) {
        wait.until(ExpectedConditions.visibilityOf(searchBlock));
        searchBlock.search(inputValue);
        return new EbaySearchResultsPage(driver);
    }

    public EbayShoppingCartPage clickYourShoppingCartBtn() {
        wait.until(ExpectedConditions.visibilityOf(YourCartBtn)).click();
        return new EbayShoppingCartPage(driver);
    }

    public EbayAdvancedSearchPage clickAdvancedButton() {
        wait.until(ExpectedConditions.visibilityOf(AdvancedBtn)).click();
        return new EbayAdvancedSearchPage(driver);
    }
}
