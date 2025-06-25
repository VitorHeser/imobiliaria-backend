package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.domain.entity.Usuario;
import br.com.heserproject.imobiliaria.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.of(Optional.of(usuarioService.findAll()));
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.of(usuarioService.findById(id)));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id,
                                              @RequestBody Usuario usuario) {
        return ResponseEntity.of(Optional.of(usuarioService.atualizar(id, usuario)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        return ResponseEntity.of(Optional.of(usuarioService.salvar(usuario)));
    }
}
