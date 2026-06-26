package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import playwrightframework.base.UIBaseTest;
import playwrightframework.pages.LoginPage;
import playwrightframework.pages.ProductsPage;

public class AddToCartTest extends UIBaseTest {

    @Test
    public void addBackpackToCartTest() {

        page.navigate("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(page);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        ProductsPage productsPage = new ProductsPage(page);

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed()
        );

        productsPage.addBackpackToCart();
        Assert.assertEquals(
                "1",
                productsPage.getCartCount()
        );

    }
}