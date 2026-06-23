package playwrightapisessions;

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

public class TokenTest {

    Playwright playwright;
    APIRequest apiRequest;
    APIRequestContext apiRequestcontext;

    @Before
    public void setup() {
        playwright = Playwright.create();
        apiRequest = playwright.request();
        apiRequestcontext = apiRequest.newContext();

    }
    @Test
    public void getTokenTest() throws IOException {

        //String json
        String reqTokenJsonBody = "{\n" +
                "  \"username\" : \"admin\",\n" +
                "  \"password\" : \"password123\"\n" +
                "}";

        //POST Call: Create a token
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

        Assert.assertNotNull(token);
    }
}
