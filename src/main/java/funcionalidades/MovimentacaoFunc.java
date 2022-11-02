package funcionalidades;

import core.BaseTest;
import utils.Movimentacao;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static utils.Movimentacao.getMovimentacaoValida;

public class MovimentacaoFunc extends BaseTest {

    public static void createTransaction() {
        Movimentacao transaction = getMovimentacaoValida();
        MOV_ID = given()
                .body(transaction)
                .when()
                .post("/transacoes")
                .then()
                .statusCode(201)
                .body("id", is(notNullValue()))
                .body("descricao", is("Test transaction"))
                .body("valor", is("16000.00"))
                .extract().path("id")
        ;
    }

    public static void createInvalidTransaction() {
        given()
                .when()
                .post("/transacoes")
                .then()
                .statusCode(400)
                .body("msg", hasItems("Data da Movimentação é obrigatório",
                        "Data do pagamento é obrigatório",
                        "Descrição é obrigatório",
                        "Interessado é obrigatório",
                        "Valor é obrigatório",
                        "Conta é obrigatório",
                        "Situação é obrigatório"))
        ;
    }

    public static void createInvalidTransaction(String data_transacao) {
        Movimentacao transaction = getMovimentacaoValida();
        transaction.setData_transacao(data_transacao);
        given()
                .body(transaction)
                .when()
                .post("/transacoes")
                .then()
                .statusCode(400)
                .body("msg", hasItem("Data da Movimentação deve ser menor ou igual à data atual"))
        ;
    }

    public static void deleteTransaction() {
        given()
                .pathParam("id", MOV_ID)
                .when()
                .delete("/transacoes/{id}")
                .then()
                .statusCode(204)
        ;
    }

}
