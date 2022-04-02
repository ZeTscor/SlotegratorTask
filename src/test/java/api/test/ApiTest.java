package api.test;

import api.helpers.data.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ApiTest extends TestBase {
    @Test
    @Tag("API")
    @DisplayName("Получения токена гостя")
    public void getTokenGuestTest() {
        Token token = restConst.getGuestToken();
        Assertions.assertNotNull(token.getAccess_token());
    }

    @Test
    @Tag("API")
    @DisplayName("Регистарция нового пользователя")
    public void registerPlayerTest() {
        PlayerRequest newPlayerRequest = newPlayer.getNewPlayer();
        Token authToken = restConst.getGuestToken();
        String headerToken = authToken.getAccess_token();
        PlayerProfileInfo newPlayer = restConst.registerNewPlayer(newPlayerRequest, headerToken);
        Assertions.assertEquals(newPlayerRequest.getUsername(), newPlayer.getUsername());
    }

    @Test
    @Tag("API")
    @DisplayName("Авторизация пользователя и получения его токенна")
    public void loginPlayerTest() {
        PlayerRequest newPlayerRequest = newPlayer.getNewPlayer();
        Token authToken = restConst.getGuestToken();
        String headerToken = authToken.getAccess_token();
        restConst.registerNewPlayer(newPlayerRequest, headerToken);
        AuthCredential requestBody = AuthCredential.builder()
                .username(newPlayerRequest.getUsername())
                .password(newPlayerRequest.getPasswordChange())
                .build();
        Token tokenPlayer = restConst.getTokenPlayer(requestBody);
        Assertions.assertNotNull(tokenPlayer.getAccess_token());
    }

    @Test
    @Tag("API")
    @DisplayName("Получения провфиля пользователя")
    public void getPlayerProfileTest() {
        PlayerRequest newPlayerRequest = newPlayer.getNewPlayer();
        Token authToken = restConst.getGuestToken();
        String headerToken = authToken.getAccess_token();
        PlayerProfileInfo newPlayer = restConst.registerNewPlayer(newPlayerRequest, headerToken);
        AuthCredential requestBody = AuthCredential.builder()
                .username(newPlayerRequest.getUsername())
                .password(newPlayerRequest.getPasswordChange())
                .build();
        Token tokenPlayer = restConst.getTokenPlayer(requestBody);
        PlayerProfileInfo currentProfile = restConst.getPlayerProfile(tokenPlayer.getAccess_token(), newPlayer.getId());
        Assertions.assertNotNull(currentProfile.getId());
        Assertions.assertEquals(newPlayer.getUsername(), currentProfile.getUsername());
        Assertions.assertEquals(newPlayer.getEmail(), currentProfile.getEmail());
    }

    @Test
    @Tag("API")
    @DisplayName("Получения профеля другого пользователя")
    public void getAnotherPlayerProfileTest() {
        PlayerRequest newPlayerRequest = newPlayer.getNewPlayer();
        Token authToken = restConst.getGuestToken();
        String headerToken = authToken.getAccess_token();
        restConst.registerNewPlayer(newPlayerRequest, headerToken);
        AuthCredential requestBody = AuthCredential.builder()
                .username(newPlayerRequest.getUsername())
                .password(newPlayerRequest.getPasswordChange())
                .build();
        Token tokenPlayer = restConst.getTokenPlayer(requestBody);
        Response anotherProfile = restConst.getAnotherProfile(tokenPlayer.getAccess_token());
        Assertions.assertEquals(404, anotherProfile.statusCode());
    }
}
