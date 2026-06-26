package tests.api;

import TestingData.User;
import TestingData.UsersWithLombok;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

@Ignore
public class DELETEAPICallTest {

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

        //1. POST Call- Create User
        //create users object: using builder pattern
        UsersWithLombok users = UsersWithLombok.builder()
                .name("Shaifali Mishra")
                .email(getRandomEmail())
                .gender("female")
                .status("active").build();

        //1. POST Call: Create a user
        APIResponse apiPostResponse = apiRequestcontext.post("https://gorest.co.in/public/v2/users", RequestOptions.create()
                .setHeader("Content-Type","application/json")
                .setHeader("Authorization","Bearer cf38425df2282f98358988f59d6845c9d63087a2277130139fa5196c0e392d8e")
                .setData(users));

        System.out.println(apiPostResponse.status());
        Assert.assertEquals(apiPostResponse.status(),201);


        String responseText = apiPostResponse.text();
        System.out.println(responseText);

        //convert response text/json to POJO-- deserialization
        ObjectMapper objectMapper = new ObjectMapper();
        User actualUser= objectMapper.readValue(responseText,User.class);
        Assert.assertEquals(actualUser.getEmail(),users.getEmail());
        Assert.assertEquals(actualUser.getName(),users.getName());
        Assert.assertEquals(actualUser.getStatus(),users.getStatus());
        Assert.assertEquals(actualUser.getGender(),users.getGender());
        Assert.assertNotNull(actualUser.getId());

        String userId = actualUser.getId();
        System.out.println("new user is :"+userId);

        System.out.println("---------------------------------------------");

        //2. DELETE Call- Update User
        APIResponse apiPutResponse = apiRequestcontext.delete("https://gorest.co.in/public/v2/users/"+userId, RequestOptions.create()
                .setHeader("Content-Type","application/json")
                .setHeader("Authorization","Bearer cf38425df2282f98358988f59d6845c9d63087a2277130139fa5196c0e392d8e")
                .setData(users));
        System.out.println(apiPutResponse.status());

//        String putResponseText = apiPutResponse.text();
//        System.out.println("update user :"+putResponseText);
//        User actualUser2 = objectMapper.readValue(putResponseText, User.class);
//        Assert.assertEquals(actualUser2.getName(),users.getName());
//        Assert.assertEquals(actualUser2.getStatus(),users.getStatus());

        //3. Get Call: get updated user info
        APIResponse apiGetResponse = apiRequestcontext.put("https://gorest.co.in/public/v2/users/"+userId, RequestOptions.create()
                .setHeader("Content-Type","application/json")
                .setHeader("Authorization","Bearer cf38425df2282f98358988f59d6845c9d63087a2277130139fa5196c0e392d8e")
                .setData(users));
        System.out.println(apiGetResponse.status());
//        System.out.println(users.getName());
//        System.out.println(users.getStatus());
        ;
    }
}
