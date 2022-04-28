package tests;

import org.junit.Test;

import static funcionalidades.AuthFunc.acessoSemToken;

public class AuthTest {
    @Test
    public void naoDeveAcessarAPISemToken() {
        acessoSemToken();
    }
}
