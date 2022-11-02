package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static funcionalidades.ContasFunc.*;
import static funcionalidades.MovimentacaoFunc.*;
import static utils.DateUtils.getDataDiferencaDias;

public class MovimentacaoTest extends BaseTest {

    @Test
    public void shouldAddTransactionSuccessfully() {
        createAccount();
        createTransaction();
        deleteTransaction();
        removeAccount();
    }

    @Test
    public void shouldValidateTransactionRequiredFields() {
        createAccount();
        createInvalidTransaction();
        removeAccount();
    }

    @Test
    public void shouldNotAddFutureTransaction() {
        createAccount();
        createInvalidTransaction(getDataDiferencaDias(2));
        removeAccount();
    }

    @Test
    public void shouldNotRemoveAccountWithTransactions() {
        createAccount();
        createTransaction();
        removeAccountWithTransaction();
        deleteTransaction();
        removeAccount();
    }

    @Test
    public void shouldRemoveTransaction() {
        createAccount();
        createTransaction();
        deleteTransaction();
        removeAccount();
    }
}
