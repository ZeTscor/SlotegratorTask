package api.helpers.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class AuthCredential {
    @Builder.Default
    @JsonProperty("grant_type")
    private String grant_type = "password";
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

}
