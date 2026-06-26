package playwrightframework.factory;

import playwrightframework.model.User;

public class UserFactory {

    public static User createRandomActiveUser() {

        User user = new User();

        long timestamp = System.currentTimeMillis();

        user.setName("User" + timestamp);
        user.setEmail("user" + timestamp + "@gmail.com");
        user.setGender("male");
        user.setStatus("active");

        return user;
    }
}