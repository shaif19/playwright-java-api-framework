package playwrightframework.base;

import com.microsoft.playwright.*;
import org.junit.After;
import org.junit.Before;
import playwrightframework.factory.BrowserFactory;

public class UIBaseTest extends RetryBaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @Before
    public void setUp() {

        playwright = Playwright.create();

        browser = BrowserFactory.launchBrowser(playwright);

        context = browser.newContext();

        page = context.newPage();
    }

    @After
    public void tearDown() {

        if (context != null)
            context.close();

        if (browser != null)
            browser.close();

        if (playwright != null)
            playwright.close();
    }
}