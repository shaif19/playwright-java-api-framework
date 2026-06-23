package playwrightuisessions;

import com.microsoft.playwright.*;

public class BrowserContextDemo {
    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext br1 = browser.newContext();
        Page p1 = br1.newPage();
        p1.navigate("https://www.facebook.com");
        System.out.println(p1.title());

        BrowserContext br2 = (BrowserContext) browser.newContext();
        Page p2 = br1.newPage();
        p2.navigate("https://www.amazon.com");
        System.out.println(p1.title());

        p1.close();
        br1.close();

        p2.close();
        br2.close();

    }

}
