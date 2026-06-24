package playwrightapisessions.utils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {

    private final int maxRetry = 2;

    @Override
    public Statement apply(Statement base, Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                Throwable lastError = null;

                for (int attempt = 0; attempt <= maxRetry; attempt++) {

                    try {
                        System.out.println("Running test: " + description.getMethodName()
                                + " Attempt: " + (attempt + 1));

                        base.evaluate();
                        return;

                    } catch (Throwable t) {
                        lastError = t;

                        boolean isTimeout =
                                t.getMessage() != null &&
                                        t.getMessage().toLowerCase().contains("timeout");

                        // ❌ DO NOT retry assertion failures
                        boolean isAssertion =
                                t instanceof AssertionError;

                        if (isAssertion) {
                            throw t; // fail immediately
                        }

                        // retry ONLY timeout-related issues
                        if (!isTimeout || attempt == maxRetry) {
                            throw t;
                        }

                        System.out.println("Retrying due to timeout...");
                    }
                }

                throw lastError;
            }
        };
    }
}