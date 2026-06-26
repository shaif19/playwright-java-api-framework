//package playwrightsessions;
//
//import com.microsoft.playwright.*;
//
//public class LocatorsDemo {
//
//    public static void main(String[] args) {
//
//        Playwright playwright = Playwright.create();
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//
//        BrowserContext br1 = browser.newContext();
//        Page p1 = br1.newPage();
//        p1.navigate("https://www.facebook.com");
//
//        //Single element
//        Locator createAccount = p1.locator("text=Create new account");
//        createAccount.click();
//
//        //By chance there are more than 1 login texts on page
//        //Locator loginBtn = p1.locator("text=login");
//        //loginBtn.first().click();
//
//        //multiple elements
//        Locator selectOptions = p1.locator ();
//        System.out.println();
//
//
//    }
//}
