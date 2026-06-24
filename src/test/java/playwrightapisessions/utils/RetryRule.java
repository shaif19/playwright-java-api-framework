package playwrightapisessions.utils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {

    private int retryCount;
    private final int maxRetry = 2;

    @Override
    public Statement apply(Statement base, Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                Throwable error = null;

                for (retryCount = 0; retryCount <= maxRetry; retryCount++) {
                    try {
                        base.evaluate(); // run test
                        return; // PASS → stop retrying
                    } catch (Throwable t) {
                        error = t;

                        System.out.println(
                                "Retrying test: " + description.getMethodName()
                                        + " | Attempt: " + (retryCount + 1)
                        );
                    }
                }

                throw error; // final failure after retries
            }
        };
    }
}