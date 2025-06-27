package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.core.base.BaseApiResponse;
import br.com.heserproject.imobiliaria.core.base.BaseSimpleController;
import br.com.heserproject.imobiliaria.domain.entity.Endereco;
import br.com.heserproject.imobiliaria.domain.io.EnderecoOutput;
import br.com.heserproject.imobiliaria.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/endereco")
public class EnderecoController extends BaseSimpleController {

    private final EnderecoService enderecoService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<List<Endereco>>> findAll() {
        return sendResponseOK(enderecoService::findAll);
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Endereco>> findById(@PathVariable Integer id) {
        return sendResponseOK(() -> enderecoService.findById(id));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Void>> deleteById(@PathVariable Integer id) {
        return sendResponseOK(() -> enderecoService.deleteById(id));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Endereco>> atualizar(@PathVariable Integer id,
                                                               @RequestBody Endereco endereco) {
        return sendResponseOK(() -> enderecoService.atualizar(id, endereco));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Endereco>> salvar(@RequestBody Endereco endereco) {
        return sendResponseCreated(() -> enderecoService.salvar(endereco));
    }
}
