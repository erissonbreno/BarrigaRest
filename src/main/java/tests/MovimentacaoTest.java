package tests;

import org.junit.Test;

import static funcionalidades.ContasFunc.*;
import static funcionalidades.MovimentacaoFunc.*;
import static utils.DateUtils.getDataDiferencaDias;

public class MovimentacaoTest {

    @Test
    public void deveInserirMovimentacaoComSucesso() {
        criaConta();
        criaMovimentacao();
        removeMovimentacao();
        removeConta();
    }

    @Test
    public void deveValidarCamposObrigatoriosMovimentacao() {
        criaConta();
        criaMovimentacaoInvalida();
        removeConta();
    }

    @Test
    public void naoDeveCadastrarMovimentacaoFutura() {
        criaConta();
        criaMovimentacaoInvalida(getDataDiferencaDias(2));
        removeConta();
    }

    @Test
    public void naoDeveRemoverUmaContaComMovimentacao() {
        criaConta();
        criaMovimentacao();
        removeContaComMovimentacao();
        removeMovimentacao();
        removeConta();
    }

    @Test
    public void deveRemoverMovimentacao() {
        criaConta();
        criaMovimentacao();
        removeMovimentacao();
        removeConta();
    }
}
