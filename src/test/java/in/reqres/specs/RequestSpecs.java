package in.reqres.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import static in.reqres.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.http.ContentType.JSON;

public class RequestSpecs {

    private static RequestSpecification getBaseReqSpec() {
        return new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(JSON)
                .setBaseUri("https://reqres.in/api/")
                .build()
                .filter(withCustomTemplates());
    }

    public static RequestSpecification usersRequestSpecification = getBaseReqSpec().basePath("users");
    public static RequestSpecification registerUserRequestSpecification =
            getBaseReqSpec().basePath("register");
    public static RequestSpecification loginRequestSpecification = getBaseReqSpec().basePath("login");
    public static RequestSpecification getResourcesRequestSpecification =
            getBaseReqSpec().basePath("resource");
}