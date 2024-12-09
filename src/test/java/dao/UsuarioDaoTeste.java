package dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import entities.Usuario;

class UsuarioDaoTeste {
	@Test
	void adicionarCliente() throws SQLException, IOException {
		Usuario userTeste;
		@SuppressWarnings("unused")
		UsuarioDao userDao;
		
		userDao = new UsuarioDao(BancoDados.conectar());
		userTeste = new Usuario("Yan dos Campos", "Yan@gmail.com","SenhaBacana123", "123.456.765-11");
		
		try {
			UsuarioDao.cadastrar(userTeste);
		} catch (SQLException erro) {
			fail("Não foi possível cadastrar um cliente!"+erro);
		}
	}
	@Test
	void retirarClientePorCpf() throws SQLException, IOException {
		Usuario userTeste;
		@SuppressWarnings("unused")
		UsuarioDao userDao;
		
		userDao = new UsuarioDao(BancoDados.conectar());
		userTeste = new Usuario("Yan dos Campos", "Yan@gmail.com","SenhaBacana123", "123.456.765-11");
		
		try {
			UsuarioDao.cadastrar(userTeste);
			new UsuarioDao(BancoDados.conectar());	
			UsuarioDao.getUsuarioPorCpf("1234567");
		} catch (SQLException erro) {
			fail("Não foi possível cadastrar ou listar um cliente!"+erro);
		}
	}
}
