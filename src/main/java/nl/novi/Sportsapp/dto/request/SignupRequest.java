package nl.novi.Sportsapp.dto.request;


import nl.novi.Sportsapp.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {

    @NotBlank
    @Size(min=8, max=30)
    private String username;

    @NotBlank
    @Size(max=40)
    @Email
    private String email;

    private Set<Role> role;

    @NotBlank
    @Size(min=8, max=30)
    private String password;


    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
