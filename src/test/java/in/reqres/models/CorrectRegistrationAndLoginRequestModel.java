package in.reqres.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CorrectRegistrationAndLoginRequestModel {
    String email, password;
}
