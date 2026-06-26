package tests.ui;

import org.junit.Test;
import playwrightframework.base.UIBaseTest;
import playwrightframework.pages.GooglePage;
import org.junit.Assert;

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