package tests.ui;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import playwrightframework.base.UIBaseTest;
import playwrightframework.pages.GooglePage;
import org.junit.Assert;
import tags.Smoke;

@Category(Smoke.class)
public class GoogleTest extends UIBaseTest {

    @Test
    public void openGoogle() {

        GooglePage googlePage = new GooglePage(page);
        googlePage.open();

        Assert.assertTrue(
                googlePage.getTitle().contains("Google")
        );
    }
}