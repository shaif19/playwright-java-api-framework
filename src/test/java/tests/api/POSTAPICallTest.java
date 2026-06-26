package tests.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class POSTAPICallTest {

    Playwright playwright;
    APIRequest apiRequest;
    APIRequestContext apiRequestcontext;

    @Before
    public void setup() {
        playwright = Playwright.create();
        apiRequest = playwright.request();
        apiRequestcontext = apiRequest.newContext();

    }

    //cannot write @Test here because it is static method
    public static String getRandomEmail(){
        String emailId= "shaifalimishra" +System.currentTimeMillis() +"@gmail.com"; //generate random email id
        return emailId;

    }
    @Test
    public void postCall() throws IOException {

        Map<String,Object> data= new HashMap<String,Object>();
        data.put("name","Naviine Kumar");
        data.put("email",getRandomEmail()); //email id should be unique
        data.put("gender","male");
        data.put("status","active");

        //POST Call: Create a user
        APIResponse apiPostResponse = apiRequestcontext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type","application/json")
                .setHeader("Authorization","Bearer cf38425df2282f98358988f59d6845c9d63087a2277130139fa5196c0e392d8e")
                .setData(data));

        System.out.println(apiPostResponse.status());
        Assert.assertEquals(apiPostResponse.status(),201);

        //print response body in pretty json format
        System.out.println(apiPostResponse.text());
        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode jsonresponse = objectMapper.readTree(apiPostResponse.body());
        String jsonPrettyResponse = jsonresponse.toPrettyString();
        System.out.println(jsonPrettyResponse);

        //capture id from the post json response
        String id = jsonresponse.get("id").asText();
        System.out.println(id);

        //Get call : fetch the above created user by id
       APIResponse apiGetResponse =  apiRequestcontext.get("https://gorest.co.in/public/v2/users/"+id,
                RequestOptions.create()
                        .setHeader("Authorization","Bearer cf38425df2282f98358988f59d6845c9d63087a2277130139fa5196c0e392d8e"));

           Assert.assertEquals(apiGetResponse.status(),200);
        System.out.println(apiPostResponse.text());
        }


}
