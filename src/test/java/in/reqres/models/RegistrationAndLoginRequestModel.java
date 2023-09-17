package in.reqres.models;

import lombok.Data;

@Data
public class RegistrationAndLoginRequestModel {
    String username, email, password;

    public RegistrationAndLoginRequestModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public RegistrationAndLoginRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegistrationAndLoginRequestModel(String email) {
        this.email = email;
    }
}




