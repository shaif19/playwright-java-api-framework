package playwrightframework.pages;

import com.microsoft.playwright.Page;

public class ProductsPage {

    private final Page page;

    private final String backpackAddToCartBtn =
            "#add-to-cart-sauce-labs-backpack";

    private final String shoppingCartBadge =
            ".shopping_cart_badge";

    public ProductsPage(Page page) {
        this.page = page;
    }

    public boolean isProductsPageDisplayed() {

        return page.url().contains("inventory.html");
    }

    public void addBackpackToCart() {

        page.locator(backpackAddToCartBtn).click();
    }

    public String getCartCount() {

        return page.locator(shoppingCartBadge).textContent();
    }
}