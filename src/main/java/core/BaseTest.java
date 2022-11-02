package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseTest implements Constantes {

    public static String ACCOUNT_NAME = "Conta" + System.nanoTime();
    public static Integer ACCOUNT_ID;
    public static Integer MOV_ID;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = APP_BASE_URL;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        Map<String, String> login = new HashMap<String, String>();
        login.put("email", "erissonbreno@hotmail.com");
        login.put("senha", "04011960");

        String TOKEN = given()
                .body(login)
                .when()
                .post("/signin")
                .then()
                .statusCode(200)
                .extract().path("token");

        RestAssured.requestSpecification.headers("Authorization", "JWT " + TOKEN);
    }
}
//
//    @BeforeAll
//    public static void singIn() {
//        Map<String, String> login = new HashMap<String, String>();
//        login.put("email", "erissonbreno@hotmail.com");
//        login.put("senha", "04011960");
//
//        String TOKEN = given()
//                .body(login)
//                .when()
//                .post("/signin")
//                .then()
//                .statusCode(200)
//                .extract().path("token");
//
//        RestAssured.requestSpecification.headers("Authorization", "JWT " + TOKEN);
//    }
