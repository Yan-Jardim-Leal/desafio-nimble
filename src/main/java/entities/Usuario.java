package entities;

public final class Usuario {
	
	private String nome;
	private String email;
	
	private String senha;
	private int cpf;
	
	public Usuario(String nome, String email, String senha, int cpf) {	
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}	
	/*
 		Gerenciamento de Usuários - Cadastro de Usuário: - - 
		Campos obrigatórios: Nome, CPF, e-mail e senha. 
		Validação do CPF. 
		Página 3 de 5 
		Este documento é confidencial e não pode ser compartilhado sem autorização prévia da Nimble - - - 
		A senha deve ser armazenada de forma segura. 
		Login de Usuário: 
		Login deve permitir autenticação por CPF e senha ou e-mail e senha. - Retornar um 
		token de autenticação.
	 */
	
}
