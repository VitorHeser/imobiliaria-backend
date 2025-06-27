package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.domain.entity.Imovel;
import br.com.heserproject.imobiliaria.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/imovel")
public class ImovelController {

    private final ImovelService imovelService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Imovel>> findAll() {
        return ResponseEntity.of(Optional.of(imovelService.findAll()));
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Imovel> findById(@PathVariable Integer id) {
        return ResponseEntity.of(Optional.of(imovelService.findById(id)));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Integer id) {
        imovelService.deleteById(id);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Imovel> atualizar(@PathVariable Integer id,
                                            @RequestBody Imovel imovel) {
        return ResponseEntity.of(Optional.of(imovelService.atualizar(id, imovel)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Imovel> salvar(@RequestBody Imovel imovel) {
        return ResponseEntity.of(Optional.of(imovelService.salvar(imovel)));
    }
}
