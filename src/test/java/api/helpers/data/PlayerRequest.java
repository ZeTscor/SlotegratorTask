package api.helpers.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class PlayerRequest {
    @NotNull
    @JsonProperty("username")
    private String username;
    @NotNull
    @JsonProperty("password_change")
    private String passwordChange;
    @NotNull
    @JsonProperty("password_repeat")
    private String passwordRepeat;
    @NotNull
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("currency_code")
    private String currency_code;
}
