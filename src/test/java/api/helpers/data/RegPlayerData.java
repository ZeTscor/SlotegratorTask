package api.helpers.data;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class RegPlayerData {
    private Faker faker = new Faker();
    private String username = faker.name().username();
    private String password = faker.internet().password();
    private String email = faker.internet().emailAddress();
    private String name = faker.name().firstName();
    private String surname = faker.name().lastName();
}
