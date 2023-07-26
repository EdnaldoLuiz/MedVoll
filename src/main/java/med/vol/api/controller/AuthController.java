package med.vol.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.vol.api.domain.usuario.DadosAutenticacao;
import med.vol.api.domain.usuario.Usuario;
import med.vol.api.infra.DadosTokenJWT;
import med.vol.api.service.TokenService;

@RestController
@RequestMapping("login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {
        var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var auth = manager.authenticate(authToken);
        var tokenJWT = tokenService.gerarToken((Usuario)auth.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
    
}
