package funcionalidades;

import core.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ContasFunc extends BaseTest {

    public static String criaConta() {
        Map<String, String> conta = new HashMap<String, String>();
        conta.put("nome", CONTA_NAME);

        CONTA_ID = given()
                .body(conta)
                .when()
                .post("/contas")
                .then()
                .statusCode(201)
                .body("nome", is(CONTA_NAME))
                .extract().path("id")
        ;
        return CONTA_NAME;
    }

    public static void criaContaRepetida() {
        Map<String, String> conta = new HashMap<String, String>();
        conta.put("nome", CONTA_NAME);

        given()
                .body(conta)
                .when()
                .post("/contas")
                .then()
                .statusCode(400)
                .body("error", is("Já existe uma conta com esse nome!"))
        ;
    }

    public static void removeConta() {
        given()
                .pathParam("id", CONTA_ID)
                .when()
                .delete("/contas/{id}")
                .then()
                .statusCode(204)
        ;
    }

    public static void removeContaComMovimentacao() {
        given()
                .pathParam("id", CONTA_ID)
                .when()
                .delete("/contas/{id}")
                .then()
                .statusCode(500)
        ;
    }

    public static void alteraConta() {
        Map<String, String> conta = new HashMap<String, String>();
        conta.put("nome", CONTA_NAME + "Alterada");

        given()
                .body(conta)
                .pathParam("id", CONTA_ID)
                .when()
                .put("/contas/{id}")
                .then()
                .statusCode(200)
                .body("nome", is(CONTA_NAME + "Alterada"))
        ;
    }
}
