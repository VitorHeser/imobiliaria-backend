package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.core.base.BaseApiResponse;
import br.com.heserproject.imobiliaria.core.base.BaseSimpleController;
import br.com.heserproject.imobiliaria.domain.entity.Imovel;
import br.com.heserproject.imobiliaria.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/imovel")
public class ImovelController extends BaseSimpleController {

    private final ImovelService imovelService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<List<Imovel>>> findAll() {
        return sendResponseOK(imovelService::findAll);
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Imovel>> findById(@PathVariable Integer id) {
        return sendResponseOK(() -> imovelService.findById(id));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Void>> deleteById(@PathVariable Integer id) {
        return sendResponseOK(() -> imovelService.deleteById(id));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Imovel>> atualizar(@PathVariable Integer id,
                                                             @RequestBody Imovel imovel) {
        return sendResponseCreated(() -> imovelService.atualizar(id, imovel));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Imovel>> salvar(@RequestBody Imovel imovel) {
        return sendResponseCreated(() -> imovelService.salvar(imovel));
    }
}
