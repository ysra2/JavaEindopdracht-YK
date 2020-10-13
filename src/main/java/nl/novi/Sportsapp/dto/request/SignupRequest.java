package nl.novi.Sportsapp.dto.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {


    @NotBlank
    @Size(max=40)
    @Email
    private String email;

    @NotBlank
    @Size(min=8, max=30)
    private String password;

    private Set<String> role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

}
