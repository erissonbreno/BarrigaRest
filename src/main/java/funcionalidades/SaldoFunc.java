package funcionalidades;

import core.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SaldoFunc extends BaseTest {
    public static void validateBalance() {
        given()
                .when()
                .get("/saldo")
                .then()
                .statusCode(200)
                .body("find{it.conta_id == "+ ACCOUNT_ID +"}.saldo",is("16000.00"))
        ;
    }
}
