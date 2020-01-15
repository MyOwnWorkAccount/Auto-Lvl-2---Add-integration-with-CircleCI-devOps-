package test;

import org.junit.Assert;
import org.junit.Test;
import page.EbayMainPage;
import page.EbaySearchResultsPage;
import page.EbayShoppingCartPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EbayTestCase2 extends BaseTest {
    @Test
    public void testCase2() {
        logger.info("Click Your shopping cart button.");
        EbayShoppingCartPage shoppingCartPage = new EbayMainPage(browser)
                .openPage(PropertyManager.url)
                .chooseEnLangIfNotChosen()
                .clickYourShoppingCartBtn();

        logger.info("Search for 'tttttttttttttttttttt' in 'Baby' category.");
        EbaySearchResultsPage searchResultsPage = shoppingCartPage
                .chooseSearchCategory("Baby")
                .searchForProduct("tttttttttttttttttttt");

        Pattern pattern = Pattern.compile("^\\d+(,\\d+)?");
        Matcher matcher = pattern.matcher(searchResultsPage.getResultsFieldText());
        matcher.find();
        Assert.assertEquals("Result field is not '0 results'", "0", matcher.group());

        Assert.assertTrue("Result header is unexpected",
                searchResultsPage.getNullSearchHeadingText().contains("No exact matches found"));
    }
}
