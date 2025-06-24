package br.com.heserproject.imobiliaria.service;

import br.com.heserproject.imobiliaria.domain.entity.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco salvar(Endereco endereco);

    List<Endereco> findAll();

    Endereco findById(Long id);

    Endereco atualizar(Long id, Endereco endereco);

    void deleteById(Long id);

}
