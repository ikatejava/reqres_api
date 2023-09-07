package in.reqres.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static in.reqres.tests.TestData.*;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class ResponseSpecs {
    public static ResponseSpecification getAllUsersInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/all_users_on_1_page.json"))
            .expectBody("page", is(page1))
            .expectBody("per_page", is(perPage12))
            .expectBody("total", is(total))
            .expectBody("total_pages", is(totalPages1))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();

    public static ResponseSpecification getAllResourcesInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/all_resources_on_1_page.json"))
            .expectBody("page", is(page1))
            .expectBody("per_page", is(perPage12))
            .expectBody("total", is(total))
            .expectBody("total_pages", is(totalPages1))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();


    public static ResponseSpecification getSomeUsersInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/6_users_on_one_page.json"))
            .expectBody("page", is(page2))
            .expectBody("per_page", is(perPage6))
            .expectBody("total", is(total))
            .expectBody("total_pages", is(totalPages2))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();

    public static ResponseSpecification getSomeUsersInfoDelayed200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/6_users_on_one_page.json"))
            .expectBody("page", is(page1))
            .expectBody("per_page", is(perPage6))
            .expectBody("total", is(total))
            .expectBody("total_pages", is(totalPages2))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();

    public static ResponseSpecification getSomeResourcesInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/6_resources_on_one_page.json"))
            .expectBody("page", is(page2))
            .expectBody("per_page", is(perPage6))
            .expectBody("total", is(total))
            .expectBody("total_pages", is(totalPages2))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();

    public static ResponseSpecification getEmptyList200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/empty_list.json"))
            .expectBody("page", is(page3))
            .expectBody("per_page", is(perPage6))
            .expectBody("total", is(total))
            .expectBody("total_pages", is(totalPages2))
            .expectBody("data", empty())
            .expectBody("support", notNullValue())
            .build();

    public static ResponseSpecification getUserInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/one_user_info.json"))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();

    public static ResponseSpecification getResourceInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/one_resource_info.json"))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .build();

    public static ResponseSpecification updateUserInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("name", notNullValue())
            .expectBody("job", notNullValue())
            .expectBody("updatedAt", notNullValue())
            .build();

    public static ResponseSpecification getNewlyRegisteredUserInfo200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("id", notNullValue())
            .expectBody("token", notNullValue())
            .build();

    public static ResponseSpecification successfulLogin200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("token", notNullValue())
            .build();

    public static ResponseSpecification getNewUserInfo201 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .expectBody("name", notNullValue())
            .expectBody("job", notNullValue())
            .expectBody("id", notNullValue())
            .expectBody("createdAt", notNullValue())
            .build();


    public static ResponseSpecification deleteUser204 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(204)
            .build();

    public static ResponseSpecification failedToRegisterOrAuthorizeUser400 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(400)
            .expectBody("error", notNullValue())
            .build();

    public static ResponseSpecification getUnexistingObjectInfo404 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(404)
            .build();
}
