package tests;

import org.junit.Test;

import static funcionalidades.ContasFunc.*;

public class ContasTest {
    @Test
    public void deveIncluirContaComSucesso() {
        criaConta();
        removeConta();
    }

    @Test
    public void deveAlterarContaComSucesso() {
        criaConta();
        alteraConta();
        removeConta();
    }

    @Test
    public void naoDeveIncluirContaComNomeRepetido() {
        criaConta();
        criaContaRepetida();
        removeConta();
    }

    @Test
    public void deveRemoverConta() {
        criaConta();
        removeConta();
    }
}
