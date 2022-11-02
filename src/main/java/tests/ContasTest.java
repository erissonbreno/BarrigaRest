package tests;


import core.BaseTest;
import org.junit.jupiter.api.Test;

import static funcionalidades.ContasFunc.*;

public class ContasTest extends BaseTest {

    @Test
    public void shouldAddAccountSuccessfully() {
        createAccount();
        removeAccount();
    }

    @Test
    public void shouldChangeAccountSuccessfully() {
        createAccount();
        changeAccount();
        removeAccount();
    }

    @Test
    public void shouldNotAddAccountWithSameName() {
        createAccount();
        createRepeatAccount();
        removeAccount();
    }

    @Test
    public void shouldRemoveAccount() {
        createAccount();
        removeAccount();
    }
}
