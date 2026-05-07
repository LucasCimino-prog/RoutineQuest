package Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Chave secreta usada para assinar o token (em producao, isso ficaria escondido)
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Tempo de validade do token: 1 hora (em milissegundos)
    private final long EXPIRATION_TIME = 3600000;

    // Metodo que gera o Token baseado no email do usuario
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}