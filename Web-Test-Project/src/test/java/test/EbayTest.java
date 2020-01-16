package test;

import org.junit.Assert;
import org.junit.Test;
import page.EbayMainPage;
import page.EbayProductDetailsPage;
import page.EbaySearchResultsPage;
import page.EbayShoppingCartPage;


public class EbayTest extends BaseTest {
    @Test
    public void testEbayComplex() {
        logger.info("Force language to EN. Search for product.");
        EbaySearchResultsPage searchResultsPage = new EbayMainPage(browser)
                .openPage(PropertyManager.url)
                .chooseEnLangIfNotChosen()
                .searchForProduct("Xiaomi Mi A1 64GB");

        int productItemsCount = searchResultsPage.getProductItemsCount();
        //Assert.assertEquals("Search results page does not contain 50 results", 50, productItemsCount);
        logger.info("Click Buy It Now button. Navigate to Details Page of random product.");
        String phoneNameInResultsList = searchResultsPage
                .clickBuyItNowButton()
                .chooseRandomItem();
        EbayProductDetailsPage productDetailsPage = searchResultsPage.clickRandomItem();

        String phoneNameInDetailsPage = productDetailsPage.getPhoneName();
        Assert.assertEquals("Product names in search results list and in details page are not the same",
                phoneNameInResultsList, phoneNameInDetailsPage);
        Assert.assertTrue("Current page is Product Details page",
                productDetailsPage.getPageUrl().toLowerCase().contains("/itm/"));
        logger.info("Select product params and quantity.");
        EbayShoppingCartPage shoppingCartPage = productDetailsPage
                .chooseDropdownsValues()
                .chooseProductQuantity(1)
                .clickAddToCartButton();

        Assert.assertTrue("Current page is not Cart",
                shoppingCartPage.getPageSource().getTitleName().toLowerCase().contains("shopping cart"));
        Assert.assertEquals("Cart does not contain 1 product",
                1, shoppingCartPage.getCartProductsCount());
        Assert.assertEquals("Product name in details page and in cart page is not the same",
                phoneNameInDetailsPage, shoppingCartPage.getCartProductName());
        Assert.assertTrue("Cart does not contain 1 pieces of a product",
                shoppingCartPage.getCartItemsText().contains("1"));
    }
}
