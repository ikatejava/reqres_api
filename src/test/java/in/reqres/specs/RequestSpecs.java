package in.reqres.specs;

import io.restassured.specification.RequestSpecification;

import static in.reqres.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestSpecs {

    public static RequestSpecification usersRequestSpecification = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri("https://reqres.in/")
            .basePath("api/users");

    public static RequestSpecification registerUserRequestSpecification = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri("https://reqres.in/")
            .basePath("api/register");

    public static RequestSpecification loginRequestSpecification = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri("https://reqres.in/")
            .basePath("api/login");

    public static RequestSpecification getResourcesRequestSpecification = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in/")
            .basePath("api/resource");
}
