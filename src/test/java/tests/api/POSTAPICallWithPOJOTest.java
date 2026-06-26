package tests.api;

import TestingData.User;
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

public class POSTAPICallWithPOJOTest {

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
        //create users object
        User user = new User("34567","Naveen",getRandomEmail(),"female","active");

        //POST Call: Create a user
        APIResponse apiPostResponse = apiRequestcontext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type","application/json")
                .setHeader("Authorization","Bearer cf38425df2282f98358988f59d6845c9d63087a2277130139fa5196c0e392d8e")
                .setData(user));

        System.out.println(apiPostResponse.status());
        Assert.assertEquals(apiPostResponse.status(),201);


        String responseText = apiPostResponse.text();
        System.out.println(responseText);

        //convert response text/json to POJO-- deserialization
        ObjectMapper objectMapper = new ObjectMapper();
        User actualUser= objectMapper.readValue(responseText,User.class);
        Assert.assertEquals(actualUser.getEmail(),user.getEmail());
        Assert.assertEquals(actualUser.getName(),user.getName());
        Assert.assertEquals(actualUser.getStatus(),user.getStatus());
        Assert.assertEquals(actualUser.getGender(),user.getGender());
    }
}
