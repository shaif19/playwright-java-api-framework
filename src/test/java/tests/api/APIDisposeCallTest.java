//Dispose the body of this reponse, if not called then the body will stay in memory until the context closes.

package tests.api;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class APIDisposeCallTest {

    Playwright playwright;
    APIRequest apiRequest;
    APIRequestContext apiRequestContext;

    @Before
    public void setup(){
        playwright= Playwright.create();
        apiRequest = playwright.request();
        apiRequestContext= apiRequest.newContext();
    }

    @Test
    public void disposeResponseTest(){
        APIResponse apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setQueryParam("gender","male")
                .setQueryParam("status","active"));
        System.out.println("-----print api response with plain text-----");
        System.out.println(apiResponse.text());
        apiResponse.dispose();// dispose will only dispose response body but status code, url etc will remain same
//        System.out.println("-----print api response with plain text after dispose-----");
//        System.out.println(apiResponse.text());
        System.out.println(apiResponse.status());
        System.out.println(apiResponse.statusText());

    }

    @After
    public void tearDown(){
        playwright.close();
    }
}
