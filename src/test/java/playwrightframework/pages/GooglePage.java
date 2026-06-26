package playwrightframework.pages;

import com.microsoft.playwright.Page;
import playwrightframework.utils.ConfigReader;

public class GooglePage {

    private final Page page;

    public GooglePage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate(ConfigReader.get("google.url"));
    }

    public String getTitle() {
        return page.title();
    }
}