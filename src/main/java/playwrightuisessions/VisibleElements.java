package playwrightuisessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class VisibleElements {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.facebook.com/");

        //All links text
        List<String> linksText = page.locator("a:visible").allInnerTexts();
        for (int i = 0; i < linksText.size(); i++) {
            System.out.println(linksText.get(i));

        }

        //Images count
        int imageCount = page.locator("xpath=//img>>visible=true").count();
        System.out.println(imageCount);
    }
}
