package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.domain.entity.Usuario;
import br.com.heserproject.imobiliaria.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.of(Optional.of(usuarioService.findAll()));
    }

    @GetMapping(path = "/{idCpf}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> findById(@PathVariable Long idCpf) {
        return ResponseEntity.of(Optional.of(usuarioService.findById(idCpf)));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    @PutMapping(path = "/{idCpf}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> atualizar(@PathVariable Long idCpf,
                                             @RequestBody Usuario usuario) {
        return ResponseEntity.of(Optional.of(usuarioService.atualizar(idCpf, usuario)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        return ResponseEntity.of(Optional.of(usuarioService.salvar(usuario)));
    }
}
