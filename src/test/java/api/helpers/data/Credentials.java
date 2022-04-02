package api.helpers.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Credentials {
    @Builder.Default
    @JsonProperty("grant_type")
    private String grant_type = "client_credentials";
    @Builder.Default
    @JsonProperty("scope")
    private String scope = "guest:default";
}
