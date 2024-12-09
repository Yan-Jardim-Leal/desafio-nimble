package entities;
import java.util.List;

public class GeradorSenha {
	public static final int maxSize = 100;
	//Não pode ser abaixo de 4
	public static final int minSize = 12;
	
	private GeradorSenha() {}
	
	public static String gerar(int tamanho) {
		if (tamanho > maxSize)
			tamanho = maxSize;
		if (tamanho < minSize)
			tamanho = minSize;
		
		String senha = "";
		String minuscula = String.valueOf((char) (Math.random() * 26 + 97));
		String maiuscula = String.valueOf((char) (Math.random() * 26 + 65));
		String simbolo = String.valueOf((char) (Math.random() * 14 + 33));
		String numero = String.valueOf((char) (Math.random() * 9 + 48));
		
		List<String> requisitosSenha = List.of(minuscula,maiuscula,simbolo,numero);	
		senha = String.join("", requisitosSenha);
		
		for (int intLoop = 0; intLoop < (tamanho - 4); intLoop++) {
			char randomChar = (char) (Math.random() * 205 + 33);
			senha = String.join("", senha, String.valueOf(randomChar));
		}
		
		return senha;
	}
	
}

/*
 * 	Faço e ultilizo do melhor proveito da tabela ASCI
*/
