package in.reqres.tests;

import in.reqres.models.CreateNewUserResponseModel;
import in.reqres.models.SuccesfulLoginResponseModel;
import in.reqres.models.SuccessfulRegistrationResponseModel;
import in.reqres.models.UnsuccessfulRegistrationAndLoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.RequestSpecs.*;
import static in.reqres.specs.ResponseSpecs.*;
import static in.reqres.tests.TestData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class postTests extends TestBase {
    @Test
    @Tag("user")
    @Tag("positive")
    @DisplayName("Successful creation of a new user")
    void createUserSuccessTest() {
        CreateNewUserResponseModel createNewUserResponse = step("Make request", () -> {
            return given(usersRequestSpecification)
                    .body(createNewUserRequestBody)
                    .when()
                    .post()
                    .then()
                    .spec(getNewUserInfo201)
                    .extract().as(CreateNewUserResponseModel.class);
        });
        step("Check response 201", () -> {
            assertEquals(createNewUserRequestBody.getName(), createNewUserResponse.getName());
            assertEquals(createNewUserRequestBody.getJob(), createNewUserResponse.getJob());
        });
    }

    @Test
    @Tag("user")
    @Tag("positive")
    @DisplayName("Successful registration of a new user")
    void registerUserSuccessTest() {
        SuccessfulRegistrationResponseModel successfulRegistration = step("Make request", () -> {
            return given(registerUserRequestSpecification)
                    .body(rightRegAndAuthData)
                    .when()
                    .post()
                    .then()
                    .spec(getNewlyRegisteredUserInfo200)
                    .extract().as(SuccessfulRegistrationResponseModel.class);
        });
        step("Check response 200", () -> {
            assertEquals(newUserId, successfulRegistration.getId());
            assertEquals(userToken, successfulRegistration.getToken());
        });
    }

    @Test
    @Tag("user")
    @Tag("negative")
    @DisplayName("Unsuccessful registration of a new user with missing password")
    void registerUserMissingPasswordTest() {
        UnsuccessfulRegistrationAndLoginResponseModel failedRegistration = step("Make request", () -> {
            return given(registerUserRequestSpecification)
                    .body(missingPasswordRegAndAuthData)
                    .when()
                    .post()
                    .then()
                    .spec(failedToRegisterOrAuthorizeUser400)
                    .extract().as(UnsuccessfulRegistrationAndLoginResponseModel.class);
        });
        step("Check response 400", () -> {
            assertEquals(errorMissingPassword, failedRegistration.getError());
        });
    }

    @Test
    @Tag("user")
    @Tag("negative")
    @DisplayName("Unsuccessful registration of a new user")
    void registerUserFailedTest() {
        UnsuccessfulRegistrationAndLoginResponseModel failedRegistration = step("Make request", () -> {
            return given(registerUserRequestSpecification)
                    .body(wrongRegAndAuthData)
                    .when()
                    .post()
                    .then()
                    .spec(failedToRegisterOrAuthorizeUser400)
                    .extract().as(UnsuccessfulRegistrationAndLoginResponseModel.class);
        });
        step("Check response 400", () -> {
            assertEquals(errorRegistrationMessage, failedRegistration.getError());
        });
    }

    @Test
    @Tag("user")
    @Tag("positive")
    @DisplayName("Successful login of existing user")
    void LoginSuccessTest() {
        SuccesfulLoginResponseModel successfulLogin = step("Make request", () -> {
            return given(loginRequestSpecification)
                    .body(rightRegAndAuthData)
                    .when()
                    .post()
                    .then()
                    .spec(successfulLogin200)
                    .extract().as(SuccesfulLoginResponseModel.class);
        });
        step("Check response 200", () -> {
            assertEquals(userToken, successfulLogin.getToken());
        });
    }

    @Test
    @Tag("user")
    @Tag("negative")
    @DisplayName("Unsuccessful login of existing user with missing password")
    void loginUserMissingPasswordTest() {
        UnsuccessfulRegistrationAndLoginResponseModel failedLogin = step("Make request", () -> {
            return given(loginRequestSpecification)
                    .body(missingPasswordRegAndAuthData)
                    .when()
                    .post()
                    .then()
                    .spec(failedToRegisterOrAuthorizeUser400)
                    .extract().as(UnsuccessfulRegistrationAndLoginResponseModel.class);
        });
        step("Check response 400", () -> {
            assertEquals(errorMissingPassword, failedLogin.getError());
        });
    }

    @Test
    @Tag("user")
    @Tag("negative")
    @DisplayName("Unsuccessful login of unexisting user")
    void loginFailedTest() {
        UnsuccessfulRegistrationAndLoginResponseModel failedLogin = step("Make request", () -> {
            return given(loginRequestSpecification)
                    .body(wrongRegAndAuthData)
                    .when()
                    .post()
                    .then()
                    .spec(failedToRegisterOrAuthorizeUser400)
                    .extract().as(UnsuccessfulRegistrationAndLoginResponseModel.class);
        });
        step("Check response 400", () -> {
            assertEquals(errorUserNotFound, failedLogin.getError());
        });
    }
}
