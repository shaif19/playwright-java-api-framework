package playwrightapisessions.base;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import playwrightapisessions.utils.RetryRule;

public class BaseTest {

    protected Playwright playwright;
    protected APIRequest apiRequest;
    protected APIRequestContext apiRequestContext;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        apiRequest = playwright.request();
        apiRequestContext = apiRequest.newContext();
    }

    @After
    public void tearDown() {
        if (playwright != null) {
            playwright.close();
        }
    }

    @Rule
    public RetryRule retryRule = new RetryRule();
}