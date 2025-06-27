package br.com.heserproject.imobiliaria.service.impl;

import br.com.heserproject.imobiliaria.domain.entity.Endereco;
import br.com.heserproject.imobiliaria.repository.EnderecoRepository;
import br.com.heserproject.imobiliaria.service.EnderecoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.saveAndFlush(endereco);
    }

    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco findById(Integer id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    @Override
    @Transactional
    public Endereco atualizar(Integer id, Endereco endereco) {
        endereco.setId(id);
        return salvar(endereco);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        enderecoRepository.deleteById(id);
    }

}
