//package playwrightsessions;
//import com.microsoft.playwright.*;
//import com.microsoft.playwright.options.*;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
//
//import java.nio.file.Paths;
//import java.util.*;
//
//public class Inspector {
//
//    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                    .setHeadless(false));
//            BrowserContext context = browser.newContext();
//
//            // Start tracing before creating/navigating a page
//            context.tracing().start(new Tracing.StartOptions()
//               .setScreenshots(true)
//               .setSnapshots(true));
//
//
//            Page page = context.newPage();
//            page.navigate("https://academy.naveenautomationlabs.com/");
//            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("EXPLORE COURSES")).click();
//            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).click();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).fill("Shaifali Mishra");
//           // page.pause();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).click();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).fill("shaifali.mishra20@gmail.com");
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).click();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).click();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).fill("12210000");
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).click();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).click();
//            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).fill("+91 78978-97890");
//
//            //Stop tracing and export it into a zip archive
//            context.tracing().stop(new Tracing.StopOptions()
//                    .setPath(Paths.get("trace.zip")));
//        }
//    }
//}
