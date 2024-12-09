package dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class BancoDadosTeste {
	@Test
	void conectar() {
		try {
			assertNotNull(BancoDados.conectar());
		} catch (SQLException | IOException erro) {
			fail("Não foi possível se conectar ao banco de dados:"+erro);
		}		
	}
}
