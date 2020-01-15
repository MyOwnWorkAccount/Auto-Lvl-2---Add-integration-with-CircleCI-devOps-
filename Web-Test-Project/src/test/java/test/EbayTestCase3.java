package test;

import org.junit.Assert;
import org.junit.Test;
import page.EbayAdvancedSearchPage;
import page.EbayAllCategoriesPage;
import page.EbayMainPage;


public class EbayTestCase3 extends BaseTest {
    @Test
    public void testCase3() {
        logger.info("Navigate to Advanced search page.");
        EbayAdvancedSearchPage advancedSearchPage = new EbayMainPage(browser)
                .openPage(PropertyManager.url)
                .chooseEnLangIfNotChosen()
                .clickAdvancedButton();

        logger.info("Select 'Completed listings' and 'Show items priced from' with 0 to 1 $ range parameters.");
        EbayAllCategoriesPage allCategoriesPage = advancedSearchPage
                .checkCompletedListings()
                .checkCompletedListings()
                .setItemsPricedFrom(0)
                .setItemsPricedTo(1)
                .clickBottomSearchButton();

        Assert.assertTrue("All Categories page is not shown", allCategoriesPage.getPageName().equals("All Categories"));
    }
}
