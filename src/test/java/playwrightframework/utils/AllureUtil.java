package playwrightframework.utils;

import io.qameta.allure.Allure;

public class AllureUtil {

    public static void attachJson(String name, String json) {
        Allure.addAttachment(
                name,
                "application/json",
                json,
                ".json"
        );
    }

    public static void attachText(String name, String text) {
        Allure.addAttachment(name, text);
    }
}