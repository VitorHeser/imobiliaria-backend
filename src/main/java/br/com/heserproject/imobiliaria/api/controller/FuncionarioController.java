package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.domain.entity.Endereco;
import br.com.heserproject.imobiliaria.domain.entity.Funcionario;
import br.com.heserproject.imobiliaria.service.EnderecoService;
import br.com.heserproject.imobiliaria.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.of(Optional.of(funcionarioService.findAll()));
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id) {
        return ResponseEntity.of(Optional.of(funcionarioService.findById(id)));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Integer id) {
        funcionarioService.deleteById(id);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> atualizar(@PathVariable Integer id,
                                              @RequestBody Funcionario funcionario) {
        return ResponseEntity.of(Optional.of(funcionarioService.atualizar(id, funcionario)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.of(Optional.of(funcionarioService.salvar(funcionario)));
    }
}
