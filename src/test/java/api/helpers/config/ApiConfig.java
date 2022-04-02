package api.helpers.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api.properties"
})

public interface ApiConfig extends Config {
    @Key("guestLogin")
    @DefaultValue("front_2d6b0a8391742f5d789d7d915755e09e")
    String guestLogin();

    @Key("guestPassword")
    @DefaultValue("")
    String guestPassword();

    @Key("tokenEndPoint")
    @DefaultValue("/v2/oauth2/token")
    String tokenEndPoint();

    @Key("playerEndPoint")
    @DefaultValue("/v2/players/{id}")
    String playerEndPoint();

    @Key("playersEndPoint")
    @DefaultValue("/v2/players")
    String playersEndPoint();

    @Key("baseUrl")
    @DefaultValue("http://test-api.d6.dev.devcaz.com")
    String baseUrl();
}
