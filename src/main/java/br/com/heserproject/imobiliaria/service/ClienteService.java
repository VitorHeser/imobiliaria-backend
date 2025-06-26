package br.com.heserproject.imobiliaria.service;

import br.com.heserproject.imobiliaria.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente salvar(Cliente cliente);

    List<Cliente> findAll();

    Cliente findById(Long id);

    Cliente atualizar(Long id, Cliente cliente);

    void deleteById(Long id);
}
