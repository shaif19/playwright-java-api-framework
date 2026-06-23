package playwrightuisessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        //page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

        //use css selector inside frame locator
//        String header= page.frameLocator("frame[name='main']").locator("h2").textContent();
//        System.out.println(header);

        //use frame only
//        String header1 = page.frame("main").locator("h2").textContent();
//        System.out.println(header1);

        //use xpath inside frame locator
//        String header2 = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
//        System.out.println(header2);

        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
        page.frameLocator("//iframe[contains(@id,'frame-one')]")
                .locator("#RESULT_TextField-8").fill("Naveen automation");
    }
}
