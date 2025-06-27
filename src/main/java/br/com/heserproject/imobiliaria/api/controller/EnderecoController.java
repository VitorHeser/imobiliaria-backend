package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.domain.entity.Endereco;
import br.com.heserproject.imobiliaria.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

//GET - Obtém, recupera
//POST - Cria
//PUT - Atualiza
//DELETE - Deleta

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.of(Optional.of(enderecoService.findAll()));
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        return ResponseEntity.of(Optional.of(enderecoService.findById(id)));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Integer id) {
        enderecoService.deleteById(id);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> atualizar(@PathVariable Integer id,
                                              @RequestBody Endereco endereco) {
        return ResponseEntity.of(Optional.of(enderecoService.atualizar(id, endereco)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco) {
        return ResponseEntity.of(Optional.of(enderecoService.salvar(endereco)));
    }
}
