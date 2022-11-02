package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static funcionalidades.ContasFunc.createAccount;
import static funcionalidades.ContasFunc.removeAccount;
import static funcionalidades.MovimentacaoFunc.createTransaction;
import static funcionalidades.MovimentacaoFunc.deleteTransaction;
import static funcionalidades.SaldoFunc.validateBalance;

public class SaldoTest extends BaseTest {
    @Test
    public void shouldValidateAccountBalance() {
        createAccount();
        createTransaction();
        validateBalance();
        deleteTransaction();
        removeAccount();
    }
}
