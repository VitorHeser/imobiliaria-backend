package br.com.heserproject.imobiliaria.service;

import br.com.heserproject.imobiliaria.domain.entity.Imovel;

import java.util.List;

public interface ImovelService {

    Imovel salvar(Imovel imovel);

    List<Imovel> findAll();

    Imovel findById(Integer id);

    Imovel atualizar(Integer id, Imovel imovel);

    void deleteById(Integer id);
}
