package playwrightframework.factory;

import com.microsoft.playwright.*;
import playwrightframework.utils.ConfigReader;

public class BrowserFactory {

    public static Browser launchBrowser(Playwright playwright) {

        String browserName = System.getProperty("browser");

        if (browserName == null || browserName.isEmpty()) {
            browserName = ConfigReader.get("browser");
        }

        BrowserType.LaunchOptions options =
                new BrowserType.LaunchOptions()
                        .setHeadless(
                                Boolean.parseBoolean(
                                        ConfigReader.get("headless")
                                )
                        );

        switch (browserName.toLowerCase()) {

            case "firefox":
                return playwright.firefox().launch(options);

            case "webkit":
                return playwright.webkit().launch(options);

            default:
                return playwright.chromium().launch(options);
        }
    }
}
