package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Usuario;

public class UsuarioDao {
	
	private static Connection conexaoBD;
	
	public UsuarioDao(Connection conexaoBD) {
		UsuarioDao.conexaoBD = conexaoBD;
	}
	
	public static int cadastrar(Usuario user) throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = conexaoBD.prepareStatement("insert into usuario (nome,cpf,email,senha) values (?,?,?,?)");
			statement.setString(1, user.getNome());
			statement.setString(2, user.getCpf());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getSenha());
			return statement.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(statement);
		}
	}
	
	public static void getUsuarioPorCpf(String cpf) throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultado = null;
		try {
			statement = conexaoBD.prepareStatement("select nome,cpf,email from clientes where cpf = ?");
			statement.setString(1, cpf);
			resultado = statement.executeQuery();
			
			if (resultado.next()) {
				System.out.println("Nome: "+resultado.getString("nome")+"\nCpf: "+resultado.getString("cpf")+"\nEmail: "+resultado.getString("email"));
			}else {
				System.out.println("Usuário com esse CPF não encontrado!");
			}
		}finally {
			BancoDados.finalizarResultSet(resultado);
			BancoDados.finalizarStatement(statement);
		}
	}
}
