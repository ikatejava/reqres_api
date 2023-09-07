package in.reqres.tests;

import in.reqres.models.ResourceInfoModel;
import in.reqres.models.UserInfoModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.RequestSpecs.getResourcesRequestSpecification;
import static in.reqres.specs.RequestSpecs.usersRequestSpecification;
import static in.reqres.specs.ResponseSpecs.*;
import static in.reqres.tests.TestData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class getTests extends TestBase {

    @Test
    @Tag("get")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Get list of all ReqRes users with information about them on one page")
    void getListOfUsersOnOnePageSuccessTest() {
        given(usersRequestSpecification)
                .queryParam("page", page1)
                .queryParam("per_page", perPage12)
                .when()
                .get()
                .then()
                .spec(getAllUsersInfo200);
    }

    @Test
    @Tag("get")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Get list of half of ReqRes users with information about them on 2nd page")
    void getListOfSomeUsersSuccessTest() {
        given(usersRequestSpecification)
                .queryParam("page", page2)
                .queryParam("per_page", perPage6)
                .when()
                .get()
                .then()
                .spec(getSomeUsersInfo200);
    }

    @Test
    @Tag("get")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Get delayed response of half of ReqRes users with information about them on any possible page")
    void getListOfSomeUsersDelayedSuccessTest() {

        int pageNumber = faker.random().nextInt(0, 2_000_000_000);
        given(usersRequestSpecification)
                .queryParam("delay", pageNumber)
                .when()
                .get()
                .then()
                .spec(getSomeUsersInfoDelayed200);
    }

    @Test
    @Tag("get")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Get empty list of ReqRes users on 3rd page")
    void getEmptyListOfUsersSuccessTest() {
        given(usersRequestSpecification)
                .queryParam("page", page3)
                .queryParam("per_page", perPage6)
                .when()
                .get()
                .then()
                .spec(getEmptyList200);
    }

    @Test
    @Tag("get")
    @Tag("users")
    @Tag("positive")
    @DisplayName("Check information about one random ReqRes user")
    void getUserInfoSuccessTest() {

        int userNumber = faker.random().nextInt(1, 12);

        UserInfoModel userInfo = step("Make request", () -> {
            return given(usersRequestSpecification)
                    .when()
                    .get(String.valueOf(userNumber))
                    .then()
                    .spec(getUserInfo200)
                    .extract().as(UserInfoModel.class);
        });
        step("Check response 200", () -> {
            if (userNumber == 1) {
                assertEquals(1, userInfo.getData().getId());
                assertEquals(user1Email, userInfo.getData().getEmail());
                assertEquals(user1FirstName, userInfo.getData().getFirst_name());
                assertEquals(user1LastName, userInfo.getData().getLast_name());
                assertEquals(user1Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 2) {
                assertEquals(2, userInfo.getData().getId());
                assertEquals(user2Email, userInfo.getData().getEmail());
                assertEquals(user2FirstName, userInfo.getData().getFirst_name());
                assertEquals(user2LastName, userInfo.getData().getLast_name());
                assertEquals(user2Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 3) {
                assertEquals(3, userInfo.getData().getId());
                assertEquals(user3Email, userInfo.getData().getEmail());
                assertEquals(user3FirstName, userInfo.getData().getFirst_name());
                assertEquals(user3LastName, userInfo.getData().getLast_name());
                assertEquals(user3Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 4) {
                assertEquals(4, userInfo.getData().getId());
                assertEquals(user4Email, userInfo.getData().getEmail());
                assertEquals(user4FirstName, userInfo.getData().getFirst_name());
                assertEquals(user4LastName, userInfo.getData().getLast_name());
                assertEquals(user4Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 5) {
                assertEquals(5, userInfo.getData().getId());
                assertEquals(user5Email, userInfo.getData().getEmail());
                assertEquals(user5FirstName, userInfo.getData().getFirst_name());
                assertEquals(user5LastName, userInfo.getData().getLast_name());
                assertEquals(user5Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 6) {
                assertEquals(6, userInfo.getData().getId());
                assertEquals(user6Email, userInfo.getData().getEmail());
                assertEquals(user6FirstName, userInfo.getData().getFirst_name());
                assertEquals(user6LastName, userInfo.getData().getLast_name());
                assertEquals(user6Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 7) {
                assertEquals(7, userInfo.getData().getId());
                assertEquals(user7Email, userInfo.getData().getEmail());
                assertEquals(user7FirstName, userInfo.getData().getFirst_name());
                assertEquals(user7LastName, userInfo.getData().getLast_name());
                assertEquals(user7Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 8) {
                assertEquals(8, userInfo.getData().getId());
                assertEquals(user8Email, userInfo.getData().getEmail());
                assertEquals(user8FirstName, userInfo.getData().getFirst_name());
                assertEquals(user8LastName, userInfo.getData().getLast_name());
                assertEquals(user8Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 9) {
                assertEquals(9, userInfo.getData().getId());
                assertEquals(user9Email, userInfo.getData().getEmail());
                assertEquals(user9FirstName, userInfo.getData().getFirst_name());
                assertEquals(user9LastName, userInfo.getData().getLast_name());
                assertEquals(user9Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 10) {
                assertEquals(10, userInfo.getData().getId());
                assertEquals(user10Email, userInfo.getData().getEmail());
                assertEquals(user10FirstName, userInfo.getData().getFirst_name());
                assertEquals(user10LastName, userInfo.getData().getLast_name());
                assertEquals(user10Avatar, userInfo.getData().getAvatar());
            } else if (userNumber == 11) {
                assertEquals(11, userInfo.getData().getId());
                assertEquals(user11Email, userInfo.getData().getEmail());
                assertEquals(user11FirstName, userInfo.getData().getFirst_name());
                assertEquals(user11LastName, userInfo.getData().getLast_name());
                assertEquals(user11Avatar, userInfo.getData().getAvatar());
            } else {
                assertEquals(12, userInfo.getData().getId());
                assertEquals(user12Email, userInfo.getData().getEmail());
                assertEquals(user12FirstName, userInfo.getData().getFirst_name());
                assertEquals(user12LastName, userInfo.getData().getLast_name());
                assertEquals(user12Avatar, userInfo.getData().getAvatar());
            }
            assertEquals(supportUrl, userInfo.getSupport().getUrl());
            assertEquals(supportText, userInfo.getSupport().getText());
        });
    }

    @Test
    @Tag("get")
    @Tag("users")
    @Tag("negative")
    @DisplayName("Check information about one ReqRes unexisting user (failure)")
    void getUserInfoFailureTest() {

        int userNumber = faker.random().nextInt(13, 100);

        given(usersRequestSpecification)
                .when()
                .get(String.valueOf(userNumber))
                .then()
                .spec(getUnexistingObjectInfo404);
    }

    @Test
    @Tag("get")
    @Tag("resources")
    @Tag("positive")
    @DisplayName("Get list of all ReqRes resources with information about them on one page")
    void getListOfResourcesOnOnePageSuccessTest() {
        given(getResourcesRequestSpecification)
                .queryParam("page", page1)
                .queryParam("per_page", perPage12)
                .when()
                .get()
                .then()
                .spec(getAllResourcesInfo200);
    }

    @Test
    @Tag("get")
    @Tag("resources")
    @Tag("positive")
    @DisplayName("Get list of half of ReqRes recources with information about them on 2nd page")
    void getListOfSomeResourcesSuccessTest() {
        given(getResourcesRequestSpecification)
                .queryParam("page", page2)
                .queryParam("per_page", perPage6)
                .when()
                .get()
                .then()
                .spec(getSomeResourcesInfo200);
    }

    @Test
    @Tag("get")
    @Tag("resources")
    @Tag("positive")
    @DisplayName("Get empty list of ReqRes resources on 3rd page")
    void getEmptyListOfResourcesSuccessTest() {
        given(getResourcesRequestSpecification)
                .queryParam("page", page3)
                .queryParam("per_page", perPage6)
                .when()
                .get()
                .then()
                .spec(getEmptyList200);
    }

    @Test
    @Tag("get")
    @Tag("resources")
    @Tag("positive")
    @DisplayName("Check information about one random ReqRes resource")
    void getResourceInfoSuccessTest() {

        int resourceNumber = faker.random().nextInt(1, 12);

        ResourceInfoModel resourceInfo = step("Make request", () -> {
            return given(getResourcesRequestSpecification)
                    .when()
                    .get(String.valueOf(resourceNumber))
                    .then()
                    .spec(getResourceInfo200)
                    .extract().as(ResourceInfoModel.class);
        });
        step("Check response 200", () -> {
            if (resourceNumber == 1) {
                assertEquals(1, resourceInfo.getData().getId());
                assertEquals(resource1Name, resourceInfo.getData().getName());
                assertEquals(resource1Year, resourceInfo.getData().getYear());
                assertEquals(resource1Color, resourceInfo.getData().getColor());
                assertEquals(resource1PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 2) {
                assertEquals(2, resourceInfo.getData().getId());
                assertEquals(resource2Name, resourceInfo.getData().getName());
                assertEquals(resource2Year, resourceInfo.getData().getYear());
                assertEquals(resource2Color, resourceInfo.getData().getColor());
                assertEquals(resource2PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 3) {
                assertEquals(3, resourceInfo.getData().getId());
                assertEquals(resource3Name, resourceInfo.getData().getName());
                assertEquals(resource3Year, resourceInfo.getData().getYear());
                assertEquals(resource3Color, resourceInfo.getData().getColor());
                assertEquals(resource3PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 4) {
                assertEquals(4, resourceInfo.getData().getId());
                assertEquals(resource4Name, resourceInfo.getData().getName());
                assertEquals(resource4Year, resourceInfo.getData().getYear());
                assertEquals(resource4Color, resourceInfo.getData().getColor());
                assertEquals(resource4PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 5) {
                assertEquals(5, resourceInfo.getData().getId());
                assertEquals(resource5Name, resourceInfo.getData().getName());
                assertEquals(resource5Year, resourceInfo.getData().getYear());
                assertEquals(resource5Color, resourceInfo.getData().getColor());
                assertEquals(resource5PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 6) {
                assertEquals(6, resourceInfo.getData().getId());
                assertEquals(resource6Name, resourceInfo.getData().getName());
                assertEquals(resource6Year, resourceInfo.getData().getYear());
                assertEquals(resource6Color, resourceInfo.getData().getColor());
                assertEquals(resource6PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 7) {
                assertEquals(7, resourceInfo.getData().getId());
                assertEquals(resource7Name, resourceInfo.getData().getName());
                assertEquals(resource7Year, resourceInfo.getData().getYear());
                assertEquals(resource7Color, resourceInfo.getData().getColor());
                assertEquals(resource7PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 8) {
                assertEquals(8, resourceInfo.getData().getId());
                assertEquals(resource8Name, resourceInfo.getData().getName());
                assertEquals(resource8Year, resourceInfo.getData().getYear());
                assertEquals(resource8Color, resourceInfo.getData().getColor());
                assertEquals(resource8PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 9) {
                assertEquals(9, resourceInfo.getData().getId());
                assertEquals(resource9Name, resourceInfo.getData().getName());
                assertEquals(resource9Year, resourceInfo.getData().getYear());
                assertEquals(resource9Color, resourceInfo.getData().getColor());
                assertEquals(resource9PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 10) {
                assertEquals(10, resourceInfo.getData().getId());
                assertEquals(resource10Name, resourceInfo.getData().getName());
                assertEquals(resource10Year, resourceInfo.getData().getYear());
                assertEquals(resource10Color, resourceInfo.getData().getColor());
                assertEquals(resource10PantoneValue, resourceInfo.getData().getPantone_value());
            } else if (resourceNumber == 11) {
                assertEquals(11, resourceInfo.getData().getId());
                assertEquals(resource11Name, resourceInfo.getData().getName());
                assertEquals(resource11Year, resourceInfo.getData().getYear());
                assertEquals(resource11Color, resourceInfo.getData().getColor());
                assertEquals(resource11PantoneValue, resourceInfo.getData().getPantone_value());
            } else {
                assertEquals(12, resourceInfo.getData().getId());
                assertEquals(resource12Name, resourceInfo.getData().getName());
                assertEquals(resource12Year, resourceInfo.getData().getYear());
                assertEquals(resource12Color, resourceInfo.getData().getColor());
                assertEquals(resource12PantoneValue, resourceInfo.getData().getPantone_value());
            }
            assertEquals(supportUrl, resourceInfo.getSupport().getUrl());
            assertEquals(supportText, resourceInfo.getSupport().getText());
        });
    }

    @Test
    @Tag("get")
    @Tag("resources")
    @Tag("negative")
    @DisplayName("Check information about one ReqRes unexisting resource (failure)")
    void getResourceInfoFailureTest() {

        int resourceNumber = faker.random().nextInt(13, 100);

        given(getResourcesRequestSpecification)
                .when()
                .get(String.valueOf(resourceNumber))
                .then()
                .spec(getUnexistingObjectInfo404);
    }
}
