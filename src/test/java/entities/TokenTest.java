package entities;

import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TokenTest {

	@Test
	void testeValidarToken() {
		String token = Token.gerarToken("Informação_legal_123");
		assertTrue(Token.validarToken(token));
	}

}
