package tests.demo;

import com.microsoft.playwright.*;

public class TextSelector {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //text locators
        Page page = browser.newPage();
        page.navigate("https://orangehrm.com/");
        //fetch the text of total number of links
//        Locator links = page.locator( "text=Contact Sales");
//        for(int i=0;i<links.count();i++){
//            System.out.println(links.nth(i).textContent());

        //has text method
//        String header = page.locator("h3:has-text('People Management')").textContent();
//        System.out.println(header);

        //other way of writing has text method with parent tag,
        // here class = product-title, div->h3->people management
//        String header = page.locator("div.product-title h3:has-text('People Management')").textContent();
//        System.out.println(header);
//
//        //other way of text selector without using text
//        String pageHeader= page.locator("'Compensation'").textContent();
//        System.out.println(pageHeader);

        //button
        page.locator("form input:has-text('Start Your 30 Day Free Trial')").click();
        }






}

