package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EbayProductDetailsPage extends AbstractPage {
    public EbayProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "itemTitle")
    private WebElement productTitle;
    @FindBy(xpath = "//*[contains(@class,'nonActPanel')]//select")
    private List<WebElement> dropdowns;
    @FindBy(id = "qtyTextBox")
    private List<WebElement> quantityTextBox;
    @FindBy(id = "isCartBtn_btn")
    private WebElement AddToCartButton;

    public String getPhoneName() {
        return wait.until(ExpectedConditions.visibilityOf(productTitle)).getText();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public EbayProductDetailsPage chooseDropdownsValues() {
        wait.until(ExpectedConditions.visibilityOfAllElements(dropdowns));
        if (!dropdowns.isEmpty()) {
            for (WebElement dropdown: dropdowns) {
                Select select = new Select(dropdown);
                List<WebElement> options = select.getOptions();
                int choise;
                do {
                    choise = (int) Math.round(1 + Math.random() * (options.size() - 2));
                } while (!options.get(choise).isEnabled());
                select.selectByIndex(choise);
            }
        }
        return this;
    }

    public EbayProductDetailsPage chooseProductQuantity(int quantity) {
        if (!quantityTextBox.isEmpty()) {
            WebElement qTextBox = quantityTextBox.get(0);
            if (qTextBox.isEnabled()) {
                qTextBox.clear();
                qTextBox.sendKeys(String.valueOf(quantity));
            }
        }
        return this;
    }

    public EbayShoppingCartPage clickAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(AddToCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddToCartButton);
        return new EbayShoppingCartPage(driver);
    }
}
