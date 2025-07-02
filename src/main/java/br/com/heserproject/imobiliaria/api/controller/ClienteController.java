package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.core.base.BaseApiResponse;
import br.com.heserproject.imobiliaria.core.base.BaseSimpleController;
import br.com.heserproject.imobiliaria.domain.entity.Cliente;
import br.com.heserproject.imobiliaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/cliente")
public class ClienteController extends BaseSimpleController {

    private final ClienteService clienteService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<List<Cliente>>> findAll() {
        return sendResponseOK(clienteService::findAll);
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Cliente>> findById(@PathVariable Integer id) {
        return sendResponseOK(() -> clienteService.findById(id));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Void>> deleteById(@PathVariable Integer id) {
        return sendResponseOK(() -> clienteService.deleteById(id));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Cliente>> atualizar(@PathVariable Integer id,
                                                              @RequestBody Cliente cliente) {
        return sendResponseCreated(() -> clienteService.atualizar(id, cliente));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Cliente>> salvar(@RequestBody Cliente cliente) {
        return sendResponseCreated(() -> clienteService.salvar(cliente));
    }
}
