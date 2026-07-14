package api;

import static io.restassured.RestAssured.given;

import builders.AuthBuilder;
import endpoints.Routes;
import io.restassured.response.Response;
import models.AuthRequest;
import specifications.RequestSpecificationFactory;

public class AuthenticationAPI {

    public static String generateToken() {

        AuthRequest auth = AuthBuilder.createAuth();

        Response response =
                given()
                        .spec(RequestSpecificationFactory.requestSpec())
                        .body(auth)
                .when()
                        .post(Routes.AUTH);

        response.then().statusCode(200);

        return response.jsonPath().getString("token");
    }
}