package in.reqres.tests;

import in.reqres.models.CreateAndUpdateUserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.RequestSpecs.usersRequestSpecification;
import static in.reqres.specs.ResponseSpecs.getNewUserInfo201;
import static in.reqres.specs.ResponseSpecs.updateUserInfo200;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PutAndPatchTests extends TestBase {
    @Test
    @Tag("put_patch")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Successful update user's information")
    void updateUserInfoWithPUTMethodSuccessTest() {
        CreateAndUpdateUserResponseModel createNewUserResponse = given(usersRequestSpecification)
                .body(createNewUserRequestBody)
                .when()
                .post()
                .then()
                .spec(getNewUserInfo201)
                .extract().as(CreateAndUpdateUserResponseModel.class);
        assertEquals(createNewUserRequestBody.getName(), createNewUserResponse.getName());
        assertEquals(createNewUserRequestBody.getJob(), createNewUserResponse.getJob());

        CreateAndUpdateUserResponseModel updateUserInfoResponse = given(usersRequestSpecification)
                .body(updateUserRequestModel)
                .when()
                .put(String.valueOf(createNewUserResponse.getId()))
                .then()
                .spec(updateUserInfo200)
                .extract().as(CreateAndUpdateUserResponseModel.class);
        assertEquals(updateUserRequestModel.getName(), updateUserInfoResponse.getName());
        assertEquals(updateUserRequestModel.getJob(), updateUserInfoResponse.getJob());
    }

    @Test
    @Tag("put_patch")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Successful update user's information")
    void updateUserInfoWithPATCHMethodSuccessTest() {
        CreateAndUpdateUserResponseModel createNewUserResponse = given(usersRequestSpecification)
                .body(createNewUserRequestBody)
                .when()
                .post()
                .then()
                .spec(getNewUserInfo201)
                .extract().as(CreateAndUpdateUserResponseModel.class);
        assertEquals(createNewUserRequestBody.getName(), createNewUserResponse.getName());
        assertEquals(createNewUserRequestBody.getJob(), createNewUserResponse.getJob());

        CreateAndUpdateUserResponseModel updateUserInfoResponse = given(usersRequestSpecification)
                .body(updateUserRequestModel)
                .when()
                .patch(String.valueOf(createNewUserResponse.getId()))
                .then()
                .spec(updateUserInfo200)
                .extract().as(CreateAndUpdateUserResponseModel.class);
        assertEquals(updateUserRequestModel.getName(), updateUserInfoResponse.getName());
        assertEquals(updateUserRequestModel.getJob(), updateUserInfoResponse.getJob());
    }
}
