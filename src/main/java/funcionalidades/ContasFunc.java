package funcionalidades;

import core.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ContasFunc extends BaseTest {

    public static String createAccount() {
        Map<String, String> account = new HashMap<String, String>();
        account.put("nome", ACCOUNT_NAME);

        ACCOUNT_ID = given()
                .body(account)
                .when()
                .post("/contas")
                .then()
                .statusCode(201)
                .body("nome", is(ACCOUNT_NAME))
                .extract().path("id")
        ;
        return ACCOUNT_NAME;
    }

    public static void createRepeatAccount() {
        Map<String, String> account = new HashMap<String, String>();
        account.put("nome", ACCOUNT_NAME);

        given()
                .body(account)
                .when()
                .post("/contas")
                .then()
                .statusCode(400)
                .body("error", is("Já existe uma conta com esse nome!"))
        ;
    }

    public static void removeAccount() {
        given()
                .pathParam("id", ACCOUNT_ID)
                .when()
                .delete("/contas/{id}")
                .then()
                .statusCode(204)
        ;
    }

    public static void removeAccountWithTransaction() {
        given()
                .pathParam("id", ACCOUNT_ID)
                .when()
                .delete("/contas/{id}")
                .then()
                .statusCode(500)
        ;
    }

    public static void changeAccount() {
        Map<String, String> account = new HashMap<String, String>();
        account.put("nome", ACCOUNT_NAME + "Changed");

        given()
                .body(account)
                .pathParam("id", ACCOUNT_ID)
                .when()
                .put("/contas/{id}")
                .then()
                .statusCode(200)
                .body("nome", is(ACCOUNT_NAME + "Changed"))
        ;
    }
}
