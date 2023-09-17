package in.reqres.tests;

import in.reqres.models.CreateAndUpdateUserResponseModel;
import in.reqres.models.ErrorResponseModel;
import in.reqres.models.RegistrationAndLoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.RequestSpecs.*;
import static in.reqres.specs.ResponseSpecs.*;
import static in.reqres.tests.TestData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTests extends TestBase {
    @Test
    @Tag("post")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Successful creation of a new user")
    void createUserSuccessTest() {
        CreateAndUpdateUserResponseModel createNewUserResponse = step("Make request", () ->
                given(usersRequestSpecification)
                        .body(createNewUserRequestBody)
                        .when()
                        .post()
                        .then()
                        .spec(getNewUserInfo201)
                        .extract().as(CreateAndUpdateUserResponseModel.class));
        step("Check response 201", () -> {
            assertEquals(createNewUserRequestBody.getName(), createNewUserResponse.getName());
            assertEquals(createNewUserRequestBody.getJob(), createNewUserResponse.getJob());
        });
    }

    @Test
    @Tag("post")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Successful registration of a new user")
    void registerUserSuccessTest() {
        RegistrationAndLoginResponseModel successfulRegistration = step("Make request", () ->
                given(registerUserRequestSpecification)
                        .body(rightRegAndAuthData)
                        .when()
                        .post()
                        .then()
                        .spec(getNewlyRegisteredUserInfo200)
                        .extract().as(RegistrationAndLoginResponseModel.class));
        step("Check response 200", () -> {
            assertEquals(newUserId, successfulRegistration.getId());
            assertEquals(userToken, successfulRegistration.getToken());
        });
    }

    @Test
    @Tag("post")
    @Tag("users")
    @Tag("negative")
    @DisplayName("Unsuccessful registration of a new user with missing password")
    void registerUserMissingPasswordTest() {
        ErrorResponseModel failedRegistration = step("Make request", () ->
                given(registerUserRequestSpecification)
                        .body(missingPasswordRegAndAuthData)
                        .when()
                        .post()
                        .then()
                        .spec(failedToRegisterOrAuthorizeUser400)
                        .extract().as(ErrorResponseModel.class));
        step("Check response 400", () ->
                assertEquals(errorMissingPassword, failedRegistration.getError()));
    }

    @Test
    @Tag("post")
    @Tag("users")
    @Tag("negative")
    @DisplayName("Unsuccessful registration of a new user")
    void registerUserFailedTest() {
        ErrorResponseModel failedRegistration = step("Make request", () ->
                given(registerUserRequestSpecification)
                        .body(wrongRegAndAuthData)
                        .when()
                        .post()
                        .then()
                        .spec(failedToRegisterOrAuthorizeUser400)
                        .extract().as(ErrorResponseModel.class));
        step("Check response 400", () ->
                assertEquals(errorRegistrationMessage, failedRegistration.getError()));
    }

    @Test
    @Tag("post")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Successful login of existing user")
    void LoginSuccessTest() {
        RegistrationAndLoginResponseModel successfulLogin = step("Make request", () ->
                given(loginRequestSpecification)
                        .body(rightRegAndAuthData)
                        .when()
                        .post()
                        .then()
                        .spec(successfulLogin200)
                        .extract().as(RegistrationAndLoginResponseModel.class));
        step("Check response 200", () ->
                assertEquals(userToken, successfulLogin.getToken()));
    }

    @Test
    @Tag("post")
    @Tag("users")
    @Tag("negative")
    @DisplayName("Unsuccessful login of existing user with missing password")
    void loginUserMissingPasswordTest() {
        ErrorResponseModel failedLogin = step("Make request", () ->
                given(loginRequestSpecification)
                        .body(missingPasswordRegAndAuthData)
                        .when()
                        .post()
                        .then()
                        .spec(failedToRegisterOrAuthorizeUser400)
                        .extract().as(ErrorResponseModel.class));
        step("Check response 400", () ->
                assertEquals(errorMissingPassword, failedLogin.getError()));
    }

    @Test
    @Tag("post")
    @Tag("users")
    @Tag("negative")
    @DisplayName("Unsuccessful login of unexisting user")
    void loginFailedTest() {
        ErrorResponseModel failedLogin = step("Make request", () ->
                given(loginRequestSpecification)
                        .body(wrongRegAndAuthData)
                        .when()
                        .post()
                        .then()
                        .spec(failedToRegisterOrAuthorizeUser400)
                        .extract().as(ErrorResponseModel.class));
        step("Check response 400", () ->
                assertEquals(errorUserNotFound, failedLogin.getError()));
    }
}
