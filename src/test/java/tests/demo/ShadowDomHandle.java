package tests.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomHandle {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
        page.frameLocator("#pact").first().locator("div#snacktime #tea").fill("Ginger");

    }
}
