package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.core.base.BaseApiResponse;
import br.com.heserproject.imobiliaria.core.base.BaseSimpleController;
import br.com.heserproject.imobiliaria.domain.entity.Imobiliaria;
import br.com.heserproject.imobiliaria.service.ImobiliariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/imobiliaria")
public class ImobiliariaController extends BaseSimpleController {

    private final ImobiliariaService imobiliariaService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<List<Imobiliaria>>> findAll() {
        return sendResponseOK(imobiliariaService::findAll);
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Imobiliaria>> findById(@PathVariable Integer id) {
        return sendResponseOK(() -> imobiliariaService.findById(id));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Void>> deleteById(@PathVariable Integer id) {
        return sendResponseOK(() -> imobiliariaService.deleteById(id));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Imobiliaria>> atualizar(@PathVariable Integer id,
                                                                  @RequestBody Imobiliaria imobiliaria) {
        return sendResponseCreated(() -> imobiliariaService.atualizar(id, imobiliaria));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Imobiliaria>> salvar(@RequestBody Imobiliaria imobiliaria) {
        return sendResponseCreated(() -> imobiliariaService.salvar(imobiliaria));
    }

}
