package tests;

import org.junit.Test;

import static funcionalidades.ContasFunc.criaConta;
import static funcionalidades.ContasFunc.removeConta;
import static funcionalidades.MovimentacaoFunc.criaMovimentacao;
import static funcionalidades.MovimentacaoFunc.removeMovimentacao;
import static funcionalidades.SaldoFunc.validaSaldo;

public class SaldoTest {
    @Test
    public void deveVerificarSaldoContas() {
        criaConta();
        criaMovimentacao();
        validaSaldo();
        removeMovimentacao();
        removeConta();
    }
}
