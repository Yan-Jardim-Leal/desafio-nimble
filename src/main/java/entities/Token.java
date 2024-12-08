package entities;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public final class Token {
	private Token() {}
	
    //# Uma chave "Secreta" que é gerada a cada inicio de programa.
    private static final SecretKey chave = Keys.hmacShaKeyFor(GeradorSenha.gerar(40).getBytes());

    //# Gerar um Token
    public static String gerarToken(String subject) {
    	System.out.println("Me chamaram para gerar um token!");
    	JwtBuilder encoder = Jwts.builder();
    	
    	encoder.subject(subject);
    	encoder.issuedAt(new Date());
    	encoder.expiration(new Date(System.currentTimeMillis() + 86400000));
    	encoder.signWith(chave);
    	
    	String token = encoder.compact();
        return token;
    }

    //# Verificar se um token é válido
    public static boolean validarToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(chave)
                    .build()
                    .parseSignedClaims(token)
            		.getPayload();
            
            System.out.println("Token válido!");
            //System.out.println("Subject: " + claims.getSubject());
            //System.out.println("Emitido em: " + claims.getIssuedAt());
            //System.out.println("Expira em: " + claims.getExpiration());
            return true;
        } catch (Exception erro) {
            System.out.println("Token inválido ou expirado!");
            return false;
        }
    }
	
	
}
