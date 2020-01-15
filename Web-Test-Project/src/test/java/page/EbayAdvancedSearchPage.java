package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EbayAdvancedSearchPage extends AbstractPage {
    public EbayAdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "LH_Complete")
    private WebElement CompletedListingsCheckbox;
    @FindBy(id = "_mPrRngCbx")
    private WebElement ShowItemsPricedCheckbox;
    @FindBy(xpath = "//input[@name='_udlo']")
    private WebElement rangeMinPriceInput;
    @FindBy(xpath = "//input[@name='_udhi']")
    private WebElement rangeMaxPriceInput;
    @FindBy(id = "searchBtnLowerLnk")
    private WebElement bottomSearchButton;

    public EbayAdvancedSearchPage checkCompletedListings() {
        wait.until(ExpectedConditions.visibilityOf(CompletedListingsCheckbox)).click();
        return this;
    }

    public EbayAdvancedSearchPage checkShowItemsPriced() {
        wait.until(ExpectedConditions.visibilityOf(ShowItemsPricedCheckbox)).click();
        return this;
    }

    public EbayAdvancedSearchPage setItemsPricedFrom(int value) {
        rangeMinPriceInput.sendKeys(String.valueOf(value));
        return this;
    }

    public EbayAdvancedSearchPage setItemsPricedTo(int value) {
        rangeMaxPriceInput.sendKeys(String.valueOf(value));
        return this;
    }

    public EbayAllCategoriesPage clickBottomSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(bottomSearchButton)).click();
        return new EbayAllCategoriesPage(driver);
    }
}
