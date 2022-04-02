package api.helpers.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Token {
    private String token_type;
    private long expires_in;
    private String access_token;
    private String refresh_token;
}
