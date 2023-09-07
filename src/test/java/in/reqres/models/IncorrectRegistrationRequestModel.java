package in.reqres.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IncorrectRegistrationRequestModel {
    String username, email, password;
}
