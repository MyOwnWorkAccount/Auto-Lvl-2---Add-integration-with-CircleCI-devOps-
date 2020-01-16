package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class EbayShoppingCartPage extends AbstractPage {
    public EbayShoppingCartPage(WebDriver driver) {
        super(driver);
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100));
    }

    Wait<WebDriver> fluentWait;

    private SearchBlock searchBlock;
    @FindBy(className = "main-title")
    private WebElement cartTitle;
    @FindBy(className = "cart-bucket")
    private List<WebElement> cartItems;
    @FindBy(css = ".cart-bucket .BOLD")
    private WebElement cartProductName;
    @FindBy(xpath = "//*[@class='cartsummary']//span[contains(text(), 'Item')]")
    private WebElement cartItemsText;

    public String getTitleName() {
        return wait.until(ExpectedConditions.visibilityOf(cartTitle)).getText();
    }

    public int getCartProductsCount() {
        return fluentWait.until(ExpectedConditions.visibilityOfAllElements(cartItems)).size();
    }

    public String getCartProductName() {
        return wait.until(ExpectedConditions.visibilityOf(cartProductName)).getText();
    }

    public String getCartItemsText() {
        return wait.until(ExpectedConditions.visibilityOf(cartItemsText)).getText();
    }

    public EbayShoppingCartPage chooseSearchCategory(String categoryName) {
        wait.until(ExpectedConditions.visibilityOf(searchBlock));
        searchBlock.selectCategory(categoryName);
        return this;
    }

    public EbaySearchResultsPage searchForProduct(String inputValue) {
        wait.until(ExpectedConditions.visibilityOf(searchBlock));
        searchBlock.search(inputValue);
        return new EbaySearchResultsPage(driver);
    }

    public EbayShoppingCartPage getPageSource() {
        System.out.println(driver.getPageSource());
        return this;
    }
}
