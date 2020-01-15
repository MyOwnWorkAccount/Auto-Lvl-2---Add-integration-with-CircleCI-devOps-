package page;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(css = "#gh-f .gh-tbl2")
public class SearchBlock extends HtmlElement {
    @FindBy(id = "gh-ac")
    private TextInput requestInput;
    @FindBy(id = "gh-btn")
    private Button searchButton;
    @FindBy(id = "gh-cat")
    private Select dropdown;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }

    public void selectCategory(String categoryName) {
        dropdown.selectByVisibleText(categoryName);
    }
}
