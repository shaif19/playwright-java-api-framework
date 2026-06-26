package playwrightframework.client;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import playwrightframework.utils.AllureUtil;
import playwrightframework.utils.ConfigReader;

public class ApiClient {

    private static final Logger logger = LogManager.getLogger(ApiClient.class);

    private final APIRequestContext apiRequestContext;
    private final String baseUrl;
    private final String token;

    public ApiClient(APIRequestContext apiRequestContext) {
        this.apiRequestContext = apiRequestContext;
        this.baseUrl = ConfigReader.get("base.url");
        this.token = ConfigReader.get("bearer.token");
    }

    public APIResponse post(String endpoint, String requestBody) {

        logger.info("POST Request URL: {}{}", baseUrl, endpoint);
        logger.info("POST Request Body: {}", requestBody);

        AllureUtil.attachJson("POST Request Body", requestBody);

        APIResponse response = apiRequestContext.post(
                baseUrl + endpoint,
                RequestOptions.create()
                        .setHeader("Content-Type", "application/json")
                        .setHeader("Authorization", "Bearer " + token)
                        .setData(requestBody)
        );

        logger.info("POST Response Status: {}", response.status());
        logger.info("POST Response Body: {}", response.text());

        AllureUtil.attachJson("POST Response Body", response.text());
        AllureUtil.attachText("POST Status Code", String.valueOf(response.status()));

        return response;
    }

    public APIResponse get(String endpoint) {

        logger.info("GET Request URL: {}{}", baseUrl, endpoint);

        APIResponse response = apiRequestContext.get(
                baseUrl + endpoint,
                RequestOptions.create()
                        .setHeader("Authorization", "Bearer " + token)
        );

        logger.info("GET Response Status: {}", response.status());
        logger.info("GET Response Body: {}", response.text());

        AllureUtil.attachJson("GET Response Body", response.text());
        AllureUtil.attachText("GET Status Code", String.valueOf(response.status()));

        return response;
    }
}