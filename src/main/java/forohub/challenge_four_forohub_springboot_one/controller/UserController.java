package forohub.challenge_four_forohub_springboot_one.controller;

import forohub.challenge_four_forohub_springboot_one.domain.usuarios.DatosAutenticacionUsuario;
import forohub.challenge_four_forohub_springboot_one.domain.usuarios.Usuario;
import forohub.challenge_four_forohub_springboot_one.infra.security.TokenJWT;
import forohub.challenge_four_forohub_springboot_one.infra.security.DatosJWTToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenJWT tokenJWT;

    @PostMapping
    public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.user(),  datosAutenticacionUsuario.password());
        var usuarioJWT = authenticationManager.authenticate(authenticationToken);
        var JWTtoken = tokenJWT.generarToken((Usuario) usuarioJWT.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }

}
