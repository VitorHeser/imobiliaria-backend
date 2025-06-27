package br.com.heserproject.imobiliaria.service;

import br.com.heserproject.imobiliaria.domain.entity.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco salvar(Endereco endereco);

    List<Endereco> findAll();

    Endereco findById(Integer id);

    Endereco atualizar(Integer id, Endereco endereco);

    void deleteById(Integer id);

}
