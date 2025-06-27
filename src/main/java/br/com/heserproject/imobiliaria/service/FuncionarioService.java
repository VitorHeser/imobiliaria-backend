package br.com.heserproject.imobiliaria.service;

import br.com.heserproject.imobiliaria.domain.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {

    Funcionario salvar(Funcionario funcionario);

    List<Funcionario> findAll();

    Funcionario findById(Integer id);

    Funcionario atualizar(Integer id, Funcionario funcionario);

    void deleteById(Integer id);
}
