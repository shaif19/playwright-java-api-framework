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
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

@Ignore
public class UpdateBookingUsingTokenTest {

    Playwright playwright;
    APIRequest apiRequest;
    APIRequestContext apiRequestcontext;
    private static String token = null;

    @Before
    public void setup() throws IOException {
        playwright = Playwright.create();
        apiRequest = playwright.request();
        apiRequestcontext = apiRequest.newContext();
        //POST Call: Create a token

        String reqTokenJsonBody = "{\n" +
                "  \"username\" : \"admin\",\n" +
                "  \"password\" : \"password123\"\n" +
                "}";
        APIResponse apiPostResponse = apiRequestcontext.post("https://restful-booker.herokuapp.com/auth", RequestOptions.create()
                .setHeader("Content-Type","application/json")
                .setData(reqTokenJsonBody));

        System.out.println(apiPostResponse.status());
        Assert.assertEquals(apiPostResponse.status(),200);

        //print response body in pretty json format
        System.out.println(apiPostResponse.text());
        ObjectMapper objectMapper= new ObjectMapper();
        JsonNode jsonresponse = objectMapper.readTree(apiPostResponse.body());
        String jsonPrettyResponse = jsonresponse.toPrettyString();
        System.out.println(jsonPrettyResponse);

        //capture token from the post json response
        String token = jsonresponse.get("token").asText();
        System.out.println(token);


    }

    @Test
    public void updateBookingTest(){
        String bookingJson= "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        APIResponse apiResponse = apiRequestcontext.put("https://restful-booker.herokuapp.com/booking/1",
                RequestOptions.create()
                        .setHeader("Content-Type","application/json")
                        .setHeader("Cookie","token="+token)
                        .setData(bookingJson));

        System.out.println(apiResponse.status());
        Assert.assertEquals(apiResponse.status(),200);
    }

}
