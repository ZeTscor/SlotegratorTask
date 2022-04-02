package api.helpers.spec;

import api.helpers.config.ApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Spec {
    static ApiConfig api = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public static RequestSpecification requestSpec() {
        return given()
                .spec(new RequestSpecBuilder().build())
                .contentType(ContentType.JSON)
                .baseUri(api.baseUrl())
                .when();
    }
}
