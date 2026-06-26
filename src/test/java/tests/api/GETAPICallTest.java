package tests.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class GETAPICallTest {

    Playwright playwright;
    APIRequest request;
    APIRequestContext requestContext;

    @Before
    public void setUp(){
       playwright = Playwright.create();
       request = playwright.request();
       requestContext = request.newContext();
    }

    @Test
    public void getUsersApiTest() throws IOException {

//        Playwright playwright = Playwright.create();
//        APIRequest request = playwright.request();
//        APIRequestContext requestContext = request.newContext();


        APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users");
        int statusCode = apiResponse.status();
        System.out.println("response status code: " +statusCode);
        Assert.assertEquals(apiResponse.status(),200);

        //printing response body
        ObjectMapper objectmapper = new ObjectMapper();
        JsonNode jsonResponse= objectmapper.readTree(apiResponse.body());
        String jsonPrettyResponse = jsonResponse.toPrettyString(); //beautify json like postman response
        System.out.println(jsonPrettyResponse);

        //check URL of response
        System.out.println(apiResponse.url());

        //print response headers using .headers
        System.out.println(apiResponse.headers());

        //print response headers using .headersArray
        Map<String,String> headersMap = apiResponse.headers();
        System.out.println(headersMap);
        Assert.assertEquals(headersMap.get("content-type"),"application/json; charset=utf-8");
        Assert.assertEquals(headersMap.get("cache-control"),"max-age=0, private, must-revalidate");
    }


    //how to use query param
    //https://gorest.co.in/public/v2/users?id=8512086&status=active

    @Test
    public void getSpecificUser() {  //query param example
        APIResponse apiResponse = requestContext.get("https://gorest.co.in/public/v2/users",
                RequestOptions.create()
                        .setQueryParam("gender", "male")
                        .setQueryParam("status", "active"));
        System.out.println("----------------query param example----------------");
        System.out.println(apiResponse.status());
        System.out.println(apiResponse.text());
    }

    @After
    public void tearDown(){
        playwright.close();
    }


    }


