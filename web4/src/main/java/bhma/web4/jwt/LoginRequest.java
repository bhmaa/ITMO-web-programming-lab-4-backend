package bhma.web4.jwt;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {
    }
}
