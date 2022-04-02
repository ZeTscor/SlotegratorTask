package api.helpers.reques;

import api.helpers.data.PlayerRequest;
import api.helpers.data.RegPlayerData;
import com.github.javafaker.shaded.snakeyaml.external.biz.base64Coder.Base64Coder;


public class PlayerRequestGen{
      RegPlayerData faker = new RegPlayerData();
    public  PlayerRequest getNewPlayer(){
        PlayerRequest newPlayer = PlayerRequest.builder()
                .username(faker.getUsername())
                .passwordChange(Base64Coder.encodeString(faker.getPassword()))
                .passwordRepeat(Base64Coder.encodeString(faker.getPassword()))
                .email(faker.getEmail())
                .name(faker.getName())
                .surname(faker.getSurname())
                .currency_code("RUB")
                .build();
        return newPlayer;
    }
}
