package api.helpers.additionalReq;

import api.helpers.config.ApiConfig;
import api.helpers.data.*;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;

import java.util.Random;

import static api.helpers.spec.Spec.requestSpec;

public class AdditionalRequest {
    static ApiConfig api = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public Token getGuestToken() {
        Credentials requestBody = Credentials.builder().build();
        Token token = requestSpec()
                .auth().preemptive()
                .basic(api.guestLogin(), api.guestPassword())
                .body(requestBody)
                .post(api.tokenEndPoint())
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .body().as(Token.class);
        return token;
    }

    public PlayerProfileInfo registerNewPlayer(PlayerRequest newReq, String token) {
        PlayerProfileInfo newPlayer = requestSpec()
                .headers("Authorization", "Bearer " + token)
                .body(newReq)
                .post(api.playersEndPoint())
                .then()
                .statusCode(201)
                .log()
                .all()
                .extract()
                .body().as(PlayerProfileInfo.class);
        return newPlayer;
    }

    public Token getTokenPlayer(AuthCredential playerLogRequest) {
        Token token = requestSpec()
                .auth().preemptive()
                .basic(api.guestLogin(), api.guestPassword())
                .body(playerLogRequest)
                .post(api.tokenEndPoint())
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .body().as(Token.class);
        return token;
    }

    public PlayerProfileInfo getPlayerProfile(String token, long id) {
        PlayerProfileInfo player = requestSpec()
                .headers("Authorization", "Bearer " + token)
                .get(api.playerEndPoint(), id)
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .body().as(PlayerProfileInfo.class);
        return player;
    }

    public Response getAnotherProfile(String token) {
        Random rand = new Random();
        int value = rand.nextInt(32325355);
        Response player = requestSpec()
                .headers("Authorization", "Bearer " + token)
                .get(api.playersEndPoint() + "/" + value)
                .then()
                .statusCode(404)
                .log()
                .all()
                .extract()
                .response();
        return player;
    }

}
