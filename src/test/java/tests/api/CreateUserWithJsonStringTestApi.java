package tests.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import playwrightframework.base.ApiBaseTest;
import playwrightframework.client.ApiClient;
import playwrightframework.factory.UserFactory;
import playwrightframework.model.User;

import java.io.IOException;

public class CreateUserWithJsonStringTestApi extends ApiBaseTest {

    @Step("Create user using POST API")
    private APIResponse createUser(String requestBody) {
        ApiClient apiClient = new ApiClient(apiRequestContext);
        return apiClient.post("/users", requestBody);
    }

    @Test
    @Description("Create a new user using POJO and verify it using GET API")
    public void postCall() throws IOException {

        // Generate random test data
        User user = UserFactory.createRandomActiveUser();

        // Convert POJO to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJsonBody = objectMapper.writeValueAsString(user);

        // Execute POST API
        APIResponse apiPostResponse = createUser(requestJsonBody);

        // Validate POST status code
        Assert.assertEquals(201, apiPostResponse.status());

        // Parse POST response
        JsonNode postResponse =
                objectMapper.readTree(apiPostResponse.body());

        // Validate created user
        Assert.assertEquals(user.getEmail(), postResponse.get("email").asText());
        Assert.assertEquals(user.getStatus(), postResponse.get("status").asText());

        // Capture created user id
        String userId = postResponse.get("id").asText();

        // Execute GET API
        ApiClient apiClient = new ApiClient(apiRequestContext);
        APIResponse apiGetResponse = apiClient.get("/users/" + userId);

        // Validate GET status code
        Assert.assertEquals(200, apiGetResponse.status());

        // Parse GET response
        JsonNode getResponse =
                objectMapper.readTree(apiGetResponse.body());

        // Validate fetched user data
        Assert.assertEquals(user.getName(), getResponse.get("name").asText());
        Assert.assertEquals(user.getEmail(), getResponse.get("email").asText());
        Assert.assertEquals(user.getGender(), getResponse.get("gender").asText());
        Assert.assertEquals(user.getStatus(), getResponse.get("status").asText());
    }
}