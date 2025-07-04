package br.com.heserproject.imobiliaria.api.controller;

import br.com.heserproject.imobiliaria.core.base.BaseApiResponse;
import br.com.heserproject.imobiliaria.core.base.BaseSimpleController;
import br.com.heserproject.imobiliaria.domain.entity.Funcionario;
import br.com.heserproject.imobiliaria.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/funcionario")
public class FuncionarioController extends BaseSimpleController {

    private final FuncionarioService funcionarioService;

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<List<Funcionario>>> findAll() {
        return sendResponseOK(funcionarioService::findAll);
    }

    @GetMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Funcionario>> findById(@PathVariable Integer id) {
        return sendResponseOK(() -> funcionarioService.findById(id));
    }

    @DeleteMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Void>> deleteById(@PathVariable Integer id) {
        return sendResponseOK(() -> funcionarioService.deleteById(id));
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Funcionario>> atualizar(@PathVariable Integer id,
                                                                  @RequestBody Funcionario funcionario) {
        return sendResponseCreated(() -> funcionarioService.atualizar(id, funcionario));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse<Funcionario>> salvar(@RequestBody Funcionario funcionario) {
        return sendResponseCreated(() -> funcionarioService.salvar(funcionario));
    }
}
