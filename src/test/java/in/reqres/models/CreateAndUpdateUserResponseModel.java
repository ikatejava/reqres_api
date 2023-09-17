package in.reqres.models;

import lombok.Data;

@Data
public class CreateAndUpdateUserResponseModel {
    String name, job, createdAt, updatedAt;
    int id;
}
