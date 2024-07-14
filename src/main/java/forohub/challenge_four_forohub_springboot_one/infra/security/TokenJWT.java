package forohub.challenge_four_forohub_springboot_one.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import forohub.challenge_four_forohub_springboot_one.domain.usuarios.Usuario;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenJWT {


    @Value("${api.security.secret}")
    private String key;
    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject(usuario.getUser())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String validacionToken(String token){
        if (token == null){
            throw new RuntimeException("Token is Null");
        }
        DecodedJWT decodedJWT = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(key);
            decodedJWT = JWT.require(algorithm)
                    .withIssuer("voll med")
                    .build()
                    .verify(token);
            decodedJWT.getSubject();

        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token verification failed " + e.getMessage(), e);
        }
        if (decodedJWT.getSubject() == null) {
            throw new RuntimeException("Autorizacion Invalida");
        }
        return decodedJWT.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-08:00"));
    }
}
