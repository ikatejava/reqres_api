package in.reqres.tests;

import in.reqres.models.CreateNewUserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.RequestSpecs.usersRequestSpecification;
import static in.reqres.specs.ResponseSpecs.deleteUser204;
import static in.reqres.specs.ResponseSpecs.getNewUserInfo201;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class deleteTests extends TestBase {
    @Test
    @Tag("delete")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Successful user deletion")
    void deleteUserSuccessTest() {
        CreateNewUserResponseModel createNewUserResponse = given(usersRequestSpecification)
                .body(createNewUserRequestBody)
                .when()
                .post()
                .then()
                .spec(getNewUserInfo201)
                .extract().as(CreateNewUserResponseModel.class);
        assertEquals(createNewUserRequestBody.getName(), createNewUserResponse.getName());
        assertEquals(createNewUserRequestBody.getJob(), createNewUserResponse.getJob());

        given(usersRequestSpecification)
                .when()
                .delete(String.valueOf(createNewUserResponse.getId()))
                .then()
                .spec(deleteUser204);
    }
}
