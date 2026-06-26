package playwrightframework.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private final String username = "#user-name";
    private final String password = "#password";
    private final String loginButton = "#login-button";

    public LoginPage(Page page) {
        this.page = page;

    }
        public void login(String user, String pass) {

            page.locator(username).fill(user);

            page.locator(password).fill(pass);

            page.locator(loginButton).click();
        }

}