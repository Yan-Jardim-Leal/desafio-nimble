package entities;

public final class UsuarioManager {
	

	private UsuarioManager() {}
	
	public static String cadastrarUsuario(String nome, String email, String senha, char[] cpf) {
		cpf = cpfNumbers(cpf);
		
		if (validarCPF(cpf) == false)
			return "CPF inválido!";
		
		if (validarEmailExistente(email) == true && validarCPFExistente(cpf) == true)
			return "Já existe um usuário cadastrado com esse email/cpf";
		
		senha = encriptarSenha(senha);
		return "Usuário cadastrado com sucesso!";
		
	}
	
	public static Usuario getUser(Usuario user) {
		// Procura no BD -> retorna o usuário caso encontrar
		
		return user;
	}
	
	
	private boolean verificarCredenciais(String credencial, String senha) {
		
		return false;
	}
	
	public String login(String credencial, String senha) {
		if (verificarCredenciais(credencial,senha) == false)
			return null;
		
		
		
		return Token.gerarToken("");
	}
	
	public static boolean validarCPFExistente(char[] cpf) {
		// Procura no BD -> retorna 'false' se não encontrar
		
		
		return false;
	}
	
	public static boolean validarEmailExistente(String email) {
		// Procura no BD -> retorna 'false' se não encontrar
		
		
		return false;
	}
	
	private static char[] cpfNumbers(char[] cpf) {
		if (cpf == null || cpf.length < 12)
			return null;
		
		int charAtual = 0;
		char[] cpfNumerico = new char[9];
		
		for (char caractere : cpf) {
			if ((int) caractere > 47 &&  (int) caractere < 58) {
				cpfNumerico[charAtual] = caractere;
				charAtual++;
			}
		}
		
		if (charAtual != 9)
			return null;
		
		return cpfNumerico;
	}
	
	//Mudar para Classe própria depois
	private static String encriptarSenha(String senha) {
		return senha;
	}
	
	private static int verificarCPFEtapa(char[] cpf, int maxIndex) {
		int resultado = 0;
		int oposto = maxIndex+1;
		
		for (int indice = 0; indice < maxIndex; indice++) {
			resultado += ((int) cpf[indice] - 48) * oposto;
			oposto--;
		}
		
		int restoDivisao = resultado % 11;
		
		if (restoDivisao >= 2) {
			return 11 - restoDivisao;
		}else {
			return 0;
		}
		
	}
	
	private static boolean validarCPF(char[] cpf) {
		// Retorna true se é válido
		int primeiroDigitoVerificador = verificarCPFEtapa(cpf, 9);
		
		if ((int) cpf[9] - 48 != primeiroDigitoVerificador)
			return false;
		
		int segundoDigitoVerificador = verificarCPFEtapa(cpf, 10);
		
		if ((int) cpf[10] - 48 != segundoDigitoVerificador)
			return false;
		
		return true;
	}
	
}

/*
	cpfNumbers:
		Porque escolhi essa abordagem? 
		1º Por não confiar no usuário, isso evita até mesmo que ele use processamento demais.
		2º Eu nunca havia resolvido dessa forma, achei que fosse legal!
	
	verificarCPF:
		A explicação dos calculos da função "verificarCPF" estão na pasta de documentos

*/