package playwrightframework.base;

import org.junit.Rule;
import playwrightframework.utils.RetryRule;

public class RetryBaseTest {

    //For retry flaky tests
    @Rule
    public RetryRule retryRule = new RetryRule();
}
