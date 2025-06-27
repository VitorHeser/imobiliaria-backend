package br.com.heserproject.imobiliaria.service;

import br.com.heserproject.imobiliaria.domain.entity.Imobiliaria;

import java.util.List;

public interface ImobiliariaService {

    Imobiliaria salvar(Imobiliaria imobiliaria);

    List<Imobiliaria> findAll();

    Imobiliaria findById(Integer id);

    Imobiliaria atualizar(Integer id, Imobiliaria imobiliaria);

    void deleteById(Integer id);

}
