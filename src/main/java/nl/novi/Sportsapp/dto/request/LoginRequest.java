package nl.novi.Sportsapp.dto.request;

public class LoginRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
/// setPassword doet het niet waardoor ik niet kan inloggen
    public void setPassword(String password) {
        this.password = password;
    }
}
