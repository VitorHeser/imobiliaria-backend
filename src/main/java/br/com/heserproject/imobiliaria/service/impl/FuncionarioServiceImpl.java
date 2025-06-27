package br.com.heserproject.imobiliaria.service.impl;

import br.com.heserproject.imobiliaria.domain.entity.Funcionario;
import br.com.heserproject.imobiliaria.repository.FuncionarioRepository;
import br.com.heserproject.imobiliaria.service.FuncionarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.saveAndFlush(funcionario);
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario findById(Integer id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    @Override
    @Transactional
    public Funcionario atualizar(Integer id, Funcionario funcionario) {
        funcionario.setId(id);
        return salvar(funcionario);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        funcionarioRepository.deleteById(id);
    }

}
