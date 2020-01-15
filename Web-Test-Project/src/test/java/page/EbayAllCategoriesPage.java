package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EbayAllCategoriesPage extends AbstractPage {
    public EbayAllCategoriesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".all-categories-left-nav-container h1")
    private WebElement mainLabel;

    public String getPageName() {
        return wait.until(ExpectedConditions.visibilityOf(mainLabel)).getText();
    }
}
