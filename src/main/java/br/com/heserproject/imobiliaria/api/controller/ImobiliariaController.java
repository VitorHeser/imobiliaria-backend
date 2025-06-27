package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.domain.entity.Imobiliaria;
import br.com.heserproject.imobiliaria.service.ImobiliariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/imobiliaria")
public class ImobiliariaController {

    private final ImobiliariaService imobiliariaService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Imobiliaria>> findAll() {
        return ResponseEntity.of(Optional.of(imobiliariaService.findAll()));
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Imobiliaria> findById(@PathVariable Integer id) {
        return ResponseEntity.of(Optional.of(imobiliariaService.findById(id)));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Integer id) {
        imobiliariaService.deleteById(id);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Imobiliaria> atualizar(@PathVariable Integer id,
                                                 @RequestBody Imobiliaria imobiliaria) {
        return ResponseEntity.of(Optional.of(imobiliariaService.atualizar(id, imobiliaria)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Imobiliaria> salvar(@RequestBody Imobiliaria imobiliaria) {
        return ResponseEntity.of(Optional.of(imobiliariaService.salvar(imobiliaria)));
    }

}
