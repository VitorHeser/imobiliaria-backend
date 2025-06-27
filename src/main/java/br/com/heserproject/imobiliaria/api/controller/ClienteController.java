package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.domain.entity.Cliente;
import br.com.heserproject.imobiliaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.of(Optional.of(clienteService.findAll()));
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        return ResponseEntity.of(Optional.of(clienteService.findById(id)));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Integer id) {
        clienteService.deleteById(id);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id,
                                             @RequestBody Cliente cliente) {
        return ResponseEntity.of(Optional.of(clienteService.atualizar(id, cliente)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        return ResponseEntity.of(Optional.of(clienteService.salvar(cliente)));
    }
}
