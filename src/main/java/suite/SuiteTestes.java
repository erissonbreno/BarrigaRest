package suite;

import core.BaseTest;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.AuthTest;
import tests.ContasTest;
import tests.MovimentacaoTest;
import tests.SaldoTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContasTest.class,
        MovimentacaoTest.class,
        SaldoTest.class,
        AuthTest.class
})
public class SuiteTestes extends BaseTest {

    @BeforeClass
    public static void fazerLogin() {
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
