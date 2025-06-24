package br.com.heserproject.imobiliaria.core.base;

public interface BaseServiceCrud<T> {

    T salvar(T endereco);

    T findById(Integer id);

    T update(Integer id, T endereco);

    void deleteById(Integer id);

}
