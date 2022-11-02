package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static funcionalidades.AuthFunc.accessWithoutToken;

public class AuthTest extends BaseTest {
    @Test
    public void cannontAccessAPIWithoutToken() {
        accessWithoutToken();
    }
}
