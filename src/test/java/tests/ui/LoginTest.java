package tests.ui;

import org.junit.Assert;
import org.junit.Test;
import playwrightframework.base.UIBaseTest;
import playwrightframework.pages.LoginPage;
import playwrightframework.pages.ProductsPage;

public class LoginTest extends UIBaseTest {

    @Test
    public void loginTest() {

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

    }
}